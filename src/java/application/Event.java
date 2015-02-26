/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.*;

/**
 *
 * @author Caroline Corcoran
 */
public class Event {
    private int eventID;
    private String eventName;
    private String eventType;
    private int stream;
    private int period;
    private Calendar startDate;
    private Calendar endDate;
    private String recurrence;
    private String moduleCode;
    private String location;
    private String description;
    
    public Event( int eventID, String eventName, String eventType, int stream, int period, 
            Calendar startDate, Calendar endDate, String recurrence, String moduleCode,
            String location, String description) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventType = eventType;
        this.stream = stream;
        this.period = period;
        this.startDate = startDate;
        this.endDate = endDate;
        this.recurrence = recurrence;
        this.moduleCode = moduleCode;
        this.location = location;
        this.description = description;           
    }
    
    public int getEventID(){
        return eventID;
    }
    
    public void setEventID(int eventID){
        this.eventID = eventID;
    }
    
    public String getEventName(){
        return eventName;
    }
    
    public void setEventName(String eventName){
        this.eventName = eventName;
    }
    
    public String getEventType(){
        return eventType;
    }
    
    public void setEventType(String eventType){
        this.eventType = eventType;
    }
    
    public Calendar getStartDate(){
        return this.startDate;
    }
    
    public void setStartDate(){
        this.startDate = startDate;
    }
    
    public Calendar getEndDate(){
        return this.endDate;
    }
    
    public void setEndDate(){
        this.endDate = endDate;
    }
    
    public int getPeriod( ) {
        return period;
    } 
    
    public void setPeriod( final int period ) {
        this.period = period;
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
}
