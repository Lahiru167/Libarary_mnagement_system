/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Jframe;

import com.libararysystem.library_management_system.LibraryManagementSystem_Test;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Lahiru
 */
public class Login_PageTest {
    
    
    
    
   private JTextField txt_userName;
    private JPasswordField txt_Password;
    private ValidateLogin validateLogin;
    
    


    @BeforeEach
    public void setUp() {
       
        txt_userName = new JTextField();
        txt_Password = new JPasswordField();
        validateLogin = new ValidateLogin();
        
    }

    @Test
    public void testEmptyUserName() {
        txt_userName.setText("");
        txt_Password.setText("password");
        boolean result = validateLogin.validateLogin(txt_userName, txt_Password);
        assertFalse(result);
    }

    @Test
    public void testEmptyPassword() {
        txt_userName.setText("username");
        txt_Password.setText("");
        boolean result = validateLogin.validateLogin(txt_userName, txt_Password);
        assertFalse(result);
    }

    @Test
    public void testValidLogin() {
        txt_userName.setText("username");
        txt_Password.setText("password");
        boolean result = validateLogin.validateLogin(txt_userName, txt_Password);
        assertTrue(result);
    }
    
    
   
    
    
    
    

    private Object verify(ResultSet mockResultSet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
  public class ValidateLogin {
    public boolean validateLogin(JTextField txt_userName, JPasswordField txt_Password) {
        String name = txt_userName.getText();
        String pwd = new String(txt_Password.getPassword());
        
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter UserName");
            return false;
        }
        if (pwd.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter password");
            return false;
        }
        
        return true;
    }
  }
    
}
