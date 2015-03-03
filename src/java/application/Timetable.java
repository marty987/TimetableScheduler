package application;
/**
 * This class defines how the timetable for the scheduling system can be displayed
 * and implemented.
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
    private Date today = new Date();
    private Date startOfWeek = new Date();
    private Date endOfWeek = new Date();
    
    private DatabaseClass database;
    
    private int eventId;
    private String eventName;
    private String eventType;
    private int stream;
    private int period;
    private Date startDate = new Date();
    private Date endDate = new Date();
    private String recurrence;
    private String moduleCode;
    private String location;
    private String description;
    /**
     * Constructor for the timetable class.
     */
    public Timetable() {
        startOfWeek = getMondayOfWeek();
        endOfWeek = getSundayOfWeek();
        
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
    
    public int getEventId() {
        return eventId;
    }
    
    public String getEventName() {
        return eventName;
    }
    
    /**
     * Function that contacts the database and gets the relevant events for the user that is 
     * logged in.
     * @param userId 
     */
    private void fetchEventsFromDB( String userId ) {  
        database = new DatabaseClass( );
        //database.setup( "localhost", "timetable_scheduler_db", "root", "" );
        database.setup( "cs1.ucc.ie", "2016_mjb2", "mjb2", "diechoro" );
        
        //get IDs of all events associated with this user
        String[] eventIDs = database.SelectColumn( "SELECT event_id "
                + "FROM has_events "
                + "WHERE user_id = " + userId + ";");
        String[] currentEvent = new String[eventIDs.length];
        
        //iterate through eventIDs[] array and fetch data associated with each
        //eventsID
        if(eventIDs.length > 0){
            for( int i = 0;
                i < eventIDs.length; i++ ) {
                currentEvent = database.SelectRow( "SELECT * "
                        + "FROM events "
                        + "WHERE event_id = " + eventIDs[i] + ";");

                eventId = Integer.parseInt(currentEvent[0]);
                eventName = currentEvent[1];
                eventType = currentEvent[2];
                stream = Integer.parseInt(currentEvent[3]);
                period = Integer.parseInt(currentEvent[4]);
                try{
                startDate = sdf.parse( currentEvent[5]); 
                endDate = sdf.parse( currentEvent[6]);
                }catch(Exception e){}
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
    /**
     * Function to add events to the timetable.
     */
    private void addEventsToTimetable( ) {
        Event myEvent;
        Calendar mondayDateAsCal = Calendar.getInstance();
        mondayDateAsCal.setTime(startOfWeek);
        Calendar sundayDateAsCal = Calendar.getInstance();
        sundayDateAsCal.setTime(endOfWeek);
        Calendar startDateAsCal = Calendar.getInstance();
        Calendar endDateAsCal = Calendar.getInstance();
        int dayOfEvent;
        
        //iterate through the user's events 
        for ( int i = 0; i < myEvents.size(); i++ ) {
            
            myEvent = myEvents.get(i);
            startDateAsCal.setTime(myEvent.getStartDate());
            endDateAsCal.setTime(myEvent.getEndDate());
            dayOfEvent = startDateAsCal.get(Calendar.DAY_OF_WEEK);
            
            if(!((startDateAsCal.compareTo(sundayDateAsCal) > 0) && !((endDateAsCal.compareTo(mondayDateAsCal) < 0))))
            { //occurs this week
                //to force days of the week correspond to our timetable layout
                dayOfEvent = fitDayOfWeekToTimetable(dayOfEvent);
                
                if ( myEvent.getRecurrence().equals("once") || myEvent.getRecurrence().equals("weekly"))
                    //non-recurring events or weekly recurring events
                {
                    
                    timetableValues[myEvent.getPeriod()][dayOfEvent]                          
                                = "<td><a href=\"delete.jsp\">" + myEvent.getEventName()+ " in " + myEvent.getLocation() + "</td>";
                } 
                else
                    //monthly recurring events
                {
                    
                    for( Calendar j = mondayDateAsCal; j.compareTo(sundayDateAsCal) <= 0 ; j.add(Calendar.DATE, 1)){

                        if ( j.get(Calendar.DAY_OF_MONTH) == startDateAsCal.get(Calendar.DAY_OF_MONTH)){
                            timetableValues[myEvent.getPeriod()][dayOfEvent] 
                                = "<td>" + myEvent.getEventName()+ " in " + myEvent.getLocation() + "</td>"; 
                        }
                    }
                  mondayDateAsCal.setTime(startOfWeek);  
                } 
            }    
        }
    }
    /**
     * Function to print the timetable.
     * @return the variable table (string)
     */
    public String printTimetable( String userId ) {
        
        fetchEventsFromDB( userId );
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
    /**
     * Function to get the first day of the week (Monday) for display purposes.
     * @return the variable date (Date instance)
     */
    private Date getMondayOfWeek( ){
        Calendar temp = Calendar.getInstance();
        int currentDayOfWeek = temp.get(Calendar.DAY_OF_WEEK);
        temp.add(Calendar.DATE, 2 - currentDayOfWeek);
        
        return temp.getTime();
    }
    
    /**
     * Function to force the DAY_OF_WEEK values to fit our timetable.
     * @return the day of the week into which our event fits on our timetable.
     */
    private int fitDayOfWeekToTimetable(int dayOfEvent){
        if (dayOfEvent == 1){
                    dayOfEvent = 7;
                } else {
                    dayOfEvent--;
                }
        return dayOfEvent;
    }
    
    /**
     * Function to get the last day of the week (Sunday) for display purposes.
     * @return the variable date (Date instance)
     */
    private Date getSundayOfWeek( ){
        Calendar tempCal = Calendar.getInstance();
        int currentDayOfWeek = tempCal.get(Calendar.DAY_OF_WEEK);
        tempCal.add(Calendar.DATE, 8 - currentDayOfWeek);
        
        return tempCal.getTime();
    }
    
    /**
     * Function to get date of this day next week
     * @return Date object for this day next week.
     */
    private Date getNextWeek(){
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(today);
        tempCal.add(Calendar.DATE, 7);
        return tempCal.getTime();
    }
    
    /**
     * Function to get date of this day next week
     * @return Date object for this day last week.
     */
    private Date getPreviousWeek(){
        Calendar tempCal = Calendar.getInstance();
        tempCal.setTime(today);
        tempCal.add(Calendar.DATE, -7);
        return tempCal.getTime();
    }
}
