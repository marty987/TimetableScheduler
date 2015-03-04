/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cmc8
 */
public class DeleteTest {
    
    public DeleteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setEventId method, of class Delete.
     */
    @Test
    public void testSetEventId() {
        System.out.println("setEventId");
        String eventId = "";
        Delete instance = new Delete();
        instance.setEventId(eventId);
    }

    /**
     * Test of eventInfo method, of class Delete.
     */
    @Test
    public void testEventInfo() {
        System.out.println("eventInfo");
        String event_id = "";
        Delete instance = new Delete();
        String[] expResult = null;
        String[] result = instance.eventInfo(event_id);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of printInfo method, of class Delete.
     */
    @Test
    public void testPrintInfo() {
        System.out.println("printInfo");
        Delete instance = new Delete();
        String expResult = "";
        String result = instance.printInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteEvent method, of class Delete.
     */
    @Test
    public void testDeleteEvent() {
        System.out.println("deleteEvent");
        String userId = "";
        String eventId = "";
        Delete instance = new Delete();
        instance.deleteEvent(userId, eventId);
    }
}