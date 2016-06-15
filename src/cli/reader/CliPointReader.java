/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cli.reader;

import cli.CliError;
import java.util.Map;
import point.DefaultPoint;
import point.interfaces.IPoint;

/**
 *
 * @author KevinJio
 */
public class CliPointReader extends AbstractCliReader<IPoint>{
    private int dim;
    //public static final REGEX = "[]";
    public CliPointReader(int dim){
        this.dim = dim;
    }

    @Override
    public IPoint read(Map params) {
        IPoint p = new DefaultPoint(dim);
        String chaine;
        boolean status = false;
        do{
            status = true;
            chaine = sc.nextLine().replaceAll("\\[", "");
            chaine = chaine.replaceAll("\\]", "");
            System.out.println("chaine to split : " + chaine);
            String[] elements = chaine.split(",");      
            if(elements.length != dim){
                CliError.print("la dimmension du vecteur point est incorrecte");
                status = false;
            }else{
                for(int i=0 ; i < elements.length ; i++){
                    try{
                        p.set(i, Double.valueOf(elements[i]));
                    }catch(NumberFormatException e){
                        CliError.print(e.getMessage());
                        status = false;
                        break;
                    }
                }
            }
        }while(!status);
        
        
        return p;
    }
    
}
