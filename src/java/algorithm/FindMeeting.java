package algorithm;
/**
 * @author Emily Horgan 112340841 Martin Bullman 112735341
 * @since Feb 27, 2015, 12:56:25 PM
 */
import java.util.*;
import dbpackage.DatabaseClass;
import javax.servlet.http.HttpServletRequest;

public class FindMeeting {
    private String date; 
    private String stream;
    private String[] groupMembers;
    private String[] privateGroupMembers;
    private final DatabaseClass database;
    private final ArrayList<String> errors;
    private ArrayList<String> periodTimes;
    private ArrayList<Integer> busyPeriods;
    private ArrayList<Integer> currentFreePeriods;


    /**
     * Constructor for the class.
     */
    public FindMeeting( ) {
        this.date = "";
        this.stream = "";
        this.privateGroupMembers = new String[5];
        this.errors = new ArrayList<>( );
        this.database = new DatabaseClass( );
        this.busyPeriods = new ArrayList<>( );
        this.periodTimes = new ArrayList<>( );
        this.currentFreePeriods = new ArrayList<>( );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
        
        periodTimes.add( "8:00am-9:00am" );
        periodTimes.add( "9:00am - 10:00am" );
        periodTimes.add( "10:00am - 11:00am" );
        periodTimes.add( "11:00am - 12:00am" );
        periodTimes.add( "12:00pm - 1:00pm" );
        periodTimes.add( "1:00pm - 2:00pm" );
        periodTimes.add( "2:00pm - 3:00pm" );
        periodTimes.add( "3:00pm - 4:00pm" ); 
        periodTimes.add( "4:00pm - 5:00pm" );
        periodTimes.add( "5:00pm - 6:00pm" );
    }
    
    public ArrayList<String> getPeriodTimes() {
        return periodTimes;
    }
    
    public String[] getGroupMembers() {
        return groupMembers;
    }
    
