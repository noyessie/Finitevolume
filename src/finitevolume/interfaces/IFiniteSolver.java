/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitevolume.interfaces;

import function.interfaces.IFunction;

/**
 *
 * @author hubert
 */
public interface IFiniteSolver {
    
    public double[] solve(IFunction f , double u0 , double u1 , double[] mesh );
    
    public double[] solve(IFunction f , double u0 , double u1 , int pas );
    
}
