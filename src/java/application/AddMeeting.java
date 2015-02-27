package application;
/**
 * Class designed to add a meeting to your own personal calender.
 * @author Martin Bullman 112735341
 * @since Feb 8, 2015, 12:56:25 PM
 */
import dbpackage.DatabaseClass;
import java.util.ArrayList;

public class AddMeeting {
    private String eventName;
    private String eventType;
    private String stream;
    private String period;
    private String startDate;
    private String endDate;
    private String recurrence;
    private String moduleCode;
    private String location;
    private String description;
    private final DatabaseClass database;
    private final ArrayList<String> errors;
    /**
     * Constructor for the class
     */
    public AddMeeting( ){
        this.eventName = "";
        this.eventType = "";
        this.stream = "";
        this.period = "";
        this.startDate = "";
        this.endDate = "";
        this.recurrence = "";
        this.moduleCode = "";
        this.location = "";
        this.description = "";
        this.errors = new ArrayList<>( );
        this.database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    /**
     * Getter method for the variable eventName ie. the name of the event (CS3500, Group Meeting)
     * @return variable eventName (String)
     */
    public String getEventName( ){
        return eventName;
    }
    /**
     * Setter method for the variable eventName ie. the name of the event (CS3500, Group Meeting)
     * @param eventName (String)
     */
    public void setEventName( final String eventName ){
        this.eventName = eventName;
    }
    /**
     * Getter method for the variable eventType ie the type of event being created (Meeting, lecture)
     * @return variable eventType (String)
     */
    public String getEventType( ){
        return eventType;
    }
    /**
     * Setter method for the variable eventType ie the type of event being created (Meeting, lecture)
     * @param eventType (String)
     */
    public void setEventType( final String eventType ){
        this.eventType = eventType;
    }
    /**
     * Getter method for the variable period ie the integer representation of a timeslot during a college
     * day which you can schedule a meeting during.
     * @return variable period (integer)
     */
    public String getPeriod( ){
        return period;
    }
    /**
     * Setter method for the variable period ie the integer representation of a timeslot during a college
     * day which you can schedule a meeting during.
     * @param period (integer)
     */
    public void setPeriod( final String period ){
        this.period = period;
    }
    /**
     * Getter method for the start date of the event.
     * @return variable startDate (string)
     */
    public String getStartDate( ) {
        return startDate;
    } 
    /**
     * Setter method for the start date of the event.
     * @param startDate (integer)
     */
    public void setStartDate( final String startDate ) {
        this.startDate = startDate;
    }
    /**
     * Getter method for the end date of the event.
     * @return variable endDate (string)
     */
    public String getEndDate( ) {
        return endDate;
    } 
    /**
     * Setter method for the end date of the event
     * @param endDate (string)
     */
    public void setEndDate( final String endDate ) {
        this.endDate = endDate;
    }
    /**
     * Getter method for the state of the event (once off or recurring)
     * @return variable recurrence (String)
     */
    public String getRecurrence( ) {
        return recurrence;
    } 
    /**
     * Setter method for the state of the event (once off or recurring)
     * @param recurrence (string)
     */
    public void setRecurrence( final String recurrence ) {
        this.recurrence = recurrence;
    }
    /**
     * Getter method for the module code of a module.
     * @return variable moduleCode(string)
     */
    public String getModuleCode( ) {
        return moduleCode;
    } 
    /**
     * Setter method for the module code of a module.
     * @param moduleCode (string)
     */
    public void setModuleCode( final String moduleCode ) {
        this.moduleCode = moduleCode;
    }
    /**
     * Getter method for the location of the event.
     * @return variable location (string)
     */
    public String getLocation( ) {
        return location;
    } 
    /**
     * Setter method for the location of the event.
     * @param location (string)
     */
    public void setLocation( final String location ) {
        this.location = location;
    }
    /**
     * Getter method for the description of the event.
     * @return variable description (string)
     */
    public String getDescription( ) {
        return description;
    } 
    /**
     * Setter method for the description of the event.
     * @param description (string)
     */
    public void setDescription( final String description ) {
        this.description = description;
    }   
    /**
     * Setter method for the stream that a student is enrolled in. (ie. Core stream, web stream)
     * @return variable stream (string)
     */
    public String getStream() {
        return stream;
    }
    /**
     * Setter method for the stream that a student is enrolled in. (ie Core stream, web stream)
     * @param stream (string)
     */
    public void setStream( final String stream) {
        this.stream = stream;
    }
    /**
     * Function to ensure that the user has filled out the form correctly when adding a meeting.
     * @param userId Your student id.
     * @return true if form is filled out correctly and false otherwise.
     */
    public boolean validateMeetingForm( final String userId ) {
        boolean isValid = true;

        if( eventName.equals ("") ){
            errors.add( "Event Name required");
            isValid = false;
            eventName = "";
        }
        
        if( eventType.equals ("") ){
            errors.add( "Event Type required");
            isValid = false;
            eventType = "";
        }
        
        if( startDate.equals( "" ) || startDate.length() != 10 ) {
            errors.add( "Start date required. Must be in yyyy/mm/dd format." );
            isValid = false;
            startDate = "";
        }
        
        if( endDate.equals( "" ) || endDate.length( ) != 10 ) {
            errors.add( "End date required. Must be in yyyy/mm/dd format." );
            isValid = false;
            endDate = "";
        }
        
        if( moduleCode.equals( "" ) || moduleCode.length( ) > 6 ) {
            errors.add( "Module Code required. Must be six characters in length" );
            isValid = false;
            moduleCode = "";
        }
        
        if( location.equals( "" ) || location.length( ) > 100 ) {
            errors.add( "Location required. No greater that one hundred characters" );
            isValid = false;
            location = "";
        }
        
        if( description.equals( "" ) ) {
            errors.add( "Description required." );
            isValid = false;
            description = "";
        }
        
        if( isValid ) {
            insertNewMeeting( userId );
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
     * Function to insert a new meeting into the database and into a student's timetable.
     * @param userId the student's user ID.
     */
    public void insertNewMeeting( String userId ) {
        database.Insert( "INSERT INTO events( event_name, event_type, stream, period, start_date, end_date, recurrence, module_code, location, description )" +
                         "VALUES( '" + eventName + "', '" + eventType + "', '" + stream + "', '" + period + "', '" + startDate + "', '" +
                          endDate + "', '" + recurrence + "', '" + moduleCode + "', '" + location + "', '" + description + "' );" );
        
        String[] last = database.SelectRow( "SELECT MAX( event_id ) FROM events;" );
        
        System.out.println( last[0].toString( ) );
        
        database.Insert( "INSERT INTO has_events( user_id, event_id, has_seen )" + 
                         "VALUES( '" + userId+ "', '" + last[0].toString( ) + "', '0' );");
        //database.Close( );
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
     * Function to get the user's (type student) stream.
     * @param userId
     * @return the variable stream (string)
     */
    public String getUserStream(String userId){
        String[] userStream = database.SelectRow("SELECT stream FROM users WHERE user_id ='"+ userId +"';");
        return userStream[0];
    }
    /**
     * Form used to add a meeting.
     * @param userId
     * @return form (string)
     */
    public String addMeetingForm( String userId ) {
        String form = "<form name=\"add_meeting\" action=\"add_meeting.jsp\" method=\"POST\">\n";
               
               form += "<label for=\"eventName\">Event Name:</label>\n";
               form += "<input type=\"text\" name=\"eventName\" value=\"" + eventName + "\" placeholder=\"Team Meeting\"/><br />\n";
               form += "<label for=\"eventType\">Event Type:</label>\n";
               form += "<input type=\"text\" name=\"eventType\" value=\"" + eventType + "\" placeholder=\"Meeting\"/><br />\n";
               
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
                   String userStream = getUserStream(userId);
                   setStream(userStream);
               }
             
               form += "<label for=\"period\">Period:</label>\n";
               form += "<select name=\"period\" id='dropdown'>" +
                       "    <option value=\"1\" selected>8:00 - 9:00</option>" +
                       "    <option value=\"2\">9:00 - 10:00</option>" +
                       "    <option value=\"3\">10:00 - 11:00</option>" +
                       "    <option value=\"4\">11:00 - 12:00</option>" +
                       "    <option value=\"5\">12:00 - 13:00</option>" +
                       "    <option value=\"6\">13:00 - 14:00</option>" +
                       "    <option value=\"7\">14:00 - 15:00</option>" +
                       "    <option value=\"8\">15:00 - 16:00</option>" +
                       "    <option value=\"9\">16:00 - 17:00</option>" +
                       "    <option value=\"10\">17:00 - 18:00</option>" +
                       "</select><br />";
               
               form += "<label for=\"startDate\">Start Date:</label>\n";
               form += "<input type=\"text\" class=\"datepicker\" name=\"startDate\" value=\"" + startDate + "\" placeholder=\"2015/01/01\"/><br />\n";
               form += "<label for=\"endDate\">End Date:</label>\n";
               form += "<input type=\"text\" class=\"datepicker\" name=\"endDate\" value=\"" + endDate + "\" placeholder=\"2015/01/31\"/><br />\n";
               
               form += "<label for=\"recurrence\">Recurrence:</label>\n";
               form += "<select name=\"recurrence\" id='dropdown'>" +
                       "    <option value=\"once\" selected>Single Meeting</option>" +
                       "    <option value=\"weekly\">Weekly</option>" +
                       "    <option value=\"montly\">Monthly</option>" +
                       "</select><br />";
                          
               form += "<label for=\"moduleCode\">Module Code:</label>\n";
               form += "<input type=\"text\" name=\"moduleCode\" value=\"" + moduleCode + "\" placeholder=\"CS3505\"/><br />\n";
               form += "<label for=\"location\">Location:</label>\n";
               form += "<input type=\"text\" name=\"location\" value=\"" + location + "\" placeholder=\"WGB 1.01\"/><br />\n";
               form += "<textarea name=\"description\" rows=\"10\" cols=\"30\" placeholder=\"Add description here!\">" + description + "</textarea><br />\n";
        
               form += "<input type='submit' value='Submit' name='submit' /><br />\n";
               form += "</form>\n";
               
        return form;
    }
}