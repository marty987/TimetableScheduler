/*
*@author Emily Horgan 112340841
* 26/02/2015
*/
package algorithm;

import dbpackage.DatabaseClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FindMeeting {
    private String stream;
    private String student;
    private String[] groupMembers;
    private final ArrayList<String> errors;
    private final DatabaseClass database;
    private Connection connectionObject;
    private Statement statementObject;
    
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

           if( dbResult.length == 0 || dbResult[0].equals( "0" )) {
               return false;
           } 
           return true;
     }

     public String[] getGroupMembers(String stream) {
         String[] userIds;
         userIds = database.SelectRow("SELECT user_id FROM users WHERE stream = '"+ stream +"'");
         return userIds;
     }
//     public String[] getGroupMembers() throws SQLException {
//         String[] users = {""};
//        // Establish connection to database
//        connectionObject = DriverManager.getConnection( "jdbc:mysql://" + "cs1.ucc.ie" + "/" + "2016_mjb2", "mjb2", "diechoro" );
//        
//        try{
//            statementObject = connectionObject.createStatement( );
//            ResultSet statementResult = statementObject.executeQuery( "Select user_id FROM users;" );
//            while( statementResult.next( ) ){
//                  String group = statementResult.getString( 1 );         
//            }
//        }
//        catch( SQLException exceptionObject ){
//           
//        }
//        finally{
//               return users;
//        }
//         
//         
//    
//         return groupMembers;
//     }
     
     public int[] getLectureTimes(String startDate){
         String member = groupMembers[0];
         
         int[] lectureTimes = database.SelectIntColumn("SELECT period FROM events JOIN has_events JOIN users ON events.event_id = has_events.event_id "
                 + "AND users.user_id = has_events.user_id WHERE events.start_date = '" + startDate + "' AND users.user_id = '" + member + "' AND events.event_type = "
                 + "'Lecture'"); 
          
        
         return lectureTimes;
     }
     
     public int[] getMembersEvents(String startDate, int memberNumber){
         String member = groupMembers[memberNumber];
         
         int[] otherEvents = database.SelectIntColumn("SELECT period FROM events JOIN has_events JOIN users ON events.event_id = has_events.event_id "
                 + "AND users.user_id = has_events.user_id WHERE events.start_date = '" + startDate + "' AND users.user_id = '" + member + "' AND events.event_type != "
                 + "'Lecture'"); 
          
        
         return otherEvents;
     }
  
     public int getFreeSlot(String start_date, String stream){
         String[] groupMembers = getGroupMembers(stream);
         int memberNumber = 0;
         int[] lectureTimes = getLectureTimes(start_date);
         int[] eventTimes = getMembersEvents(start_date, memberNumber);
         int currentFreeTime = -1;
         
         while( memberNumber < groupMembers.length ){
             for(int period = 0; period < 9 ; period++){
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
        String form = "<form name=\"find_meeting\" action=\"timetable.jsp\" method=\"POST\">\n";

        form += "<label for=\"eventType\">Event Type:</label>\n"
              + "<select name =\"eventType\" >\n +"
                  + "<option value=\"1\" selected>Lecture</option>\n" 
                  + "<option value=\"2\" selected>Meeting</option>\n" 
                  + "<option value=\"3\" selected>Tutorial</option>\n" 
                  + "<option value=\"4\" selected>Other</option>\n" 
              + "</select><br />";

         if( isLecturer( userId ) ) {
             form += "<label for='stream'>Stream:</label>\n"
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

        form += "<label for=\"startDate\">Preferred Day:</label>\n"
              + "<input type=\"text\" class=\"datepicker\" name=\"startDate\" value=\"\" placeholder=\"2015/01/01\"/><br />\n"
              + "<label for=\"recurrence\">Recurrence:</label>\n"
              + "<select name=\"recurrence\" id='dropdown'>" 
              + "  <option value=\"once\" selected>Single Meeting</option>" 
              + "  <option value=\"weekly\">Weekly</option>" 
              + "  <option value=\"montly\">Monthly</option>" 
              + "</select><br />";


        form += "<input type='submit' value='Search Availability' name='find_meet' /><br />\n";
        form += "</form>\n";

        return form;
    }
}
