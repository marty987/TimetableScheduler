package application;
/**
 * @author Martin Bullman 112735341
 * @since Feb 7, 2015, 12:56:25 PM
 */
import dbpackage.DatabaseClass;
import javax.servlet.http.HttpServletRequest;

public class Login {
    private String username; 
    private String password;
    private String[] result;
    
    public Login(){
        this.username = "";
        this.password = "";
        this.result = new String[10];
    }
    
    public boolean loginUser( HttpServletRequest request ) {
        DatabaseClass database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
        
        username = request.getParameter( "username" );
        password = request.getParameter( "password" );
        
        result = database.SelectRow( "SELECT * FROM users WHERE user_id = '" + username + 
                                     "' AND password = '" + PasswordHasher.sha256Hash( password ) + "';" );
        
        return result.length != 0;
    }
    
    public String loginForm( ) {
        String form = "<form name=\"login_form\" action=\"index.jsp\" method=\"POST\">\n";
               form += "<label for=\"username\">Username:</label>\n";
               form += "<input type=\"text\" name=\"username\" value=\"" + username + "\"placeholder=\"Enter Username\" /><br/>\n";
               form += "<label for=\"Password\">Password:</label>\n";
               form += "<input type=\"password\" name=\"password\" placeholder=\"Enter Password\"/><br />\n";
               
               form += "<input type=\"submit\" value=\"Login\" name=\"submit\" /><br />\n";
               form += "</form>";
        return form;
    }
}
