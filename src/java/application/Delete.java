package application;


/**
 * @author jd7
 */

import dbpackage.DatabaseClass;
import java.util.*;
import java.text.*;

public class Delete {
    private final DatabaseClass database;
    private String[] dbResults;
    /**
     * Constuctor for the class
     */
    public Delete() {
        database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    /**
     * Getter method for the details of a specified event.
     * @param event_id id of the event
     * @return dbResults - a string array of the event's details from the database -
     * event_id, event_name, event_type, stream, period, start_date, end_date, recurrence
     * module code, location, description.
     */
    public String[] getEventInfo( String event_id){
        dbResults = database.SelectRow("Select * FROM events WHERE events.event_id = '" + event_id + "';");
        System.out.println( Arrays.toString(dbResults));
        return dbResults;
    }
    
  
    
    public String printInfo( ){
        String table = "<form action =\"delete.jsp\" method=\"POST\">"
                     + "<table class=\"emp-sales\">\n"
                     + "<caption>Event</catption>\n"
                     + "<tbody>\n"
                     + "<tr><th>Event Number</th><th>Event Name</th><Event Type</th><th>Stream</th><th>Period</th><th>Start Date</th><th>End date</th><th>Recurrence</th>\n"
                     + "<th>Module Code</th><th>Location</th><th>Description</th></tr>\n"
                     + "<td>" + dbResults[0] + "</td><td>" + dbResults[1] + "</td><td>" + dbResults[2] + "</td><td>" + dbResults[3] + "</td>\n"
                     + "<td>" + dbResults[4] + "</td><td>" + dbResults[5] + "</td><td>" + dbResults[6] + "</td><td>" + dbResults[7] + "</td>\n"
                     + "<td>" + dbResults[8] + "</td><td>" + dbResults[9] + "</td><td>" + dbResults[10] + "</td>\n"
                     + "<input type='submit' value='Delete' name='delete_event' /><br />\n"
                     + "<tbody>\n"         
                     + "<table>\n"
                     + "</form>";
        
        return table;
    }

    /**
     * Function to delete an event. Needs to take the event ID from a form.
     * @param event_id
     */
    public void deleteEvent( String event_id ){
        database.Insert("DELETE FROM events WHERE events.event_id = '" + event_id + "';");
        database.Insert("DELETE FROM has_event WHERE has_event.event_id = '" + event_id + "';");
    }
    /**
     * Getter method for the event name.
     * @return eventName the name of the event
     */
    public void getEventName(){
        
    }
    /**
     * Form to delete an event from a user's calender and the database.
     * @param eventId
     * @return table 
     */
    public String printDeleteForm(String eventId) {
        String table = "<table class=\"emp-sales\">\n"
                     + "<caption>Event</catption>\n"
                     + "<tbody>\n"
                     + "<tr><th>Event ID</th><th>Event Name</th></tr>"
                     + "<tr><td>" + eventId + "</td><td>"
                     + "</tbody>"
                     + "</table>";
        
        return table;
    }
}
