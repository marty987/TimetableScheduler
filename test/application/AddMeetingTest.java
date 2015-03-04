/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javax.servlet.http.HttpServletRequest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cmc8
 */
public class AddMeetingTest {
    
    public AddMeetingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getEventName method, of class AddMeeting.
     */
    @Test
    public void testGetEventName() {
        System.out.println("getEventName");
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.getEventName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEventName method, of class AddMeeting.
     */
    @Test
    public void testSetEventName() {
        System.out.println("setEventName");
        String eventName = "";
        AddMeeting instance = new AddMeeting();
        instance.setEventName(eventName);
    }

    /**
     * Test of getEventType method, of class AddMeeting.
     */
    @Test
    public void testGetEventType() {
        System.out.println("getEventType");
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.getEventType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEventType method, of class AddMeeting.
     */
    @Test
    public void testSetEventType() {
        System.out.println("setEventType");
        String eventType = "";
        AddMeeting instance = new AddMeeting();
        instance.setEventType(eventType);
    }

    /**
     * Test of getPeriod method, of class AddMeeting.
     */
    @Test
    public void testGetPeriod() {
        System.out.println("getPeriod");
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.getPeriod();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPeriod method, of class AddMeeting.
     */
    @Test
    public void testSetPeriod() {
        System.out.println("setPeriod");
        String period = "";
        AddMeeting instance = new AddMeeting();
        instance.setPeriod(period);
    }

    /**
     * Test of getStartDate method, of class AddMeeting.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStartDate method, of class AddMeeting.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        String startDate = "";
        AddMeeting instance = new AddMeeting();
        instance.setStartDate(startDate);
    }

    /**
     * Test of getEndDate method, of class AddMeeting.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.getEndDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEndDate method, of class AddMeeting.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        String endDate = "";
        AddMeeting instance = new AddMeeting();
        instance.setEndDate(endDate);

    }

    /**
     * Test of getRecurrence method, of class AddMeeting.
     */
    @Test
    public void testGetRecurrence() {
        System.out.println("getRecurrence");
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.getRecurrence();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRecurrence method, of class AddMeeting.
     */
    @Test
    public void testSetRecurrence() {
        System.out.println("setRecurrence");
        String recurrence = "";
        AddMeeting instance = new AddMeeting();
        instance.setRecurrence(recurrence);
    }

    /**
     * Test of getModuleCode method, of class AddMeeting.
     */
    @Test
    public void testGetModuleCode() {
        System.out.println("getModuleCode");
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.getModuleCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModuleCode method, of class AddMeeting.
     */
    @Test
    public void testSetModuleCode() {
        System.out.println("setModuleCode");
        String moduleCode = "";
        AddMeeting instance = new AddMeeting();
        instance.setModuleCode(moduleCode);
    }

    /**
     * Test of getLocation method, of class AddMeeting.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);

    }

    /**
     * Test of setLocation method, of class AddMeeting.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String location = "";
        AddMeeting instance = new AddMeeting();
        instance.setLocation(location);
    }

    /**
     * Test of getDescription method, of class AddMeeting.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class AddMeeting.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        AddMeeting instance = new AddMeeting();
        instance.setDescription(description);

    }

    /**
     * Test of getStream method, of class AddMeeting.
     */
    @Test
    public void testGetStream() {
        System.out.println("getStream");
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.getStream();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStream method, of class AddMeeting.
     */
    @Test
    public void testSetStream() {
        System.out.println("setStream");
        String stream = "";
        AddMeeting instance = new AddMeeting();
        instance.setStream(stream);
    }


    /**
     * Test of errors method, of class AddMeeting.
     */
    @Test
    public void testErrors() {
        System.out.println("errors");
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.errors();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPeriodFree method, of class AddMeeting.
     */
    @Test
    public void testIsPeriodFree() {
        System.out.println("isPeriodFree");
        String period = "";
        String startDate = "";
        AddMeeting instance = new AddMeeting();
        boolean expResult = false;
        boolean result = instance.isPeriodFree(period, startDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertNewMeeting method, of class AddMeeting.
     */
    @Test
    public void testInsertNewMeeting() {
        System.out.println("insertNewMeeting");
        String userId = "";
        AddMeeting instance = new AddMeeting();
        instance.insertNewMeeting(userId);

    }

    /**
     * Test of isLecturer method, of class AddMeeting.
     */
    @Test
    public void testIsLecturer() {
        System.out.println("isLecturer");
        String userId = "";
        AddMeeting instance = new AddMeeting();
        boolean expResult = false;
        boolean result = instance.isLecturer(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserStream method, of class AddMeeting.
     */
    @Test
    public void testGetUserStream() {
        System.out.println("getUserStream");
        String userId = "";
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.getUserStream(userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of addMeetingForm method, of class AddMeeting.
     */
    @Test
    public void testAddMeetingForm() {
        System.out.println("addMeetingForm");
        String userId = "";
        HttpServletRequest request = null;
        AddMeeting instance = new AddMeeting();
        String expResult = "";
        String result = instance.addMeetingForm(userId, request);
        assertEquals(expResult, result);
    }
}