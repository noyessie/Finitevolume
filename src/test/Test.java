
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import finitevolume.DifferenceFinieSolver;
import finitevolume.EllipticvolumeFiniesolver;
import finitevolume.VolumeFinieSolver;
import finitevolume.error.EuclidienError;
import finitevolume.error.InfiniteError;
import finitevolume.error.interfaces.IErreur;
import finitevolume.interfaces.IFiniteSolver;
import function.DefaultFunction;
import function.FunctionByPoint;
import function.interfaces.IFunction;
import gui.Plotter1D;
import gui.plot.Graph;
import java.awt.Color;
import mesh.Dim1Mesh;
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
        
        //System.setOut(new PrintStream(new File("sortie.txt")));
        
        
        System.out.println("\n\n################### METHODE DES DIFFERENCES FINIES ########################");
        executeTest(tf , new DifferenceFinieSolver());
        
        
        System.out.println("\n\n\n################### METHODE DES VOLUMES FINIES ########################\n\n\n");
        executeTest(tf, new VolumeFinieSolver());
        
        System.out.println("\n\n\n################### METHODE DES VOLUMES FINIES ELLIPTIQUE ########################\n\n\n");
        IFunction f = new DefaultFunction("1"); 
        executeTest(tf, new EllipticvolumeFiniesolver(f, 0 , 1));
      
        

        
    }
    
    protected static void executeTest(TestFormater[] tf , IFiniteSolver solver) throws Exception{
        AbstractTestExecutor te = new DefaultTestExecutor(solver , 1000);
        IErreur erreur = new InfiniteError();
        for (TestFormater tf1 : tf) {
            boolean sol = te.execute(tf1);
            if (sol) {
                //System.out.println("\n\n\n");
                writeText(tf1, te.getExpectedResult(), te.getResult());
                //System.out.println("erreur " + erreur.erreur(te.getExpectedResult(), te.getResult()));
            } else {
                System.out.println("error " + te.getLastError());
            }
        }
    }
    
    public static void writeText(TestFormater tf , double[] expectedResult , double[] result){
        double[] error = new double[result.length];
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
            error[i] = (Math.abs(result[i]-expectedResult[i]));
            System.out.printf("* |\t %10f \t\t | \t\t %10f \t\t | \t\t %10f \t\t | \t\t %10f \t\t| *\n",tf.getMesh().get(i).get(IPoint.X) , result[i] ,expectedResult[i] , error[i] );
            //System.out.println("|\t "+ tf.getMesh().get(i).get(IPoint.X) +" \t\t | \t\t "+ result[i] +" \t\t | \t\t "+expectedResult[i]+" \t\t | \t\t "+(Math.abs(result[i]-expectedResult[i]))+" \t\t");
        }
        
        double infinityError = new InfiniteError().erreur(expectedResult , result);
        double euclidienneError = new EuclidienError().erreur(expectedResult, result);
        
        System.out.println("* ------------------------------------------------------------------------------------------------------------------------------------------------------- *");
        System.out.println("* erreur infinie :   " + infinityError + "\t\t\t erreur euclidienne :  " + euclidienneError );
        System.out.println("***********************************************************************************************************************************************************");


        //construction du graph pour la fonction trouver
        Graph g[] = new Graph[3];
        FunctionByPoint f_result = new FunctionByPoint(tf.getMesh().getMesh(), result);
        FunctionByPoint f_expected = new FunctionByPoint(tf.getMesh().getMesh(), expectedResult);
        
        FunctionByPoint f_infinity = new FunctionByPoint(tf.getMesh().getMesh() ,error );
        
        g[0] = new Graph(f_result, "resultat obtenue ", Color.red);
        g[1] = new Graph(f_expected, "resultat experer ", Color.red);
        g[2] = new Graph(f_infinity, " erreur ", Color.red);

        Plotter1D plt = new Plotter1D(g);
        
        plt.plot("graphe" ,  "f(x) = ".concat(tf.getFunction().toString()));
        
        
    }
}
