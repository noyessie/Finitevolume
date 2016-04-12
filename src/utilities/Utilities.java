/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author ROY
 */
public class Utilities {
    protected Utilities(){
        
    }
    
    public static boolean arrayEquals(double[] u1 , double[] u2 , double epsilon){
        if(u1.length != u2.length)
            return false;
        
        for(int i=0 ; i< u1.length ; i++){
            if(Math.abs(u1[i]-u2[i]) > epsilon)
                return false;
        }       
       return true;
    }
    
    public static String formatTable(double[] tab){
        String chaine = "[";
        for(int i=0 ; i<tab.length ; i++){
            if(i == tab.length-1){
                chaine += "" + tab[i] + "";
                continue;
            }
            chaine += "" + tab[i] + " , ";
        }
        chaine += "]";
        
        return chaine;
    }
    
    public static void printMatrice(double[][] mat){
        String chaine = "[\n";
        for(int i=0 ; i<mat.length ; i++){
            for(int j=0 ; j<mat[0].length ; j++){
                chaine += " " +mat[i][j]+"\t";
            }
            chaine += "\n";
        }
        chaine += "]";
        
        System.out.println(chaine);
    }
}
