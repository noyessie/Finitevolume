/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitevolume;

import function.interfaces.IFunction;
import mesh.nterfaces.IMesh;
import point.interfaces.IPoint;

/**
 *
 * @author hubert
 */
public class VolumeFinieSolver extends AbstractFiniteSolver{

    @Override
    public double[] solve(IFunction f, IPoint u0, IPoint u1, IMesh mesh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] solve(IFunction f, IPoint u0, IPoint u1, int point) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
