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
public class DefaultMatrice extends AbstractMatrice{
    protected double[][] matrice;
    
    public DefaultMatrice(int i , int j){
        matrice = new double[i][j];
    }
    
    public DefaultMatrice(double[][] mat){
        this.matrice = mat;
    }
    

    @Override
    public int getNumberOfRow() {
        return matrice.length;
    }

    @Override
    public int getNumberOfColumn() {
        if(matrice.length > 0){
            return matrice[0].length;
        }
        return 0;
    }

    @Override
    public double[][] getMatrice() {
        return matrice;
    }

    @Override
    public double get(int i, int j) {
        return matrice[i][j];
    }

    @Override
    public IMatrice set(int i, int j, double value) {
        matrice[i][j] = value;
        return this;
    }
}
