package application;
/**
 * @author Martin Bullman 112735341
 * @since Feb 8, 2015, 12:56:25 PM
 */
import dbpackage.DatabaseClass;
import java.util.ArrayList;

public class AddMeeting {
    private String creatorID;
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
    
    public AddMeeting( ){
        this.creatorID = "";
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
    
    public String getEventName( ){
        return eventName;
    }
    
    public void setEventName( final String eventName ){
        this.eventName = eventName;
    }
    
    public String getEventType( ){
        return eventType;
    }
    
    public void setEventType( final String eventType ){
        this.eventType = eventType;
    }
    
    public String getPeriod( ){
        return period;
    }
    
    public void setPeriod( final String period ){
        this.period = period;
    }
    
    public String getStartDate( ) {
        return startDate;
    } 
    
    public void setStartDate( final String startDate ) {
        this.startDate = startDate;
    }
            
    public String getEndDate( ) {
        return endDate;
    } 
    
    public void setEndDate( final String endDate ) {
        this.endDate = endDate;
    }
    
    public String getRecurrence( ) {
        return recurrence;
    } 
    
    public void setRecurrence( final String recurrence ) {
        this.recurrence = recurrence;
    }
    
    public String getModuleCode( ) {
        return moduleCode;
    } 
    
    public void setModuleCode( final String moduleCode ) {
        this.moduleCode = moduleCode;
    }
    
    public String getLocation( ) {
        return location;
    } 
    
    public void setLocation( final String location ) {
        this.location = location;
    }
    
    public String getDescription( ) {
        return description;
    } 
    
    public void setDescription( final String description ) {
        this.description = description;
    }   
    
    public String getStream() {
        return stream;
    }
    
    public void setStream(String stream) {
        this.stream = stream;
    }
    
    public boolean validateMeetingForm( ) {
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
            insertNewMeeting( );
        }
        
        return isValid;
    }
    
    public String errors( ) {
        String errorList;
        
        errorList = "<ul>";
            for( String error: errors ) {
                errorList += "<li>" + error + "</li>";
            }
        errorList += "</ul>";
        
        return errorList;
    }
    
    public void insertNewMeeting(  ) {
        database.Insert( "INSERT INTO events( event_name, event_type, stream, period, start_date, end_date, recurrence, module_code, location, description )" +
                         "VALUES( '" + eventName + "', '" + eventType + "', '" + stream + "', '" + period + "', '" + startDate + "', '" +
                          endDate + "', '" + recurrence + "', '" + moduleCode + "', '" + location + "', '" + description + "' );" );
        
        database.Insert( "INSERT INTO has_events( user_id, event_id )" + 
                         "VALUES( '" + creatorID + "', '10' );");
        //database.Close( );
    }
    
    public boolean isLecturer( String userId ) {
        String[] dbResult = database.SelectRow( "SELECT is_admin FROM users WHERE user_id = '" + userId + "';" );
        database.Close( );
        
        if( dbResult.length == 0 || dbResult[0].equals("0")) {
            return false;
        } 
        return true;
    }

    public String addMeetingForm( String userId ) {
        creatorID = userId;
        
        System.out.println( creatorID );
        
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
                  
               //Need a dropdown menu put here
               //form += "<label for=\"startTime\">Start Time:</label>\n";
               //form += "<input type=\"text\" name=\"startTime\" value=\"" + startTime + "\" placeholder=\"01:00:00\" /><br />\n";
               //form += "<label for=\"endTime\">End Time:</label>\n";
               //form += "<input type=\"text\" name=\"endTime\" value=\"" + endTime + "\" placeholder=\"02:00:00\"/><br />\n";
               //form += "<label for=\"startDate\">Start Date:</label>\n"; 
             
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
               form += "<input type=\"text\" name=\"startDate\" value=\"" + startDate + "\" placeholder=\"2015/01/01\"/><br />\n";
               form += "<label for=\"endDate\">End Date:</label>\n";
               form += "<input type=\"text\" name=\"endDate\" value=\"" + endDate + "\" placeholder=\"2015/01/31\"/><br />\n";
               
               form += "<label for=\"recurrence\">Recurrence:</label>\n";
               form += "<select name=\"recurrence\" id='dropdown'>" +
                       "    <option value=\"day\" selected>Single Meeting</option>" +
                       "    <option value=\"weekly\">Weekly</option>" +
                       "    <option value=\"montly\">Monthly</option>" +
                       "    <option value=\"semester\">Semester</option>" +
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
