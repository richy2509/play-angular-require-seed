package controllers

import models.SmtpMailer
import play.api.cache.CacheApi
import play.api.libs.mailer.MailerClient
import play.api.mvc._

class Mails (mailerClient: MailerClient, val cache: CacheApi) extends Controller with Security{


    /** Retrieves a logged in user if the authentication token is valid.
      *
      * @return The user in JSON format.
      */
    def send(content: String, title: String) = Action {
      val mailer: SmtpMailer = new SmtpMailer(mailerClient)
      mailer.sendEmail()
      Ok("bonjour")
    }

/*

    def send() = HasToken(parse.empty) { token => userId => implicit request =>
    /*val mailer: SmtpMailer = new SmtpMailer(mailerClient)
    mailer.sendEmail()*/
    Ok("bonjour");
  }
*/

}