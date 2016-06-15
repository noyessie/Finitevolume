/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitevolume;

import mesh.nterfaces.IMesh;
import point.interfaces.IPoint;

/**
 *
 * @author KevinJio
 */
public class Utility {
    protected Utility(){
        
    }
    
    public static double[] get_h(IMesh meshh){
        int n = meshh.getNumberOfPoint();
        //determination des pas en fonction du maillage
       
        //on calcul les h(i)
        double h[] = new double[n];
        if(n == 1){
            h[0] = 0.5;
        }else{
            h[0] = 0.5 * (meshh.get(1).get(IPoint.X));
            h[n-1] = 0.5 * ( 1- meshh.get(1).get(IPoint.X) );
            for(int i=1 ; i<n-1 ; i++){
                h[i] = 0.5 * (meshh.get(i+1).get(IPoint.X) - meshh.get(i-1).get(IPoint.X));
            }
        }
        
        return h;
    }
    
    public static double[] get_h_demie(IMesh meshh){
        int n = meshh.getNumberOfPoint();

        //on calcul les h(i+1/2)
       double h_demie[] = new double[n+1];
       h_demie[0] = meshh.get(0).get(IPoint.X);
       h_demie[n] = 1 - meshh.get(n-1).get(IPoint.X);
       for(int i=1 ; i<n ; i++){
           h_demie[i] = meshh.get(i).get(IPoint.X) - meshh.get(i-1).get(IPoint.X);
       }
       
       return h_demie;
    }
    
}
