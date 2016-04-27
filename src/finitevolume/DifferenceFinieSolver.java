/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitevolume;

import function.interfaces.IFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import matrice.MatriceException;
import matrice.TriDiagonalMatrice;
import matrice.solver.TriDiagMatriceSolver;
import mesh.Dim1Mesh;
import mesh.nterfaces.IMesh;
import point.interfaces.IPoint;
import utilities.Utilities;
import static utilities.Utilities.printMatrice;
import static utilities.Utilities.formatTable;


/**
 *
 * @author hubert
 */
public class DifferenceFinieSolver extends AbstractFiniteSolver {

    
        // @Override
        @Override
        public double[] solve(IFunction f, IPoint pu0, IPoint pu1, int n) {
            double u0 = pu0.get(IPoint.X);
            double u1 = pu1.get(IPoint.X);
            double pas ; double[] mesh={}; double[] u ={};
            if( 1<n){
                u = solve(f,pu0,pu1,new Dim1Mesh(n));
            }else{
                System.out.println("Entez un nombre de points supérieur à 1");
            }
         return u;
        }

        @Override
        public double[] solve (IFunction f, IPoint pu0, IPoint pu1, IMesh meshh){
               // calcul des images de la fonction f par x
            //on calcul les h(i+1/2)
            int n = meshh.getNumberOfPoint();
            double h_demie[] = new double[n+1];
            h_demie[0] = meshh.get(0).get(IPoint.X);
            h_demie[n] = 1 - meshh.get(n-1).get(IPoint.X);
            double h=0;
            for(int i=1 ; i<n ; i++){
                h_demie[i] = meshh.get(i).get(IPoint.X) - meshh.get(i-1).get(IPoint.X);
                h = h_demie[i] > h ? h_demie[i]:h;
            }
            double inv_h = 1.0/h;
            double inv_h_carre = 1.0 / (h*h);
            
            /*double rho[] = new double[n];
            for(int i=0 ; i<rho.length ; i++){
                rho[i] = ( ( h_demie[i+1] - h_demie[i] ) / ( h_demie[i+1] + h_demie[i] )  );
            }
            
        */    
       //construction de la matrice diagonal A
       TriDiagonalMatrice tri = new TriDiagonalMatrice(n);
        double[] diagInf = new double[n-1];
        double[] diag = new double[n];
        double[] diagSup = new double[n-1];
        for(int i=0 ; i<n ; i++){
            diag[i] = 2.0*inv_h_carre;
        }
        
        for(int i= 0 ; i<diagInf.length ; i++)
        {
            diagInf[i] = -inv_h_carre;
            diagSup[i] = -inv_h_carre;
        }        
        
        try {
            //ajout des diagonals à la matrice
            tri.setDiagonal(diag);
            tri.setDiagonalInferieur(diagInf);
            tri.setDiagonalSuperieur(diagSup);
        } catch (MatriceException ex) {
            Logger.getLogger(VolumeFinieSolver.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        //creation du vecteur b
        double b[] = new double[n];
        
        b[0] = f.valueOf(meshh.get(0).get(IPoint.X)) + inv_h_carre * pu0.get(IPoint.X);
        b[n-1] =f.valueOf(meshh.get(n-1).get(IPoint.X)) + inv_h_carre * pu1.get(IPoint.X);
        for(int i=1 ; i<n-1 ; i++){
            b[i] = f.valueOf(meshh.get(i));
        }
        
        //printMatrice(tri.getMatrice());
        //System.out.println(Utilities.formatTable(b));
        
        //System.out.println("valeur du vecteur b");
        //System.out.println(formatTable(b));
        TriDiagMatriceSolver solver = new TriDiagMatriceSolver();
        double[] u = solver.solve(tri, b);
        return u;
        }

    }
