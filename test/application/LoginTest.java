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
public class LoginTest {
    
    public Login test = new Login( );
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getUsername method, of class Login.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        
        String expResult = "";
        String result = test.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Login.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        
        String username = "";
        test.setUsername(username);
        String result = test.getUsername();
        assertEquals(username, result);
        
        username = "Mary";
        test.setUsername(username);
        result = test.getUsername();
        assertEquals(username, result);
        
        username = "_$@#~";
        test.setUsername(username);
        result = test.getUsername();
        assertEquals(username, result);
        
        username = "ABCDEFGHIJKLMNOP";
        test.setUsername(username);
        result = test.getUsername();
        assertEquals(username, result);
        
        username = "mary";
        test.setUsername(username);
        result = test.getUsername();
        assertEquals(username, result);
        
        username = "MARY";
        test.setUsername(username);
        result = test.getUsername();
        assertEquals(username, result);
        
        username = "1234567890";
        test.setUsername(username);
        result = test.getUsername();
        assertEquals(username, result);
    }

    /**
     * Test of getFirstName method, of class Login.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        
        Login instance = new Login();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Login.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        
        String expResult = null;
        String result = test.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of loginUser method, of class Login.
     
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        
        HttpServletRequest request = null;
        boolean expResult = false;
        boolean result = test.loginUser(request);
        assertEquals(expResult, result);
    }*/

    /**
     * Test of validateLogin method, of class Login.
     */
    @Test
    public void testValidateLogin() {
        System.out.println("validateLogin");
        
        boolean expResult = false;
        boolean result = test.validateLogin();
        assertEquals(expResult, result);
    }

    /**
     * Test of loginForm method, of class Login.
     */
    @Test
    public void testLoginForm() {
        System.out.println("loginForm");
        String username = test.getUsername();
        String expResult = "<form name=\"login_form\" action=\"index.jsp\" method=\"POST\">\n"
                + "<label for=\"username\">UCC ID:</label>\n"
                + "<input type=\"text\" name=\"username\" value=\"" + username + "\"placeholder=\"Enter Username\" /><br/>\n"
                + "<label for=\"Password\">Password:</label>\n"
                + "<input type=\"password\" name=\"password\" placeholder=\"Enter Password\"/><br />\n"
                + "<input type=\"submit\" value=\"Login\" name=\"submit\" /><br />\n"
                + "</form>";
        
        String result = test.loginForm();
        assertEquals(expResult, result);
    }
}