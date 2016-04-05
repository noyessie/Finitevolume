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
import org.junit.Ignore;

/**
 *
 * @author hubert
 */
public class DefaultFunctionTest {
    
    public DefaultFunctionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("______________________________");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of valueOf method, of class DefaultFunction.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        double point = 3;
        DefaultFunction instance = new DefaultFunction("x*x");
        double expResult = 9;
        double result = instance.valueOf(point);
        assertEquals(expResult, result, 0.01);

    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testValueOf2() {
        System.out.println("no function in parameter");
        double point = 3;
        DefaultFunction instance = new DefaultFunction("");
        double expResult = 0;
        double result = instance.valueOf(point);
        assertEquals(expResult, result, 0.01);

    }
    
    @Test
    public void testValueOf3() {
        System.out.println("constant function");
        double point = 3;
        DefaultFunction instance = new DefaultFunction("10");
        double expResult = 10;
        double result = instance.valueOf(point);
        assertEquals(expResult, result, 0.01);

    }
    
    @Test
    public void testValueOf4() {
        System.out.println("-x*x + 9/2x+10");
        double point = 1;
        DefaultFunction instance = new DefaultFunction("-x*x + (9 / 2) * x + 10");
        double expResult = -point*point + (9.0/2)*point +10;
        double result = instance.valueOf(point);
        assertEquals(expResult, result, 0.01);

    }
    
    @Test
    public void testValueCos(){
        System.out.println("cos(x)");
        double point = Math.PI/2;
        DefaultFunction instance = new DefaultFunction("cos(x)");
        double expResult = Math.cos(point);
        double result = instance.valueOf(point);
        assertEquals(expResult, result, 0.01);
    }
    
    @Test
    public void testValue5(){
        System.out.println("cos(x) + (sin(x)/tan(x))");
        double point = Math.PI/2;
        DefaultFunction instance = new DefaultFunction("cos(x) + (sin(x)/tan(x))");
        double expResult = Math.cos(point) + (Math.sin(point)/Math.tan(point));
        double result = instance.valueOf(point);
        assertEquals(expResult, result, 0.01);
    }
    
    @Test
    public void testValue6(){
        System.out.println("cos(x) + (sin(x)/tan(x))exp((1-x)/x)");
        double point = Math.PI/2;
        
        DefaultFunction instance = new DefaultFunction("cos(x) + (sin(x)/tan(x))*tan((1-x)/x)");
        double expResult = Math.cos(point) + (Math.sin(point)/Math.tan(point))*Math.exp((1-point)/point);
        double result = instance.valueOf(point);
        assertEquals(expResult, result, 0.01);
    }
    
    @Ignore
    public void testValue8(){
        System.out.println("exp(x)");
        double point = Math.PI/2;
        
        DefaultFunction instance = new DefaultFunction("exp(x)");
        double expResult = Math.exp(point);
        double result = instance.valueOf(point);
        assertEquals(expResult, result, 0.01);
    }
    
}
