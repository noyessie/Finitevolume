/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

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
public class SquareFunctionTest {
    
    public SquareFunctionTest() {
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
     * Test of valueOf method, of class SquareFunction.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        double point = 9;
        SquareFunction instance = new SquareFunction();
        double expResult = 3;
        double result = instance.valueOf(point);
        assertEquals(expResult, result, 0.0);
        
    }
    
    
}
