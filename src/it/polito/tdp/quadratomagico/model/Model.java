package it.polito.tdp.quadratomagico.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	List<Square> solutions = null; //globale così la funzione ricorsiva può accedervi (oppure potrei passare la variabile ogni volta alla funzione ricorsiva)
	
	public List<Square> findMagicSquares(int dim){ //data una dimensione restituisce tutti i possibili quadrati
		
		solutions = new ArrayList <Square>();
		
		//Creo un oggetto Square
		
		Square square = new Square(dim);
		
		//Chiamo la funzione ricorsiva
		
		int step = 0;
		
		recursive(square,step);
		
		//Ritorno tutte le soluzioni trovate
		
		return solutions;
		
	}
	
	private void recursive(Square square, int step){
		
		// condizione di terminazione
		
		if(step >= square.getN2()){
			if(square.checkMagicConst())  //valuto la soluzione trovata
				solutions.add(new Square(square));
			return;
		}
		
		for(int i = 1; i<=square.getN2() ; i++){
			
			if(!square.contains(i)){
			
				square.add(i);
			
				recursive(square,step+1);
			
				square.remove(step);
			}
		}
	}
	
}
