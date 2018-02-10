package Utils;

import java.util.Arrays;

public class MatrixUtils {
	int[][] evalMatrix;
	int size;
	
	public MatrixUtils(int size) {
		this.evalMatrix = new int[size][size];
		this.size = size;
	}
	
	public static int[][] rotateCW(int[][] mat) {
		return MatrixUtils.rotate(mat, 1);
	}
	
	public static int[][] rotateCCW(int[][] mat) {
		return MatrixUtils.rotate(mat, 3);
	}
	
	public static int[][] rotate180(int[][] mat) {
		return MatrixUtils.rotate(mat, 3);
	}
	
	public void setNumber(int x, int y, int num) {
		evalMatrix[y][x] = num;
	}
	
	
	public int[] getNumLocation(int num) {
		int[] retVal = {-1,-1};
		//retVal[0]: y-component
		//retVal[1]: x-component
		for(int i = 0; i < this.size; i ++) {
			for(int j = 0; j < this.size; j ++) {
				if(this.evalMatrix[i][j] == num) {
					retVal[0] = i;
					retVal[1] = j;
					return retVal;
				}
			}
		}
		return retVal;
	}
	
	private static int[][] rotate(int[][] mat, int iterations) {
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

	public int[][] getEvalMatrix() {
		return evalMatrix;
	}

	public void setEvalMatrix(int[][] evalMatrix) {
		this.evalMatrix = evalMatrix;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		this.evalMatrix = new int[size][size];
	}
	
	
}
