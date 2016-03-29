/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import finitevolume.DifferenceFinieSolver;
import finitevolume.interfaces.IFiniteSolver;
import function.DefaultFunction;
import function.interfaces.IFunction;
import mesh.DefaultMesh;
import mesh.Dim1Mesh;
import point.DefaultPoint;
import point.interfaces.IPoint;

/**
 *
 * @author hubert
 */
public class Test {
    public static void main(String[] args) throws Exception{
        
        IFiniteSolver solver = new DifferenceFinieSolver();

        System.out.println("f(x) = x");
        
        IPoint u0 = new DefaultPoint(1);
        IPoint u1 = new DefaultPoint(1);
        
        IFunction f = new DefaultFunction("x");
        
        IFunction s = new DefaultFunction("-1/6 * x*x*x + 1/6 * x");
        Dim1Mesh m = new Dim1Mesh(10);
        
        System.out.println(m);
        
        double[] u = solver.solve(f , u0, u1, m);
    }
}
