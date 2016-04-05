/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import matrice.interfaces.IMatrice;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hubert
 */
public class DefaultMatriceTest {
    
    public DefaultMatriceTest() {
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
     * Test of getNumberOfRow method, of class DefaultMatrice.
     */
    @Test
    public void testGetNumberOfRow() {
        System.out.println("getNumberOfRow");
        DefaultMatrice instance = null;
        int expResult = 0;
        int result = instance.getNumberOfRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfColumn method, of class DefaultMatrice.
     */
    @Test
    public void testGetNumberOfColumn() {
        System.out.println("getNumberOfColumn");
        DefaultMatrice instance = null;
        int expResult = 0;
        int result = instance.getNumberOfColumn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrice method, of class DefaultMatrice.
     */
    @Test
    public void testGetMatrice() {
        System.out.println("getMatrice");
        DefaultMatrice instance = null;
        double[][] expResult = null;
        double[][] result = instance.getMatrice();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class DefaultMatrice.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int i = 0;
        int j = 0;
        DefaultMatrice instance = null;
        double expResult = 0.0;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class DefaultMatrice.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int i = 0;
        int j = 0;
        double value = 0.0;
        DefaultMatrice instance = null;
        IMatrice expResult = null;
        IMatrice result = instance.set(i, j, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
