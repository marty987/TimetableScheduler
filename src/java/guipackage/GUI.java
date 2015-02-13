package guipackage;
/**
 *
 * @author mjb2
 */

public class GUI {
    private String form;
    
    public String loginHeader( ) {
        form = "<header>\n";
        form += "<nav>\n";
        form += "<ul>\n";
        form += "<li class = 'home'><a href='index.jsp'>Home</a></li>\n"; 
        form += "<li class = 'timetable'><a href='timetable.jsp'>Timetable</a></li>\n";
        form += "<li class = 'staff'><a href='staff.jsp'>Staff</a></li>\n";
        form += "<li class = 'students'><a href='students.jsp'>Students</a></li>\n";
        form += "<li class = 'help'><a href='help.jsp'>Help</a></li>\n";
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
}

