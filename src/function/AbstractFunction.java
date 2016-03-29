/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import function.interfaces.IFunction;

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
}
