/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import matrice.interfaces.IMatrice;
import matrice.solver.AbstractMatriceSolver;

/**
 *
 * @author KevinJio
 */
public class Gaus extends AbstractMatriceSolver{
    
    double[] solution;
    

    @Override
    public double[] solve(IMatrice mat, double[] b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
