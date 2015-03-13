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
    AddMeeting test = new AddMeeting();
    
    public AddMeetingTest() {
        AddMeeting test = new AddMeeting();
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    

    /**
     * Test of getStream method, of class AddMeeting.
     */
    @Test
    public void testGetStream() {
        System.out.println("getStream");
        
        String expResult = "";
        String result = test.getStream();
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
        
        String expResult = "";
        String result = test.errors();
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