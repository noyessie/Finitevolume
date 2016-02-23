/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice.interfaces;

/**
 *
 * @author hubert
 */
public interface IMatriceSolver {
    public double[] solve(IMatrice mat, double[] b);
}
