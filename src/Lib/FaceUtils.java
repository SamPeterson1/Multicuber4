package Lib;

import java.util.ArrayList;

public class FaceUtils {
	private Map m = new Map();
	int[][] tempData;
	private ArrayList <Center> centers = new ArrayList<Center>();
	
	public FaceUtils(Cube c, int[][] map) {
		tempData = m.unfold(map, c);
		int[][] edgesTop = new int[2][4];
		int cubeSize = tempData.length - 2;
		for(int i = 2; i < tempData.length - 2; i ++) {
			for(int j = 2; j < tempData.length - 2; j ++) {
				centers.add(new Center((i-2)*(cubeSize-2)+(j-2), tempData[i][j]));
			}
		}
		for(Center c1: centers) {
			System.out.printf("Position: %d, Color: %d\n", c1.getPosition(), c1.getColor());
		}
		for(int i = 0; i < 4; i ++) {
			edgesTop[0][i] = tempData[0][i];
		}
	}
}
