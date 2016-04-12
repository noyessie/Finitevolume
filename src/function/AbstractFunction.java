/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import function.interfaces.IFunction;
import point.interfaces.IPoint;

/**
 *
 * @author hubert
 */
public abstract class AbstractFunction implements IFunction{
    public double[] valueOf(double[] point){
        double[] result = new double[point.length];
        for(int i=0 ; i<point.length ; i++){
            result[i] = this.valueOf(point[i]);
        }
        return result;
    }
    public double[] valueOf(IPoint[] point){
        double[] result = new double[point.length];
        for(int i=0 ; i<point.length ; i++){
            result[i] = this.valueOf(point[i]);
        }
        return result;
    }

    @Override
    public String toString() {
        return "AbstractFunction{" + '}';
    }
    
    
}
