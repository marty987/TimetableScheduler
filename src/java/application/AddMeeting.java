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
    
    public String getStartTime( ) {
        return startTime;
    } 
    
    public void setStartTime( String startTime ) {
        this.startTime = startTime;
    }
    
    public String getEndTime( ) {
        return startTime;
    } 
    
    public void setEndTime( String startTime ) {
        this.startTime = startTime;
    }
    
    public String getStartDate( ) {
        return startDate;
    } 
    
    public void setStartDate( String startDate ) {
        this.startDate = startDate;
    }
            
    public void setEndDate( String endDate ) {
        this.endDate = endDate;
    } 
}
