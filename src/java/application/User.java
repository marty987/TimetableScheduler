/*
 * @author Caroline Corcoran
 */
package application;

import dbpackage.DatabaseClass;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Caroline
 */
public class User {
    private String userId;
    private String userType;
    private String stream;
    private String firstname;
    private String middlename;
    private String lastname;
    private String email;
    private String phoneNo;
    private boolean isAdmin;
    private boolean isLoggedIn; 
    
    public User( ) {
        
    }
    
    private void changePassword( String userInputCurrentPassword, String newPassword ) {
        DatabaseClass database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
        
        String currentPasswordFromDB = request.getParameter( "password" );
        
        if( currentPasswordFromDB.equals(userInputCurrentPassword) ) {
            database.Insert( "INSERT INTO users( password )"
                    + "VALUES (\"" + newPassword + "\");"
                    + "WHERE user_id = \"" + userId + "\";");
        }
        else
        {
            
        }
            
    }
    
    private void changePhoneNo( String currentPassword ) {
        
    }
}
