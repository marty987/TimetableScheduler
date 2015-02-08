/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author mjb2
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
    
    public String getStartDate( ) {
        return startDate;
    } 
    
    public void setStartDate( String startDate ) {
        this.startDate = startDate;
    }
            
    
}
