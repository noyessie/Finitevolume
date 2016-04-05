/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice.solver;

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
public class TriDiagMatriceSolverTest {
    
    public TriDiagMatriceSolverTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("_____________________________________");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of solve method, of class TriDiagMatriceSolver.
     */
    @Test
    public void testSolve() {
        System.out.println("solve");
        IMatrice mat = null;
        double[] b = null;
        TriDiagMatriceSolver instance = new TriDiagMatriceSolver();
        double[] expResult = null;
        double[] result = instance.solve(mat, b);
        assertArrayEquals(expResult, result);
    }

    private void assertArrayEquals(double[] expResult, double[] result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
