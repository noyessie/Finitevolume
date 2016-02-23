/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice.interfaces;

import matrice.MatriceException;

/**
 *
 * @author hubert
 */
public interface IMatrice {
    
    public int getNumberOfRow();
    
    public int getNumberOfColumn();
    
    public double[][] getMatrice();
    
    public double get(int i , int j) throws MatriceException;
    
    public IMatrice set(int i , int j , double value) throws MatriceException;
}
