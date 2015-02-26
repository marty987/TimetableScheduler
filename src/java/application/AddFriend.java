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
    private boolean isValid;
    private final DatabaseClass database;
    private final ArrayList<String> errors;
    
    public AddFriend() {
//        this.addingID = "";
        this.yourUserID = "";
        this.friendUserID = "";
        this.isValid = false;
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
    
    public boolean getIsValid() {
        return isValid;
    }
    
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    
    public boolean validateAddingFriendForm( final String userId ) {

        if(errors.size() == 0) {
            setIsValid(true);
        }
        
        if( friendUserID.equals ("") ){
            errors.add( "User ID required");
            setIsValid(false);
            friendUserID = "";
        }
        return isValid;
    }
    
    public String errors() {
        String errorList;
        
        errorList = "<ul>";
            for( String error: errors ) {
                errorList += "<li>" + error + "</li>";
            }
        errorList += "</ul>";
        
        return errorList;
    }
    
    public boolean doesFriendExist(String friendUserID) {
        String[] dbResult = database.SelectRow( "SELECT user_id FROM users WHERE user_id = '" + friendUserID + "';" );
        
        if(dbResult.length == 0) {
            errors.add("User does not exist");
            return false;
        }
        return true;
    }
    
    public void addFriend (String userId) {
        
        if(doesFriendExist(friendUserID)) {
            
        }
    }
    
    public String addFriendForm(String userId) {
        setYourUserID(userId);
        
        String form = "<form name=\"add_friend\" action=\"add_friend.jsp\" method=\"POST\">\n";
               form += "<label for=\"friendUserID\">Your friends UCC ID:</label>\n";
               form += "<input type=\"text\" name=\"friendUserID\" value=\"" + friendUserID + "\" placeholder=\"123456789\"/><br />\n";
        
               form += "<input type='submit' value='Submit' name='submit' /><br />\n";
               form += "</form>\n";
               
        return form;
    }
}