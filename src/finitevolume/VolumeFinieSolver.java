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
import matrice.interfaces.IMatriceSolver;
import matrice.solver.GausEidelSolver;
import matrice.solver.TriDiagMatriceSolver;
import mesh.Dim1Mesh;
import mesh.nterfaces.IMesh;
import point.interfaces.IPoint;
import utilities.Utilities;
import static utilities.Utilities.printMatrice;
import static finitevolume.Utility.*;

import Jama.Matrix;
import static utilities.Utilities.formatTable;

/**
 *
 * @author hubert
 */
public class VolumeFinieSolver extends AbstractFiniteSolver {


    @Override
    public double[] solve(IFunction f, IPoint u00, IPoint u11, IMesh meshh) {
        if(meshh.getNumberOfPoint() == 0){
            return new double[0];
        }
        int n = meshh.getNumberOfPoint();
        //determination des pas en fonction du maillage
       
        //on calcul les h(i)
        double h[] = get_h(meshh);
         
       //on calcul les h(i+1/2)
       double h_demie[] = get_h_demie(meshh);
        
       
       //construction de la matrice diagonal A
       TriDiagonalMatrice tri = new TriDiagonalMatrice(n);
        double[] diagInf = new double[n-1];
        double[] diag = new double[n];
        double[] diagSup = new double[n-1];
        for(int i=0 ; i<n ; i++){
            diag[i] = (1.0/(h_demie[i+1]))  + (1.0/h_demie[i]);
        }
        
        for(int i=1 ; i<n ; i++){
            diagInf[i-1] = (-1.0/h_demie[i]);
        }
        
        diagSup = diagInf;
        
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
        
        b[0] = h[0]*f.valueOf(meshh.get(0)) + (1.0/h_demie[0])*u00.get(IPoint.X);
        b[n-1] = h[n-1]*f.valueOf(meshh.get(n-1)) + (1.0/h_demie[n])*u11.get(IPoint.X);
        for(int i=1 ; i<n-1 ; i++){
            b[i] = h[i]*f.valueOf(meshh.get(i));
        }
        
        //System.out.println("valeur du vecteur b");
        //System.out.println(formatTable(b));
        TriDiagMatriceSolver solver = new TriDiagMatriceSolver();
        double[] u = solver.solve(tri, b);
        return u;

    }

    @Override
    public double[] solve(IFunction f, IPoint u0, IPoint u1, int n) {
        IMesh mesh = new Dim1Mesh(n);
        if(mesh.getNumberOfPoint() == 0){
            return new double[0];
        }
        double h = 1.0/(n+1);
        double inv_h = n+1;
        //on calcul les h(i)
        //on calcul les h(i+1/2)
       double h_i[] = new double[n+1];
       for(int i=1 ; i<n ; i++){
           h_i[i] = inv_h;
       }
        
        TriDiagonalMatrice tri = new TriDiagonalMatrice(n);
        double[] diagInf = new double[n-1];
        double[] diag = new double[n];
        double[] diagSup = new double[n-1];
        for(int i=0 ; i<n ; i++){
            diag[i] = (2.0*(inv_h));
        }
        
        for(int i=1 ; i<n ; i++){
            diagInf[i-1] = (-1.0*inv_h);
        }
        
        diagSup = diagInf;
        
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
        
        b[0] = h*f.valueOf(mesh.get(0)) + (inv_h)*u0.get(IPoint.X);
        b[n-1] = h*f.valueOf(mesh.get(n-1)) + (inv_h)*u1.get(IPoint.X);
        for(int i=1 ; i<n-1 ; i++){
            b[i] = h*f.valueOf(mesh.get(i));
        }
        
        //System.out.println("valeur du vecteur b");
        System.out.println(formatTable(b));
        TriDiagMatriceSolver solver = new TriDiagMatriceSolver();
        IMatriceSolver solver1 = new GausEidelSolver();
        printMatrice(tri.getMatrice());
        //System.out.println(Utilities.formatTable(b));
        double[] u = solver1.solve(tri, b);
        
        //Matrix m = new Matrix(tri.getMatrice());
        //Matrix x = new Matrix(u , u.length);
        //Matrix mx = m.times(x);
        
        
        return u;
    }

}
