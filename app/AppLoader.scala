import play.api.ApplicationLoader.Context
import play.api.cache.EhCacheComponents
import play.api.libs.mailer._
import play.api.mvc.EssentialFilter
import play.api.routing.Router
import play.api.{Logger, Application, ApplicationLoader, BuiltInComponentsFromContext}
import router.Routes
import play.filters.gzip.GzipFilter


class AppLoader extends ApplicationLoader {
  override def load(context: Context): Application = {
    Logger.configure(context.environment)
    new AppComponents(context).application
  }
}

class AppComponents(context: Context) extends BuiltInComponentsFromContext(context)
with EhCacheComponents {

  val mailerClient = new CommonsMailer(configuration)
  lazy val applicationController = new controllers.Application(defaultCacheApi)
  lazy val usersController = new controllers.Users(defaultCacheApi)
  lazy val mailsController = new controllers.Mails(mailerClient, defaultCacheApi)
  lazy val assets = new controllers.Assets(httpErrorHandler)

  // Routes is a generated class
  override def router: Router = new Routes(
    httpErrorHandler,
    applicationController,
    usersController,
    mailsController,
    assets)

  val gzipFilter = new GzipFilter(shouldGzip =
    (request, response) => {
      val contentType = response.headers.get("Content-Type")
      contentType.exists(_.startsWith("text/html")) || request.path.endsWith("jsroutes.js")
    })

  override lazy val httpFilters: Seq[EssentialFilter] = Seq(gzipFilter)
}
