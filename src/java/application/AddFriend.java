/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import dbpackage.DatabaseClass;
import java.util.ArrayList;
/**
 *
 * @author jd7
 */
public class AddFriend {
//    private String addingID;
    private String yourUserID;
    private String friendUserID;
    private final DatabaseClass database;
    private final ArrayList<String> errors;
    
    public AddFriend() {
//        this.addingID = "";
        this.yourUserID = "";
        this.friendUserID = "";
        this.errors = new ArrayList<>( );
        this.database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    
//    public String getAddingID() {
//        return addingID;
//    }
//    
//    public void setAddingID(String addingID) {
//        this.addingID = addingID;
//    }
    
    public String getYourUserID() {
        return yourUserID;
    }
    
    public void setYourUserID(String yourUserID) {
        this.yourUserID = yourUserID;
    }
    
    public String getFriendUserID() {
        return friendUserID;
    }
    
    public void setFriendUserID(String friendUserID) {
        this.friendUserID = friendUserID;
    }
    
    public boolean validateAddingFriendForm( final String userId ) {
        boolean isValid = true;

        if( friendUserID.equals ("") ){
            errors.add( "Event Name required");
            isValid = false;
            friendUserID = "";
        }
        
        return isValid;
    }
    
    public String addFriendForm( String userId ) {
        setYourUserID(userId);
        
        String form = "<form name=\"add_friend\" action=\"add_friend.jsp\" method=\"POST\">\n";
               form += "<label for=\"friendUserID\">Your friends UCC ID:</label>\n";
               form += "<input type=\"text\" name=\"friendUserID\" value=\"" + friendUserID + "\" placeholder=\"123456789\"/><br />\n";
        
               form += "<input type='submit' value='Submit' name='submit' /><br />\n";
               form += "</form>\n";
               
        return form;
    }
}