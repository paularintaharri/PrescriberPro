/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import resources.employee.EmployeeDAO;
import java.util.List;
import resources.employee.Employee;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Timo Lehtola, Paula Rinta-Harri, Joonas Siikavirta, Johanna Tani
 */
public class EmployeeDAOTest {
    private final EmployeeDAO instance = new EmployeeDAO();
    public EmployeeDAOTest(){
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
      /**
     * Test of readEmployee method, of class EmployeeDAO.
     */
    @Test
    public void testReadEmployee(){
        System.out.println("readEmployee");
        int userID = 1;
        
        
        Employee result = instance.readEmployee(userID);
        
        assertEquals(1, result.getUserID());
        assertEquals("Irvi", result.getFirstName());
        assertEquals("Kaikkonen", result.getLastName());
        assertEquals("admin@sairaala.com", result.getEmail());
        assertEquals("Ylläpitäjä", result.getTitle());
 
    }
    
     /**
     * Test of readEmployees method, of class EmployeeDAO.
     */
    @Test
    public void testReadEmployees(){
        System.out.println("readEmployees");
        List<Employee> result = instance.readEmployees();
        
        assertEquals(1, result.get(0).getUserID());
        assertEquals("Irvi", result.get(0).getFirstName());
        assertEquals("Kaikkonen", result.get(0).getLastName());
        assertEquals("admin@sairaala.com", result.get(0).getEmail());
        assertEquals("Ylläpitäjä", result.get(0).getTitle());
        
    }
    
}
