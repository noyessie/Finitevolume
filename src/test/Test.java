/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import finitevolume.VolumeFinieSolver;
import finitevolume.error.InfiniteError;
import finitevolume.error.interfaces.IErreur;
import finitevolume.interfaces.IFiniteSolver;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import point.interfaces.IPoint;
import test.executor.AbstractTestExecutor;
import test.executor.DefaultTestExecutor;
import test.formater.TestFormater;
import test.formater.TestFormaterFile;

/**
 *
 * @author hubert
 */
public class Test {
    public static void main(String[] args) throws Exception{
        TestFormaterFile tff = new TestFormaterFile("test_file/dimmension1.txt");
        TestFormater[] tf = tff.getTestFormaters();
        IFiniteSolver solver = null;
        
        
        System.out.println("################### METHODE DES DIFFERENCES FINIES ########################");
        //executeTest(tf , new DifferenceFinieSolver());
        
        
        System.out.println("################### METHODE DES VOLUMES FINIES ########################");
        executeTest(tf, new VolumeFinieSolver());
      
        

        
    }
    
    protected static void executeTest(TestFormater[] tf , IFiniteSolver solver) throws Exception{
        AbstractTestExecutor te = new DefaultTestExecutor(solver , 1000);
        IErreur erreur = new InfiniteError();
        for(int i=0 ; i<tf.length ; i++){
            
            boolean sol = te.execute(tf[i]);
            if(sol){
                System.out.println("\n");
                writeText(tf[i] , te.getExpectedResult() , te.getResult());
                //System.out.println("erreur " + erreur.erreur(te.getExpectedResult(), te.getResult()));
            }else{
                System.out.println("error " + te.getLastError());
            }

        }
    }
    
    public static void writeText(TestFormater tf , double[] expectedResult , double[] result){
        
        System.out.println("***********************************************************************************************************************************************************");
        
        System.out.println("* ======================================================================================================================================================= *");
        System.out.println("* |\t\t\t\t\t\t f(x) = " + tf.getFunction());
        System.out.println("* |\t\t\t\t\t\t u(x) = " + tf.getSolution());
        System.out.println("* |\t\t\t\t\t\t u(0) = " + tf.getU0());
        System.out.println("* |\t\t\t\t\t\t u(1) = " + tf.getU1());
        System.out.println("* ======================================================================================================================================================= *");
        
        System.out.println("* ------------------------------------------------------------------------------------------------------------------------------------------------------- *");
        System.out.println("* |\t\t Point \t\t | \t\t Valeur Approchee \t | \t\t Valeur Exacte \t\t | \t\t Erreur \t\t| *");
        System.out.println("* ------------------------------------------------------------------------------------------------------------------------------------------------------- *");
        for(int i=0 ; i<expectedResult.length ; i++){
            System.out.printf("* |\t %10f \t\t | \t\t %10f \t\t | \t\t %10f \t\t | \t\t %10f \t\t| *\n",tf.getMesh().get(i).get(IPoint.X) , result[i] ,expectedResult[i] , (Math.abs(result[i]-expectedResult[i])));
            //System.out.println("|\t "+ tf.getMesh().get(i).get(IPoint.X) +" \t\t | \t\t "+ result[i] +" \t\t | \t\t "+expectedResult[i]+" \t\t | \t\t "+(Math.abs(result[i]-expectedResult[i]))+" \t\t");
        }
        System.out.println("* ------------------------------------------------------------------------------------------------------------------------------------------------------- *");
        System.out.println("* erreur infinie :   " + new InfiniteError().erreur(expectedResult , result));
        System.out.println("***********************************************************************************************************************************************************");


        
        
    }
}
