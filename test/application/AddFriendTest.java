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
public class AddFriendTest {
    
    public AddFriendTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getFriendUserID method, of class AddFriend.
     */
    @Test
    public void testGetFriendUserID() {
        System.out.println("getFriendUserID");
        AddFriend instance = new AddFriend();
        String expResult = "";
        String result = instance.getFriendUserID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFriendUserID method, of class AddFriend.
     */
    @Test
    public void testSetFriendUserID() {
        System.out.println("setFriendUserID");
        String friendUserID = "";
        AddFriend instance = new AddFriend();
        instance.setFriendUserID(friendUserID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsValid method, of class AddFriend.
     */
    @Test
    public void testGetIsValid() {
        System.out.println("getIsValid");
        AddFriend instance = new AddFriend();
        boolean expResult = false;
        boolean result = instance.getIsValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsValid method, of class AddFriend.
     */
    @Test
    public void testSetIsValid() {
        System.out.println("setIsValid");
        boolean isValid = false;
        AddFriend instance = new AddFriend();
        instance.setIsValid(isValid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateAddingFriendForm method, of class AddFriend.
     */
    @Test
    public void testValidateAddingFriendForm() {
        System.out.println("validateAddingFriendForm");
        String userId = "";
        AddFriend instance = new AddFriend();
        boolean expResult = false;
        boolean result = instance.validateAddingFriendForm(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of errors method, of class AddFriend.
     */
    @Test
    public void testErrors() {
        System.out.println("errors");
        AddFriend instance = new AddFriend();
        String expResult = "";
        String result = instance.errors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doesFriendExist method, of class AddFriend.
     */
    @Test
    public void testDoesFriendExist() {
        System.out.println("doesFriendExist");
        String friendUserID = "";
        AddFriend instance = new AddFriend();
        boolean expResult = false;
        boolean result = instance.doesFriendExist(friendUserID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFriend method, of class AddFriend.
     */
    @Test
    public void testAddFriend() {
        System.out.println("addFriend");
        String userId = "";
        AddFriend instance = new AddFriend();
        instance.addFriend(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFriendForm method, of class AddFriend.
     */
    @Test
    public void testAddFriendForm() {
        System.out.println("addFriendForm");
        AddFriend instance = new AddFriend();
        String expResult = "";
        String result = instance.addFriendForm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}