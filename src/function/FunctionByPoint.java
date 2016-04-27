/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import java.util.Iterator;
import point.Dim1Point;
import point.interfaces.IPoint;

/**
 *
 * @author KevinJio
 */
public class FunctionByPoint extends AbstractFunction implements Iterable{
    public double[] images;
    public IPoint[] points;

    public FunctionByPoint(IPoint[] p , double[] img){
        if(p.length != img.length)
            throw new IllegalArgumentException("Le nombre d'antécedant et d'images sont différents");
        this.points = p;
        this.images = img;
    }
    @Override
    public double valueOf(double point) {
        IPoint p = new Dim1Point(point);
        return valueOf(p);
    }

    @Override
    public double valueOf(IPoint point) {
        for(int i=0 ; i< points.length ; i++){
            if(this.points[i].equals(point)){
                return images[i];
            }
        }
        return 0;
    }

    

    @Override
    public Iterator iterator() {
        Iterator<IPoint> it = new Iterator<IPoint>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < images.length ;
            }

            @Override
            public IPoint next() {
                return points[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;    
    }
    
}
