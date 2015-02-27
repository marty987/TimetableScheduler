/*
* Class that defines finding a free slot to make a meeting with using the timetables
* of students registered in the system
*@author Emily Horgan 112340841
*@author Martin Bullman
* 26/02/2015
*/
package algorithm;
/**
 * @author Emily Horgan 112340841 
 * @since Feb 8, 2015, 12:56:25 PM
 */

import java.util.Arrays;
import dbpackage.DatabaseClass;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;

public class FindMeeting {
    private String stream;
    private String date; 
    private String[] groupMembers;
    private final ArrayList<String> errors;
    private final DatabaseClass database;

    /**
     * Constructor for the class.
     */
    public FindMeeting( ) {
        this.date = "";
        this.stream = "";
        this.errors = new ArrayList<>( );
        this.database = new DatabaseClass( );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    
    /**
     * Funtion to set up the servlet for Javascript. Allows the stream and date 
     * to be taken from the form and used globally in the class
     * @param request Form.
     */
    public void setup( HttpServletRequest request ){
        stream = request.getParameter( "stream" );
        date = request.getParameter( "date" );
    }
    
    /**
     * Method used to check if the user is a lecturer or not. 
     * @param userId
     * @return boolean
     */
     public boolean isLecturer( String userId ) {
           String[] dbResult = database.SelectRow( "SELECT is_admin FROM users WHERE user_id = '" + userId + "';" );

           if( dbResult.length == 0 || dbResult[0].equals( "0" )) {
               return false;
           } 
           return true;
     }
     /**
      * Function to get the group members of a certain stream. The stream is whatever 
      * is chosen through the form which is taken as a global variable.
      * @return An array of user id's of the students in the selected stream. (Strings)
      */
     public String[] getGroupMembers( ) {
         groupMembers = database.SelectColumn( "SELECT user_id FROM users WHERE stream = '" + stream + "';" );
         System.out.println( "Group Members: " + Arrays.toString( groupMembers ) );   
         
         return groupMembers;
     }
     
     /**
      * Function to get the times of the lectures of a certain stream ie. the master timetable
      * that is common to all students of the stream.
      * @return array of the period slots which lectures occur in a given day. Day defined using the 
      * global variable 'start_date' chosen through the form. (Integers)
      */
     public int[] getLectureTimes( ){
         String member = groupMembers[0];
         
         int[] lectureTimes = database.SelectIntColumn( "SELECT period "
                                                      + "FROM events JOIN has_events JOIN users "
                                                      + "ON events.event_id = has_events.event_id AND users.user_id = has_events.user_id "
                                                      + "WHERE events.start_date = '" + date + "' AND users.user_id = '" + member + "' AND events.event_type = 'Lecture';" ); 
         
         System.out.println( "Lecture periods: " + Arrays.toString( lectureTimes ) );   
         return lectureTimes;
     }
     /**
      * Function used to get a particular member of the stream's extra events, disregarding lectures.
      * @param startDate
      * @param memberNumber - user id.
      * @return an array of period slots that correspond to times of events that the member has
      * on the given day. (Integers)
      */
     public int[] getMembersEvents(String startDate, int memberNumber){
         String member = groupMembers[memberNumber];
         
         int[] otherEvents = database.SelectIntColumn( "SELECT period "
                                                     + "FROM events JOIN has_events JOIN users "
                                                     + "ON events.event_id = has_events.event_id AND users.user_id = has_events.user_id "
                                                     + "WHERE events.start_date = '" + date + "' AND users.user_id = '" + member + "' AND events.event_type != 'Lecture';" ); 
         
         System.out.println( "Other periods: " + Arrays.toString( otherEvents ) );    
         return otherEvents;
     }
     /**
      * Function designed to get a free slot that could be used for a meeting based on the timetables
      * of the students in the stream picked by the user.
      * @return period during the start_date day that is free for all members of the stream.
      * represented by an integer.
      */
     public int getFreeSlot(  ){
         groupMembers = getGroupMembers(  );
         int memberNumber = 0;
         int[] lectureTimes = getLectureTimes(  );
         int[] eventTimes = getMembersEvents( memberNumber );
         int currentFreeTime = -1;
         
         while( memberNumber < groupMembers.length ){
             for(int period = 1; period < 11 ; period++){
                 for( int i = 0; i < lectureTimes.length; i++){
                     if(period == lectureTimes[i]){
                         memberNumber = 0;
                         break;
                     }
                     else{
                            for( int j = 0; j < eventTimes.length; j++){
                                if(period != eventTimes[j]){
                                    if( memberNumber == groupMembers.length - 1){
                                           currentFreeTime = period;
                                           return currentFreeTime;
                                    }else{
                                           memberNumber++;
                                    }                                    
                                    break;
                                }
                            }
                        }
                     break;  
                  }
               break;                
             }
         }
         return currentFreeTime;
         
     }
    /**
     * Form used to get the information of the type of meeting to be set and the preferred day to meet.
     * If the form user is a lecturer, they can make a meeting with a full class. However, if they are 
     * a student, they can only make meetings with other classmates.
     * @return form
     */
    public String findMeetingForm( String userId ) {
        String form = "<form name=\"find_meeting\" id = 'dropdown' action=\"timetable.jsp\" method=\"POST\">\n" 
                        + "<label for=\"eventType\">Event Type:</label>\n"
                        + "<select name =\"eventType\" >\n +"
                            + "<option value=\"1\" selected>Lecture</option>\n" 
                            + "<option value=\"2\" selected>Meeting</option>\n" 
                            + "<option value=\"3\" selected>Tutorial</option>\n" 
                            + "<option value=\"4\" selected>Other</option>\n" 
                        + "</select><br />";

              if( isLecturer( userId ) ) {
                  form += "<label id = 'dropdown' for='stream'>Stream:</label>\n"
                        + "<select name=\"stream\" >\n" 
                        + "  <option value=\"1\" selected>Computer Sci Year 1</option>\n" 
                        + "  <option value=\"2\">Core Year 2</option>\n" 
                        + "  <option value=\"3\">Core Year 3</option>\n" 
                        + "  <option value=\"4\">Core Year 4</option>\n" 
                        + "  <option value=\"5\">Web Year 2</option>\n" 
                        + "  <option value=\"6\">Web Year 3</option>\n" 
                        + "  <option value=\"7\">Web Year 4</option>\n" 
                        + "  <option value=\"8\">Soft Entrep Year 2</option>\n" 
                        + "  <option value=\"9\">Soft Entrep Year 3</option>\n" 
                        + "  <option value=\"10\">Soft Entrep Year 4</option>\n" 
                        + "  <option value=\"11\">Chinese Year 2</option>\n" 
                        + "  <option value=\"12\">Chinese Year 3</option>\n" 
                        + "  <option value=\"13\">Chinese Year 4</option>\n" 
                        + "</select><br />"; 
              }
              else {
                  //get the user id's of all of the students in the same stream as the student and
                  //offer to set meeting with these students.
                  //this.stream = database.
              }

                  form += "<label id = 'dropdown' for=\"date\">Preferred Day:</label>\n"
                        + "<input type=\"text\" class=\"datepicker\" name=\"date\" value=\"" + date + "\" placeholder=\"2015/01/01\"/><br />\n"
                        + "<label for=\"recurrence\">Recurrence:</label>\n"
                        + "<select name=\"recurrence\">\n" 
                        + "  <option value=\"once\" selected>Single Meeting</option>" 
                        + "  <option value=\"weekly\">Weekly</option>" 
                        + "  <option value=\"montly\">Monthly</option>" 
                        + "</select><br />"

                        + "<input type='submit' value='Search Availability' name='find_meet' /><br />\n"
                    + "</form>\n";

        return form;
    }
}
