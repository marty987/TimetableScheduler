package application;
/**
 * @author Jack Desmond, James Delaney, Caroline Corcoran
 * @since Feb 13, 2015, 12:56:25 PM
 */
import dbpackage.DatabaseClass;
import java.util.*;
import java.text.*;

public class Timetable {
    ArrayList<Event> myEvents = new ArrayList<Event>();
    private final String[][] timetableValues;
    SimpleDateFormat sdf = 
    new SimpleDateFormat("yyyy-MM-dd");
    private Calendar today = Calendar.getInstance();
    private final Calendar startOfWeek = Calendar.getInstance();
    private final Calendar endOfWeek = Calendar.getInstance();
    
    private DatabaseClass database;
    
    private int eventId;
    private String eventName;
    private String eventType;
    private int stream;
    private int period;
    private final Calendar startDate = Calendar.getInstance();
    private final Calendar endDate = Calendar.getInstance();
    private String recurrence;
    private String moduleCode;
    private String location;
    private String description;
    
    public Timetable() {
        startOfWeek.setTime(getMondayOfWeek());
        endOfWeek.setTime(getSundayOfWeek());
        
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
    
    private void fetchEventsFromDB( String userId ) {
        String[] currentEvent = new String[11];
        ParsePosition startDatePos = new ParsePosition(0);
        ParsePosition endDatePos = new ParsePosition(0);
        database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
        
        //get IDs of all events associated with this user
        String[] eventIDs = database.SelectColumn( "SELECT event_id "
                + "FROM has_events "
                + "WHERE user_id = " + "112735341" + ";");
        
        //iterate through eventIDs[] array and fetch data associated with each
        //eventsID
        if(eventIDs.length > 0){
            for( int i = 0;
                i < eventIDs.length; i++ ) {
                //THIS IS WHERE PROBLEM IS!!
                currentEvent = database.SelectRow( "SELECT * "
                        + "FROM events "
                        + "WHERE event_id = " + eventIDs[i] + ";");

                eventId = Integer.parseInt(currentEvent[0]);
                eventName = currentEvent[1];
                eventType = currentEvent[2];
                stream = Integer.parseInt(currentEvent[3]);
                period = Integer.parseInt(currentEvent[4]);
                try{
                    startDate.setTime(sdf.parse( currentEvent[5], startDatePos )); 
                    endDate.setTime(sdf.parse( currentEvent[6], startDatePos ));
                } catch (Exception e) {
                    //parse exception
                }
                recurrence = currentEvent[7];
                moduleCode = currentEvent[8];
                location = currentEvent[9];
                description = currentEvent[10];

                //create an Event instance from this row and add it to the myEvents[]
                //array
                Event event = new Event(eventId, eventName, eventType, stream, period, startDate, endDate, recurrence, moduleCode, location, description);
                myEvents.add(event);
            }   
        }
    
        database.Close();
    }
    
    private void addEventsToTimetable( ) {
        //iterate through the user's events 
        for ( int i = 0; i <= myEvents.size(); i++ ) {
            Calendar startOfEvent = myEvents.get(i).getStartDate();
            Calendar endOfEvent = myEvents.get(i).getEndDate();
            
            timetableValues[0][0]                          
                                = "<th>" + startOfWeek.getTime() + "</th>";
            
            if(startOfEvent.compareTo(endOfWeek) <= 0 
                    && endOfEvent.compareTo(startOfWeek) >= 0 ){
                //occurs this week
                if ( myEvents.get(i).getRecurrence().equals("once") || myEvents.get(i).getRecurrence().equals("weekly"))
                    //non-recurring events
                {
                     timetableValues[myEvents.get(i).getPeriod()][startOfEvent.get(Calendar.DAY_OF_WEEK)]                          
                                = "<td>" + myEvents.get(i).getEventName()+ " in " + myEvents.get(i).getLocation() + "</td>"; 
                } 
                else
                    //monthly recurring events
                {
                    for( int j = 1; i <= 7; i++ ){
                        if ( j == startOfEvent.DAY_OF_MONTH ){
                            timetableValues[myEvents.get(i).getPeriod()][j] 
                                = "<td>" + myEvents.get(i).getEventName()+ " in " + myEvents.get(i).getLocation() + "</td>"; 
                        }
                    }
                } 
            }
        }
        
    }
    
    public String printTimetable( ) {
        
        fetchEventsFromDB( "112735341" );
        addEventsToTimetable( );
        
        String table = "<table class=\"emp-sales\">\n"
                     + "<caption>Schedule Your Timetable</catption>\n"
                     + "<tbody>\n";
        
        //iterate through columns
        for (int i = 0; i < 11; i++ ) {
            table += "<tr>\n";
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
    
    private Date getMondayOfWeek( ){
        Calendar temp = Calendar.getInstance();
        int currentDayOfWeek = temp.get(Calendar.DAY_OF_WEEK);
        temp.add(Calendar.DATE, 2 - currentDayOfWeek);
        
        return temp.getTime();
    }
    
    private Date getSundayOfWeek( ){
        Calendar temp = Calendar.getInstance();
        int currentDayOfWeek = temp.get(Calendar.DAY_OF_WEEK);
        temp.add(Calendar.DATE, 8 - currentDayOfWeek);
        
        return temp.getTime();
    }
}
