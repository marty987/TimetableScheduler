/*
*@author Emily Horgan 112340841
* 26/02/2015
*/
package application;

import dbpackage.DatabaseClass;
import java.util.ArrayList;

public class FindMeeting {
    
    private String stream = "";
    private String student = "";
    private final ArrayList<String> errors;
    private final DatabaseClass database;
    
    public FindMeeting( ) {
        this.errors = new ArrayList<>( );
        this.database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
 /**
  * Method used to check if the user is a lecturer or not. 
  * @param userId
  * @return boolean
  */
  public boolean isLecturer( String userId ) {
        String[] dbResult = database.SelectRow( "SELECT is_admin FROM users WHERE user_id = '" + userId + "';" );
        database.Close( );
        
        if( dbResult.length == 0 || dbResult[0].equals("0")) {
            return false;
        } 
        return true;
    }
  
/**
 * Form used to get the information of the type of meeting to be set and the preferred day to meet.
 * If the form user is a lecturer, they can make a meeting with a full class. However, if they are 
 * a student, they can only make meetings with other classmates.
 * @return form
 */
public String findMeetingForm(String userId) {
        String form = "<form name=\"find_meeting\" action=\"find_meeting.jsp\" method=\"POST\">\n";
               
               form += "<label for=\"eventType\">Event Type:</label>\n";
               form += "<select name =\"eventType\"id='dropdown' >\n +"
                       + "<option value=\"1\" selected>Lecture</option>\n" +
                       "<option value=\"2\" selected>Meeting</option>\n" +
                       "<option value=\"3\" selected>Tutorial</option>\n" +
                       "<option value=\"4\" selected>Other</option>\n"+
                       "</select><br />";
               
               if( isLecturer( userId ) ) {
                   form += "<label for='stream'>Stream:</label>\n";
                   form += "<select name=\"stream\"id='dropdown' >\n" +
                        "  <option value=\"1\" selected>Computer Sci Year 1</option>\n" +
                        "  <option value=\"2\">Core Year 2</option>\n" +
                        "  <option value=\"3\">Core Year 3</option>\n" +
                        "  <option value=\"4\">Core Year 4</option>\n" +
                        "  <option value=\"5\">Web Year 2</option>\n" +
                        "  <option value=\"6\">Web Year 3</option>\n" +
                        "  <option value=\"7\">Web Year 4</option>\n" +
                        "  <option value=\"8\">Soft Entrep Year 2</option>\n" +
                        "  <option value=\"9\">Soft Entrep Year 3</option>\n" +
                        "  <option value=\"10\">Soft Entrep Year 4</option>\n" +
                        "  <option value=\"11\">Chinese Year 2</option>\n" +
                        "  <option value=\"12\">Chinese Year 3</option>\n" +
                        "  <option value=\"13\">Chinese Year 4</option>\n" +
                        "</select><br />"; 
               }
               else{
                   //get the user id's of all of the students in the same stream as the student and
                   //offer to set meeting with these students.
                   this.stream = database.
                   
               }
              
                                                
               form += "<label for=\"startDate\">Preferred Day:</label>\n";
               form += "<input type=\"text\" class=\"datepicker\" name=\"startDate\" value=\"" + startDate + "\" placeholder=\"2015/01/01\"/><br />\n";
                              
               form += "<label for=\"recurrence\">Recurrence:</label>\n";
               form += "<select name=\"recurrence\" id='dropdown'>" +
                       "    <option value=\"once\" selected>Single Meeting</option>" +
                       "    <option value=\"weekly\">Weekly</option>" +
                       "    <option value=\"montly\">Monthly</option>" +
                       "</select><br />";
               
                          
               form += "<input type='submit' value='Search Availability' name='submit' /><br />\n";
               form += "</form>\n";
               
        return form;
    }
}
