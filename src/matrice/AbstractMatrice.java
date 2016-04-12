/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import java.util.logging.Level;
import java.util.logging.Logger;
import matrice.interfaces.IMatrice;

/**
 *
 * @author hubert
 */
public abstract class AbstractMatrice implements IMatrice{
    @Override
    public double[][] getMatrice() {
        double mat[][] = new double[this.getNumberOfRow()][this.getNumberOfColumn()];
        
        for(int i=0 ; i< this.getNumberOfRow() ; i++){
            for(int j=0 ; j<this.getNumberOfColumn() ; j++){
                try {
                    mat[i][j] = this.get(i, j);
                } catch (MatriceException ex) {
                    Logger.getLogger(AbstractMatrice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return mat;
    }
}
