/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import function.FunctionByPoint;
import gui.Plotter1D;
import gui.plot.Graph;
import java.awt.Color;
import point.Dim1Point;
import point.interfaces.IPoint;

/**
 *
 * @author KevinJio
 */
public class TestGraph {
    public static void main(String[] args){
        FunctionByPoint f ;
        IPoint p[] = {new Dim1Point(1),new Dim1Point(2)};
        double i[] = {1 , 4};
        f = new FunctionByPoint(p, i);
        
        Graph[] g = new Graph[2];
        g[0] = new Graph(f, "test", Color.red);
        g[1] = new Graph(f, "test 2", Color.red);
        
        Plotter1D pl = new Plotter1D(g);
        pl.plot();
        
    }
}
