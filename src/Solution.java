/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KevinJio
 */
public class Solution {
    protected Probleme probleme;
    protected double[] result;
    protected double[] expectedResult;
    protected double infiniteError;

    public Solution(Probleme probleme, double[] result) {
        this.probleme = probleme;
        this.result = result;
    }

    protected void init(){
        
    }
    
    public Probleme getProbleme() {
        return probleme;
    }

    public void setProbleme(Probleme probleme) {
        this.probleme = probleme;
    }

    public double[] getResult() {
        return result;
    }

    public void setResult(double[] result) {
        this.result = result;
    }

    public double[] getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(double[] expectedResult) {
        this.expectedResult = expectedResult;
    }

    public double getInfiniteError() {
        return infiniteError;
    }

    public void setInfiniteError(double infiniteError) {
        this.infiniteError = infiniteError;
    }

    public double getEuclidianerror() {
        return euclidianerror;
    }

    public void setEuclidianerror(double euclidianerror) {
        this.euclidianerror = euclidianerror;
    }
    protected double euclidianerror;
}
