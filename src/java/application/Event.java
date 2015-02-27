/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.*;

/**
 *This class defines an event within the scope of the scheduling system.
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
    /**
     * Constructor for the class.
     * @param eventID
     * @param eventName
     * @param eventType
     * @param stream
     * @param period
     * @param startDate
     * @param endDate
     * @param recurrence
     * @param moduleCode
     * @param location
     * @param description 
     */
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
    /**
     * Getter method for the event ID
     * @return the variable eventID (integer)
     */
    public int getEventID(){
        return eventID;
    }
    /**
     * Setter method for the event ID.
     * @param eventID (integer)
     */
    public void setEventID(int eventID){
        this.eventID = eventID;
    }
    /**
     * Getter method for the name of the event. ie CS3500 lecture, Group Meeting
     * @return the variable eventName (string)
     */
    public String getEventName(){
        return eventName;
    }
    /**
     * Setter method for the name of the event ie. CS2500 lecture, Group Meeting
     * @param eventName (string)
     */
    public void setEventName(String eventName){
        this.eventName = eventName;
    }
    /**
     * Getter method for the type of event. ie. Meeting, Lecture
     * @return thhe variable eventType (String)
     */
    public String getEventType(){
        return eventType;
    }
    /**
     * Setter method for the type of event ie. Meeting, Lecture
     * @param eventType (string)
     */
    public void setEventType(String eventType){
        this.eventType = eventType;
    }
    /**
     * Getter method for the start date of the event.
     * @return startDate (calender object)
     */
    public Calendar getStartDate(){
        return this.startDate;
    }
    /**
     * Setter method for the start date of the event.
     */
    public void setStartDate(){
        this.startDate = startDate;
    }
    /**
     * Getter method for the end date of the event
     * @return the variable endDate (calender object)
     */
    public Calendar getEndDate(){
        return this.endDate;
    }
    /**
     * Setter method for the end date of an event
     */
    public void setEndDate(){
        this.endDate = endDate;
    }
    /**
     * Getter method for the variable period ie the integer representation of a timeslot during a college
     * day which you can schedule a meeting during.
     * @return variable period (integer)
     */
    public int getPeriod( ) {
        return period;
    } 
    /**
     * Setter method for the variable period ie the integer representation of a timeslot during a college
     * day which you can schedule a meeting during.
     * @param period (integer)
     */
    public void setPeriod( final int period ) {
        this.period = period;
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
}
