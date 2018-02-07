package Lib;

import java.util.ArrayList;

public class Algorithm {
	ArrayList<Move> moves = new ArrayList<Move>();
	
	public Algorithm(Move... m) {
		for(int i = 0; i < m.length; i ++) {
			moves.add(m[i]);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Algorithm(ArrayList<Move> moves) {
		this.moves = (ArrayList<Move>) moves.clone();
	}
	
	public void addMove(Move m) {
		this.moves.add(m);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Move> getMoves() {
		return (ArrayList<Move>) moves.clone();
	}
	public void print() {
		for(Move m: moves) {
			System.out.print(m.getName() + " ");
		}
		System.out.println("");
	}
}