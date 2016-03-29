/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesh;

import point.DefaultPoint;
import point.interfaces.IPoint;

/**
 *
 * @author hubert
 */
public class Dim1Mesh extends AbstractMesh{
    public Dim1Mesh(double[] m) throws Exception{
        this.mesh = new IPoint[m.length];
        
        for(int i=0 ; i< m.length ; i++){
            this.mesh[i] = new DefaultPoint(1).set(IPoint.X, m[i]);
            if(i > 0 && this.mesh[i-1].get(IPoint.X) >= this.mesh[i].get(IPoint.X)){
                throw new Exception("Invalid Mesh " + mesh[i-1] + " >= " + mesh[i]);
            }
            
        }
        
    }
    
    public Dim1Mesh(int point){
        mesh = new IPoint[point];
        double pas = 1.0/(point+1);
        for(int i=0 ; i<mesh.length ; i++){
            mesh[i] = new DefaultPoint(1).set(IPoint.X, (i+1)*pas);
        }
    }
    
}
