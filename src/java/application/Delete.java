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
  
    public Delete() {
        database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    
    public String[] eventInfo( String event_id){
        dbResults = database.SelectRow("Select * FROM events WHERE events.event_id = '" + event_id + "';");
        System.out.println( Arrays.toString(dbResults));
        return dbResults;
    }
    
    public String printInfo( ){
        String table = "<table class=\"emp-sales\">\n"
                     + "<caption>Event</catption>\n"
                     + "<tbody>\n"
                     + "<tr><th>Event ID</th><th>Event Name</th><Event Type</th><th>Stream</th><th>Period</th><th>Start Date</th><th>End date</th><th>Recurrence</th>\n"
                     + "<th>Module Code</th><th>Location</th><th>Description</th></tr>\n"
                     + "<td>" + dbResults[0] + "</td><td>" + dbResults[1] + "</td><td>" + dbResults[2] + "</td><td>" + dbResults[3] + "</td>\n"
                     + "<td>" + dbResults[4] + "</td><td>" + dbResults[5] + "</td><td>" + dbResults[6] + "</td><td>" + dbResults[7] + "</td>\n"
                     + "<td>" + dbResults[8] + "</td><td>" + dbResults[9] + "</td><td>" + dbResults[10] + "</td>\n"
                     + "<tbody>\n"
                     + "<table>\n";
        
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
    public void getEventName(){
        
    }
    
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