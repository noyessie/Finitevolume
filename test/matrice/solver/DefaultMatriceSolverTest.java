/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice.solver;

import matrice.DefaultMatrice;
import matrice.interfaces.IMatrice;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Abdel Aziz NGOUH
 */
public class DefaultMatriceSolverTest {
    
    private double epsilon = 0.01;
    
    public DefaultMatriceSolverTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("____________________________________");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of solve method, of class DefaultMatriceSolver.
     */
    @Test
    public void testSolve() {
        System.out.println("solve");
        double[] b = {9.5,45};
        System.out.println(b[1]);
        double[][] mattrice = {{1,1},{0,1}};
        System.out.println(mattrice[0][1]);
        IMatrice mat = new DefaultMatrice(mattrice);        
        DefaultMatriceSolver instance = new DefaultMatriceSolver();
        double[] expResult = {-35.5,45};
        double[] result = instance.solve(mat, b);
        assertArrayEquals(expResult, result , epsilon);
    }

    
}
