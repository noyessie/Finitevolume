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
       protected double[][] cds;
    
    public TriDiagonalMatrice(int n){
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
        //System.out.println( " i = " + i + " j = " + j);
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
    
    public void setDiagonalSuperieur(double[] diag) throws MatriceException{
        setDiag(diag, 1);
    }
    
    public void setDiagonalInferieur(double[] diag) throws MatriceException{
        setDiag(diag , -1);
    }
    
    public void setDiagonal(double[] diag) throws MatriceException{
        setDiag(diag , 0);
    }
    
    protected void setDiag(double[] diag , int number) throws MatriceException{
        if(diag.length != this.getNumberOfRow()- Math.abs(number))
            throw new MatriceException("Diagonnal de taille incorrect");
        int offset = 0;
        offset = number < 0 ? 1:0;
        for(int i=0 ; i<diag.length ; i++){
            cds[i+offset][number+1] = diag[i]; 
        }
    }
}
