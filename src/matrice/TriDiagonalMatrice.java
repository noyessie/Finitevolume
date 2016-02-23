/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import matrice.interfaces.IMatrice;

/**
 *
 * @author hubert
 */
public class TriDiagonalMatrice extends AbstractMatrice{
    public double[] diagPrincipale;
    public double[] diagInferieure;
    public double[] diagSuperieure;
    
    public TriDiagonalMatrice(int n){
        
    }

    @Override
    public int getNumberOfRow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfColumn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[][] getMatrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double get(int i, int j) throws MatriceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IMatrice set(int i, int j, double value) throws MatriceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
