/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import matrice.CDSMatrice;
import matrice.MatriceException;
import matrice.TriDiagonalMatrice;
import static utilities.Utilities.printMatrice;

/**
 *
 * @author ROY
 */
public class Testcds {
    public static void main(String[] args) throws MatriceException{
        TriDiagonalMatrice cds = new TriDiagonalMatrice(5);
        printMatrice(cds.getMatrice());
        //element 0 0
        cds.set(0, 0, 10);
        //element 0 1
        cds.set(0, 1, 110);
        //element 1 0
        cds.set(1, 0, 11);
        
        printMatrice(cds.getMatrice());
        
        //element 4 4
        cds.set(4, 4, 55);
        
        //element 3 4
        cds.set(3, 4, 34);
        
        printMatrice(cds.getMatrice());
        
        //element 2 0
        cds.set(2, 0, 20);
        
        //element 2 4
        cds.set(2, 4, 24);
        
        //set Diag
        double[] diag = {1, 2 , 3 ,  4 , 5};
        
        cds.setDiagonal(diag);
        printMatrice(cds.getMatrice());
        //set DiagSup
        double[] diags = {1, 2 , 3 ,  4};
        
        cds.setDiagonalSuperieur(diags);
        printMatrice(cds.getMatrice());
        //set DiagInf
        double[] diagi = { 2 , 3 ,  4 , 5};
        
        cds.setDiagonalInferieur(diagi);
        printMatrice(cds.getMatrice());
    } 
}
