package application;
/**
 * @author Martin Bullman 112735341
 * @since Feb 8, 2015, 12:56:25 PM
 */
import dbpackage.DatabaseClass;
import java.util.ArrayList;

public class AddMeeting {
    private String startTime;
    private String endTime;
    private String startDate;
    private String endDate;
    private String reoccurance;
    private String moduleCode;
    private String location;
    private String description;
    private final ArrayList<String> errors;
    
    public AddMeeting( ){
        this.startTime = "";
        this.endTime = "";
        this.startDate = "";
        this.endDate = "";
        this.reoccurance = "";
        this.location = "";
        this.description = "";
        this.errors = new ArrayList<>();
    }
    
    public String getStartTime( ) {
        return startTime;
    } 
    
    public void setStartTime( final String startTime ) {
        this.startTime = startTime;
    }
    
    public String getEndTime( ) {
        return endTime;
    } 
    
    public void setEndTime( final String endTime ) {
        this.endTime = endTime;
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
    
    public String getReoccurance( ) {
        return reoccurance;
    } 
    
    public void setReoccurance( final String reoccurance ) {
        this.reoccurance = reoccurance;
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
    
    
    public boolean validateMeetingForm( ) {
        boolean isValid = true;
        
        if( startTime.equals( "" ) ) {
            errors.add( "Start time required. Must be in 12:00:00 format." );
            isValid = false;
            startTime = "";
        }
        
        if( endTime.equals( "" )  ) {
            errors.add( "End time required. Must be in 12:00:00 format." );
            isValid = false;
            endTime = "";
        }
      
        if( startDate.equals( "" )  ) {
            errors.add( "Start date required. Must be in yyyy/mm/dd format." );
            isValid = false;
            startDate = "";
        }
        
        if( endDate.equals( "" ) ) {
            errors.add( "End date required. Must be in yyyy/mm/dd format." );
            isValid = false;
            endDate = "";
        }
        
        if( moduleCode.equals( "" ) ) {
            errors.add( "Module Code required." );
            isValid = false;
            moduleCode = "";
        }
        
        if( location.equals( "" ) ) {
            errors.add( "Location required." );
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
    
    public void insertNewUser(  ) {
        database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
        
        database.Insert( "INSERT INTO users( user_id, stream, first_name, middle_name, last_name, email, password, phone_number, date_joined )" +
                         "VALUES( '" + userId + "', '" + stream + "', '" + firstName + "', '" + middleName 
                            + "', '" + lastName + "', '" + email + "', '" + PasswordHasher.sha256Hash( password2 ) + "', '" + phoneNo 
                            + "', '" + getCurrentDate( ) + "' );" );
    }
    
    
    
    public String addMeetingForm( ) {
        String form = "<form name=\"add_mmeting\" action=\"add_meeting.jsp\" method=\"POST\">\n";
               form += "<label for=\"startTime\">Start Time:</label>\n";
               form += "<input type=\"text\" name=\"startTime\" value=" + startTime + " placeholder=\"01:00:00\"/><br />\n";
               form += "<label for=\"endTime\">End Time:</label>\n";
               form += "<input type=\"text\" name=\"endTime\" value=" + endTime + " placeholder=\"02:00:00\"/><br />\n";
               form += "<label for=\"startDate\">Start Date:</label>\n"; 
               form += "<input type=\"text\" name=\"startDate\" value=" + startDate + " placeholder=\"2015/01/01\"/><br />\n";
               form += "<label for=\"endDate\">End Date:</label>\n";
               form += "<input type=\"text\" name=\"endDate\" value=" + endDate + " placeholder=\"2015/01/31\"/><br />\n";
               form += "<label for=\"reoccurance\">Reoccurance:</label>\n";
               form += "<input type=\"text\" name=\"reoccurance\" value=" + reoccurance + " placeholder=\"12:00:00\"/><br />\n";
               form += "<label for=\"moduleCode\">Module Code:</label>\n";
               form += "<input type=\"text\" name=\"moduleCode\" value=" + moduleCode + " placeholder=\"CS3505\"/><br />\n";
               form += "<label for=\"location\">Location:</label>\n";
               form += "<input type=\"text\" name=\"location\" value=" + location + " placeholder=\"WGB 1.01\"/><br />\n";
               form += "<textarea name=\"decription\" row=\"20\" cols=\"40\" placeholder=\"Add description here!\">" + description + "</textarea><br />\n";
        
               form += "<input type='submit' value='Submit' name='submit' /><br />\n";
               form += "</form>\n";
               
        return form;
    }
}
