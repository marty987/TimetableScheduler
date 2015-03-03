package application;

import dbpackage.DatabaseClass;

/**
 * @author jd7
 */
public class Delete {
    private final DatabaseClass database;
    
    public Delete() {
        database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
    }

    /**
     * Function to delete an event. Needs to take the event ID from a form.
     * @param event_id
     */
    public void deleteEvent( String event_id ){
        database.Insert("DELETE FROM events WHERE events.event_id = '" + event_id + "';");
        database.Insert("DELETE FROM has_event WHERE has_event.event_id = '" + event_id + "';");
    }
    
    public String printDeleteForm(int eventId, String eventName) {
        String table = "<table class=\"emp-sales\">\n"
                     + "<caption>Event</catption>\n"
                     + "<tbody>\n"
                     + "<tr><th>Event ID</th><th>Event Name</th></tr>"
                     + "<tr><td>" + eventId + "</td><td>" + eventName + "</td></tr>"
                     + "</tbody>"
                     +"</table>";
        
        return table;
    }
}