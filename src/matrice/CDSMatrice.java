/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import matrice.interfaces.IMatrice;

/**
 *
 * @author ROY
 */
public class CDSMatrice extends AbstractMatrice{
    
    protected double[][] cds;
    
    public CDSMatrice(int n) throws MatriceException{
        if(n<=0)
            throw new MatriceException("Taille de la matrice superieur ou égal à zero");
        cds = new double[n][3];
    }

    @Override
    public int getNumberOfRow() {
        return cds.length;
    }

    @Override
    public int getNumberOfColumn() {
        return cds.length;
    }

    @Override
    public double get(int i, int j) throws MatriceException {
        System.out.println( " i = " + i + " j = " + j);
        return val(i , j-i+1);
    }

    @Override
    public IMatrice set(int i, int j, double value) throws MatriceException {
        setVal(i , j-i+1 , value);
        return this;
    }
    
    protected double val(int i , int j){
        if(j!=0 && j!=1 && j!=2){
            return 0;
        }
        return cds[i][j];
    }
    
    protected void setVal(int i , int j ,double val){
        if(j!=0 && j!=1 && j!=2){
            return;
        }
        cds[i][j] = val;
    }
    
}
