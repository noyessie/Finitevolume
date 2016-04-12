/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice.solver;

import java.util.logging.Level;
import java.util.logging.Logger;
import matrice.MatriceException;
import matrice.interfaces.IMatrice;

/**
 *
 * @author hubert
 */
public class GausEidelSolver extends AbstractMatriceSolver{
    
    
   private void copy(double[] tab, double[] tab2, int n) {
        for (int i = 0; i < n; i++) {
            tab[i] = tab2[i];
        }
    }

    private void init(double[] tab) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = 0.0000000000;
        }
    }
    
    private double som1(IMatrice matrice, double[] suivant,int id_fin, int i) throws MatriceException{
        int n = matrice.getNumberOfColumn();
        double s = 0;
            for (int k=0;k <=id_fin;k++){
                s = s + matrice.get(i, k)*suivant[k];
            }
        return s;
    }
    
    private double som2(IMatrice mat, double[] pres ,int id_debut, int i) throws MatriceException{
        double t = 0; int n = mat.getNumberOfColumn(); 
        for(int m = id_debut; m <n; m++){
            t = t + mat.get(i, m)*pres[m];
        }
        return t;
    }

    @Override
    public double[] solve(IMatrice mat, double[] b) {
        int n = mat.getNumberOfColumn(); int max = n*100;
        double[] sol; sol = new double[n];
        double[] pres; pres = new double[n];
        init(sol); init(pres);
        for( int p =0 ; p<=max ; p++ ){
            try {
                sol[0] =( b[0] -som2(mat,pres,1,0))*1/(mat.get(0, 0));
                for(int i = 1; i<n;i++ ){
                    try {
                            sol[i] =( b[i] - som1(mat,sol,i-1,i) -som2(mat,pres,i+1,i))*1/(mat.get(i, i));
                    } catch (MatriceException ex) {
                        Logger.getLogger(GausEidelSolver.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    copy(pres, sol, n);
                }} catch (MatriceException ex) {
                Logger.getLogger(GausEidelSolver.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
     
        return sol;
    }
    
}
