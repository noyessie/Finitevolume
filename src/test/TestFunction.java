/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import function.DefaultFunction;

/**
 *
 * @author KevinJio
 */
public class TestFunction {
    public static void main(String[] args){
        DefaultFunction f = new DefaultFunction("log(x)");
        System.out.println(Math.E);
        System.out.println(f.valueOf(Math.E));
    }
}
