package notifications;
/**
 * @author Martin Bullman 112735341
 * @since Feb 24, 2015, 12:56:25 PM
 */
import dbpackage.DatabaseClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersNotifications {
    private DatabaseClass database;
    private Statement statementObject;
    private Connection connectionObject;
    
    public String getUsersNotifications( String userId ) throws SQLException {
        String notifications = "";
        
        // Establish connection to database
        connectionObject = DriverManager.getConnection( "jdbc:mysql://" + "cs1.ucc.ie" + "/" + "2016_mjb2", "mjb2", "diechoro" );
        
        try{
            statementObject = connectionObject.createStatement( );
            ResultSet statementResult = statementObject.executeQuery( "SELECT * FROM events JOIN has_events JOIN users" +
                                                                      "ON users.user_id = has_events.user_id AND events.event_id = has_events.event_id" +
                                                                      "WHERE users.user_id = '" + userId + "';"); 
    
            notifications = "<table>";
            notifications += "<th>Event Name</th><th>Event Type</th><th>Period</th><th>Recurrence</th><th>Module Code</th><th>Location</th><th>Description</th>";
           
            while( statementResult.next( ) ){
                notifications += "<td>" + statementResult.getString(2) + "</td>";
            }
            
            notifications += "</table>";
        }
        catch( SQLException exceptionObject ){
           
        }
        
        return notifications;
    }
}
