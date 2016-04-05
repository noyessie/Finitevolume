/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitevolume;

import finitevolume.interfaces.IFiniteSolver;
import function.DefaultFunction;
import function.interfaces.IFunction;
import mesh.Dim1Mesh;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import point.DefaultPoint;
import point.interfaces.IPoint;

/**
 *
 * @author hubert
 */
public class EDFTest {
    
    static double epsilon = 0.0001;
    static IFiniteSolver solver;
    
    public EDFTest() {
        solver = new DifferenceFinieSolver();
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        System.out.println("tests pour les differences finies");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("fin tests pour les differences finies");
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        System.out.println();
    }

    /**
     * Test of solve method, of class EDF.
     */
    //@Test
    public void solve1_constantFunction() {
        System.out.println("f(x) = 1");
        double[] mesh = {0.25 , 0.5 , 0.75};
        
        double u0 = 10;
        double u1 = 5;
        
        IFunction f = new DefaultFunction("1");

        
        IFunction s = new DefaultFunction("-0.5*x*x - 9/2*x +10");

        //double[] u = solver.solve(f , u0, u1, mesh);
        
        //assertArrayEquals(u, s.valueOf(mesh) , epsilon);
    }
    
    @Test
    public void solve1_nullFunction(){
        System.out.println("f(x) = x");
        
        
        IPoint u0 = new DefaultPoint(1);
        IPoint u1 = new DefaultPoint(1);
        u0.set(IPoint.X, 0);
        u1.set(IPoint.X, 0);

        
        IFunction f = new DefaultFunction("x");
        
        IFunction s = new DefaultFunction("-1/6 * x*x*x + 1/6 * x");
        Dim1Mesh m = new Dim1Mesh(10);
        System.out.println(m);
        double[] u = solver.solve(f , u0, u1, m);
        double mesh[] = new double[m.getMesh().length];
        for(int i=0 ; i<mesh.length ; i++){
            mesh[i] = m.get(i).get(IPoint.X);
        }
        
        double so[] = s.valueOf(mesh);
        
        for(int i=0 ; i<u.length ; i++){
            System.out.println(u[i] + "      " + so[i]);
        }
        assertArrayEquals(u, so , epsilon);
    }
    
//    @Test
    public void solve1_sinFunction(){
        System.out.println("f(x) = sin(x)");
        double[] mesh = {0.25 , 0.5 , 0.75};
        
        double u0 = 0;
        double u1 = 0;
        
        IFunction f = new DefaultFunction("sin(x)");
        
        IFunction s = new DefaultFunction("sin(x) + x * sin(-1) ");

        //double[] u = solver.solve(f , u0, u1, mesh);
        
        //assertArrayEquals(u, s.valueOf(mesh) , epsilon);
    }
    
    
}
