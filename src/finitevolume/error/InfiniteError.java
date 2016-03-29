/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitevolume.error;

/**
 *
 * @author hubert
 */
public class InfiniteError extends AbstractError{

    @Override
    public double erreur(double[] solutionReel, double[] solutionApproche) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
