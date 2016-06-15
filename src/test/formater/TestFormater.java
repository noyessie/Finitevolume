/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.formater;

import function.DefaultFunction;
import function.interfaces.IFunction;
import mesh.Dim1Mesh;
import mesh.nterfaces.IMesh;
import point.DefaultPoint;
import point.interfaces.IPoint;

/**
 *
 * @author USER
 */
public class TestFormater {
    private String line;
    private IFunction function;
    private IPoint u0;
    private IPoint u1;
    private IMesh mesh;
    private IFunction solution;
    private boolean pasConstant = false;

    public boolean isPasConstant() {
        return pasConstant;
    }

    public IFunction getSolution() {
        return solution;
    }

    public void setSolution(IFunction solution) {
        this.solution = solution;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }


    public IFunction getFunction() {
        return function;
    }

    public void setFunction(IFunction function) {
        this.function = function;
    }

    public IPoint getU0() {
        return u0;
    }

    public void setU0(IPoint u0) {
        this.u0 = u0;
    }

    public IPoint getU1() {
        return u1;
    }

    public void setU1(IPoint u1) {
        this.u1 = u1;
    }

    public IMesh getMesh() {
        return mesh;
    }

    public void setMesh(IMesh mesh) {
        this.mesh = mesh;
    }
    
    
    public TestFormater(String line  ,  int dim) throws Exception{
        this.line = line;
        if(dim == 1){
            format_dim1();
        }
        else
        {
            throw new UnsupportedOperationException("N'est pas encore valide pour la dimension " + dim);
        }
    }
    
    /**
     * formatage:
     * 0 : la fonction concidère
     * 1 : la valeur de la fonction en 0, u0*
     * 2 : la valeur de la fonction en 1, u1
     * 3 : la solution de l'équation ie u
     * 5,+ les points du maillage
     */
    protected void format_dim1() throws Exception{
        String[] elements = line.split(";");
        for(int i=0 ; i<elements.length ; i++){
            elements[i] = elements[i].trim();
        }
        function  = new DefaultFunction(elements[0]);
        u0 = new DefaultPoint(1);
        u1 = new DefaultPoint(1);

        u0.set(IPoint.X, Double.parseDouble(elements[1]));
        u1.set(IPoint.X, Double.parseDouble(elements[2]));

        solution = new DefaultFunction(elements[3]);

        if(elements[4].startsWith("#")){
            elements[4] = elements[4].replaceAll("#", "");
            mesh = new Dim1Mesh(Integer.parseInt(elements[4]));
            this.pasConstant = true;
        }else{
            double m[] = new double[elements.length-4];
            for(int i=4 ; i<elements.length ; i++){
                m[i-4] = Double.parseDouble(elements[i]);
            }
            mesh = new Dim1Mesh(m);
        }
    }

    @Override
    public String toString() {
        return "TestFormater{" + "line=" + line + ", function=" + function + ", u0=" + u0 + ", u1=" + u1 + ", mesh=" + mesh + ", solution=" + solution + '}';
    }
    
    
}
