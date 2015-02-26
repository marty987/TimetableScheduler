package application;

/**
 *
 * @author jd11
 */
import dbpackage.DatabaseClass;
import java.util.ArrayList;


public class Contact {


public class AddMessage {
    private String email;
    private String subject;
    private String message;
    private final DatabaseClass database;
    private final ArrayList<String> errors;
    
    public AddMessage( ){
        this.email = "";
        this.subject = "";
        this.message = "";
        this.errors = new ArrayList<>( );
        this.database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    
    public String getEmail( ){
        return email;
    }
    
    public void setEmail( final String email ){
        this.email = email;
    }
    
    public String getSubject( ){
        return subject;
    }
    
    public void setSubject( final String subject ){
        this.subject = subject;
    }
    
    public String getMessage( ){
        return message;
    }
    
    public void setMessage( final String message ){
        this.message = message;
    }
    
 
    public boolean validateContactForm( final String userId ) {
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
    
    public void insertNewMessage( String userId ) {
        database.Insert( "INSERT INTO contact( email, subject, message )" +
                         "VALUES( '" + email + "', '" + subject + "', '" + message + "'  );" );
        database.Close( );
    }
    
    public String addContactForm( String userId ) {
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
}  
