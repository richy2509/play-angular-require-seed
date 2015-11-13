package models

import javax.inject.Inject

import play.api.libs.mailer._


/**
  * <p>Title: ${CLASS_NAME}.</p>
  * <p>Description:</p>
  * <p>Copyright: Copyright (c) 2015</p>
  * <p>Company: Travelsoft</p>
  *
  * @author richard.koehl
  */
class SmtpMailer @Inject() (mailerClient: MailerClient) {

  def sendEmail() {
    val cid = "1234"
    val email = Email(
      "Simple email",
      "koehl.richard@gmail.com",
      Seq("koehl.richard@gmail.com"),
      // adds attachment
      /*attachments = Seq(
        AttachmentFile("attachment.pdf", new File("/some/path/attachment.pdf")),
        // adds inline attachment from byte array
        AttachmentData("data.txt", "data".getBytes, "text/plain", Some("Simple data"), Some(EmailAttachment.INLINE)),
        // adds cid attachment
        AttachmentFile("image.jpg", new File("/some/path/image.jpg"))
      ),*/
      // sends text, HTML or both...
      bodyText = Some("A text message"),
      bodyHtml = Some(s"""<html><body><p>An <b>html</b> message with cid <img src="cid:$cid"></p></body></html>""")
    )
    /*val send: String = mailerClient.send(email) */
  }
}
