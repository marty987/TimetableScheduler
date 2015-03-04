package application;


/**
 * @author jd7
 */

import dbpackage.DatabaseClass;
import java.util.*;
import java.text.*;

public class Delete {
    private final DatabaseClass database;
  
    public Delete() {
        database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }
    
    public String[] eventInfo( String event_id){
        String[] dbResults = database.SelectRow("Select * FROM events WHERE events.event_id = '" + event_id + "';");
        System.out.println( Arrays.toString(dbResults));
        return dbResults;
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