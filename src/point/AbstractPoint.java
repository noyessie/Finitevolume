/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point;

import java.util.Arrays;
import point.interfaces.IPoint;

/**
 *
 * @author hubert
 */
public class AbstractPoint implements IPoint{
    public double[] point;
    
    public AbstractPoint(int dim){
        if(dim <=0)
            throw new IllegalArgumentException("the dimnsion may be less or equal than 0");
        point = new double[dim];
    }
    
    public AbstractPoint(double[] p){
        if(p.length <=0)
            throw new IllegalArgumentException("the dimnsion may be less or equal than 0");
        point = p;
    }

    @Override
    public double get(int dim) {
        return point[dim];
    }

    @Override
    public int getDimension() {
        return point.length;
    }

    @Override
    public IPoint set(int dim, double val) {
        this.point[dim] = val;
        return this;
    }

    @Override
    public String toString() {
        String chaine = "[";
        for(int i=0 ; i<point.length ; i++){
            chaine += " " + get(i) + " ";
        }
        chaine += "]";
        return chaine;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Arrays.hashCode(this.point);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractPoint other = (AbstractPoint) obj;
        if (!Arrays.equals(this.point, other.point)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
