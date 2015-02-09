package application;

/**
 * @author Jack Desmond, James Delaney
 */
import dbpackage.DatabaseClass;

public class Timetable {
    
    public Timetable() {
        
    }
    
    public String printedTimetable() {
        String timetable = "<div id=\'wrapper\'>"
                +"<section>"
                +"<a href=\"search_availability.php\">Search for available time period</a>"
                +"</section>"
                +"<table class=\"emp-sales\">"
                +"<caption>Schedule Your Timetable</caption>"
                +"<thead>"
                /*
                 * DAYS
                 */
                +"<tr>"
                +"<td></td>"
                +"<th scope=\"col\">Mon</th>"
                +"<th scope=\"col\">Tue</th>"
                +"<th scope=\"col\">Wed</th>"
                +"<th scope=\"col\">Thu</th>"
                +"<th scope=\"col\">Fri</th>"
                +"<th scope=\"col\">Sat</th>"
                +"<th scope=\"col\">Sun</th>"
                +"</tr>"
                +"</thead>"
                +"<tbody>"
                /*
                 * 8AM - 9AM
                 */
                +"<tr>"
                +"<th scope=\"row\">8AM - 9AM</th>"
                +"<td></td>"
                +"<td></td>"
                +"<td>"
                +"<section>"
                +"<span>CS3301</span><br />"
                +"<span>WGB G01</span>"
                +"</section>"
                +"<section>"
                +"<span id = 'secondSpan'>-</span><br />"
                +"</section></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"</tr>"
                /*
                 * 9AM - 10AM
                 */
                +"<tr>"
                +"<th scope=\"row\">9AM - 10AM</th>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"</tr>"
                /*
                 * 10AM - 11AM
                 */
                +"<tr>"
                +"<th scope=\"row\">10AM - 11AM</th>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"</tr>"
                /*
                 * 11AM - 12AM
                 */
                +"<tr>"
                +"<th scope=\"row\">11AM - 12AM</th>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"</tr>"  
                /*
                 * 12AM - 1PM
                 */
                +"<tr>"
                +"<th scope=\"row\">12AM - 1PM</th>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td>"	    
                +"<section>"
                +"<span>CS3508</span><br />"
                +"<span>WGB G02</span>"
                +"</section>"					
		+"<section>"
		+"<span id = 'secondSpan'>-</span><br />"
		+"</section></td>"
                +"<td></td>"
                +"<td></td>"
                +"</tr>"
                /*
                 * 1PM - 2PM
                 */
                +"<tr>"
                +"<th scope=\"row\">1PM - 2PM</th>"
                +"<td></td>"
                +"<td>"
		+"<section>"
                +"<span>CS3509</span><br />"
		+"<span>WGB G02</span>"
		+"</section>"					
		+"<section>"
		+"<span id = 'secondSpan'>-</span><br />"
		+"</section>"	
		+"</td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"</tr>"
                /*
                 * 2PM - 3PM
                 */
                +"<tr>"
                +"<th scope=\"row\">2PM - 3PM</th>"
                +"<td>"
		+"<section>"
		+"<span>CS3500</span><br />"
		+"<span>WGB G01</span>"
		+"</section>"					
		+"<section>"
		+"<span id = 'secondSpan'>-</span><br />"
		+"</section>"	
		+"</td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"</tr>"
                /*
                 * 3PM - 4PM
                 */
                +"<tr>"
                +"<th scope=\"row\">3PM - 4PM</th>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"</tr>"
                /*
                 * 4PM - 5PM
                 */
                +"<tr>"
                +"<th scope=\"row\">4PM - 5PM</th>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td>"		    
		+"<section>"
		+"<span>CS3500</span><br />"
		+"<span>WGB G01</span>"
		+"</section>"						
		+"<section>"
		+"<span id = 'secondSpan'>-</span><br />"
		+"</section></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"</tr>"
                /*
                 * 5PM - 6PM
                 */
                +"</tr>"
                +"<th scope=\"row\">5PM - 6PM</th>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"<td></td>"
                +"</tr>"
                +"</tbody>"
                +"</table>";
        
        return timetable;
    }
}