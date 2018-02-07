package Lib;

import java.util.Arrays;

public class Corner {
	int[] colors = null;
	int ID = 0;
	
	public Corner(int[] colors, int ID) {
		this.colors = Arrays.copyOf(colors, colors.length);
		this.ID = ID;
	}
	
	public int[] getColors() {
		return this.colors;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public boolean contains(int color) {
		for(int i = 0; i < 3; i ++) {
			if(this.colors[i] == color) {
				return true;
			}
		}
		return false;
	}
	
	public void updateColors(int[] colors) {
		this.colors = Arrays.copyOf(colors, colors.length);
	}
	
	public boolean matchesColorCommutative(int[] colors){
		boolean[] logic = new boolean[3];
		for(int i = 0; i < 3; i ++) {
			logic[i] =this.contains(colors[i]);
		}
		int j = 0;
		for(int i = 0; i < 3; i ++) {
			if(logic[i]) {
				j ++;
			}
		}
		if(j == 3) {
			return true;
		}
		return false;
	}
	
	public boolean matches(int[] colors) {
		if(colors[0] == this.colors[0] & colors[1] == this.colors[1] & colors[2] == this.colors[2]) {
			return true;
		}
		return false;
	}
}
