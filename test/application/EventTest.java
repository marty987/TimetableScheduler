/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cmc8
 */
public class EventTest {
    Event test1 = new Event (1, "CS3300 Lecture", "Lecture", 6, 1, new Date(1001011), new Date(999999999), "weekly", "CS3300", "WGB G02", "Lecture for fake class.");
    Event test2 = new Event (0, "", "", 0, 0, new Date(0), new Date(1), "", "", "", "");
    
    public EventTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getEventID method, of class Event.
     */
    @Test
    public void testGetEventID() {
        System.out.println("getEventID");
        
        int expResult1 = 1;
        int result1 = test1.getEventID();
        assertEquals(expResult1, result1);
        
        int expResult2 = 0;
        int result2 = test2.getEventID();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setEventID method, of class Event.
     */
    @Test
    public void testSetEventID() {
        System.out.println("setEventID");
        int eventID = 4;
        test1.setEventID(eventID);
    }

    /**
     * Test of getEventName method, of class Event.
     */
    @Test
    public void testGetEventName() {
        System.out.println("getEventName");
        
        String expResult1 = "CS3300 Lecture";
        String result1 = test1.getEventName();
        assertEquals(expResult1, result1);
        
        String expResult2 = "";
        String result2 = test2.getEventName();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setEventName method, of class Event.
     */
    @Test
    public void testSetEventName() {
        System.out.println("setEventName");
        String eventName = "CS3301 Lab";
        test1.setEventName(eventName);
    }

    /**
     * Test of getEventType method, of class Event.
     */
    @Test
    public void testGetEventType() {
        System.out.println("getEventType");
        
        String expResult1 = "Lecture";
        String result1 = test1.getEventType();
        assertEquals(expResult1, result1);
        
        String expResult2 = "";
        String result2 = test2.getEventType();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setEventType method, of class Event.
     */
    @Test
    public void testSetEventType() {
        System.out.println("setEventType");
        String eventType = "Lab";
        test1.setEventType(eventType);
    }

    /**
     * Test of getStartDate method, of class Event.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        
        Date expResult1 = new Date(1001011);
        Date result1 = test1.getStartDate();
        assertEquals(expResult1, result1);
        
        Date expResult2 = new Date(0);
        Date result2 = test2.getStartDate();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setStartDate method, of class Event.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        test1.setStartDate(new Date(0));
    }

    /**
     * Test of getEndDate method, of class Event.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        
        Date expResult1 = new Date(999999999);
        Date result1 = test1.getEndDate();
        assertEquals(expResult1, result1);
        
        Date expResult2 = new Date(14);
        Date result2 = test2.getEndDate();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setEndDate method, of class Event.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        test1.setEndDate(new Date(77777));
    }

    /**
     * Test of getPeriod method, of class Event.
     */
    @Test
    public void testGetPeriod() {
        System.out.println("getPeriod");
        
        int expResult1 = 1;
        int result1 = test1.getPeriod();
        assertEquals(expResult1, result1);
        
        int expResult2 = 0;
        int result2 = test2.getPeriod();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setPeriod method, of class Event.
     */
    @Test
    public void testSetPeriod() {
        System.out.println("setPeriod");
        int period = 10;
        test1.setPeriod(period);
    }

    /**
     * Test of getRecurrence method, of class Event.
     */
    @Test
    public void testGetRecurrence() {
        System.out.println("getRecurrence");
        
        String expResult1 = "weekly";
        String result1 = test1.getRecurrence();
        assertEquals(expResult1, result1);
        
        String expResult2 = "";
        String result2 = test2.getRecurrence();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setRecurrence method, of class Event.
     */
    @Test
    public void testSetRecurrence() {
        System.out.println("setRecurrence");
        String recurrence = "once";
        test1.setRecurrence(recurrence);
    }

    /**
     * Test of getModuleCode method, of class Event.
     */
    @Test
    public void testGetModuleCode() {
        System.out.println("getModuleCode");
        
        String expResult1 = "CS3300";
        String result1 = test1.getModuleCode();
        assertEquals(expResult1, result1);
        
        String expResult2 = "";
        String result2 = test2.getModuleCode();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setModuleCode method, of class Event.
     */
    @Test
    public void testSetModuleCode() {
        System.out.println("setModuleCode");
        String moduleCode = "CS3301";
        test1.setModuleCode(moduleCode);
    }

    /**
     * Test of getLocation method, of class Event.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        
        String expResult1 = "WGB G02";
        String result1 = test1.getLocation();
        assertEquals(expResult1, result1);
        
        String expResult2 = "";
        String result2 = test2.getLocation();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setLocation method, of class Event.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "Kampus Kitchen";
        test1.setLocation(location);
    }

    /**
     * Test of getDescription method, of class Event.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        
        String expResult1 = "Lecture for fake class.";
        String result1 = test1.getDescription();
        assertEquals(expResult1, result1);
        
        String expResult2 = "";
        String result2 = test2.getLocation();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setDescription method, of class Event.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "No description";
        test1.setDescription(description);
    }
}