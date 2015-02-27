package application;

/**
 * This class acts as a chat/messenger service between users of the systems. 
 * @author jd11
 */
import dbpackage.DatabaseClass;
import java.util.ArrayList;


/**
 * This class allows you to add a personal message to the database for another user within the system.
 **/
public class Contact {
    private String email;
    private String subject;
    private String message;
    private DatabaseClass database;
    private ArrayList<String> errors;
    /**
     * Constructor for the AddMessage class
     */
    public Contact( ){
        email = "";
        subject = "";
        message = "";
        errors = new ArrayList<>( );
        database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    /**
     * Getter method for the email address of a user of the system.
     * @return variable email (string)
     */
    public String getEmail( ){
        return email;
    }
    /**
     * Setter method for the email address of a user of the system. 
     * @param email (string)
     */
    public void setEmail( final String email ){
        this.email = email;
    }
    /**
     * Getter method for the subject line of the message. 
     * @return the variable 'subject' (string)
     */
    public String getSubject( ){
        return subject;
    }
    /**
     * Setter method for the subject line of the message.
     * @param subject (string)
     */
    public void setSubject( final String subject ){
        this.subject = subject;
    }
    /**
     * Getter method for the body of the message to be sent.
     * @return the variable 'message' (string)
     */
    public String getMessage( ){
        return message;
    }
    /**
     * Setter method for the body of the message to be sent. 
     * @param message (string)
     */
    public void setMessage( final String message ){
        this.message = message;
    }
    
 /**
     * Ensures the form is filled out correctly by the user.
     * @param userId Your own user ID.
     * @return true if form is filled out correctly and false if otherwise.
     */
    public boolean validateContactForm(  ) {
        boolean isValid = true;

        if( email.equals( "" ) || ! email.contains( "@" ) || ! email.contains( "." ) ) {
            errors.add( "Email required. Must be valid email address" );
            isValid = false;
            email = "";
        }
        
        if( subject.equals ("") ){
            errors.add( "Subject required");
            isValid = false;
            subject = "";
        }
        
        if( message.equals ("") ){
            errors.add( "A message is required");
            isValid = false;
            message = "";
        }
        
        return isValid;
    }
    
    public String errors( ) {
        String errorList;
        
        errorList = "<ul>";
            for( String error: errors ) {
                errorList += "<li>" + error + "</li>";
            }
        errorList += "</ul>";
        
        return errorList;
    }
    /**
     * Function to insert the message entered in the form to the database.
     * @param userId the user's ID (string)
     */
    public void insertNewMessage( String email, String subject, String message  ) {
        database.Insert( "INSERT INTO contact( email, subject, message )" +
                         "VALUES( '" + email + "', '" + subject + "', '" + message + "'  );" );
        //database.Close( );
    }
    /**
     * Function to create the form to send a message.
     * @param userId (string)
     * @return the form (string)
     */
    public String contactForm(  ) {
        String form = "<form name=\"contact\" action=\"contact.jsp\" method=\"POST\">\n";
               
               form += "<label for='email'>Email:</label>\n";
               form += "<input type='email' id='email' name='email' value='" + email +  "' placeholder='martin@live.ie' /><br />\n";
               form += "<label for=\"subject\">Subject:</label>\n";
               form += "<input type=\"text\" name=\"subject\" value=\"" + subject + "\" placeholder=\"Meeting\"/><br />\n";
               form += "<label for=\"message\">Message:</label>\n";
               form += "<input type=\"text\" name=\"message\" value=\"" + message + "\" placeholder=\"Please enter a message....\"/><br />\n";

        
               form += "<input type='submit' value='Submit' name='submit' /><br />\n";
               form += "</form>\n";
               
        return form;
    }
  }
  
