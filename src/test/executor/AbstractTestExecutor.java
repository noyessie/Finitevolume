/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.executor;

import test.executor.interfaces.ITextExecutor;
import test.formater.TestFormater;

/**
 *
 * @author ROY
 */
public abstract class AbstractTestExecutor implements ITextExecutor{
    protected String executionError = "";
    protected double[] expectedResult = null;
    protected double[] Result = null;
    TestFormater tf;
    
    @Override
    public String getLastError(){
        return this.executionError;
    }
    
    protected void setLastError(String error){
        this.executionError = error;
    }

    public double[] getExpectedResult() {
        return expectedResult;
    }


    public double[] getResult() {
        return Result;
    }

    protected void setExpectedResult(double[] expectedResult) {
        this.expectedResult = expectedResult;
    }

    protected void setResult(double[] Result) {
        this.Result = Result;
    }
    
    
}