    /**
     * Funtion to set up the servlet for Javascript. Allows the stream and date 
     * to be taken from the form and used globally in the class
     * @param request Form.
     */
    public boolean processFindSlotFormData( HttpServletRequest request ) {
        boolean isValid = true;
        
        stream = request.getParameter( "pick_stream" );
        date = request.getParameter( "date" );
        
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
     * Function to check is logged in user is a lecturer/administrative staff member or student.
     * @param userId
     * @return true if lecturer or administrative staff member and false if otherwise.
     */
    public boolean isLecturer( String userId ) {
        String[] dbResult = database.SelectRow( "SELECT is_admin FROM users WHERE user_id = '" + userId + "';" );
        //database.Close( );
        
        if( dbResult.length == 0 || dbResult[0].equals("0")) {
            return false;
        } 
        return true;
    }

    /**
     * Function to get the group members of a certain stream. The stream is whatever 
     * is chosen through the form which is taken as a global variable.
     * @return An array of user id's of the students in the selected stream. (Strings)
     */
    public String[] getStreamGroupMembers( ) {
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
    public int[] getLectureTimes( int memberNumber ){ 
        String member = groupMembers[ memberNumber ];
        
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
    
    public String[] getStreams() {
        String[] streams = database.SelectColumn( "SELECT group_name FROM groups;" );
        
        System.out.println( Arrays.toString(streams) );
        return streams;
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
                if( currentFreePeriods.contains( period ) ) {
                    int index = currentFreePeriods.indexOf( period );
                        currentFreePeriods.remove( index );
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
    public ArrayList<Integer> getFreeSlot( HttpServletRequest request ) {
        int currentMember = 0;
        
        if( request.getParameter("checker") != null){
            groupMembers = privateGroupMembers;
            System.out.println( "Group Members: " + Arrays.toString( groupMembers ) ); 
        }else{
            groupMembers = getStreamGroupMembers( );
        }
                  
        while( currentMember < groupMembers.length ) {
            System.out.println( "Member: " + currentMember );
            
            int[] lectureTimes = getLectureTimes( currentMember );
            int[] eventTimes = getEventTimes( currentMember );  
            
            for( int period = 1; period < 11; period++ ) {   
                System.out.println( "period: " + period + " - is already taken: " + intIsInArray( period, lectureTimes ));

                if( intIsInArray( period, lectureTimes ) ) {
                    
                }
                else {
                    if( ! intIsInArray( period, eventTimes ) ) {
                        if( ! currentFreePeriods.contains( period ) && ! busyPeriods.contains( period ) ) {
                            System.out.println( "New free period: " + period );
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
    
    public int getTimePeriodIndex( String period ) {
        int index = 0;
        
        for( int i = 0; i < periodTimes.size(); i++ ){
            if( periodTimes.get( i ).equals( period ) )
            {
                index = i;
                return index + 1;
            }
        }
        
        return index;
    }
    
    public String pickAvailablePeriodFrom( String stream, String date ) {
        String form = "<form name=\"available_times\" action=\"add_meeting.jsp\" method=\"POST\">\n"
                      + "<h3>Free Periods</h3>"   
                      + "<input type=\"hidden\" name=\"pick_stream\" value=\"" + stream + "\" />" 
                      + "<input type=\"hidden\" name=\"date\" value=\"" + date + "\" />";  
     
        int counter = 0;
        for( int i = 0; i <= 9; i++ ) {
            if( currentFreePeriods.contains( i + 1) ) {
                if( counter == 0 ) {
                    form += "<label for=\"free_period\"> " + periodTimes.get( i ) + "</label>\n"
                          + "<input type=\"radio\" name=\"free_period\" value=\"" + periodTimes.get( i ) + "\" checked=\"checked\"/><br />";
                    counter++;
                }
                else {
                    form += "<label for=\"free_period\"> " + periodTimes.get( i ) + "</label>\n"
                          + "<input type=\"radio\" name=\"free_period\" value=\"" + periodTimes.get( i ) + "\" /><br />";
                }
            }
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
    public String findMeetingForm( ) {
        String form = "<form name=\"find_meeting\" action=\"timetable.jsp\" method=\"POST\">\n"
                        + "<label for='pick_stream'>Stream:</label>\n"
                        + "<select id='dropdown' name=\"pick_stream\" >\n" 
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

                        + "<input type='submit' value='Search Availability!' name='find_meeting' /><br />\n"
                    + "</form>\n";

        return form;
    }

    public boolean checkGroupMembers( ){
        for( int i = 0; i < 5; i++){
            if( ! privateGroupMembers[i].equals( "" ) ) {
                String[] dbResult = database.SelectRow("SELECT * FROM users WHERE user_id = '" + privateGroupMembers[i] + "';");
                if(dbResult.length == 0){
                    //user doesn't exist in database
                    System.out.println( dbResult[0] );
                }
            }
        }
        
        System.out.println(  );
        return true;
    }
    
    public boolean validatePrivateGroupForm( HttpServletRequest request ) {
        boolean isValid = true;
        
        privateGroupMembers[0] = request.getParameter( "member1" );
        privateGroupMembers[1] = request.getParameter( "member2" );
        privateGroupMembers[2] = request.getParameter( "member3" );
        privateGroupMembers[3] = request.getParameter( "member4" );
        privateGroupMembers[4] = request.getParameter( "member5" );      
        date = request.getParameter( "group_date" );
        
        if( privateGroupMembers[0].equals("") || privateGroupMembers[1].equals("") ) {
            isValid = false;
            errors.add("Must have at least two members to create a group!");
        }
        if( date.equals( "" ) ) {
            isValid = false;
            errors.add("Date is required!");
        }

        return isValid;
    }
    
    public String groupFrom( ) {
         String form = "<form name=\"find_meeting\" action=\"timetable.jsp\" method=\"POST\">\n" 
                        + "<h4>Create Personal Group Event</h4>"
                 
                        + "<input type=\"hidden\" name=\"checker\"/><br />\n"
                        
                        + "<label for='member1'>Member 1:</label>\n"
                        + "<input type=\"text\" name=\"member1\" value=\"" + ( privateGroupMembers[0] != null ? privateGroupMembers[0] : "" ) + "\" placeholder=\"Student 1\"/><br />\n"
                 
                        + "<label for='member2'>Member 2:</label>\n"
                        + "<input type=\"text\" name=\"member2\" value=\"" + ( privateGroupMembers[1] != null ? privateGroupMembers[1] : "" ) + "\" placeholder=\"Student 2\"/><br />\n"
                 
                        + "<label for='member3'>Member 3:</label>\n"
                        + "<input type=\"text\" name=\"member3\" value=\"" + ( privateGroupMembers[2] != null ? privateGroupMembers[2] : "" ) + "\" placeholder=\"Student 3\"/><br />\n"
                 
                        + "<label for='member4'>Member 4:</label>\n"
                        + "<input type=\"text\" name=\"member4\" value=\"" + ( privateGroupMembers[3] != null ? privateGroupMembers[3] : "" ) + "\" placeholder=\"Student 4\"/><br />\n"
                 
                        + "<label for='member5'>Member 5:</label>\n"
                        + "<input type=\"text\" name=\"member5\" value=\"" + ( privateGroupMembers[4] != null ? privateGroupMembers[4] : "" ) + "\" placeholder=\"Student 5\"/><br />\n"
                 
                        + "<label for=\"group_date\">Preferred Day:</label>\n"
                        + "<input type=\"text\" class=\"datepicker\" name=\"group_date\" value=\"" + date + "\" placeholder=\"2015/01/01\"/><br />\n"

                        + "<input type='submit' value='Create Personal Group Event!' name='get_members' /><br />\n"
                    + "</form>\n";

        return form;
    }
    
    
}
