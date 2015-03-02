package algorithm;
/**
 * @author Emily Horgan 112340841 Martin Bullman 112735341
 * @since Feb 27, 2015, 12:56:25 PM
 */
import java.util.*;
import dbpackage.DatabaseClass;
import javax.servlet.http.HttpServletRequest;

public class FindMeeting {
    private int period;
    private String date; 
    private String stream;
    private String eventType;
    private String recurrence;
    private String[] groupMembers;
    private final DatabaseClass database;
    private final ArrayList<String> errors;
    private ArrayList<Integer> currentFreePeriods;
    private ArrayList<Integer> busyPeriods;

    /**
     * Constructor for the class.
     */
    public FindMeeting( ) {
        this.period = 0;
        this.date = "";
        this.stream = "";
        this.eventType = "";
        this.recurrence = "";
        this.errors = new ArrayList<>( );
        this.database = new DatabaseClass( );
        this.busyPeriods = new ArrayList<>( );
        this.currentFreePeriods = new ArrayList<>( );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    
    /**
     * Funtion to set up the servlet for Javascript. Allows the stream and date 
     * to be taken from the form and used globally in the class
     * @param request Form.
     */
    public boolean processFormData( HttpServletRequest request ) {
        boolean isValid = true;
        
        eventType = request.getParameter( "eventType" );
        stream = request.getParameter( "stream" );
        date = request.getParameter( "date" );
        recurrence = request.getParameter( "recurrence" );
        
        if( date.equals( "" ) ) {
            isValid = false;
            errors.add( "Date is required!" );
        }
        
        return isValid;
    }
    
    /**
     * function to collect any error messages that are created throughout the creation and implementation
     * of the addFriend class.
     * @return a string of errors.
     */
    public String errors( ) {
        String errorList;
        
        errorList = "<ul>";
            for( String error: errors ) {
                errorList += "<li>" + error + "</li>";
            }
        errorList += "</ul>";
        
        return errorList;
    }

    /**
     * Function to get the group members of a certain stream. The stream is whatever 
     * is chosen through the form which is taken as a global variable.
     * @return An array of user id's of the students in the selected stream. (Strings)
     */
    public String[] getGroupMembers( ) {
        groupMembers = database.SelectColumn( "SELECT user_id FROM users WHERE stream = '" + stream + "';" );
        if( groupMembers.length == 0 ) {
            groupMembers = new String[]{ "000000000" };
        }  
        
        System.out.println( "Group Members: " + Arrays.toString( groupMembers ) );   
         
        return groupMembers;
    }
     
    /**
     * Function to get the times of the lectures of a certain stream ie. the master timetable
     * that is common to all students of the stream.
     * @return array of the period slots which lectures occur in a given day. Day defined using the 
     * global variable 'start_date' chosen through the form. (Integers)
     */
    public int[] getLectureTimes(  ){ 
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
     * @param memberNumber - user id.
     * @return an array of period slots that correspond to times of events that the member has
     * on the given day. (Integers)
     */
    public int[] getEventTimes( int memberNumber ){
        String member = groupMembers[memberNumber];
         
        int[] otherEvents = database.SelectIntColumn( "SELECT period "
                                                     + "FROM events JOIN has_events JOIN users "
                                                     + "ON events.event_id = has_events.event_id AND users.user_id = has_events.user_id "
                                                     + "WHERE events.start_date = '" + date + "' AND users.user_id = '" + member + "' AND events.event_type != 'Lecture';" ); 
          
        System.out.println( "Other periods: " + Arrays.toString( otherEvents ) );    
        return otherEvents;
    }
     
    /**
     * Check if a given integer array contains a given int ( period ).
     * 
     * @param period the integer value which corresponds to a time period
     * @param array The list of periods in which the user is busy
     * @return True if the given period is not in the list of the users current list busy periods
     */
    public boolean intIsInArray( int period, int[] array ) {
        for( int i = 0; i < array.length; i++ ) {
            if( period == array[i] ) {
                if( ! busyPeriods.contains( period ) ) {
                    busyPeriods.add( period );
                }
                return true;
            }
        }
         
        return false;
    }
     
    /**
     * Function designed to get a free slot that could be used for a meeting based on the timetables
     * of the students in the stream picked by the user.
     * @return period during the start_date day that is free for all members of the stream.
     * represented by an integer.
     */
    public ArrayList<Integer> getFreeSlot(  ) {
        int currentMember = 0;
        groupMembers = getGroupMembers( );
                  
        while( currentMember < groupMembers.length ) {
            System.out.println( "Member: " + currentMember );
            
            int[] lectureTimes = getLectureTimes(  );
            int[] eventTimes = getEventTimes( currentMember );  
            
            for( int period = 1; period < 11; period++ ) {   
                System.out.println( "period: " + period + " - is already taken: " + intIsInArray( period, lectureTimes ));

                if( intIsInArray( period, lectureTimes ) ) {
                    if( currentFreePeriods.contains( period ) ) {
                        currentFreePeriods.remove( period );
                    }
                }
                else {
                    System.out.println( "Free period " + period );
                    
                    if( ! intIsInArray( period, eventTimes ) ) {
                        if( ! currentFreePeriods.contains( period ) && ! busyPeriods.contains( period ) ) {
                            System.out.println( "added new free period: " + period );
                            currentFreePeriods.add( period );
                        }
                    }
                    else {
                        System.out.println( "Period is already used: " );
                    } 
                }
            }
            
            System.out.println( "current free periods: " + currentFreePeriods );
            System.out.println( "busy Periods: " + busyPeriods );
            currentMember++;
        }
        return currentFreePeriods;
    } 
    
    public String pickAvailablePeriodFrom( ) {
        String form = "<form name=\"available_times\" action=\"add_meeting.jsp\" method=\"POST\">\n"
                      + "<h3>Free Periods</h2>";    
     
        int count = currentFreePeriods.size( );
        for( int i = 0; i < count; i++ ) {
            int value = currentFreePeriods.get( i );

                form += "<label for=\"free_period\">Period " + value + "</label>\n"
                      + "<input type=\"radio\" name=\"free_period\" value=\"" + value + "\" /><br />";
        }
                
                form += "<input type=\"submit\" name=\"accept_slot\" value=\"Accept Slot!\" />\n"
                    + "</form>";
              
        return form;
    }
     
   /**
    * Form used to get the information of the type of meeting to be set and the preferred day to meet.
    * If the form user is a lecturer, they can make a meeting with a full class. However, if they are 
    * a student, they can only make meetings with other classmates.
    * @return form
    */
    public String findMeetingForm(  ) {
        String form = "<form name=\"find_meeting\" action=\"timetable.jsp\" method=\"POST\">\n" 
                        + "<label for=\"eventType\">Event Type:</label>\n"
                        + "<select name=\"eventType\" >\n"
                            + "<option value=\"Lecture\" selected>Lecture</option>\n" 
                            + "<option value=\"Meeting\">Meeting</option>\n" 
                            + "<option value=\"Tutorial\">Tutorial</option>\n" 
                            + "<option value=\"Group Meeting\">Group Meeting</option>\n" 
                        + "</select><br />"

                        + "<label for='stream'>Stream:</label>\n"
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
                        + "</select><br />"

                        + "<label for=\"date\">Preferred Day:</label>\n"
                        + "<input type=\"text\" class=\"datepicker\" name=\"date\" value=\"" + date + "\" placeholder=\"2015/01/01\"/><br />\n"
                        
                        + "<label for=\"recurrence\">Recurrence:</label>\n"
                        + "<select name=\"recurrence\">\n" 
                        + "  <option value=\"once\" selected>Single Meeting</option>" 
                        + "  <option value=\"weekly\">Weekly</option>" 
                        + "  <option value=\"montly\">Monthly</option>" 
                        + "</select><br />"

                        + "<input type='submit' value='Search Availability' name='find_meeting' /><br />\n"
                    + "</form>\n";

        return form;
    }
}
