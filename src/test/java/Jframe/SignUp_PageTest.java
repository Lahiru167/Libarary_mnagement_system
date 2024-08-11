/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Jframe;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




/**
 *
 * @author Lahiru
 */
public class SignUp_PageTest {
    
    private JTextField txt_userName;
    private JTextField txt_Password;
    private JTextField txt_Email;
    private JTextField txt_contac;
    private JFrame frame;

    @BeforeEach
    public void setUp() {
        frame = new JFrame();
        txt_userName = new JTextField();
        txt_Password = new JTextField();
        txt_Email = new JTextField();
        txt_contac = new JTextField();
        frame.add(txt_userName);
        frame.add(txt_Password);
        frame.add(txt_Email);
        frame.add(txt_contac);
        frame.pack();
    }

    @Test
    public void testValidateSignUp_Valid() {
        txt_userName.setText("validUser");
        txt_Password.setText("validPass");
        txt_Email.setText("validEmail@example.com");
        txt_contac.setText("1234567890");
        boolean result = validateSignUp();
        assertTrue(result);
    }

    @Test
    public void testValidateSignUp_EmptyUsername() {
        txt_userName.setText("");
        txt_Password.setText("validPass");
        txt_Email.setText("validEmail@example.com");
        txt_contac.setText("1234567890");
        boolean result = validateSignUp();
        assertFalse(result);
    }

    @Test
    public void testValidateSignUp_EmptyPassword() {
        txt_userName.setText("validUser");
        txt_Password.setText("");
        txt_Email.setText("validEmail@example.com");
        txt_contac.setText("1234567890");
        boolean result = validateSignUp();
        assertFalse(result);
    }

    @Test
    public void testValidateSignUp_EmptyContact() {
        txt_userName.setText("validUser");
        txt_Password.setText("validPass");
        txt_Email.setText("validEmail@example.com");
        txt_contac.setText("");
        boolean result = validateSignUp();
        assertFalse(result);
    }

    @Test
    public void testValidateSignUp_EmptyEmail() {
        txt_userName.setText("validUser");
        txt_Password.setText("validPass");
        txt_Email.setText("");
        txt_contac.setText("1234567890");
        boolean result = validateSignUp();
        assertFalse(result);
    }

    public boolean validateSignUp() {
        String name = txt_userName.getText();
        String pwd = txt_Password.getText();
        String email = txt_Email.getText();
        String contact = txt_contac.getText();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(frame, "Please Enter UserName");
            return false;
        }
        if (pwd.equals("")) {
            JOptionPane.showMessageDialog(frame, "Please Enter Password");
            return false;
        }
        if (contact.equals("")) {
            JOptionPane.showMessageDialog(frame, "Please Enter Contact Number");
            return false;
        }
        if (email.equals("")) {
            JOptionPane.showMessageDialog(frame, "Please Enter Valid Email");
            return false;
        }

        return true;
    }
   
}
    
