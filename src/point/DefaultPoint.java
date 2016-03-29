/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point;

/**
 *
 * @author hubert
 */
public class DefaultPoint extends AbstractPoint{

    public DefaultPoint(int dim) {
        super(dim);
    }
    
    public DefaultPoint(double[] point){
        super(point);
    }
    
}
