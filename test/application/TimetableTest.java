/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

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
        Timetable instance = new Timetable();
        int expResult = 0;
        int result = instance.getEventId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEventName method, of class Timetable.
     */
    @Test
    public void testGetEventName() {
        System.out.println("getEventName");
        Timetable instance = new Timetable();
        String expResult = "";
        String result = instance.getEventName();
        assertEquals(expResult, result);
    }

    /**
     * Test of printTimetable method, of class Timetable.
     */
    @Test
    public void testPrintTimetable() {
        System.out.println("printTimetable");
        String userId = "";
        Timetable instance = new Timetable();
        String expResult = "";
        String result = instance.printTimetable(userId);
        assertEquals(expResult, result);
    }
}