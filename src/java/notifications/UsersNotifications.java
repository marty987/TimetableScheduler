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
            ResultSet statementResult = statementObject.executeQuery( "SELECT * FROM events JOIN has_events JOIN users ON users.user_id = has_events.user_id AND events.event_id = has_events.event_id WHERE users.user_id = '" + userId + "';"); 
    
            notifications += "<table>\n";
            notifications += "<tr><th>Event Name</th><th>Period</th><th>Location</th><th>Description</th></tr>\n";
           
            while( statementResult.next( ) ){
                notifications += "<tr>\n" +
                                     "<td>" + statementResult.getString( 2 ) + "</td>\n" +
                                     "<td>" + statementResult.getString( 5 ) + "</td>\n" +
                                     "<td>" + statementResult.getString( 10 ) + "</td>\n" +
                                     "<td>" + statementResult.getString( 11 ) + "</td>\n" +
                                 "</tr>\n";
            }
            
           return notifications += "</table>";
        }
        catch( SQLException exceptionObject ){
           
        }
        finally{
            return notifications;
        }
    }
}
