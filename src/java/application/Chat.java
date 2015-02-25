/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javax.swing.JOptionPane;

/**
 *
 * @author jd7
 */
public class Chat {
    
    public void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void testBox() {
        JOptionPane.showMessageDialog(frame, "Test.");
    }
}