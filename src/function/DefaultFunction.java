/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;
import java.util.HashMap;
import java.util.logging.Logger;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import point.interfaces.IPoint;

/**
 *
 * @author hubert
 */
public class DefaultFunction extends AbstractFunction{
    String expression = "";
    private String formatedExpression;
    private HashMap<Integer,String> varName = new HashMap<>();
    private Evaluator evaluator= new Evaluator();
    
    public DefaultFunction(String expression){
        //System.out.println("creation de la fonction ");
        this.expression = expression;
        if(this.expression.length() == 0){
            throw new IllegalArgumentException("la chaine doit etre non vide");
        }
        init();
    }
    
    private void init(){
        varName.put(IPoint.X, "x");
        varName.put(IPoint.Y, "y");
        varName.put(IPoint.Z, "z");
        

        //System.out.println("   " + varName.get(IPoint.X));
        //System.out.println("   " + varName.get(0));
        formatedExpression = expression.replaceAll(varName.get(IPoint.X) , " #{" + varName.get(IPoint.X) + "} ");
        //formatedExpression = expression.replaceAll("x" , " #{" + varName.get(IPoint.X) + "} ");
        //formatedExpression = expression.replaceAll(.toLowerCase()+"" , " #{" + varName.get(IPoint.X) + "} ");
        
        
        formatedExpression = formatedExpression.replaceAll(varName.get(IPoint.Y) , " #{" + varName.get(IPoint.Y) + "} ");
        //formatedExpression = expression.replaceAll(varName.get(IPoint.Y).toString().toLowerCase() , " #{" + varName.get(IPoint.Y) + "} ");
        
        
        formatedExpression = formatedExpression.replaceAll(varName.get(IPoint.Z) , " #{" + varName.get(IPoint.Z) + "} ");
        //formatedExpression = expression.replaceAll(varName.get(IPoint.Z).toString().toLowerCase() , " #{" + varName.get(IPoint.Z) + "} ");

        System.out.println("formated Expression" +formatedExpression);
    }

    @Override
    public double valueOf(double point) {
        evaluator.putVariable(varName.get(IPoint.X), point+"");

        try {
            return Double.valueOf(evaluator.evaluate(formatedExpression));
        } catch (EvaluationException ex) {
            System.err.println(ex.getMessage() + " " + formatedExpression);
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public String toString() {
        return expression;
    }

    @Override
    public double valueOf(IPoint point) {
       evaluator.putVariable(varName.get(IPoint.X)+"", point.get(IPoint.X)+"");
       evaluator.putVariable(varName.get(IPoint.Y)+"", point.get(IPoint.X)+"");
       evaluator.putVariable(varName.get(IPoint.Z)+"", point.get(IPoint.X)+"");

        try {
            return Double.valueOf(evaluator.evaluate(formatedExpression));
        } catch (EvaluationException ex) {
            System.err.println(ex.getMessage() + " " + formatedExpression);
            return 0;
        }
    }
    
    

}
