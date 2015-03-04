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
        Login instance = new Login();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Login.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Login instance = new Login();
        instance.setUsername(username);
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
        Login instance = new Login();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        HttpServletRequest request = null;
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.loginUser(request);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateLogin method, of class Login.
     */
    @Test
    public void testValidateLogin() {
        System.out.println("validateLogin");
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.validateLogin();
        assertEquals(expResult, result);
    }

    /**
     * Test of loginForm method, of class Login.
     */
    @Test
    public void testLoginForm() {
        System.out.println("loginForm");
        Login instance = new Login();
        String expResult = "";
        String result = instance.loginForm();
        assertEquals(expResult, result);
    }
}