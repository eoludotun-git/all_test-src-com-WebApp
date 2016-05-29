package com.WebApp;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import org.apache.james.mime4j.message.BodyPart;
import org.apache.james.mime4j.message.Multipart;
import org.openqa.jetty.jetty.servlet.AbstractSessionManager.Session;







public class SendFileEmail
{
   public static void main(String [] args)
   {

      // Recipient's email ID needs to be mentioned.
      String to = "abcd@gmail.com";
      // Sender's email ID needs to be mentioned
      String from = "web@gmail.com";
      // Assuming you are sending email from localhost
      String host = "localhost";
      // Get system properties
      Properties properties = System.getProperties();
      // Setup mail server
      properties.setProperty("mail.smtp.host", host);
      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));
         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Create the message part 
         BodyPart messageBodyPart = new BodyPart();

         // Fill the message
         messageBodyPart.setText(null, "This is message body");

         // Create a multipar message
         Multipart multipart = new Multipart(from);

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new BodyPart();
         String filename = "<Enter File Path of Emailable Report>";
         DataSource source = new FileDataSource(filename);
         ((Object) messageBodyPart).setDataHandler(new DataHandler(source));
         messageBodyPart.setFilename(filename);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart );

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}