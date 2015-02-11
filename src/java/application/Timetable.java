package application;

/**
 * @author Jack Desmond, James Delaney
 */
import dbpackage.DatabaseClass;

public class Timetable {
    private String[][] timetableValues;
    
    public Timetable() {
        this.timetableValues = new String[][]{
            {null, "<th scope=\"col\">Mon</th>", "<th scope=\"col\">Tue</th>", "<th scope=\"col\">Wed</th>", "<th scope=\"col\">Thurs</th>", "<th scope=\"col\">Fri</th>", "<th scope=\"col\">Sat</th>", "<th scope=\"col\">Sun</th>"},
            {"<th scope=\"row\">8AM - 9AM</th>", null, null, null, null, null, null, null},
            {"<th scope=\"row\">9AM - 10AM</th>", null, null, null, null, null, null, null},
            {"<th scope=\"row\">10AM - 11AM</th>", null, null, null, null, null, null, null},
            {"<th scope=\"row\">11AM - 12AM</th>", null, null, null, null, null, null, null},
            {"<th scope=\"row\">12AM - 1PM</th>", null, null, null, null, null, null, null},
            {"<th scope=\"row\">1PM - 2PM</th>", null, null, null, null, null, null, null},
            {"<th scope=\"row\">2PM - 3PM</th>", null, null, null, null, null, null, null},
            {"<th scope=\"row\">3PM - 4PM</th>", null, null, null, null, null, null, null},
            {"<th scope=\"row\">4PM - 5PM</th>", null, null, null, null, null, null, null},
            {"<th scope=\"row\">5PM - 6PM</th>", null, null, null, null, null, null, null}
        };
    }
    
    public void printedTimetable( ) {
        System.out.println("<div id=\'wrapper\'>"
                + "<table class=\"emp-sales\">"
                + "<captionSchedule Your Timetable</catption>"
                + "<thread>"
        );
        
        //iterate through columns
        for (int i = 0; i < 11; i++ ){
            System.out.println("<tr>");
            //iterate through rows
            for (int j = 0; j < 8; j++ ) {
                System.out.println (timetableValues[i][j]);
            }
            System.out.println("</tr>");
        }
        
        System.out.println("</tbody>"
                +"</table>");
    }
}