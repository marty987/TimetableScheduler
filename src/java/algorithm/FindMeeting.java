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
    private String[] groupMembers;
    private final ArrayList<String> errors;
    private final DatabaseClass database;

    /**
     * Constructor for the class.
     */
    public FindMeeting( ) {
        this.period = 0;
        this.date = "";
        this.stream = "";
        this.errors = new ArrayList<>( );
        this.database = new DatabaseClass( );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    
    /**
     * Returns the stream in which the user is currently looking for a free time slot.
     * @param
     */
    public String getStream( ) {
        return stream;
    }
    
    /**
     * Returns the date in which the user is currently looking for a free time slot.
     * @return The date user entered into the search free slot form 
     */
    public String getDate( ) {
        return date;
    }
    
    /**
     * Returns the current free period after the search free slot algorithm has been run.
     * @retutn The free period of the day the user specified.
     */
    public int getPeriod( ) {
        return period;
    }
    
    /**
     * Funtion to set up the servlet for Javascript. Allows the stream and date 
     * to be taken from the form and used globally in the class
     * @param request Form.
     */
    public void processFormData( HttpServletRequest request ) {
        stream = request.getParameter( "stream" );
        date = request.getParameter( "date" );
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
     * @param memberNumber - user id.
     * @return an array of period slots that correspond to times of events that the member has
     * on the given day. (Integers)
     */
    public int[] getMembersEvents( int memberNumber ){
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
                return true;
            }
        }
         
        return false;
    }
     
    public boolean hasUserThisFreePeriod( String member, int currentFreePeriod ) {
        int[] freePeriod = database.SelectIntColumn( "SELECT events.period "
                                                   + "FROM events JOIN has_events JOIN users "
                                                   + "ON events.event_id = has_events.event_id AND users.user_id = has_events.user_id " 
                                                   + "WHERE users.user_id = '" + member + "' AND events.period = '" + currentFreePeriod + "';" );
         
        if( freePeriod.length == 0 ){
            return false;
        }
        return true;
    }
     
    /**
     * Function designed to get a free slot that could be used for a meeting based on the timetables
     * of the students in the stream picked by the user.
     * @return period during the start_date day that is free for all members of the stream.
     * represented by an integer.
     */
    public int getFreeSlot(  ) {
        int memberNumber = 0;
        int currentFreePeriod = 0;
        boolean currentUserHasFreePeriod = true;
         
        groupMembers = getGroupMembers( );
        int[] lectureTimes = getLectureTimes(  );
        int[] eventTimes = getMembersEvents( memberNumber );  
                  
        while( memberNumber < groupMembers.length ) {
            System.out.println( "Member: " + memberNumber );
            
            if( memberNumber >= 1 && currentFreePeriod >= 1 ) {
                System.out.println( "checking next user also has this free period");
                currentUserHasFreePeriod = hasUserThisFreePeriod( groupMembers[memberNumber], currentFreePeriod );
            }
             
            if( currentUserHasFreePeriod ) {
                for( int period = 1; period < 11; period++ ){   
                    System.out.println( "period: " + period + " - is already taken: " + intIsInArray( period, lectureTimes ));

                    if( intIsInArray( period, lectureTimes ) ) {
                       //memberNumber = 0;
                    }
                    else {
                       System.out.println( "Current member free period " + period );

                       if( ! intIsInArray( period, eventTimes ) ) {
                           if( memberNumber == groupMembers.length - 1 ) {
                               System.out.println( "Found free period for Group: " + currentFreePeriod );
                               return currentFreePeriod = period;
                           }
                           else {
                               System.out.println( "Moving on to next group member" );
                               currentFreePeriod = period;
                               memberNumber += 1 ;
                               period = 11;    
                           }                                    
                       }
                    }
                }
            }
            else {
                System.out.println( "This member also has the same free time slot: " + memberNumber );
                memberNumber++;
            }
        } 
        System.out.println("We found free time period: " + currentFreePeriod );
        return currentFreePeriod;
    }
     
   /**
    * Form used to get the information of the type of meeting to be set and the preferred day to meet.
    * If the form user is a lecturer, they can make a meeting with a full class. However, if they are 
    * a student, they can only make meetings with other classmates.
    * @return form
    */
    public String findMeetingForm( ) {
        String form = "<form name=\"find_meeting\" action=\"timetable.jsp\" method=\"POST\">\n" 
                        + "<label for=\"eventType\">Event Type:</label>\n"
                        + "<select name=\"eventType\" >\n"
                            + "<option value=\"Lecture\" selected>Lecture</option>\n" 
                            + "<option value=\"Meeting\" selected>Meeting</option>\n" 
                            + "<option value=\"Tutorial\" selected>Tutorial</option>\n" 
                            + "<option value=\"Group Meeting\" selected>Group Meeting</option>\n" 
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
