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
    User test = new User();
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Test of getUserId and setUserId methods, of class User.
     */
    @Test
    public void testGetUserIdAndSetUserId() {
        System.out.println("getUserId and setUserId");
        
        String expResult = "111111111";
        test.setUserId(expResult);
        String result = test.getUserId();
        assertEquals(expResult, result);
        
        expResult = "999999999";
        test.setUserId(expResult);
        result = test.getUserId();
        assertEquals(expResult, result);
        
        expResult = "123423458";
        test.setUserId(expResult);
        result = test.getUserId();
        assertEquals(expResult, result);
        
        expResult = "234456567";
        test.setUserId(expResult);
        result = test.getUserId();
        assertEquals(expResult, result);
        
        expResult = "767652341";
        test.setUserId(expResult);
        result = test.getUserId();
        assertEquals(expResult, result);
        
        expResult = "000000000";
        test.setUserId(expResult);
        result = test.getUserId();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getStream and setStream methods, of class User.
     */
    @Test
    public void testGetStreamAndSetStream() {
        System.out.println("getStream and setStream");
        
        String expResult = "0";
        test.setStream(expResult);
        String result = test.getStream();
        assertEquals(expResult, result);
        
        expResult = "1";
        test.setStream(expResult);
        result = test.getStream();
        assertEquals(expResult, result);
        
        expResult = "2";
        test.setStream(expResult);
        result = test.getStream();
        assertEquals(expResult, result);
        
        expResult = "3";
        test.setStream(expResult);
        result = test.getStream();
        assertEquals(expResult, result);
        
        expResult = "4";
        test.setStream(expResult);
        result = test.getStream();
        assertEquals(expResult, result);
        
        expResult = "5";
        test.setStream(expResult);
        result = test.getStream();
        assertEquals(expResult, result);
        
        expResult = "6";
        test.setStream(expResult);
        result = test.getStream();
        assertEquals(expResult, result);
        
        expResult = "7";
        test.setStream(expResult);
        result = test.getStream();
        assertEquals(expResult, result);
        
        expResult = "8";
        test.setStream(expResult);
        result = test.getStream();
        assertEquals(expResult, result);
        
        expResult = "9";
        test.setStream(expResult);
        result = test.getStream();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName and setFirstName methods, of class User.
     */
    @Test
    public void testGetFirstNameAndSetFirstName() {
        System.out.println("getFirstName and setFirstName");
        
        String expResult = "Mary";
        test.setFirstName(expResult);
        String result = test.getFirstName();
        assertEquals(expResult, result);
        
        expResult = "MARY";
        test.setFirstName(expResult);
        result = test.getFirstName();
        assertEquals(expResult, result);
        
        expResult = "mary";
        test.setFirstName(expResult);
        result = test.getFirstName();
        assertEquals(expResult, result);
        
        expResult = " mary ";
        test.setFirstName(expResult);
        result = test.getFirstName();
        assertEquals(expResult, result);
        
        expResult = " MARY ";
        test.setFirstName(expResult);
        result = test.getFirstName();
        assertEquals(expResult, result);
        
        expResult = "0";
        test.setFirstName(expResult);
        result = test.getFirstName();
        assertEquals(expResult, result);
        
        expResult = "999";
        test.setFirstName(expResult);
        result = test.getFirstName();
        assertEquals(expResult, result);
        
        expResult = "&@*£\\";
        test.setFirstName(expResult);
        result = test.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMiddleName and setMiddleName methods, of class User.
     */
    @Test
    public void testGetMiddleNameAndSetMiddleName() {
        System.out.println("getMiddleName and setMiddleName");
        
        String expResult = "Mary";
        test.setMiddleName(expResult);
        String result = test.getMiddleName();
        assertEquals(expResult, result);
        
        expResult = "MARY";
        test.setMiddleName(expResult);
        result = test.getMiddleName();
        assertEquals(expResult, result);
        
        expResult = "mary";
        test.setMiddleName(expResult);
        result = test.getMiddleName();
        assertEquals(expResult, result);
        
        expResult = " mary ";
        test.setMiddleName(expResult);
        result = test.getMiddleName();
        assertEquals(expResult, result);
        
        expResult = " MARY ";
        test.setMiddleName(expResult);
        result = test.getMiddleName();
        assertEquals(expResult, result);
        
        expResult = "0";
        test.setMiddleName(expResult);
        result = test.getMiddleName();
        assertEquals(expResult, result);
        
        expResult = "999";
        test.setMiddleName(expResult);
        result = test.getMiddleName();
        assertEquals(expResult, result);
        
        expResult = "&@*£\\";
        test.setMiddleName(expResult);
        result = test.getMiddleName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName and setLastName methods, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName and setLastName");
        
        String expResult = "Mary";
        test.setLastName(expResult);
        String result = test.getLastName();
        assertEquals(expResult, result);
        
        expResult = "MARY";
        test.setLastName(expResult);
        result = test.getLastName();
        assertEquals(expResult, result);
        
        expResult = "mary";
        test.setLastName(expResult);
        result = test.getLastName();
        assertEquals(expResult, result);
        
        expResult = " mary ";
        test.setLastName(expResult);
        result = test.getLastName();
        assertEquals(expResult, result);
        
        expResult = " MARY ";
        test.setLastName(expResult);
        result = test.getLastName();
        assertEquals(expResult, result);
        
        expResult = "0";
        test.setLastName(expResult);
        result = test.getLastName();
        assertEquals(expResult, result);
        
        expResult = "999";
        test.setLastName(expResult);
        result = test.getLastName();
        assertEquals(expResult, result);
        
        expResult = "&@*£\\";
        test.setLastName(expResult);
        result = test.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail and setEmail methods, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
      
        String expResult = "&@*£\\";
        test.setEmail(expResult);
        String result = test.getEmail();
        assertEquals(expResult, result);
        
        expResult = "fake@umail.ucc.ie";
        test.setEmail(expResult);
        result = test.getEmail();
        assertEquals(expResult, result);
        
        expResult = "fake@gmail.com";
        test.setEmail(expResult);
        result = test.getEmail();
        assertEquals(expResult, result);
        
        expResult = "fake@hotmail.com";
        test.setEmail(expResult);
        result = test.getEmail();
        assertEquals(expResult, result);
        
        expResult = "fake@eircom.net";
        test.setEmail(expResult);
        result = test.getEmail();
        assertEquals(expResult, result);
        
        expResult = "fake@ucc.ie";
        test.setEmail(expResult);
        result = test.getEmail();
        assertEquals(expResult, result);
        
        expResult = "000400404";
        test.setEmail(expResult);
        result = test.getEmail();
        assertEquals(expResult, result);
    }


    /**
     * Test of getPassword1 and setPassword methods, of class User.
     */
    @Test
    public void testGetPassword1AndSetPassword1() {
        System.out.println("getPassword1");
        
        String expResult = "abc";
        test.setPassword1(expResult);
        String result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "_abc1";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "ABC";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "_ABC1";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "AbC";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "_AbC1";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "123456789";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "$£€&~@";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword2 and setPassword2 methods, of class User.
     */
    @Test
    public void testGetPassword2AndSetPassword2() {
        System.out.println("getPassword2 and setPassword2");
        
        String expResult = "abc";
        test.setPassword1(expResult);
        String result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "_abc1";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "ABC";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "_ABC1";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "AbC";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "_AbC1";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "123456789";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
        
        expResult = "$£€&~@";
        test.setPassword1(expResult);
        result = test.getPassword1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhoneNo and setPhoneNo method, of class User.
     */
    @Test
    public void testGetPhoneNo() {
        System.out.println("getPhoneNo and setPhoneNo");
        
        String expResult = "0";
        test.setPhoneNo(expResult);
        String result = test.getPhoneNo();
        assertEquals(expResult, result);
        
        expResult = "0877777777";
        test.setPhoneNo(expResult);
        result = test.getPhoneNo();
        assertEquals(expResult, result);
        
        expResult = "087 7777777 ";
        test.setPhoneNo(expResult);
        result = test.getPhoneNo();
        assertEquals(expResult, result);
        
        expResult = "0000000000";
        test.setPhoneNo(expResult);
        result = test.getPhoneNo();
        assertEquals(expResult, result);
        
        expResult = "999999999";
        test.setPhoneNo(expResult);
        result = test.getPhoneNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of validateRegForm method, of class User.
     */
    @Test
    public void testValidateRegForm() {
        System.out.println("validateRegForm");

        boolean expResult = false;
        boolean result = test.validateRegForm();
        assertEquals(expResult, result);
    }

    /**
     * Test of doesUserExist method, of class User.
     */
    @Test
    public void testDoesUserExist() {
        System.out.println("doesUserExist");
        
        String userID = "999999999";
        boolean expResult = false;
        boolean result = test.doesUserExist(userID);
        assertEquals(expResult, result);
                
        test.setUserId(userID);
        expResult = true;
        result = test.doesUserExist(userID);
        assertEquals(expResult, result);
        
        userID = "000000000";
        test.setUserId(userID);
        expResult = true;
        result = test.doesUserExist(userID);
        assertEquals(expResult, result);
        
        userID = "999999999";
        test.setUserId(userID);
        expResult = true;
        result = test.doesUserExist(userID);
        assertEquals(expResult, result);
        
        userID = "827368234";
        test.setUserId(userID);
        expResult = true;
        result = test.doesUserExist(userID);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of registerNewUser method, of class User.
     */
    @Test
    public void testRegisterNewUser() {
        System.out.println("registerNewUser");
        
        test.registerNewUser();
    }

    /**
     * Test of printErrors method, of class User.
     */
    @Test
    public void testPrintErrors() {
        System.out.println("printErrors");
        
        String expResult = "<ul></ul>";
        String result = test.printErrors();
        assertEquals(expResult, result);
    }

    /**
     * Test of isInteger method, of class User.
     */
    @Test
    public void testIsInteger() {
        System.out.println("isInteger");
        
        String value = "string";
        boolean expResult = false;
        boolean result = test.isInteger(value);
        assertEquals(expResult, result);
        
        value = "0";
        expResult = true;
        result = test.isInteger(value);
        assertEquals(expResult, result);
        
        value = "1";
        expResult = true;
        result = test.isInteger(value);
        assertEquals(expResult, result);
        
        value = "999999999";
        expResult = true;
        result = test.isInteger(value);
        assertEquals(expResult, result);
        
        value = "000000000";
        expResult = true;
        result = test.isInteger(value);
        assertEquals(expResult, result);
        
        value = "-0";
        expResult = true;
        result = test.isInteger(value);
        assertEquals(expResult, result);
        
        value = "";
        expResult = false;
        result = test.isInteger(value);
        assertEquals(expResult, result);
        
        value = "-999999999";
        expResult = true;
        result = test.isInteger(value);
        assertEquals(expResult, result);
        
        value = "-1";
        expResult = true;
        result = test.isInteger(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentDate method, of class User.
     */
    @Test
    public void testGetCurrentDate() {
        System.out.println("getCurrentDate");
        
        String expResult = "2015-03-13";
        String result = test.getCurrentDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of resetPassword method, of class User.
     */
    @Test
    public void testResetPassword() {
        System.out.println("resetPassword");
        
        String password1 = "abc";
        test.setPassword1(password1);
        String password2 = "def";
        String userId = "999999999";
        boolean expResult = true;
        boolean result = test.resetPassword(password1, password2, userId);
        assertEquals(expResult, result);
        
        password2 = "abc";
        expResult = true;
        result = test.resetPassword(password1, password2, userId);
        assertEquals(expResult, result);
  
        password1 = "123";
        password2 = "def";
        expResult = false;
        result = test.resetPassword(password1, password2, userId);
        assertEquals(expResult, result);
        
        password2 = "ABC";
        expResult = true;
        result = test.resetPassword(password1, password2, userId);
        assertEquals(expResult, result);

        password2 = "abc123";
        expResult = true;
        result = test.resetPassword(password1, password2, userId);
        assertEquals(expResult, result);
        
        password2 = "123abc";
        expResult = true;
        result = test.resetPassword(password1, password2, userId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class User.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        
        String userId = "999999999";
        String[] expResult = null;
        String[] result = test.getUser(userId);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of registrationForm method, of class User.
     */
    @Test
    public void testRegistrationForm() {
        System.out.println("registrationForm");
        String expResult = "<form name='registration_form' action='register.jsp' method='POST'>\n" +
        "<label for='userId'>Id Number:</label>\n" +
        "<input type='text' name='userId' value='" + test.getUserId() + "' placeholder='123456789' /><br />\n" +
        "<label for='stream'>Stream:</label>\n" +
                "<select name=\"stream\"id='dropdown' >\n" +
                    "  <option value=\"1\" selected>Computer Sci Year 1</option>\n" +
                    "  <option value=\"2\">Core Year 2</option>\n" +
                    "  <option value=\"3\">Core Year 3</option>\n" +
                    "  <option value=\"4\">Core Year 4</option>\n" +
                    "  <option value=\"5\">Web Year 2</option>\n" +
                    "  <option value=\"6\">Web Year 3</option>\n" +
                    "  <option value=\"7\">Web Year 4</option>\n" +
                    "  <option value=\"8\">Soft Entrep Year 2</option>\n" +
                    "  <option value=\"9\">Soft Entrep Year 3</option>\n" +
                    "  <option value=\"10\">Soft Entrep Year 4</option>\n" +
                    "  <option value=\"11\">Chinese Year 2</option>\n" +
                    "  <option value=\"12\">Chinese Year 3</option>\n" +
                    "  <option value=\"13\">Chinese Year 4</option>\n" +
                "</select><br />"+
        
        "<label for='firstName'>First Name:</label>\n" +
        "<input type='text' name='firstName' value='" + test.getFirstName() +  "' placeholder='John' /><br />\n" +
        "<label for='middleName'>Middle Name:</label>\n" +
        "<input type='text' name='middleName' value='" + test.getMiddleName() +  "' placeholder='Swan' /><br />\n" +
        "<label for='lastName'>Last Name:</label>\n" +
        "<input type='text' name='lastName' value='" + test.getLastName() +  "' placeholder='Smith' /><br />\n" +
        "<label for='email'>Email:</label>\n" +
        "<input type='email' id='email' name='email' value='" + test.getEmail() +  "' placeholder='martin@live.ie' /><br />\n"+
        "<label for='password1'>Password:</label>\n" +
        "<input type='password' name='password1' /><br />\n" +
        "<label for='password2'>Confirm Password:</label>\n" +
        "<input type='password' name='password2' /><br />\n" +
        "<label for='phoneNo'>Phone Number:</label>\n" +
        "<input type='text' name='phoneNo' value='" + test.getPhoneNo() +  "' placeholder='085-1175892' /><br />\n" +
        "<input type='submit' value='Submit' name='submit' /><br />\n" +
        "</form>\n";
        String result = test.registrationForm();
        assertEquals(expResult, result);
    }
}