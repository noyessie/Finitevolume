package matrice;

import java.util.ArrayList;

public class CRS {
	private ArrayList<Double> val = new ArrayList<Double>();
	private ArrayList<Integer> col_ind = new ArrayList<Integer>();
	private ArrayList<Integer> row_ptr = new ArrayList<Integer>();

	private int iMax = 0;
	private int jMax = 0;

	/**
	 * Permet de sp�cifier le nombre de ligne et le nombre de colone de depart
	 * de la matrice
	 * 
	 * @param i
	 * @param j
	 */
	public CRS(int i, int j) {
		for (int k = 0; k < i; k++) {
			row_ptr.add(0);
		}
		this.iMax = i - 1;
		this.jMax = j - 1;
	}

	public CRS(double[][] elt) {
		int inc = 0;
		row_ptr.add(inc);
		for (int i = 0; i < elt[0].length; i++) {
			for (int j = 0; j < elt.length; j++) {
				if (elt[i][j] != 0) {
					val.add(elt[i][j]);
					col_ind.add(j);
					inc++;
				}
			}
			row_ptr.add(row_ptr.get(row_ptr.size() - 1) + inc);
			inc = 0;
		}
		this.iMax = elt[0].length - 1;
		this.jMax = elt.length - 1;
	}

	public void afficher() {

		System.out.println("val : " + val.toString());
		System.out.println("col_ind : " + col_ind.toString());
		System.out.println("row_ptr : " + row_ptr.toString());

	}
	
	public void mathAfficher(){
		for(int i=0 ; i<=iMax ; i++){
			for(int j=0 ; j<=jMax ; j++){
				System.out.print(" " + this.get(i, j) + " ");
			}
			System.out.println("");
		}
	}

	/**
	 * permet de r�cuperer l'�lement (i,j) de la matrice, l'indi�age commence �
	 * 0
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public double get(int i, int j) {
		int ind_debut = 0; // r�presenter la valeur de depart de k
		int ind_fin = 0; // r�presenter la valeur de fin de k

		if (i > iMax || j > jMax) {
			System.out.println("indice incorrect");
			return 0;
		}

		ind_debut = row_ptr.get(i);
		ind_fin = row_ptr.get(i + 1);

		if (ind_debut == ind_fin) {
			return 0;
		}

		for (int k = ind_debut; k < ind_fin; k++) {
			if (col_ind.get(k) == j) {
				return val.get(k);
			} else if (col_ind.get(k) > j){
				return 0;
			}
		}
		return 0;
	}

	public void set(int i, int j, double v) {
		int ind_debut = 0; // r�presenter la valeur de depart de k
		int ind_fin = 0; // r�presenter la valeur de fin de k
		int ajout = 0; // r�presenter le type d'ajout dans le tableau row_ptr
		boolean present = false;

		if (i > iMax || j > jMax) {
			System.out.println("indice incorrect");
			return;
		}

		ind_debut = row_ptr.get(i);
		ind_fin = row_ptr.get(i + 1);

		//ici on regarder si l'�lement se trouver dans le tableau val donc est nom_null
		for (int k = ind_debut; k < ind_fin; k++) {
			
			if (col_ind.get(k) == j)
			// dans cet condition on est sur que la valuer (i,j) de la matrice
			// est nom null
			{
				present = true;
				if (v == 0)// si c'est un zero, alors on reduit le nombre
							// d'�l�ments non nul
				{
					val.remove(k);
					col_ind.remove(k);
					ajout = -1;// retrait des valeurs dans le tableau row_ptr
					break;
				} else // l'�lement est nom null comme celui que l'on veut
						// remplacer. on ne retire rien
				{
					val.set(k, v);
					ajout = 0;
					break;
				}
			}
		}

		// si v== 0 on ne fait rien
		// sinon on remplacer et l'on apporter les modification n�cessaires
		if (v != 0 && !present) {
			ajout = 1;
			// si l'indice de d�but est �gal � l'indice de fin, alors on ins�re
			// � l'index ind_debut
			// a noter qu'ici la ligne est compl�tement null
			if (ind_debut == ind_fin) {
				val = this.inser(ind_debut, val, v);
			}else{
				int p = ind_debut;
				while(p < ind_fin &&  j<col_ind.get(p)){
					p++;
				}
				//p+1 r�presenter l'indice ou doit �tre inserer l'�l�ment
				//si p == size()-1 , on fait un add
				if(p == val.size()-1){
					val.add(v);
					col_ind.add(j);
				}else{
					val = this.inser(p+1 , val , v);
					col_ind = this.inser(p+1, col_ind, j);
				}
				
			}
		}
		
		//mise a jour du tableau row_ptr
		for(int k= i+2 ; k< row_ptr.size() ; k++){
			row_ptr.set(k, row_ptr.get(k)+ajout);
		}
		
	}

	// methode permettant d'inserer un �l�ment � la position k dans un arrayList

	private ArrayList<Double> inser(int k, ArrayList<Double> a, double value) {
		ArrayList<Double> finalList = new ArrayList<Double>();

		if (k < a.size() - 1) {
			finalList.addAll(a.subList(0, k+1));
			finalList.add(value);
			finalList.addAll(a.subList(k+1, a.size()));
		} else {
			finalList.add(value);
		}

		return finalList;
	}
	
	private ArrayList<Integer> inser(int k, ArrayList<Integer> a, int value) {
		ArrayList<Integer> finalList = new ArrayList<Integer>();

		if (k < a.size() - 1) {
			finalList.addAll(a.subList(0, k+1));
			finalList.add(value);
			finalList.addAll(a.subList(k+1, a.size()));
		} else {
			finalList.add(value);
		}
		return finalList;
	}

}
