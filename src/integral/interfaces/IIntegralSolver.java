/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integral.interfaces;

import function.interfaces.IFunction;

/**
 *
 * @author KevinJio
 */
public interface IIntegralSolver {
    public double integral(IFunction f , double a , double b);
}
