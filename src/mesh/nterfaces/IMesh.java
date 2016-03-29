/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesh.nterfaces;

import point.interfaces.IPoint;

/**
 *
 * @author hubert
 */
public interface IMesh {
    /**
     * permet de recupère l'élèmenet du maillage Xindice
     * @param indice
     * @return the mesh point Xindice 
     */
    public IPoint get(int indice);
    
    
    public IMesh set(int indice , IPoint val);
    
    public int getNumberOfPoint();
    
    public IPoint[] getMesh();
}
