package application;


/**
 * @author jd7
 */

import dbpackage.DatabaseClass;

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
    
    public void setEventId( String eventId ) {
        System.out.println( "event id set: " + eventId );
    }
    
    /**
     * Getter method for the details of a specified event.
     * @param event_id id of the event
     * @return dbResults - a string array of the event's details from the database -
     * event_id, event_name, event_type, stream, period, start_date, end_date, recurrence
     * module code, location, description.
     */
    public String[] eventInfo( String event_id ){
        dbResults = database.SelectRow( "Select * FROM events WHERE events.event_id = " + event_id + ";" );
        return dbResults;
    }
    
  
    
    public String printInfo( ){
        String table = "<form action =\"delete.jsp \" method=\"POST\">"
                     + "<table border=\"1px\" class=\"emp-sales\">\n"
                     + "<caption>Event</catption>\n"
                     + "<tbody>\n"
                     + "<tr><th>Event Number</th><th>Event Name</th><th><Event Type</th><th>Stream</th><th>Period</th><th>Start Date</th><th>End date</th><th>Recurrence</th>\n"
                     + "<th>Module Code</th><th>Location</th><th>Description</th></tr>\n"
                     + "<td>" + dbResults[0] + "</td><td>" + dbResults[1] + "</td><td>" + dbResults[2] + "</td><td>" + dbResults[3] + "</td>\n"
                     + "<td>" + dbResults[4] + "</td><td>" + dbResults[5] + "</td><td>" + dbResults[6] + "</td><td>" + dbResults[7] + "</td>\n"
                     + "<td>" + dbResults[8] + "</td><td>" + dbResults[9] + "</td><td>" + dbResults[10] + "</td>\n"
                     + "<tr><td colspan=\"10\"><td><input id='deleteSubmit' type='submit' value='Delete' name='delete_event' /></td></tr><br />\n"
                     + "</tbody>\n"         
                     + "</table>\n"
                     + "</form>";
        
        return table;
    }

    /**
     * Function to delete an event. Needs to take the event ID from a form.
     * @param eventId
     */
    public void deleteEvent( String userId, String eventId ){
        database.Insert("DELETE FROM has_events WHERE user_id = " + userId + " AND has_events.event_id = " + eventId + ";");
    }

}
