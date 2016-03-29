/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitevolume.error.interfaces;

/**
 *
 * @author hubert
 */
public interface IErreur {
    public double erreur(double[] solutionReel , double[] solutionApproche);
}
