package application;
/**
 * @author Martin Bullman 112735341
 * @since Feb 8, 2015, 12:56:25 PM
 */

public class AddMeeting {
    private int eventId;
    private String startTime;
    private String endTime;
    private String startDate;
    private String endDate;
    private String reoccurance;
    private int moduleCode;
    private int location;
    private int description;
    
    public int getEventId( ) {
        return eventId;
    } 
    
    public void setEventId( int eventId ) {
        this.eventId = eventId;
    }
    
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
}
