/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Jframe;


import app.bolivia.swing.JCTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;









/**
 *
 * @author Lahiru
 */
public class ManageBookTest {
     @InjectMocks
    ManageBook manageBook;

    @Mock
    DBConnection dbConnectionMock;

    @Mock
    Connection connectionMock;

    @Mock
    PreparedStatement preparedStatementMock;

    @Mock
    Statement statementMock;

    @Mock
    ResultSet resultSetMock;
    
    private PreparedStatement mockPreparedStatement;
    
    private JCTextField txt_bookId;
    private JCTextField txt_bookName;
    private JCTextField txt_AuthorName;
    private JCTextField txt_Quntity;
    private JCTextField tbl_bookDetails;
    
    

    @BeforeEach
    public void setUp() throws Exception {
        
         
        connectionMock = mock(Connection.class);
        preparedStatementMock = mock(PreparedStatement.class);
        
        
        MockitoAnnotations.openMocks(this);
        when(dbConnectionMock.getConnection()).thenReturn(connectionMock);
        
        when(mockConnection.prepareStatement("insert into book_details value (?,?,?,?)"))
                .thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        
        txt_bookId = new JCTextField();
        txt_bookName = new JCTextField();
        txt_AuthorName = new JCTextField();
        txt_Quntity = new JCTextField();
        tbl_bookDetails = new JCTextField();
        
        manageBook = new ManageBook();
        
        
        
    }

    @Test
    public void testAddBook() throws Exception {
        when(connectionMock.prepareStatement(any(String.class))).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeUpdate()).thenReturn(1);

        // Set the input values
        txt_bookId.setText("1");
        txt_bookName.setText("Test Book");
        txt_AuthorName.setText("Test Author");
        txt_Quntity.setText("10");

        boolean result = manageBook.addBook();
        assertTrue(result);
    }

    @Test
    public void testUpdateBook() throws Exception {
        when(connectionMock.prepareStatement(any(String.class))).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeUpdate()).thenReturn(1);

        // Set the input values
        txt_bookId.setText("1");
        txt_bookName.setText("Updated Book");
        txt_AuthorName.setText("Updated Author");
        txt_Quntity.setText("15");

        boolean result = manageBook.updateBook();
        assertTrue(result);
    }

    @Test
    public void testDeleteBook() throws Exception {
        when(connectionMock.prepareStatement(any(String.class))).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeUpdate()).thenReturn(1);

        
        txt_bookId.setText("1");

        boolean result = manageBook.deleteBook();
        assertTrue(result);
    }

    @Test
    public void testSetBookDetailsToTable() throws Exception {
        when(connectionMock.createStatement()).thenReturn(statementMock);
        when(statementMock.executeQuery(any(String.class))).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false);
        when(resultSetMock.getString("book_id")).thenReturn("1");
        when(resultSetMock.getString("book_name")).thenReturn("Test Book");
        when(resultSetMock.getString("author")).thenReturn("Test Author");
        when(resultSetMock.getInt("quantity")).thenReturn(10);

        manageBook.setBookDetailsToTable();

       // DefaultTableModel model = (DefaultTableModel) manageBook.tbl_bookDetails.getModel();
        //assertTrue(model.getRowCount() == 1);
        //assertTrue(model.getValueAt(0, 0).equals("1"));
       // assertTrue(model.getValueAt(0, 1).equals("Test Book"));
       // assertTrue(model.getValueAt(0, 2).equals("Test Author"));
       // assertTrue(model.getValueAt(0, 3).equals(10));
    }

   
    }


  

