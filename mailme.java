package com.WebApp;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class mailme {
	public void sendMessage(List<String> attachment)throws Exception{
		Properties props = System.getProperties(); 
		String host="SMTP_HOST";
		String from="FROM_EMAIL";
		String to="TO_EMAIL";
		  // Setup a mail server
		  
		 //setting the host    
		props.put("mail.smtp.host", host);
		Session session = 
		        Session.getInstance(props, null);
		 
		      // Define the mail message
		      MimeMessage message = new MimeMessage(session);
		//setting the from address      
		message.setFrom(new InternetAddress(from));
		//Creating an array of email addresses for sending the mail
		      javax.mail.internet.InternetAddress[] addressTo = javax.mail.internet.InternetAddress.parse(to);
		 
		      for (int i = 0; i < addressTo.length; i++)
		      message.addRecipient(Message.RecipientType.TO, addressTo[i]);
		      //Setting the suject of the mail
		      message.setSubject(
		        "Automation TestSuite Report");
		 
		      // create the message part 
		      MimeBodyPart messageBodyPart = 
		        new MimeBodyPart();
		 
		      //fill message
		      messageBodyPart.setText("Hi,\n\nAttached is the Automation TestSuite Report for Test application.\n\nRegards,\nAutomation Team");
		 
		      Multipart multipart = new MimeMultipart();
		      multipart.addBodyPart(messageBodyPart);
		       
		      // The below secton is used to add attachments to the mail. A list String is sent with the apth of different files that needs to be attached.
		      messageBodyPart = new MimeBodyPart();
		      Iterator<String> itr = attachment.iterator(); 
		      while(itr.hasNext()){
		      messageBodyPart = new MimeBodyPart();
		      String filename=itr.next().toString();
		      DataSource source = new FileDataSource(filename);
		      messageBodyPart.setDataHandler(new DataHandler(source));
		      filename=filename.substring((filename.lastIndexOf("/"))+1);
		      messageBodyPart.setFileName(filename);
		      multipart.addBodyPart(messageBodyPart);
		      }
		      // Put parts in message
		      message.setContent(multipart);
		 
		      // Send the message
		      Transport.send( message );
		 
		 }
}
