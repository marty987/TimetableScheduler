package application;
/**
 * This class allows a user to log into the system.
 * @author Martin Bullman 112735341
 * @since Feb 7, 2015, 12:56:25 PM
 */
import miscellaneous.PasswordHasher;
import dbpackage.DatabaseClass;
import javax.servlet.http.HttpServletRequest;

public class Login {
    private String username; 
    private String password;
    private String firstName;
    private String lastName;
    private String[] result;
    /**
     * Constructor for the class
     */
    public Login(){
        this.username = "";
        this.password = "";
        this.firstName = "";
        this.result = new String[10];
    }
    /**
    * Getter method for the user's username.
    * @return username (string)
    **/
    public String getUsername() {
        return username;
    }
    /**
     * Setter method for the user's username
     * @param username (string)
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Getter method for the user's first name
     * @return the variable firstName (string)
     */
    public String getFirstName( ) {
        return firstName;
    }
    /**
     * Getter method for the user's last name (surname)
     * @return the variable lastName (string)
     */
    public String getLastName( ) {
        return lastName;
    }
    /**
     * Function used to log the user into the system, giving them access to view timetables,
     * add events and use the system.
     * @param request (HttpServletRequest)
     * @return true if logged in and false if otherwise.
     */
    public boolean loginUser( HttpServletRequest request ) {
        DatabaseClass database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
        
        username = request.getParameter( "username" );
        password = request.getParameter( "password" );
        
        result = database.SelectRow( "SELECT * FROM users WHERE user_id = '" + username + 
                                     "' AND password = '" + PasswordHasher.sha256Hash( password ) + "';" );
        
        if( result.length != 0 ) {
            firstName = result[2];
            lastName = result[4];
        }
        
        if( ! validateLogin( ) ){
            return false;
        }
        
        //database.Close();
  
        return result.length != 0;
    }
    /**
     * Function to validate if the user's log in credentials are correct. ie. they match
     * the username and password stored in the database
     * @return true if correct and false if otherwise.
     */
    public boolean validateLogin( ){
        boolean isValid = true;
        
        if( username.equals( "" ) ) {
            isValid = false;
        }
        if( password.equals( "" ) ) {
            isValid = false;
        }
        
        return isValid;
    }  
    /**
     * Form used by the user to log into the system
     * @return form (string)
     */
    public String loginForm( ) {
        String form = "<form name=\"login_form\" action=\"index.jsp\" method=\"POST\">\n";
               form += "<label for=\"username\">UCC ID:</label>\n";
               form += "<input type=\"text\" name=\"username\" value=\"" + username + "\"placeholder=\"Enter Username\" /><br/>\n";
               form += "<label for=\"Password\">Password:</label>\n";
               form += "<input type=\"password\" name=\"password\" placeholder=\"Enter Password\"/><br />\n";
               
               form += "<input type=\"submit\" value=\"Login\" name=\"submit\" /><br />\n";
               form += "</form>";
        return form;
    }
}
