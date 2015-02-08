package guipackage;
/**
 *
 * @author mjb2
 */

public class GUI {
    private String form;
    
    public String loginForm(  ) {
        form = "<form name='login_form' action='loginform' method='POST'>\n";
        form += "<label for='username'>Id Number:</label>\n";
        form += "<input type='text' name='username' value='Id Number' />\n"; 
        form += "<label for='password'>Password:</label>\n";
        form += "<input type='password' name='password' value='Password' />/n"; 
        form += "</form>\n";
        
        return form;
    } 
    
    public String registrationForm( ) {
        form = "<form name='registration_form' action='register.jsp' method='POST'>\n";
        form += "<label for='userId'>Id Number:</label>\n";
        form += "<input type='text' name='userId' placeholder='1112223' /><br />\n"; 
        form += "<label for='firstName'>First Name::</label>\n";
        form += "<input type='text' name='firstName' placeholder='John' /><br />\n";
        form += "<label for='middleName'>Middle Name::</label>\n";
        form += "<input type='text' name='middleName' placeholder='Swan' /><br />\n";
        form += "<label for='lastName'>Last Name::</label>\n";
        form += "<input type='text' name='lastName' placeholder='Smith' /><br />\n";
        form += "<label for='email'>Email:</label>\n";
        form += "<input type='text' name='email' placeholder='martin@live.ie' /><br />\n";
        form += "<label for='phoneNo'>Phone Number:</label>\n";
        form += "<input type='text' name='phoneNo' placeholder='085 1175892' /><br />\n";
        
        form += "<input type='submit' value='Submit' name='submit' /><br />\n";
        form += "</form>\n";
        
        return form;
    }
}

