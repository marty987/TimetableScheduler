/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import dbpackage.DatabaseClass;
import java.util.ArrayList;
/**
 * Class to add a friend on the system to subsequentially chat with the user.
 * @author Jack Desmond
 */
public class AddFriend {
//    private String addingID;
//    private String yourUserID;
    private String friendUserID;
    private boolean isValid;
    private final DatabaseClass database;
    private final ArrayList<String> errors;
    /**
     * Constructor for the class AddFriend
     */
    public AddFriend() {
//        this.addingID = "";
//        this.yourUserID = "";
        this.friendUserID = "";
        this.isValid = true;
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
//    
//    public String getYourUserID() {
//        return yourUserID;
//    }
//    
//    public void setYourUserID(String yourUserID) {
//        this.yourUserID = yourUserID;
//    }
    /**
     * Getter method for the friend's student ID.
     * @return variable friendUserID (String)
     */
    public String getFriendUserID() {
        return friendUserID;
    }
    /**
     * Setter method for the friend's user ID.
     * @param friendUserID 
     */
    public void setFriendUserID(String friendUserID) {
        this.friendUserID = friendUserID;
    }
    /**
     * Getter method for the boolean value isValid
     * @return isValid variable (boolean)
     */
    public boolean getIsValid() {
        return isValid;
    }
    /**
     * Setter method for the boolean variable isValid.
     * @param isValid 
     */
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
    /**
     * Ensures the form is filled out correctly by the user.
     * @param userId Your own user ID.
     * @return true if form is filled out correctly and false if otherwise.
     */
    public boolean validateAddingFriendForm( final String userId ) {

        if(friendUserID.equals("") || !doesFriendExist(friendUserID)) {
            
            if(friendUserID.equals("")) {
                errors.add("User ID required");
            }
            setIsValid(false);
            friendUserID = "";
        }
        
        if(isValid) {
            addFriend(userId);
        }
        
        return isValid;
    }
    /**
     * function to collect any error messages that are created throughout the creation and implementation
     * of the addFriend class.
     * @return a string of errors.
     */
    public String errors() {
        String errorList;
        
        errorList = "<ul>";
            for( String error: errors ) {
                errorList += "<li>" + error + "</li>";
            }
        errorList += "</ul>";
        
        return errorList;
    }
    /**
     * Function to check if the user ID of another member of the course is registered in the system.
     * @param friendUserID
     * @return true if it does exist and false otherwise.
     */
    public boolean doesFriendExist(String friendUserID) {
        String[] dbResult = database.SelectRow( "SELECT user_id FROM users WHERE user_id = '" + friendUserID + "';" );
        
        if(dbResult.length == 0) {
            errors.add("User does not exist");
            return false;
        }
        return true;
    }
    
    /**
     * Function to add a friend if friend's user ID is a valid ID on the system.
     * @param userId Your own user ID.
     */
    public void addFriend (String userId) {
        
        if(doesFriendExist(friendUserID)) {
            database.Insert("INSERT INTO friends_list (user_id, friend_id, accepted)" +
                    "VALUES( '" + userId + "', '" + friendUserID + "', '0' );");
        }
    }
    /**
     * Form used to add a friend.
     * @return form (String)
     */
    public String addFriendForm() {
        
        String form = "<form name=\"add_friend\" action=\"add_friend.jsp\" method=\"POST\">\n";
               form += "<label for=\"friendUserID\">Your friends UCC ID:</label>\n";
               form += "<input type=\"text\" name=\"friendUserID\" value=\"" + friendUserID + "\" placeholder=\"123456789\"/><br />\n";
        
               form += "<input type='submit' value='Submit' name='submit' /><br />\n";
               form += "</form>\n";
               
        return form;
    }
}