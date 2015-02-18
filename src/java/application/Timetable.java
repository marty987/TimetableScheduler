package application;
/**
 * @author Jack Desmond, James Delaney, Caroline Corcoran
 * @since Feb 13, 2015, 12:56:25 PM
 */
import dbpackage.DatabaseClass;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.text.*;

public class Timetable {
    private Event[] myEvents;
    SimpleDateFormat formatter = 
            new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
    private Calendar calendar = Calendar.getInstance();
    private int mondayOfWeek = calendar.getFirstDayOfWeek();
    
    private DatabaseClass database;
    private String[][] timetableValues;
    
    private String eventName;
    private String eventType;
    private int period;
    private Date startDate;
    private Date endDate;
    private String recurrence;
    private String moduleCode;
    private String location;
    private String description;
    
    public Timetable() {
        this.database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
        
        this.timetableValues = new String[][]{
            {"<th></th>", "<th scope=\"col\">Mon</th>", "<th scope=\"col\">Tue</th>", "<th scope=\"col\">Wed</th>", "<th scope=\"col\">Thurs</th>", "<th scope=\"col\">Fri</th>", "<th scope=\"col\">Sat</th>", "<th scope=\"col\">Sun</th>"},
            {"<th scope=\"row\">8AM - 9AM</th>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>"},
            {"<th scope=\"row\">9AM - 10AM</th>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>"},
            {"<th scope=\"row\">10AM - 11AM</th>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>"},
            {"<th scope=\"row\">11AM - 12AM</th>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>"},
            {"<th scope=\"row\">12AM - 1PM</th>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>"},
            {"<th scope=\"row\">1PM - 2PM</th>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>"},
            {"<th scope=\"row\">2PM - 3PM</th>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>"},
            {"<th scope=\"row\">3PM - 4PM</th>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>"},
            {"<th scope=\"row\">4PM - 5PM</th>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>"},
            {"<th scope=\"row\">5PM - 6PM</th>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>", "<td></td>"}
        };
    }
    
    public int daysBetween(Date d1, Date d2){
             return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
    
    private void fetchEventsFromDB( String userId ) {
        String eventIDs[];
        String currentEvent[];
        ParsePosition startDatePos = new ParsePosition(0);
        ParsePosition endDatePos = new ParsePosition(0);
        database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
        
        //get IDs of all events associated with this user
        eventIDs = database.SelectColumn( "SELECT event_id "
                + "FROM events JOIN has_events "
                + "ON events.event_id = has_events.user_id"
                + "WHERE has_events.user_id = " + userId + ";");
        
        //iterate through eventIDs[] array and fetch data associated with each
        //eventsID
        for( int i = 0; i < eventIDs.length; i++ ) {
            currentEvent = database.SelectRow( "SELECT *"
                    + "FROM events"
                    + "WHERE event_id = " + eventIDs[i] + ";");
            
            eventName = currentEvent[1];
            eventType = currentEvent[2];
            period = Integer.parseInt(currentEvent[3]);
            startDate = formatter.parse( currentEvent[4], startDatePos ); 
            endDate = formatter.parse( currentEvent[4], endDatePos );
            recurrence = currentEvent[6];
            moduleCode = currentEvent[7];
            location = currentEvent[8];
            description = currentEvent[9];
            
            //create an Event instance from this row and add it to the myEvents[]
            //array
            myEvents[i] = new Event( Integer.parseInt(eventIDs[i]), eventName,
                    eventType, period, startDate, endDate, recurrence, 
                    moduleCode, location, description );
        }   
    }
    
    private void addEventsToTimetable( ) {
        //iterate through the user's events
        for ( int i = 0; i < myEvents.length; i++ ) {
            if ( myEvents[i].getStartDate().equals(myEvents[i].getEndDate()) )
                //non-recurring events
            {
                //if ( myEvents[i].getStartDate().compareTo(mondayOfWeek) && myEvents[i].getStartDate() <= mondayOfWeek ) 
                    //if this event occurs this week
               // {
                    
                //}
            } 
            else if (myEvents[i].getRecurrence().equals("daily")) 
                //daily recurring events
            {
                for ( int j = 1; j <= daysBetween(startDate, endDate); j++ ){
                    timetableValues[myEvents[i].getPeriod()][j] = myEvents[i].getEventName(); 
                }
            }
            else if (myEvents[i].getRecurrence().equals("monthly"))
                //monthly recurring events
            {
                
            }   
            else if (myEvents[i].getRecurrence().equals("semesterly"))
                //semesterly recurring events
            {
                
            }   
            else 
                //annually recurring events
            {
                
            }    
        }
        
    }
    
    public String printTimetable( ) {
        String table = "<table class=\"emp-sales\">\n"
                     + "<caption>Schedule Your Timetable</catption>\n"
                     + "<tbody>\n";
        
        //iterate through columns
        for (int i = 0; i < 11; i++ ) {
            table += "<tr>";
            //iterate through rows
            for (int j = 0; j < 8; j++ ) {
                table += timetableValues[i][j];
            }
            table += "</tr>\n";
        }
        
               table += "</tbody>"
                     +"</table>";
               
        return table;
    }
}