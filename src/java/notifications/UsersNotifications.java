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
import javax.servlet.http.HttpServletRequest;

public class UsersNotifications {
    private int count = 0;
    private String userId;
    private DatabaseClass database;
    private DatabaseClass db;
    private Statement statementObject;
    private Connection connectionObject;
    
    public UsersNotifications( ) {
        this.db = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        db.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    
    public String getUsersNotifications( String userId ) throws SQLException {
        String notifications = "";
        this.userId = userId;
        
        // Establish connection to database
        connectionObject = DriverManager.getConnection( "jdbc:mysql://" + "cs1.ucc.ie" + "/" + "2016_mjb2", "mjb2", "diechoro" );
        
        try{
            statementObject = connectionObject.createStatement( );
            ResultSet statementResult = statementObject.executeQuery( "SELECT events.event_name, events.period, events.location, events.description, has_events.event_id, has_events.has_seen "
                                                                    + "FROM events JOIN has_events JOIN users "
                                                                    + "ON users.user_id = has_events.user_id AND events.event_id = has_events.event_id "
                                                                    + "WHERE users.user_id = '" + userId + "';"); 
    
            notifications = "<form action='timetable.jsp'>" + 
                               "<table>\n" +
                                 "<tr><th>Event Name</th><th>Period</th><th>Location</th><th>Description</th><th>Accept event</th></tr>\n";
           
            while( statementResult.next( ) ){
                String[] results = db.SelectRow( "SELECT has_seen "
                                               + "FROM has_events "
                                               + "WHERE user_id = '" + userId + "' AND event_id = " + statementResult.getString( 5 ) + "" );
              
                if( results[0].equals( "0" ) ) { 
                    notifications += "<tr>\n" +
                                         "<td>" + statementResult.getString( 1 ) + "</td>\n" +
                                         "<td>" + statementResult.getString( 2 ) + "</td>\n" +
                                         "<td>" + statementResult.getString( 3 ) + "</td>\n" +
                                         "<td>" + statementResult.getString( 4 ) + "</td>\n" +
                                         "<td><input type='checkbox' name='seen_events' value='" + statementResult.getString( 5 ) + "' /></td>\n" 
                                   + "</tr>\n";
                }
            }
           
            notifications +=    "<tr><td colspan='4'><b>THESE ARE YOUR UNSEEN NOTIFICATIONS!</b></td>"
                          + "<td><input type='submit' value='Submit!' id='checker' /></td></tr>\n" 
                          +   "</table>\n"
                          + "</form>\n";
        }
        catch( SQLException exceptionObject ){
           notifications = "There has been an error retreiveing your notifications, Please try again!";
        }
        finally{
            return notifications;
        }
    }
    
    public void hasSeen( HttpServletRequest request ) {    
        String[] events = request.getParameterValues( "seen_events" );
        
        for( String event: events ){
                db.Insert( "UPDATE has_events SET has_seen = '1' WHERE user_id = '" + userId + "' AND event_id = '" + event + "';" );
        }
    }
    
    public String getFriendRequests( String userId ) throws SQLException {
        String friendRequests = "";
        this.userId = userId;
        
        // Establish connection to database
        connectionObject = DriverManager.getConnection( "jdbc:mysql://" + "cs1.ucc.ie" + "/" + "2016_mjb2", "mjb2", "diechoro" );
        
        try{
            statementObject = connectionObject.createStatement( );
            
            
        }
        catch( SQLException exceptionObject ){
           friendRequests = "There has been an error retreiveing your friend requests, Please try again!";
        }
        finally{
            return friendRequests;
        }
    }
}
