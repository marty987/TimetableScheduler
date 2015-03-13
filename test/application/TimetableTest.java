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
     * Test of getEventName method, of class Timetable.
     */
    @Test
    public void testGetEventName() {
        System.out.println("getEventName");
        
        String expResult = "";
        String result = test.getEventName();
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
                                "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<td></td>" +
                            "</tr>\n" + 
                            "<tr>\n" +
                                "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<td></td>" +
                            "</tr>\n" + 
                            "<tr>\n" +
                                "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<td></td>" +
                            "</tr>\n" +
                            "<tr>\n" +
                                "<td></td>" +
                            "</tr>\n" +
                     "</tbody>" +
                "</table>";
        String result = instance.printTimetable(userId);
        assertEquals(expResult, result);
    }
}