/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author punib
 */
public class EmpleadoTest {
    
    public EmpleadoTest() {
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
     * Test of validarId method, of class Empleado.
     */
    @Test
    public void testValidarId() {
        System.out.println("validarId");
        long id = 0L;
        boolean expResult = false;
        boolean result = Empleado.validarId(id);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of validarNombre method, of class Empleado.
     */
    @Test
    public void testValidarNombre001() {
        System.out.println("validarNombre");
        String nombre = "Paula ";
        boolean expResult = true;
        boolean result = Empleado.validarNombre(nombre);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testValidarNombre002() {
        System.out.println("validarNombre");
        String nombre = "P";
        boolean expResult = false;
        boolean result = Empleado.validarNombre(nombre);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testValidarNombre003() {
        System.out.println("validarNombre");
        String nombre = "Paula Luisa";
        boolean expResult = true;
        boolean result = Empleado.validarNombre(nombre);
        assertEquals(expResult, result);
        
    }

    
}
