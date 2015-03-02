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
            ResultSet statementResult = statementObject.executeQuery( "SELECT events.event_name, events.start_date, events.location, events.description, has_events.event_id, has_events.has_seen "
                                                                    + "FROM events JOIN has_events JOIN users "
                                                                    + "ON users.user_id = has_events.user_id AND events.event_id = has_events.event_id "
                                                                    + "WHERE users.user_id = '" + userId + "';"); 
    
            notifications = "<form action='timetable.jsp'>" + 
                               "<table class=\"emp-sales2\">\n" +
                                 "<caption>Your notifications</catption>\n" +
                                 "<tr><th>Event Name</th><th>Start Date</th><th>Location</th><th>Description</th><th>Accept event</th></tr>\n";
           
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
           
            notifications +=    "<tr><td colspan='4'><b></b></td>"
                          + "<td><input id='sub' type='submit' value='Clear!' /></td></tr>\n" 
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
    
    public String getFriendsAndRequests( String userId ) throws SQLException {
        String friendRequests = "";
        this.userId = userId;
        
        // Establish connection to database
        connectionObject = DriverManager.getConnection( "jdbc:mysql://" + "cs1.ucc.ie" + "/" + "2016_mjb2", "mjb2", "diechoro" );
        
        try{
            statementObject = connectionObject.createStatement( );
//            String[] dbResult = database.SelectRow( "SELECT user_id, friend_id, accepted FROM friends_list WHERE user_id = '" + userId + "';" );
            ResultSet statementResult = statementObject.executeQuery( "SELECT friends_list.user_id, friends_list.friend_id, friends_list.accepted, users.user_id, users.first_name, users.last_name"
                                                                    + "FROM friends_list JOIN users "
                                                                    + "ON users.user_id = has_events.user_id AND events.event_id = has_events.event_id " 
                                                                    + "ON friends_list.friend_id = users.user_id"
                                                                    + "WHERE friends.user_id = '" + userId + "';"); 
            friendRequests = "<form action='timetable.jsp'>" 
                             + "<table class=\"emp-sales2\">\n"
                             + "<tr><th>First Name</th><th>Last Name</th><th>Chat</th><th>Accept friend request</th></tr>\n";
            
            while( statementResult.next( ) ){
                String[] results = db.SelectRow( "SELECT accepted "
                                               + "FROM friends_list "
                                               + "WHERE user_id = '" + userId + "'" );
                friendRequests += "<tr>\n"
                               + "<td>" + statementResult.getString( 5 ) + "</td>\n"
                               + "<td>" + statementResult.getString( 6 ) + "</td>\n";
                if( results[0].equals( "0" ) ) {
                    friendRequests += "<td></td>"
                                   + "<td><input type='checkbox' name='seen_events' value='" + statementResult.getString( 1 ) + "' /></td>\n";
                } else {
                    friendRequests += "<td><a class='chat' href='chat.jsp'>Chat</a></td>"
                                   + "<td><small>Friend added</small></td>";
                }
                friendRequests += "</tr>\n";
            }
            
        } catch( SQLException exceptionObject ){
           friendRequests = "There has been an error retreiveing your friend list and friends requests, Please try again!";
        } finally{
            return friendRequests;
        }
    }
}