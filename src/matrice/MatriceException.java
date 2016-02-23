/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice;



/**
 *
 * @author hubert
 */
public class MatriceException extends Exception{
    public MatriceException(String message){
        super(message);
    }
    
    public MatriceException(String message ,Throwable ex){
        super(message, ex);
    }
    
    public MatriceException(Throwable ex){
        super(ex);
    }
}
