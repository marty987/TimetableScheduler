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
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getUserId method, of class User.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        User instance = new User();
        String expResult = "";
        String result = instance.getUserId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserId method, of class User.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        String userId = "";
        User instance = new User();
        instance.setUserId(userId);
    }

    /**
     * Test of getStream method, of class User.
     */
    @Test
    public void testGetStream() {
        System.out.println("getStream");
        User instance = new User();
        String expResult = "";
        String result = instance.getStream();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStream method, of class User.
     */
    @Test
    public void testSetStream() {
        System.out.println("setStream");
        String stream = "";
        User instance = new User();
        instance.setStream(stream);
    }

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        User instance = new User();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class User.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        User instance = new User();
        instance.setFirstName(firstName);
    }

    /**
     * Test of getMiddleName method, of class User.
     */
    @Test
    public void testGetMiddleName() {
        System.out.println("getMiddleName");
        User instance = new User();
        String expResult = "";
        String result = instance.getMiddleName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMiddleName method, of class User.
     */
    @Test
    public void testSetMiddleName() {
        System.out.println("setMiddleName");
        String middleName = "";
        User instance = new User();
        instance.setMiddleName(middleName);
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        User instance = new User();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class User.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        User instance = new User();
        instance.setLastName(lastName);
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        User instance = new User();
        instance.setEmail(email);
    }

    /**
     * Test of getPassword1 method, of class User.
     */
    @Test
    public void testGetPassword1() {
        System.out.println("getPassword1");
        User instance = new User();
        String expResult = "";
        String result = instance.getPassword1();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword1 method, of class User.
     */
    @Test
    public void testSetPassword1() {
        System.out.println("setPassword1");
        String password1 = "";
        User instance = new User();
        instance.setPassword1(password1);
    }

    /**
     * Test of getPassword2 method, of class User.
     */
    @Test
    public void testGetPassword2() {
        System.out.println("getPassword2");
        User instance = new User();
        String expResult = "";
        String result = instance.getPassword2();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword2 method, of class User.
     */
    @Test
    public void testSetPassword2() {
        System.out.println("setPassword2");
        String password2 = "";
        User instance = new User();
        instance.setPassword2(password2);
    }

    /**
     * Test of getPhoneNo method, of class User.
     */
    @Test
    public void testGetPhoneNo() {
        System.out.println("getPhoneNo");
        User instance = new User();
        String expResult = "";
        String result = instance.getPhoneNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhoneNo method, of class User.
     */
    @Test
    public void testSetPhoneNo() {
        System.out.println("setPhoneNo");
        String phoneNo = "";
        User instance = new User();
        instance.setPhoneNo(phoneNo);
    }

    /**
     * Test of validateRegForm method, of class User.
     */
    @Test
    public void testValidateRegForm() {
        System.out.println("validateRegForm");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.validateRegForm();
        assertEquals(expResult, result);
    }

    /**
     * Test of doesUserExist method, of class User.
     */
    @Test
    public void testDoesUserExist() {
        System.out.println("doesUserExist");
        String userID = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.doesUserExist(userID);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerNewUser method, of class User.
     */
    @Test
    public void testRegisterNewUser() {
        System.out.println("registerNewUser");
        User instance = new User();
        instance.registerNewUser();
    }

    /**
     * Test of printErrors method, of class User.
     */
    @Test
    public void testPrintErrors() {
        System.out.println("printErrors");
        User instance = new User();
        String expResult = "";
        String result = instance.printErrors();
        assertEquals(expResult, result);
    }

    /**
     * Test of isInteger method, of class User.
     */
    @Test
    public void testIsInteger() {
        System.out.println("isInteger");
        String value = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.isInteger(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentDate method, of class User.
     */
    @Test
    public void testGetCurrentDate() {
        System.out.println("getCurrentDate");
        User instance = new User();
        String expResult = "";
        String result = instance.getCurrentDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of resetPassword method, of class User.
     */
    @Test
    public void testResetPassword() {
        System.out.println("resetPassword");
        String password1 = "";
        String password2 = "";
        String userId = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.resetPassword(password1, password2, userId);
        assertEquals(expResult, result);
  
    }

    /**
     * Test of getUser method, of class User.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String userId = "";
        User instance = new User();
        String[] expResult = null;
        String[] result = instance.getUser(userId);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of registrationForm method, of class User.
     */
    @Test
    public void testRegistrationForm() {
        System.out.println("registrationForm");
        User instance = new User();
        String expResult = "";
        String result = instance.registrationForm();
        assertEquals(expResult, result);
    }
}