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
public class ContactTest {
    
    public ContactTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getEmail method, of class Contact.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Contact instance = new Contact();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Contact.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Contact instance = new Contact();
        instance.setEmail(email);
    }

    /**
     * Test of getSubject method, of class Contact.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        Contact instance = new Contact();
        String expResult = "";
        String result = instance.getSubject();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSubject method, of class Contact.
     */
    @Test
    public void testSetSubject() {
        System.out.println("setSubject");
        String subject = "";
        Contact instance = new Contact();
        instance.setSubject(subject);
    }

    /**
     * Test of getMessage method, of class Contact.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        Contact instance = new Contact();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMessage method, of class Contact.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        Contact instance = new Contact();
        instance.setMessage(message);
    }

    /**
     * Test of validateContactForm method, of class Contact.
     */
    @Test
    public void testValidateContactForm() {
        System.out.println("validateContactForm");
        Contact instance = new Contact();
        boolean expResult = false;
        boolean result = instance.validateContactForm();
        assertEquals(expResult, result);
    }

    /**
     * Test of errors method, of class Contact.
     */
    @Test
    public void testErrors() {
        System.out.println("errors");
        Contact instance = new Contact();
        String expResult = "";
        String result = instance.errors();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertNewMessage method, of class Contact.
     */
    @Test
    public void testInsertNewMessage() {
        System.out.println("insertNewMessage");
        String email = "";
        String subject = "";
        String message = "";
        Contact instance = new Contact();
        instance.insertNewMessage(email, subject, message);
    }

    /**
     * Test of contactForm method, of class Contact.
     */
    @Test
    public void testContactForm() {
        System.out.println("contactForm");
        Contact instance = new Contact();
        String expResult = "";
        String result = instance.contactForm();
        assertEquals(expResult, result);
    }
}