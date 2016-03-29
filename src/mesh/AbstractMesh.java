/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesh;

import mesh.nterfaces.IMesh;
import point.DefaultPoint;
import point.interfaces.IPoint;


/**
 *
 * @author hubert
 */
public abstract  class AbstractMesh implements IMesh {
    protected IPoint[] mesh ;
    
    
    @Override
    public int getNumberOfPoint(){
        return mesh.length;
    }
    
    @Override
    public IPoint get(int indice){
        return mesh[indice];
    }

    @Override
    public IMesh set(int indice, IPoint val) {
        this.mesh[indice] = val;
        return this;
    }
    
    @Override
    public IPoint[] getMesh(){
        return this.mesh;
    }

    @Override
    public String toString() {
        String chaine = "";
        for(int i=0 ; i<mesh.length ; i++){
            chaine += " mesh : " + i + " : " + mesh[i] + " \n ";
        }
        return chaine;
    }
    
    
    
    
}
