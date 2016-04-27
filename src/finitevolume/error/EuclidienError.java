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
public class EuclidienError extends AbstractError{

    @Override
    public double erreur(double[] solutionReel, double[] solutionApproche) {
        double erreur = 0;
        if(solutionApproche.length == solutionApproche.length){
            for(int i=0 ; i<solutionApproche.length ; i++){
                double err = Math.abs(solutionApproche[i]-solutionReel[i]);
                erreur += err * err ;
            }
        }
        return Math.sqrt(erreur);
    }
    
}
