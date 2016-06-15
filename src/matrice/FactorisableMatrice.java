/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;

import matrice.interfaces.IMatrice;

/**
 *
 * @author KevinJio
 */
public class FactorisableMatrice extends AbstractMatrice{
    protected double[] a;
    protected double[] b;
    
    public FactorisableMatrice(int n){
        a = new double[n];
        b = new double[n];
    }

    public double[] getA() {
        return a;
    }

    public void setA(double[] a) {
        this.a = a;
    }

    public double[] getB() {
        return b;
    }

    public void setB(double[] b) {
        this.b = b;
    }
    
    
    
    public FactorisableMatrice(double[] a , double[] b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int getNumberOfRow() {
        return a.length;
    }

    @Override
    public int getNumberOfColumn() {
        return b.length;
    }

    @Override
    public double get(int i, int j) throws MatriceException {
        if(j>= i){
            return a[i]*b[j];
        }else{
            return get(j , i);
        }
    }

    @Override
    public IMatrice set(int i, int j, double value) throws MatriceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
