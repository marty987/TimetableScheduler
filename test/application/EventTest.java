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
    Event test1 = new Event (1, "CS3300 Lecture", "Lecture", 6, 1, new Date(1001011), new Date(99999999), "weekly", "CS3300", "WGB G02", "Lecture for fake class.");
    Event test2 = new Event (0, "", "", 0, 0, new Date(1), new Date(14), "", "", "", "");
    Event test3 = new Event (2, "12345", "Appointment", 3, 10, new Date(10), new Date(1000000000), "monthly", "CS4400", "WGB 1.11", "Description");
    Event test4 = new Event (3, "", "Personal Event", 9, 9, new Date(9), new Date(89898989), "once", "CS6690", "Kane Building G03", "placeholder");
    Event test5 = new Event (4, "", "", 0, 4, new Date(999999999), new Date(999999999), "", "", "", "");
    Event test6 = new Event (999999, "_", "Meeting", 0, 5, new Date(-999), new Date(-1), "", "", "", "");
    Event test7 = new Event (256, "0", "_", 0, 7, new Date(-1), new Date(0), "", "", "", "");
    Event test8 = new Event (444, "Fake Name", "Lecture", 0, 3, new Date(-0), new Date(1), "", "", "", "");
    
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
        
        int expResult3 = 2;
        int result3 = test3.getEventID();
        assertEquals(expResult3, result3);
        
        int expResult4 = 3;
        int result4 = test4.getEventID();
        assertEquals(expResult4, result4);
        
        int expResult5 = 4;
        int result5 = test5.getEventID();
        assertEquals(expResult5, result5);
        
        int expResult6 = 999999;
        int result6 = test6.getEventID();
        assertEquals(expResult6, result6);
        
        int expResult7 = 256;
        int result7 = test7.getEventID();
        assertEquals(expResult7, result7);
        
        int expResult8 = 444;
        int result8 = test8.getEventID();
        assertEquals(expResult8, result8);
    }

    /**
     * Test of setEventID method, of class Event.
     */
    @Test
    public void testSetEventID() {
        System.out.println("setEventID");
        
        int expResult1 = 4;
        test1.setEventID(expResult1);
        int result1 = test1.getEventID();
        assertEquals(expResult1, result1);
        
        int expResult2 = 9999999;
        test2.setEventID(expResult2);
        int result2 = test2.getEventID();
        assertEquals(expResult2, result2);
        
        int expResult3 = 0;
        test3.setEventID(expResult3);
        int result3 = test3.getEventID();
        assertEquals(expResult3, result3);
        
        int expResult4 = 00000;
        test4.setEventID(expResult4);
        int result4 = test4.getEventID();
        assertEquals(expResult4, result4);
        
        int expResult5 = 909090;
        test5.setEventID(expResult5);
        int result5 = test5.getEventID();
        assertEquals(expResult5, result5);
        
        int expResult6 = 1001000100;
        test6.setEventID(expResult6);
        int result6 = test6.getEventID();
        assertEquals(expResult6, result6);
        
        int expResult7 = 8848848;
        test7.setEventID(expResult7);
        int result7 = test7.getEventID();
        assertEquals(expResult7, result7);
        
        int expResult8 = 3;
        test8.setEventID(expResult8);
        int result8 = test8.getEventID();
        assertEquals(expResult8, result8);
    }

    /**
     * Test of setEventName method, of class Event.
     */
    @Test
    public void testSetEventName() {
        System.out.println("setEventName");
        
        String expResult1 = "CS3301 Lab";
        test1.setEventName(expResult1);
        
        String expResult2 = "CS6005 Lecture";
        test2.setEventName(expResult2);
        
        String expResult3 = "";
        test3.setEventName(expResult3);
        
        String expResult4 = "0";
        test4.setEventName(expResult4);
        
        String expResult5 = "/*32£";
        test5.setEventName(expResult5);
        
        String expResult6 = "Fake";
        test6.setEventName(expResult6);
        
        String expResult7 = "*//*";
        test7.setEventName(expResult7);
        
        String expResult8 = "CS";
        test8.setEventName(expResult8);
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
        
        String expResult3 = "Appointment";
        String result3 = test3.getEventType();
        assertEquals(expResult3, result3);
        
        String expResult4 = "Personal Event";
        String result4 = test4.getEventType();
        assertEquals(expResult4, result4);
        
        String expResult5 = "";
        String result5 = test5.getEventType();
        assertEquals(expResult5, result5);
        
        String expResult6 = "Meeting";
        String result6 = test6.getEventType();
        assertEquals(expResult6, result6);
        
        String expResult7 = "_";
        String result7 = test7.getEventType();
        assertEquals(expResult7, result7);
        
        String expResult8 = "Lecture";
        String result8 = test8.getEventType();
        assertEquals(expResult8, result8);
    }

    /**
     * Test of setEventType method, of class Event.
     */
    @Test
    public void testSetEventType() {
        System.out.println("setEventType");
        
        String expResult1 = "Lab";
        test1.setEventType(expResult1);
        String result1 = test1.getEventType();
        assertEquals(expResult1, result1);
        
        String expResult2 = "Lab";
        test2.setEventType(expResult2);
        String result2 = test2.getEventType();
        assertEquals(expResult2, result2);
        
        String expResult3 = "Lecture";
        test3.setEventType(expResult3);
        String result3 = test3.getEventType();
        assertEquals(expResult3, result3);
        
        String expResult4 = "Meeting";
        test4.setEventType(expResult4);
        String result4 = test4.getEventType();
        assertEquals(expResult4, result4);
        
        String expResult5 = "";
        test5.setEventType(expResult5);
        String result5 = test5.getEventType();
        assertEquals(expResult5, result5);
        
        String expResult6 = "/*$3#";
        test6.setEventType(expResult6);
        String result6 = test6.getEventType();
        assertEquals(expResult6, result6);
        
        String expResult7 = "+";
        test7.setEventType(expResult7);
        String result7 = test7.getEventType();
        assertEquals(expResult7, result7);
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
        
        Date expResult2 = new Date(1);
        Date result2 = test2.getStartDate();
        assertEquals(expResult2, result2);
        
        Date expResult3 = new Date(10);
        Date result3 = test3.getStartDate();
        assertEquals(expResult3, result3);
        
        Date expResult4 = new Date(9);
        Date result4 = test4.getStartDate();
        assertEquals(expResult4, result4);
        
        Date expResult5 = new Date(999999999);
        Date result5 = test5.getStartDate();
        assertEquals(expResult5, result5);
        
        Date expResult6 = new Date(-999);
        Date result6 = test6.getStartDate();
        assertEquals(expResult6, result6);
        
        Date expResult7 = new Date(-1);
        Date result7  = test7.getStartDate();
        assertEquals(expResult7, result7);
        
        Date expResult8 = new Date(-0);
        Date result8 = test8.getStartDate();
        assertEquals(expResult8, result8);
    }

    /**
     * Test of setStartDate method, of class Event.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        
        test1.setStartDate(new Date(0));
        Date expResult1 = test1.getStartDate();
        Date result1 = test8.getStartDate();
        assertEquals(expResult1, result1);
        
        test2.setStartDate(new Date(1));
        Date expResult2 = test2.getStartDate();
        Date result2 = test2.getStartDate();
        assertEquals(expResult2, result2);
        
        test3.setStartDate(new Date(-1));
        Date expResult3 = test3.getStartDate();
        Date result3 = test3.getStartDate();
        assertEquals(expResult3, result3);
        
        test4.setStartDate(new Date(999999999));
        Date expResult4 = test4.getStartDate();
        Date result4 = test4.getStartDate();
        assertEquals(expResult4, result4);
        
        test5.setStartDate(new Date(-999999999));
        Date expResult5 = test5.getStartDate();
        Date result5 = test5.getStartDate();
        assertEquals(expResult5, result5);
    }

    /**
     * Test of getEndDate method, of class Event.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        
        Date expResult1 = new Date(99999999);
        Date result1 = test1.getEndDate();
        assertEquals(expResult1, result1);
        
        Date expResult2 = new Date(14);
        Date result2 = test2.getEndDate();
        assertEquals(expResult2, result2);
        
        Date expResult3 = new Date(1000000000);
        Date result3 = test3.getEndDate();
        assertEquals(expResult3, result3);
        
        Date expResult4 = new Date(89898989);
        Date result4 = test4.getEndDate();
        assertEquals(expResult4, result4);
        
        Date expResult5 = new Date(999999999);
        Date result5 = test5.getEndDate();
        assertEquals(expResult5, result5);
        
        Date expResult6 = new Date(-1);
        Date result6 = test6.getEndDate();
        assertEquals(expResult6, result6);
        
        Date expResult7 = new Date(0);
        Date result7 = test7.getEndDate();
        assertEquals(expResult7, result7);
        
        Date expResult8 = new Date(1);
        Date result8 = test8.getEndDate();
        assertEquals(expResult8, result8);
    }

    /**
     * Test of setEndDate method, of class Event.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        
        Date expResult1 = new Date(0);
        test1.setEndDate(expResult1);
        Date result1 = test1.getEndDate();
        assertEquals(expResult1, result1);
        
        Date expResult2 = new Date(-0);
        test2.setEndDate(expResult2);
        Date result2 = test2.getEndDate();
        assertEquals(expResult2, result2);
        
        Date expResult3 = new Date(9);
        test3.setEndDate(expResult3);
        Date result3 = test3.getEndDate();
        assertEquals(expResult3, result3);
        
        Date expResult4 = new Date(-9);
        test4.setEndDate(expResult4);
        Date result4 = test4.getEndDate();
        assertEquals(expResult4, result4);
        
        Date expResult5 = new Date(999999999);
        test5.setEndDate(expResult5);
        Date result5 = test5.getEndDate();
        assertEquals(expResult5, result5);
        
        Date expResult6 = new Date(-999999999);
        test6.setEndDate(expResult6);
        Date result6 = test6.getEndDate();
        assertEquals(expResult6, result6);
        
        Date expResult7 = new Date(-0);
        test7.setEndDate(expResult7);
        Date result7 = test7.getEndDate();
        assertEquals(expResult7, result7);
        
        Date expResult8 = new Date(90);
        test8.setEndDate(expResult8);
        Date result8 = test8.getEndDate();
        assertEquals(expResult8, result8);
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
        
        int expResult3 = 10;
        int result3 = test3.getPeriod();
        assertEquals(expResult3, result3);
        
        int expResult4 = 9;
        int result4 = test4.getPeriod();
        assertEquals(expResult4, result4);
        
        int expResult5 = 4;
        int result5 = test5.getPeriod();
        assertEquals(expResult5, result5);
        
        int expResult6 = 5;
        int result6 = test6.getPeriod();
        assertEquals(expResult6, result6);
        
        int expResult7 = 7;
        int result7 = test7.getPeriod();
        assertEquals(expResult7, result7);
        
        int expResult8 = 3;
        int result8 = test8.getPeriod();
        assertEquals(expResult8, result8);
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