/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/**
 *
 * @author hubert
 */
public class DefaultFunction extends AbstractFunction{
    String expression = "";
    private String formatedExpression;
    private String varName = "x";
    private Evaluator evaluator= new Evaluator();
    
    public DefaultFunction(String expression){
        this.expression = expression;
        if(this.expression.length() == 0){
            throw new IllegalArgumentException("la chaine doit etre non vide");
        }
        init();
    }
    
    private void init(){
        formatedExpression = expression.replaceAll(varName , " #{" + varName + "} ");
        System.out.println(formatedExpression);
    }

    @Override
    public double valueOf(double point) {
        evaluator.putVariable(varName, point+"");

        try {
            return Double.valueOf(evaluator.evaluate(formatedExpression));
        } catch (EvaluationException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}
