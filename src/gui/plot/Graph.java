/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.plot;

import function.FunctionByPoint;
import java.awt.Color;

/**
 *
 * @author KevinJio
 */
public class Graph {
    protected FunctionByPoint function;
    protected String name;
    protected Color coler;

    public Graph(FunctionByPoint function, String name, Color coler) {
        this.function = function;
        this.name = name;
        this.coler = coler;
    }
    
    

    public FunctionByPoint getFunction() {
        return function;
    }

    public void setFunction(FunctionByPoint function) {
        this.function = function;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColer() {
        return coler;
    }

    public void setColer(Color coler) {
        this.coler = coler;
    }
    
    
}
