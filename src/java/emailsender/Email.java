package emailsender;
/**
 * @author Martin Bullman 112735341
 * @since Feb 12, 2015, 16:00:25 PM
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
    public void sendEmailToNewRegUser( final String userId, final String firstName, final String userEmailAddress ) {
        final String username = "112735341@umail.ucc.ie";
        final String password = "Ucc*87643";
 
        Properties props = new Properties( );
        props.put( "mail.smtp.auth", "true" );
        props.put( "mail.smtp.starttls.enable", "true" );
        props.put( "mail.smtp.host", "smtp.gmail.com" );
        props.put( "mail.smtp.port", "587" );

        Session session = Session.getInstance( props, new javax.mail.Authenticator( ) {
            @Override
            protected PasswordAuthentication getPasswordAuthentication( ) {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress( username ) );
            message.setRecipients( Message.RecipientType.TO, InternetAddress.parse( userEmailAddress ) );
            message.setSubject( "New Registed User" );
            message.setText( "welcome to the timetable scheduler for UCC Computer Science Department." );

            Transport.send( message );

            System.out.println( "Email has been sent sucessfully" );

        } 
        catch( MessagingException exception ) {
            throw new RuntimeException( exception );
        }
    }
    
    
}