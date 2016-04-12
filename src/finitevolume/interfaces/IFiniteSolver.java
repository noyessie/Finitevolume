/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitevolume.interfaces;

import function.interfaces.IFunction;
import mesh.nterfaces.IMesh;
import point.interfaces.IPoint;

/**
 *
 * @author hubert
 */
public interface IFiniteSolver {
    
    public double[] solve(IFunction f , IPoint u0 , IPoint u1 , IMesh mesh );
    
    public double[] solve(IFunction f , IPoint u0 , IPoint u1 , int point );
}
