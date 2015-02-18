package application;

import dbpackage.DatabaseClass;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * @author jd7
 */
public class Email {
    private String[] result;
    private String email;
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String PrintEmail(String username) {
        DatabaseClass database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
        
        result = database.SelectRow( "SELECT email FROM users WHERE user_id = '" + username +"';" );
        
        if(result.length != 0) {
            return result[0];
        } else {
            return null;
        }
    }
    
    public void SendEmail(String username) {
      DatabaseClass database = new DatabaseClass( );
      //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
      database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
       
        
      result = database.SelectRow( "SELECT email FROM users WHERE user_id = '" + username +"';" );
      
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

         // Now set the actual message
         message.setText("This is actual message");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
    }
}