/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.interfaces;

/**
 *
 * @author hubert
 */
public interface IPoint {
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    
    public double get(int dim);
    
    public IPoint set(int dim , double val);
    
    public int getDimension();
    
}
