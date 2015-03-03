package chatpackage;

import dbpackage.DatabaseClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;

/**
 * @author jd7
 */

public class FriendRequests {
    private String userId;
    private String friendId;
    private DatabaseClass database;
    private DatabaseClass db;
    private Statement statementObject;
    private Connection connectionObject;
    
    public FriendRequests( ) {
        this.db = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        db.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    
    public String getFriendsAndRequests( String userId ) throws SQLException {
        String friendRequests = "";
        this.userId = userId;
        
        // Establish connection to database
        connectionObject = DriverManager.getConnection( "jdbc:mysql://" + "cs1.ucc.ie" + "/" + "2016_mjb2", "mjb2", "diechoro" );
        
//        try{
//            statementObject = connectionObject.createStatement( );
////            String[] dbResult = database.SelectRow( "SELECT user_id, friend_id, accepted FROM friends_list WHERE user_id = '" + userId + "';" );
//            ResultSet statementResult = statementObject.executeQuery( "SELECT friends_list.user_id, friends_list.friend_id, friends_list.accepted, users.user_id, users.first_name, users.last_name"
//                                                                    + "FROM friends_list JOIN users "
//                                                                    + "ON users.user_id = has_events.user_id AND events.event_id = has_events.event_id " 
//                                                                    + "ON friends_list.friend_id = users.user_id"
//                                                                    + "WHERE friends.user_id = '" + userId + "';"); 
            friendRequests = "<form action='timetable.jsp'>" 
                             + "<table class=\"emp-sales2\">\n"
                             + "<caption>Your friends <a href='add_friend.jsp'>(add friend)</a></catption>\n"
                             + "<tr><th>First Name</th><th>Last Name</th><th>Chat</th><th>Accept friend request</th></tr>\n";
//            
//            while( statementResult.next( ) ){
//                String[] results = db.SelectRow( "SELECT accepted "
//                                               + "FROM friends_list "
//                                               + "WHERE user_id = '" + userId + "'" );
//                friendRequests += "<tr>\n"
//                               + "<td>" + statementResult.getString( 5 ) + "</td>\n"
//                               + "<td>" + statementResult.getString( 6 ) + "</td>\n";
//                if( results[0].equals( "0" ) ) {
//                    friendRequests += "<td></td>"
//                                   + "<td><input type='checkbox' name='seen_events' value='" + statementResult.getString( 1 ) + "' /></td>\n";
//                } else {
//                    friendRequests += "<td><a class='chat' href='chat.jsp'>Chat</a></td>"
//                                   + "<td><small>Friend added</small></td>";
//                }
//                friendRequests += "</tr>\n";
//            }
//            
//        } catch( SQLException exceptionObject ){
//           friendRequests = "There has been an error retreiveing your friend list and friends requests, Please try again!";
//        } finally{
            return friendRequests;
        }
//    }
    
//    public void inviteAccepted( HttpServletRequest request ) {    
//        String[] events = request.getParameterValues( "accepted" );
//        
//        for( String event: events ){
//                db.Insert( "UPDATE friends_list SET aceepted = '1' WHERE user_id = '" + userId + "' AND event_id = '" + event + "';" );
//        }
//    }
}