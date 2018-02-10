package Lib;

import java.util.ArrayList;
import java.util.Arrays;

public class Cube {
	
	//TOP, RIGHT, FRONT, LEFT, BACK, BOTTOM

	public static final int YELLOW = 1;
	public static final int RED = 2;
	public static final int BLUE = 3;
	public static final int ORANGE = 4;
	public static final int GREEN = 5;
	public static final int WHITE = 6;
		
	//C = Clockwise
		
	public static final int TOP_FACE_C = 1;
	public static final int RIGHT_FACE_C = 2;
	public static final int FRONT_FACE_C = 3;
	public static final int LEFT_FACE_C = 4;
	public static final int BACK_FACE_C = 5;
	public static final int BOTTOM_FACE_C = 6;
		
		
	//CC = Counter-Clockwise
		
	public static final int TOP_FACE_CC = 7;
	public static final int RIGHT_FACE_CC = 8;
	public static final int FRONT_FACE_CC = 9;
	public static final int LEFT_FACE_CC = 10;
	public static final int BACK_FACE_CC = 11;
	public static final int BOTTOM_FACE_CC = 12;
		
	//U2, F2, etc...
		
	public static final int TOP_FACE_TWICE = 13;
	public static final int RIGHT_FACE_TWICE = 14;
	public static final int FRONT_FACE_TWICE = 15;
	public static final int LEFT_FACE_TWICE = 16;
	public static final int BACK_FACE_TWICE = 17;
	public static final int BOTTOM_FACE_TWICE = 18;
	
	int[][][] data = new int[6][4][4];

	public Cube() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if (j == 0 & k == 3) {
						data[i][j][k] = i + 1;
					} else {
						data[i][j][k] = i + 1;
					}
				}
			}
		}
	}
	
	public Cube(int[][][] data) {
		this.data = data;
	}

	public int[][] Map2D(int layer) {
		//new Map().applyMap(this, true, layer);
		return null;
	}

	public int[][][] getCube() {
		return this.data;
	}
	
	public void excecuteAlg(Algorithm a) {
		ArrayList<Move> moves = a.getMoves();
		for(Move m: moves) {
			this.executeMove(m.getValue(), m.getLayer());
		}
	}
	
	public Cube clone() {
		return new Cube(this.getCubeClone());
	}
	
	public void executeMove(int value, int layer) {
		int face = 0;
		Map m  = new Map();
		boolean clockwise = false;
		int iterations = 1;
		if(value < 7) {
			face = value - 1;
			clockwise = true;
		} else if(value < 13) {
			face = value - 7;
			clockwise = false;
		} else if(value < 19) {
			face = value - 13; 
			iterations = 2;
		}
		for(int i = 0; i < iterations; i ++) {
			if(face == 0) {
				m.applyMap(this, clockwise, Map.TOPFACE, layer);
			} else if(face == 1) {
				m.applyMap(this, clockwise, Map.RIGHTFACE, layer);
			} else if(face == 2) {
				m.applyMap(this, clockwise, Map.FRONTFACE, layer);
			} else if(face == 3) {
				m.applyMap(this, clockwise, Map.LEFTFACE, layer);
			} else if(face == 4) {
				m.applyMap(this, clockwise, Map.BACKFACE, layer);
			} else if(face == 5) {
				m.applyMap(this, clockwise, Map.BOTTOMFACE, layer);
			} 
		}
	}
	
	public int[][][] getCubeClone(){
		int[][][] retVal = new int[6][4][4];
		for(int i = 0; i < 6; i ++) {
			for(int j = 0; j < 4; j ++) {
				for(int k = 0; k < 4; k ++) {
					retVal[i][j][k] = this.data[i][j][k];
				}
			}
		}
		
		return retVal;
	}

	public int[][] rotateCW(int[][] mat, int iterations) {
		int[][] ret = new int[mat.length][mat[0].length];
		int[][] finalRet = new int[mat.length][mat[0].length];
		for (int i = 0; i < iterations; i++) {
			final int M = mat.length;
			final int N = mat[0].length;
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					ret[c][M - 1 - r] = mat[r][c];
				}
			}
			mat = ret;
		}
		for(int i = 0; i < mat.length; i ++) {
			finalRet[i] = Arrays.copyOf(ret[i], ret[i].length);
		}
		return finalRet;
	}
}
