/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.executor;

import finitevolume.interfaces.IFiniteSolver;
import mesh.Dim1Mesh;
import test.formater.TestFormater;
import static utilities.Utilities.arrayEquals;
import static utilities.Utilities.formatTable;

/**
 *
 * @author ROY
 */
public class DefaultTestExecutor extends AbstractTestExecutor{
    
    IFiniteSolver solver ;
    double epsilon = 0.1;
    
    public DefaultTestExecutor(IFiniteSolver solver , double epsilon){
        this.solver = solver;
        this.epsilon = epsilon;
    }

    public IFiniteSolver getSolver() {
        return solver;
    }

    public void setSolver(IFiniteSolver solver) {
        this.solver = solver;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }
    public DefaultTestExecutor(IFiniteSolver solver){
        this.solver = solver;
    }

    @Override
    public boolean execute(TestFormater tf) throws Exception {
        this.tf = tf;
        double solver_solution[] = null;
        //on recherche la solution
        if(tf.isPasConstant()){
             solver_solution = solver.solve(
                tf.getFunction(),
                tf.getU0(),
                tf.getU1(),
                tf.getMesh().getNumberOfPoint()
            );
        }else{
            solver_solution = solver.solve(
                tf.getFunction(),
                tf.getU0(),
                tf.getU1(),
                tf.getMesh()
            );
        }
        
        
        Dim1Mesh mesh = (Dim1Mesh)tf.getMesh();
        double[] true_solution = tf.getSolution().valueOf(mesh.getMesh());
       
        this.setExpectedResult(true_solution);
        this.setResult(solver_solution);
        
        boolean result = arrayEquals(solver_solution, true_solution , this.epsilon);
        
        if(!result){
            this.setLastError("la solution est incorrecte \n attendu: " + formatTable(true_solution) + " reçue : " + formatTable(solver_solution)); 
            return false;
        }
        
        return true;
    }
    
}
