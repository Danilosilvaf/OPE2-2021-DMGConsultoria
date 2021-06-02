package com.IJeans.Backend.email;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class SendMail {
	
	public void sendMail(File attrach1,String email){
		Properties props = new Properties();
	    /** Parâmetros de conexão com servidor Gmail */
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class",
	    "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");

	    Session session = Session.getDefaultInstance(props,
	      new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication()
	           {
	                 return new PasswordAuthentication("dmg.ijeans@gmail.com",
	                 "itsaboy69");
	           }
	      });
	    /** Ativa Debug para sessão */
	    session.setDebug(true);

	    try {

	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress("dmg.ijeans@gmail.com"));
	      //Remetente

	      Address[] toUser = InternetAddress //Destinatário(s)
	                 .parse(email);

	      message.setRecipients(Message.RecipientType.TO, toUser);
	      message.setSubject("Relatorio");//Assunto
	      
	      
	      Multipart mp = new MimeMultipart();
	      
	      MimeBodyPart messageBodyPart = new MimeBodyPart();
	      messageBodyPart.setContent("<b>Boa Noite!<b/><br><p><b>Segue em anexo o relatorio sobre as vendas realizadas pelo IJeans<b/><p/>","text/html");
	      mp.addBodyPart(messageBodyPart);
	      
	      MimeBodyPart anexo = new MimeBodyPart();
	      FileDataSource relatorio = new FileDataSource(attrach1);
	      anexo.setDataHandler(new DataHandler(relatorio));
	      anexo.setFileName(relatorio.getName());
	      mp.addBodyPart(anexo);
	      
	      message.setContent(mp);
	      /**Método para enviar a mensagem criada*/
	      Transport.send(message);

	      System.out.println("Feito!!!");

	     } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }
	}
	
    
}
