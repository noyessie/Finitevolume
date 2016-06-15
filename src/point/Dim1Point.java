/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point;

import point.interfaces.IPoint;

/**
 *
 * @author ROY
 */
public class Dim1Point extends AbstractPoint {
    

    
    public Dim1Point(double point){
        super(1);
        this.set(IPoint.X, point);
    }
    
}
