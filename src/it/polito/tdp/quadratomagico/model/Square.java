package it.polito.tdp.quadratomagico.model;

import java.util.ArrayList;
import java.util.List;

public class Square {
	
	//List come struttura dati per la mia griglia
	
	List <Integer> griglia = null;
	
	int N;
	int N2;
	int magicConst;
	
	public Square(Square square) {
		this.griglia = new ArrayList<Integer>(square.getGriglia());
		this.N = square.getN();
		this.N2 = square.getN2();
		this.magicConst = square.getMagicConst();
	}

	public Square(int dimension) {
		this.griglia = new ArrayList <Integer>();
		this.N=dimension;
		this.N2 = N*N;
		this.magicConst = N * (N*N + 1)/2;
	}
	
	public List<Integer> getGriglia() {
		return griglia;
	}
	
	public int getN() {
		return N;
	}
	
	public int getN2(){
		return N2;
	}
	
	public int getMagicConst() {
		return magicConst;
	}
	
	public boolean contains (int number){
		return griglia.contains(number);
	}
	
	public void add(int number){
		griglia.add(number);
	}
	
	public void remove (int pos){
		griglia.remove(pos);
	}
	
	public boolean checkMagicConst(){
		
		//Prima di tutto controllo la dimensione. La griglia deve essere completa
		
		if(griglia.size() != N2)
			return false;
		
		//Controllo le righe
		if(!checkRows())
			return false;
		
		//Controllo le colonne
		if(!checkColumns())
			return false;
		
		//Controllo le diagonali
		if(!checkDiagonals())
			return false;
		
		return true;
	}
	
	private boolean checkRows(){
		
		for(int i = 0; i < N ; i++){
			int temp = 0;
			for(int j = 0; j< N ; j++){
				temp += griglia.get(i*N + j);
			}
			if(temp != magicConst)
				return false;
		}

		return true;
	}
	
	private boolean checkColumns(){
		
		for(int i = 0; i < N ; i++){
			int temp = 0;
			for(int j = 0; j< N ; j++){
				temp += griglia.get(i + j*N);
			}
			if(temp != magicConst)
				return false;
		}
		
		return true;
	}
	
	private boolean checkDiagonals(){
		
		int temp = 0;
		
		for(int i = 0; i < N ; i++)
			
			temp += griglia.get(i*N + i);
			
		if(temp != magicConst)
			return false;
		
		
		temp = 0;
		
		for(int i = N-1 ; i>= 0 ; i--)
			
			temp += griglia.get((N-1-i)*N + i);
			
		if(temp != magicConst)
			return false;
			
		
		return true;
	}
	
	
	public String toString(){
		
//		String ris = "";
//		
//		for(int i = 0; i < N ; i++){
//			for(int j = 0; j < N ; j++)
//				ris += griglia.get(i*N + j) +  " ";
//			ris += "\n\n";
//		}
//			
//		return ris.trim();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(String.format("%d ", griglia.get(i * N + j)));
			sb.append("\n");
		}
		return sb.toString();
	}

}
