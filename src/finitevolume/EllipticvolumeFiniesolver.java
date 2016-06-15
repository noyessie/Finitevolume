/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitevolume;

import function.interfaces.IFunction;
import mesh.nterfaces.IMesh;
import point.interfaces.IPoint;
import static finitevolume.Utility.get_h_demie;
import static finitevolume.Utility.get_h;
import java.util.logging.Level;
import java.util.logging.Logger;
import matrice.MatriceException;
import matrice.TriDiagonalMatrice;
import matrice.solver.TriDiagMatriceSolver;
import mesh.Dim1Mesh;
import static utilities.Utilities.formatTable;

import static  utilities.Utilities.printMatrice;

/**
 *
 * @author KevinJio
 */
public class EllipticvolumeFiniesolver extends AbstractFiniteSolver{
    protected IFunction lambda;
    protected double a;
    protected double b;
    
    public EllipticvolumeFiniesolver(IFunction lambda , double a , double b){
        this.lambda = lambda;
        this.a = a;
        this.b = b;
    }

    @Override
    public double[] solve(IFunction f, IPoint u0, IPoint u1, IMesh mesh) {
        
        int n = mesh.getNumberOfPoint();
        
        double[] h_demie = get_h_demie(mesh);
        double[] h = get_h(mesh);
        double[] gama_demi = new double[h_demie.length];
        for(int i=0 ; i<h_demie.length ; i++){
            gama_demi[i] = (lambda.valueOf(h_demie[i])) / (h_demie[i]);
        }
        
        //construction de la matrice
        //construction de la matrice diagonal A
       TriDiagonalMatrice tri = new TriDiagonalMatrice(n);
        double[] diagInf = new double[n-1];
        double[] diag = new double[n];
        double[] diagSup = new double[n-1];
        for(int i=0 ; i<n ; i++){
            diag[i] = gama_demi[i+1] + gama_demi[i] + a + b*h[i];
        }
        
        for(int i=1 ; i<n ; i++){
            diagSup[i-1] = (-gama_demi[i]);
            diagInf[i-1] = -a + diagSup[i-1];
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
        
        b[0] = h[0]*f.valueOf(mesh.get(0)) +( a + gama_demi[0])*u0.get(IPoint.X);
        b[n-1] = h[n-1]*f.valueOf(mesh.get(n-1)) + gama_demi[n]*u1.get(IPoint.X);
        for(int i=1 ; i<n-1 ; i++){
            b[i] = h[i]*f.valueOf(mesh.get(i));
        }
        
        //System.out.println("valeur du vecteur b");
        printMatrice(tri.getMatrice());
        System.out.println(formatTable(b));
        TriDiagMatriceSolver solver = new TriDiagMatriceSolver();
        double[] u = solver.solve(tri, b);
        return u;
    }

    @Override
    public double[] solve(IFunction f, IPoint u0, IPoint u1, int point) {

            double pas ; double[] mesh={}; double[] u ={};
            if( 1< point){
                u = solve(f,u0,u1,new Dim1Mesh(point));
            }else{
                System.out.println("Entez un nombre de points supérieur à 1");
            }
         return u;
    }
    
}
