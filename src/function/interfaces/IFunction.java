/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function.interfaces;

import point.interfaces.IPoint;

/**
 *
 * @author hubert
 */
public interface IFunction {
    
    public double valueOf(double point);
    
    public double[] valueOf(double[] poont);
    
    public double valueOf(IPoint point);
    
    public double[] valueOf(IPoint[] point);
    
    
    
}
