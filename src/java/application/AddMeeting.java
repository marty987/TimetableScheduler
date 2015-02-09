package application;
/**
 * @author Martin Bullman 112735341
 * @since Feb 8, 2015, 12:56:25 PM
 */

public class AddMeeting {
    private String startTime;
    private String endTime;
    private String startDate;
    private String endDate;
    private String reoccurance;
    private int moduleCode;
    private int location;
    private int description;
    
    public String getStartTime( ) {
        return startTime;
    } 
    
    public void setStartTime( String startTime ) {
        this.startTime = startTime;
    }
    
    public String getEndTime( ) {
        return endTime;
    } 
    
    public void setEndTime( String endTime ) {
        this.endTime = endTime;
    }
    
    public String getStartDate( ) {
        return startDate;
    } 
    
    public void setStartDate( String startDate ) {
        this.startDate = startDate;
    }
            
    public String getEndDate( ) {
        return endDate;
    } 
    
    public void setEndDate( String endDate ) {
        this.endDate = endDate;
    }
    
    public String getReoccurance( ) {
        return reoccurance;
    } 
    
    public void setReoccurance( String reoccurance ) {
        this.reoccurance = reoccurance;
    }
    
    public int getModuleCode( ) {
        return moduleCode;
    } 
    
    public void setModuleCode( int moduleCode ) {
        this.moduleCode = moduleCode;
    }
    
    public int getLocation( ) {
        return location;
    } 
    
    public void setLocation( int location ) {
        this.location = location;
    }
    
    public int getDescription( ) {
        return description;
    } 
    
    public void setDescription( int description ) {
        this.description = description;
    }
    
    public String addMeetingForm( ) {
        String form = "<form name=\"add_mmeting\" action=\"add_meeting.jsp\" method=\"POST\">";
               form += "<label for=\"startTime\">Start Time:</label>";
               form += "<input type=\"text\" name=\"startTime\" value=" + startTime + " placeholder=\"01:00:00\"/>";
               form += "<label for=\"endTime\">End Time:</label>";
               form += "<input type=\"text\" name=\"endTime\" value=" + endTime + " placeholder=\"02:00:00\"/>";
               form += "<label for=\"startDate\">Start Date:</label>"; 
               form += "<input type=\"text\" name=\"startDate\" value=" + startDate + " placeholder=\"2015/01/01\"/>";
               form += "<label for=\"endDate\">End Date:</label>";
               form += "<input type=\"text\" name=\"endDate\" value=" + endDate + " placeholder=\"2015/01/31\"/>";
               form += "<label for=\"reoccurance\">Reoccurance:</label>";
               form += "<input type=\"text\" name=\"reoccurance\" value=" + reoccurance + " placeholder=\"12:00:00\"/>";
               form += "<label for=\"moduleCode\">Module Code:</label>";
               form += "<input type=\"text\" name=\"moduleCode\" value=" + moduleCode + " placeholder=\"CS3505\"/>";
               form += "<label for=\"location\">Location:</label>";
               form += "<input type=\"text\" name=\"location\" value=" + location + " placeholder=\"WGB 1.01\"/>";
               form += "<textarea name=\"decription\" row=\"20\" cols=\"40\" placeholder=\"Add description here!\">" + description + "</textarea>";
               
               form += "<input type='submit' value='Submit' name='submit' /><br />\n";
               form += "</form>";
               
        return form;
    }
}
