package emailsender;
/**
 * @author Martin Bullman 112735341
 * @since Feb 12, 2015, 16:00:25 PM
 */
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {    
    public void sendEmailToNewRegUser( final String userId, final String firstName, String userEmailAddress ) {
        final String username = "martin.bullman@insight-centre.org";
        final String password = "";
        
        Properties props = new Properties( );
        props.put( "mail.smtp.auth", "true" );
        props.put( "mail.smtp.starttls.enable", "true" );
        props.put( "mail.smtp.host", "smtp.gmail.com" );
        props.put( "mail.smtp.port", "587" );

        Session session = Session.getInstance( props, new javax.mail.Authenticator( ) {
            @Override
            protected PasswordAuthentication getPasswordAuthentication( ) {
                return new PasswordAuthentication( username, password);
            }
        });

        try {
            Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress( username ) );
            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse( userEmailAddress ) );
            message.setSubject( "Welcome To Timetable Scheduler" );
            message.setSentDate( new Date( ) );
            
            message.setContent( "<p><b>Welcome " + firstName + ",</b></p>"
                              + "<p>You have successfully registered to the <b>Timetable Scheduler Application</b>.</p>"
                              + "<p>You can now login to the scheduler web app and add events to your personal timetable.</p>"
                              + "<p>You can also view your lecture timetable whicj will be updated by you course coordinator</p><br />"
                              + "<p><b>If you face any problems, please write to us on this email.</b></p>"
                              + "<p>We look forward to seeing you on the site!</p>" 
                              + "<p>The Timetable Scheduler Team!</p><br />"
                              + "<p>Developed by: James Delaney, Emily Horgan, Martin Bullman, Caroline Corcoran, Jack Desmond</p>", 
                             
                                "text/html; charset=utf-8" );
            Transport.send( message );
        } 
        catch( MessagingException exception ) {
            
        }
    }
}