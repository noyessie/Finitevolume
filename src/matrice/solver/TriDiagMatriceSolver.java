/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrice.solver;

import Jama.Matrix;
import matrice.interfaces.IMatrice;

/**
 *
 * @author Abdel Aziz NGOUH
 */
public class TriDiagMatriceSolver extends AbstractMatriceSolver{
    
    IMatrice A;
    double[] solt, B;
    Matrix matriceA, matriceB, Solution;

    @Override
    public double[] solve(IMatrice mat, double[] b) {
        
        this.A = mat;
        this.B = b;
        matriceA = new Matrix(A.getMatrice());
        matriceB = new Matrix(B, B.length);
        Solution = matriceA.solve(matriceB);
        solt = Solution.getColumnPackedCopy();
        return solt;
    }
    
}
