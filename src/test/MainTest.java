/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import finitevolume.EDF;
import finitevolume.interfaces.IFiniteSolver;
import function.DefaultFunction;

/**
 *
 * @author hubert
 */
public class MainTest {
    public static void main(String[] args){
        constant_function_test(new EDF());
        
    }
    
    public static boolean constant_function_test(IFiniteSolver solver){
        //ce test permet d'étudier le comportement du programme
        //face à une fonction constante; nous prendrons
        // f(x) = 1;
        
        double[] mesh = {0 , 0.25 , 0.5 , 0.75 , 1};
        double u0 = 10;
        double u1 = 5;

        double[] u = solver.solve(new DefaultFunction("1"), u0, u1, mesh);
        
        if(equals(u[0] , 8.84) && equals(u[1] , 7.625) && equals(u[2] , 6.34)){
            return true;
        }
        
        
        return false;
    }
    
    public static boolean equals(double v1 , double v2){
        double epsilon = 0.01;
        if(Math.abs(v1-v2) <= epsilon){
            return true;
        }
        return false;
    }
    
    
}
