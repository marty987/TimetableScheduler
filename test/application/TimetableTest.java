/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import dbpackage.DatabaseClass;
import java.util.Calendar;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cmc8
 */
public class TimetableTest {
    Timetable test = new Timetable();
    
    public TimetableTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getEventId method, of class Timetable.
     */
    @Test
    public void testGetEventId() {
        System.out.println("getEventId");

        int expResult = 0;
        int result = test.getEventId();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of printTimetable method, of class Timetable.
     */
    @Test
    public void testPrintTimetable() {
        System.out.println("printTimetable");
        String userId = "98751177";
        Timetable instance = new Timetable();
        String expResult = "<table class=\"emp-sales\">\n"
                     + "<caption>Schedule Your Timetable</catption>\n"
                     + "<tbody>\n" +
                            "<tr>\n" +
                                "<th></th>" + "<th scope=\"col\">Mon</th>" + "<th scope=\"col\">Tue</th>" + "<th scope=\"col\">Wed</th>" + "<th scope=\"col\">Thurs</th>" + "<th scope=\"col\">Fri</th>" + "<th scope=\"col\">Sat</th>" + "<th scope=\"col\">Sun</th>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<th scope=\"row\">8AM - 9AM</th>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + 
                            "</tr>\n" +
                            "<tr>\n" +
                                "<th scope=\"row\">9AM - 10AM</th>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" +
                            "</tr>\n" + 
                            "<tr>\n" +
                                "<th scope=\"row\">10AM - 11AM</th>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<th scope=\"row\">11AM - 12PM</th>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<th scope=\"row\">12PM - 1PM</th>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<th scope=\"row\">1PM - 2PM</th>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<th scope=\"row\">2PM - 3PM</th>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<th scope=\"row\">3PM - 4PM</th>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" +
                            "</tr>\n" + 
                            "<tr>\n" +
                                "<th scope=\"row\">4PM - 5PM</th>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<th scope=\"row\">5PM - 6PM</th>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" + "<td></td>" +
                            "</tr>\n" +
                     "</tbody>" +
                "</table>";
        String result = instance.printTimetable(userId);
        assertEquals(expResult, result);
    }
}