/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitevolume;

import function.interfaces.IFunction;
import mesh.AbstractMesh;
import mesh.DefaultMesh;
import mesh.Dim1Mesh;
import mesh.nterfaces.IMesh;
import point.interfaces.IPoint;

/**
 *
 * @author hubert
 */
public class DifferenceFinieSolver extends AbstractFiniteSolver {

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

    private double pash(double[] mesh) {
        double h = 0;
        double va;
        int n = mesh.length;
        va = 0.0;
        for (int i = 0; i < n - 1; i++) {
            va = mesh[i + 1] - mesh[i];
            if (h <= va) {
                h = va;
            }
        }
        return h;
    }

    private double[] meshTable(double pas) {
        int j = 0;
        double[] mesh = {};
        if (0 < pas && pas < 0.5) {
            double jl = pas;
            while (jl < 1) {
                j++;
                jl = (double) pas * (j);
            }

            mesh = new double[j - 1];
            jl = pas;
            int i = 0;
            while (i < j - 1) {
                jl = (double) pas * (i + 1);
                mesh[i] = (double) jl;
                jl = pas * (i + 1);
                System.out.println(i + " " + "jl " + jl + " mesh[i]" + mesh[i]);
                i++;

            }
        } else {
            System.out.println(" Entrer un pas entre 0 et 0.5 ");
        }
        return mesh;
    }

        // @Override
        @Override
        public double[] solve(IFunction f, IPoint pu0, IPoint pu1, int n) {
            double u0 = pu0.get(IPoint.X);
            double u1 = pu1.get(IPoint.Y);
            double pas ; double[] mesh={}; double[] u ={};
            if( 1<n){
                pas =(double)1/n;
                mesh = meshTable(pas);
                
                
                
                u = solve(f,pu0,pu1,new Dim1Mesh(n));
            }else{
                System.out.println("Entez un nombre de points supérieur à 1");
            }
         return u;
        }

        @Override
        public double[] solve (IFunction f, IPoint pu0, IPoint pu1, IMesh mmesh){
               // calcul des images de la fonction f par x
            double u0 = pu0.get(IPoint.X);
            double u1 = pu1.get(IPoint.X);
            double mesh[] = new double[mmesh.getMesh().length];
            for(int i=0 ; i<mesh.length ; i++){
                mesh[i] = mmesh.get(i).get(IPoint.X);
            }
        int n;
            n = mesh.length;
            double pas;
            pas = pash(mesh);
            //pas = mesh[0];
            double pas2 = pas * pas;
            double[] fun;
            fun = new double[n];
            double c = pas2 / 2;
            int max = 10000;
            double c2 = 1 / pas2;
            for (int i = 0; i < n; i++) {
                fun[i] = f.valueOf(mesh[i]);
            }
            // definition du vecteur pour la resolution du système
            fun[0] = fun[0] + u0 / pas2;
            fun[n - 1] = fun[n - 1] + u1 / pas2;
            // résolution par la methode de gauss siedel
            double[] u;
            u = new double[n];
            double[] pres;
            pres = new double[n];
            init(pres);
            init(u);

            for (int k = 0; k <= max; k++) {
                u[0] = (fun[0] + pres[1] * c2) * c;
                for (int t = 1; t <= n - 2; t++) {
                    u[t] = (fun[t] + u[t - 1] * c2 + pres[t + 1] * c2) * c;
                }
                u[n - 1] = c * (fun[n - 1] + pres[n - 2] * c2);
                copy(pres, u, n);
            }

            return u;

        }

    }
