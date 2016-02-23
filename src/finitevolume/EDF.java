/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitevolume;

import function.interfaces.IFunction;

/**
 *
 * @author hubert
 */
public class EDF extends AbstractFiniteSolver{

    private void copy(double[]tab,double[] tab2, int n){
        for(int i=0;i<=n;i++){
            tab[i]=tab2[i];
        }
    }
    private void init(double[] tab){
        for(int i=0; i<tab.length;i++){
            tab[i]=0;
        }
    }
    private double pash(double[] mesh){
        double h =0; double var= 0; int n = mesh.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;i++){
               var =mesh[j] - mesh[i];
               if(h<var){
                   h=var;
               }
            }
        }
        return h;
    }
    
    @Override
    public double[] solve(IFunction f, double u0, double u1, double[] mesh) {
        // calcul des images de la fonction f par x
        int n; 
        n = mesh.length;
        double pas ;
        pas = pash(mesh);
        double pas2 = pas*pas;
        double[] fun;
        fun = new double[n];
        double c =pas2/2; int max =10;
        for(int i=0; i<n;i++){
            fun[i] = f.valueOf(mesh[i]);
        }
        // definition du vecteur pour la resolution du système
        fun[0] = fun[0] + u0/pas2; fun[n-1] = fun[n-1] + u1/pas2;
        // résolution par la methode de gauss siedel
        double[] u;
        u = new double[n];
        double[] pres;
        pres = new double[n]; init(pres);init(u);
        
        for(int k=0;k<=max;k++){
            u[0]=(fun[0]+pres[1])*c;
            for(int t=1;t<=n-2;t++){
                u[t]=(fun[t]+u[t-1]+pres[t+1])*c;
            }
            u[n-1]=c*(fun[n-1]+pres[n-2]);
           copy(pres,u,n); 
        }
       
        return u;
    }
    
    private double[] meshContant(int n, double pas){
        double[] tabe;
        tabe = new double[n+1];
        for(int i=1; i<=n;i++){
            tabe[i]= pas*i;
        }
        return tabe;
    }

    @Override
    public double[] solve(IFunction f, double u0, double u1, int n) { 
        double pas =1/n; double pas2 = pas*pas; 
        double[] fun;
        fun = new double[n];
        double c =pas2/2; int max =10;
        double[] tabX;
        tabX = new double[n];
        tabX =meshContant(n,pas);
        for(int i=0; i<n-1;i++){
            fun[i] = f.valueOf(tabX[i+1]);
        }
        // definition du vecteur pour la resolution du système
        fun[0] = fun[0] + u0/pas2; fun[n-1] = fun[n-1] + u1/pas2;
        // résolution par la methode de gauss siedel
        double[] u;
        u = new double[n];
        double[] pres;
        pres = new double[n]; init(pres);init(u);
        
        for(int k=0;k<=max;k++){
            u[1]=(fun[1]+pres[2])*c;
            for(int t=2;t<=n-2;t++){
                u[t]=(fun[t]+u[t-1]+pres[t+1])*c;
            }
            u[n-1]=c*(fun[n-1]+pres[n-2]);
           copy(pres,u,n); 
        }
       
        return u;
        
    }
    
}
