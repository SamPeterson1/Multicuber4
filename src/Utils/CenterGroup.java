package Utils;

import java.util.Arrays;

import Lib.Cube;

public class CenterGroup {
	int[][] group = new int[2][2];
	Cube c;
	int side;
	
	public void print() {	
		for(int i = 0; i < 2; i ++) {
			for(int j = 0; j < 2; j ++) {
				System.out.print(group[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}
	public int[][] getGroup() {
		int[][] retVal = new int[2][2];
		for(int i = 0; i < group.length; i ++) {
			retVal[i] = Arrays.copyOf(group[i], group[i].length);
		}
		return retVal;
	}
	
	
	public int getColorAt(int x, int y) {
		return this.getGroup()[y][x];
	}
	
	public int[] getPos(int color) {
		for(int i = 0; i < group.length; i ++) {
			for(int j = 0; j < group[0].length; j ++) {
				if(this.getColorAt(j, i) == color) {
					int[] retVal = {j, i};
					return retVal;
				}
			}
		}
		int[] retVal = {-1,-1};
		return retVal;
	}
	
	public void setGroup(int[][] group) {
		for(int i = 0; i < group.length; i ++) {
			this.group[i] = Arrays.copyOf(group[i], group[i].length);
		}
	}
	
	
	
	public int getColorCt(int color) {
		int retVal = 0;
		for(int i = 0; i < group.length; i ++) {
			for(int j = 0; j < group.length; j ++) {
				if(group[i][j] == color) {
					retVal ++;
				}
			}
		}
		return retVal;
	}
	
	public CenterGroup(int side, Cube c) {
		int[][] face = c.getCube()[side];
		for(int i = 1; i < face.length - 1; i ++) {
			for(int j = 1; j < face.length - 1; j ++) {
				group[i-1][j-1] = face[i][j];
			}
		}
		this.c = c;
		this.side = side;
	}
	
	public void update() {
		int[][] face = c.getCube()[side];
		for(int i = 1; i < face.length - 1; i ++) {
			for(int j = 1; j < face.length - 1; j ++) {
				group[i-1][j-1] = face[i][j];
			}
		}
	}
}
