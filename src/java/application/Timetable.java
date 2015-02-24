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
    SimpleDateFormat formatter = 
    new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
    private Calendar calendar = Calendar.getInstance();
    private final Calendar startOfWeek = Calendar.getInstance();
    private final Calendar endOfWeek = Calendar.getInstance();
    
    private DatabaseClass database;
    
    private int eventId;
    private String eventName;
    private String eventType;
    private int period;
    private final Calendar startDate = Calendar.getInstance();
    private final Calendar endDate = Calendar.getInstance();
    private String recurrence;
    private String moduleCode;
    private String location;
    private String description;
    
    public Timetable() {
        calendar = getTodaysDate( );
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
        String[] currentEvent = new String[10];
        ParsePosition startDatePos = new ParsePosition(0);
        ParsePosition endDatePos = new ParsePosition(0);
        database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
        
        //get IDs of all events associated with this user
        String[] eventIDs = database.SelectColumn( "SELECT event_id "
                + "FROM has_events "
                + "WHERE user_id = " + userId + ";");
        
        //iterate through eventIDs[] array and fetch data associated with each
        //eventsID
        if(eventIDs.length != 0){
            for( int i = 0;
                i < eventIDs.length; i++ ) {
                //THIS IS WHERE PROBLEM IS!!
                currentEvent = database.SelectRow( "SELECT * "
                        + "FROM events "
                        + "WHERE event_id = 40;");

                eventId = Integer.parseInt(currentEvent[0]);
                eventName = currentEvent[1];
                eventType = currentEvent[2];
                period = Integer.parseInt(currentEvent[3]);
                startDate.setTime(formatter.parse( currentEvent[4], startDatePos )); 
                endDate.setTime(formatter.parse( currentEvent[4], endDatePos ));
                recurrence = currentEvent[6];
                moduleCode = currentEvent[7];
                location = currentEvent[8];
                description = currentEvent[9];

                //create an Event instance from this row and add it to the myEvents[]
                //array
                Event event = new Event(eventId, eventName, eventType, period, startDate, endDate, recurrence, moduleCode, location, description);
            }   
        }
    
        database.Close();
    }
    
    private void addEventsToTimetable( ) {
        //iterate through the user's events
        for ( int i = 0; i < myEvents.size(); i++ ) {
            Calendar startOfEvent = myEvents.get(i).getStartDate();
            Calendar endOfEvent = myEvents.get(i).getEndDate();
            
            if(startOfEvent.compareTo(startOfWeek) >= 0 
                    && endOfEvent.compareTo(endOfWeek) <= 0 ){
                //occurs this week
                
                if ( startOfEvent.equals(endOfEvent) )
                    //non-recurring events
                {
                        timetableValues[myEvents.get(i).getPeriod()][calendar.DAY_OF_WEEK] 
                                = "<td>" + myEvents.get(i).getEventName()+ " in " + myEvents.get(i).getLocation() + "</td>"; 
                } 
                else if (myEvents.get(i).getRecurrence().equals("day")) 
                    //daily recurring events
                {
                    Date start = startDate.getTime();
                    Date end = endDate.getTime();
                    
                    for ( int j = 1; j <= daysBetween(start, end); j++ ){
                        timetableValues[myEvents.get(i).getPeriod()][j] 
                                = "<td>" + myEvents.get(i).getEventName()+ " in " + myEvents.get(i).getLocation() + "</td>"; 
                    }
                }
                else if (myEvents.get(i).getRecurrence().equals("monthly"))
                    //monthly recurring events
                {
                    for( int j = 1; i <= 7; i++ ){
                        if ( j == startOfEvent.DAY_OF_MONTH ){
                            timetableValues[myEvents.get(i).getPeriod()][j] 
                                = "<td>" + myEvents.get(i).getEventName()+ " in " + myEvents.get(i).getLocation() + "</td>"; 
                        }
                    }
                }   
                else 
                    //annually recurring events
                {
                    if(startOfWeek.DAY_OF_YEAR - startOfEvent.DAY_OF_YEAR >= 0 
                            && endOfWeek.DAY_OF_YEAR - startOfEvent.DAY_OF_YEAR <= 0){ //RETHINK - WON'T WORK AT TRANSITION OF YEAR
                        timetableValues[myEvents.get(i).getPeriod()][startOfEvent.DAY_OF_WEEK] 
                                = "<td>" + myEvents.get(i).getEventName()+ " in " + myEvents.get(i).getLocation() + "</td>";
                    }
                }   
            }
        }
        
    }
    
    public String printTimetable( ) {
        
        fetchEventsFromDB( "999999999" );
        timetableValues[2][2] = "<td>" + myEvents.get(0).getEventName() + "</td>";
        
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
    
    private int daysBetween(Date d1, Date d2){
             return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
    
    private Calendar getTodaysDate( ){
        Calendar temp = Calendar.getInstance();
        temp.set(Calendar.HOUR_OF_DAY, 0);
        temp.set(Calendar.MINUTE, 0);
        temp.set(Calendar.SECOND, 0);
        
        return temp;
    }
    
    private Date getMondayOfWeek( ){
        Calendar temp;
        temp = getTodaysDate();
        int currentDayOfWeek = temp.DAY_OF_WEEK;
        temp.add(Calendar.DATE, 0 - currentDayOfWeek);
        
        return temp.getTime();
    }
    
    private Date getSundayOfWeek( ){
        Calendar temp;
        temp = getTodaysDate();
        int currentDayOfWeek = temp.DAY_OF_WEEK;
        temp.add(Calendar.DATE, 6 - currentDayOfWeek);
        
        return temp.getTime();
    }
}
