package guipackage;
/**
 * @author James Delany 
 * @since Feb 8, 2015, 12:56:25 PM
 */
import java.math.BigInteger;
import java.security.SecureRandom;

public class GUI {
    private String form;
    private final SecureRandom random;

    public GUI( ) {
        this.random = new SecureRandom( );
    }

    public String nextSessionId( ) {
        return new BigInteger( 130, random ).toString( 32 );
    }
    
    public String loginHeader( ) {
        form = "<header>\n";
        form += "<nav>\n";
        form += "<ul>\n";
        form += "<li class = 'home'><a href='index.jsp'>Home</a></li>\n"; 
        form += "<li class = 'timetable'><a href='timetable.jsp'>Timetable</a></li>\n";
        form += "<li class = 'staff'><a href='staff.jsp'>Staff</a></li>\n";
        form += "<li class = 'students'><a href='students.jsp'>Students</a></li>\n";
        form += "<li class = 'help'><a href='help.jsp'>Help</a></li>\n";
        form += "<li class = 'timetable'><a href='contact.jsp'>Contact</a></li>\n";        
        form += "</ul>\n";
        form += "</nav>\n";
        form += "</header>\n";       

        return form;
    }
        
    public String header(boolean printName, String fName, String lName) {
        form = "<header>\n";
        form += "<nav >\n";      
        form += "<ul>\n";
        form += "<li><a href=\"logout.jsp\" id='logout'>(Logout)</a></li>\n";        
        form += "<li class = 'home'><a href='index.jsp'>Home</a></li>\n"; 
        form += "<li class = 'timetable'><a href='timetable.jsp'>Timetable</a></li>\n";
        form += "<li class = 'staff'><a href='staff.jsp'>Staff</a></li>\n";
        form += "<li class = 'students'><a href='students.jsp'>Students</a></li>\n";
        form += "<li class = 'help'><a href='help.jsp'>Help</a></li>\n";
        form += "<li class = 'timetable'><a href='contact.jsp'>Contact</a></li>\n";          
        form += "</ul>\n";
        form += "</nav>\n";
        if(printName) {
            form += "<h1 id=\"welcomeH\">Welcome "+fName+" "+lName+"</h1>";
        }
        form += "</header>\n";       

        return form;
    }        
        
    public String footer( ) {
        form = "<footer>\n";
        form += "<small>\n";
        form += "<ul class = footerLinks>\n";
        form += "<li id='sitemap'><a>Sitemap</a></li>\n"; 
        form += "<li><a>Legal</a></li>\n";
        form += "<li><a>Acceptable Use Policy</a></li>\n";
        form += "<li><a>Webmaster</a></li>\n";
        form += "</ul>\n";
        form += "</footer>\n";    

        return form;
    }    
    
    public String sessionErrorMessage() {
        form = "<p>\n";
        form += "Please <a href=\"index.jsp\">";
        form += "login</a>";
        form += " to view the timetable.</p>";
        
        return form;
    }
    
    public String forgotPassForm( ) {
        String passForm = "<form name=\"forgot_pass_form\" action=\"forgot_password.jsp\" method=\"POST\">\n";
               passForm += "<label for=\"id_number\">ID Number:</label>\n";
               passForm += "<input type=\"text\" name=\"id_number\" placeholder=\"Enter User ID Here!\" />\n";
             
               passForm += "<input type=\"hidden\" name=\"token\" value=\"" + nextSessionId( ) + "\" /><br />\n";
               
               passForm += "<input type=\"submit\" value=\"Submit!\" name=\"submit\" />\n";
               
        return passForm;
    }
    
    public String resetPassForm( ) {
        String resetPassForm = "<form name=\"reset_pass_form\" action=\"reset_password.jsp\" method=\"POST\">\n";
               resetPassForm += "<label for=\"user_id\">User ID:</label>\n";
               resetPassForm += "<input type=\"text\" name=\"user_id\" placeholder=\"Enter user ID\" /><br />\n";
               resetPassForm += "<label for=\"password1\">New Password:</label>\n";
               resetPassForm += "<input type=\"password\" name=\"password1\" placeholder=\"Enter new password\" /><br />\n";
               resetPassForm += "<label for=\"password2\">Confirm New Password:</label>\n";
               resetPassForm += "<input type=\"password\" name=\"password2\" placeholder=\"Confirm new password\" /><br />\n";
               
               resetPassForm += "<input type=\"submit\" value=\"Submit!\" name=\"submit\" />\n";
               
        return resetPassForm;
    }
}

