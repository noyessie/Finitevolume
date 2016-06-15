
import function.interfaces.IFunction;
import mesh.nterfaces.IMesh;
import point.interfaces.IPoint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KevinJio
 */
public class Probleme {
    protected IFunction function;
    protected IMesh mesh;
    protected IPoint p0;
    protected IPoint p1;

    public Probleme(IFunction function, IMesh mesh, IPoint p0, IPoint p1) {
        this.function = function;
        this.mesh = mesh;
        this.p0 = p0;
        this.p1 = p1;
    }
    
    

    public IFunction getFunction() {
        return function;
    }

    public void setFunction(IFunction function) {
        this.function = function;
    }

    public IMesh getMesh() {
        return mesh;
    }

    public void setMesh(IMesh mesh) {
        this.mesh = mesh;
    }

    public IPoint getP0() {
        return p0;
    }

    public void setP0(IPoint p0) {
        this.p0 = p0;
    }

    public IPoint getP1() {
        return p1;
    }

    public void setP1(IPoint p1) {
        this.p1 = p1;
    }
    
    
}
