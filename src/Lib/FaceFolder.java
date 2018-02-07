package Lib;

public class FaceFolder {
	public static int X = 0;
	public static int Y = 1;

	public static int[][] fold(Cube c, int face, int[] axis, int[][] unfoldMap1, int[][] unfoldMap2, int[] faces, int[] layerIncrease, int layer) {
		int[] l = { -1 };
		int[] m = { -1 };

		int[] current = m;
		int currentLayer = layer;
		
		int[][] retVal = new int[6][6];
		int[][] outerRingBase = { { 4, 5 }, { 5, 1 }, { 1, 0 }, { 0, 4 } };
		int[] toIncrease = { 2, 1, 0, 3 };
		int[][][] data = c.getCube();
		
		if(layer == 0) {
			for (int i = 1; i < 5; i++) {
				for (int j = 1; j < 5; j++) {
					retVal[i][j] = data[face][i - 1][j - 1];
				}
			}
		}
		for (int k = 0; k < 4; k++) {
			if (axis[k] == FaceFolder.Y) {
				current = l;
			} else {
				current = m;
			}
			currentLayer = layerIncrease[k] * Math.abs(currentLayer);
			unfoldMap1[k][axis[k]] += currentLayer;
			unfoldMap2[k][axis[k]] += currentLayer;
			if (unfoldMap1[k][0] < unfoldMap2[k][0] + 1 & unfoldMap1[k][1] < unfoldMap2[k][1] + 1) {
				l[0] = -1;
				for (int i = unfoldMap1[k][0]; i < unfoldMap2[k][0] + 1; i++) {
					l[0]++;
					m[0] = -1;
					for (int j = unfoldMap1[k][1]; j < unfoldMap2[k][1] + 1; j++) {
						m[0]++;
						if (toIncrease[k] == 0) {
							retVal[outerRingBase[k][0] + current[0]][outerRingBase[k][1]] = data[faces[k]][i][j];
						} else if (toIncrease[k] == 1) {
							retVal[outerRingBase[k][0]][outerRingBase[k][1] + current[0]] = data[faces[k]][i][j];
						} else if (toIncrease[k] == 2) {
							retVal[outerRingBase[k][0] - current[0]][outerRingBase[k][1]] = data[faces[k]][i][j];
						} else if (toIncrease[k] == 3) {
							retVal[outerRingBase[k][0]][outerRingBase[k][1] - current[0]] = data[faces[k]][i][j];
						}
					}
				}
			} else {
				l[0] = -1;
				for (int i = unfoldMap1[k][0]; i > unfoldMap2[k][0] - 1; i--) {
					l[0]++;
					m[0] = -1;
					for (int j = unfoldMap1[k][1]; j > unfoldMap2[k][1] - 1; j--) {
						m[0]++;
						if (toIncrease[k] == 0) {
							retVal[outerRingBase[k][0] + current[0]][outerRingBase[k][1]] = data[faces[k]][i][j];
						} else if (toIncrease[k] == 1) {
							retVal[outerRingBase[k][0]][outerRingBase[k][1] + current[0]] = data[faces[k]][i][j];
						} else if (toIncrease[k] == 2) {
							retVal[outerRingBase[k][0] - current[0]][outerRingBase[k][1]] = data[faces[k]][i][j];
						} else if (toIncrease[k] == 3) {
							retVal[outerRingBase[k][0]][outerRingBase[k][1] - current[0]] = data[faces[k]][i][j];
						}
					}
				}
			}
			unfoldMap1[k][axis[k]] -= currentLayer;
			unfoldMap2[k][axis[k]] -= currentLayer;
		}
		return retVal;
	}
	
	public static void unfold(Cube c, int face, int[] axis, int[][] unfoldMap1, int[][] unfoldMap2, int[] faces, int[][] retVal, int[]layerIncrease, int layer) {
		int currentLayer = layer;
		int[][][] data = c.getCube();
		int[][] outerRingBase = { { 4, 5 }, { 5, 1 }, { 1, 0 }, { 0, 4 } };
		int[] toIncrease = { 2, 1, 0, 3 };
		
		int[] l = { -1 };
		int[] m = { -1 };

		int[] current = m;
		for (int k = 0; k < 4; k++) {	
			if (axis[k] == FaceFolder.Y) {
				current = l;
			} else {
				current = m;
			}
			currentLayer = layerIncrease[k] * Math.abs(currentLayer);
			unfoldMap1[k][axis[k]] += currentLayer;
			unfoldMap2[k][axis[k]] += currentLayer;
			if (unfoldMap1[k][0] < unfoldMap2[k][0] + 1 & unfoldMap1[k][1] < unfoldMap2[k][1] + 1) {
				l[0] = -1;
				m[0] = -1;
				for (int i = unfoldMap1[k][0]; i < unfoldMap2[k][0] + 1; i++) {
					l[0]++;
					m[0] = -1;
					for (int j = unfoldMap1[k][1]; j < unfoldMap2[k][1] + 1; j++) {
						m[0]++;
						if (toIncrease[k] == 0) {
							data[faces[k]][i][j] = retVal[outerRingBase[k][0] + current[0]][outerRingBase[k][1]];
						} else if (toIncrease[k] == 1) {
							data[faces[k]][i][j] = retVal[outerRingBase[k][0]][outerRingBase[k][1] + current[0]];
						} else if (toIncrease[k] == 2) {
							data[faces[k]][i][j] = retVal[outerRingBase[k][0] - current[0]][outerRingBase[k][1]];
						} else if (toIncrease[k] == 3) {
							data[faces[k]][i][j] = retVal[outerRingBase[k][0]][outerRingBase[k][1] - current[0]];
						}
					}
				}
			} else {
				l[0] = -1;
				m[0] = -1;
				for (int i = unfoldMap1[k][0]; i > unfoldMap2[k][0] - 1; i--) {
					l[0]++;
					m[0] = -1;
					for (int j = unfoldMap1[k][1]; j > unfoldMap2[k][1] - 1; j--) {
						m[0]++;

						if (toIncrease[k] == 0) {
							data[faces[k]][i][j] = retVal[outerRingBase[k][0] + current[0]][outerRingBase[k][1]];
						} else if (toIncrease[k] == 1) {
							data[faces[k]][i][j] = retVal[outerRingBase[k][0]][outerRingBase[k][1] + current[0]];
						} else if (toIncrease[k] == 2) {
							data[faces[k]][i][j] = retVal[outerRingBase[k][0] - current[0]][outerRingBase[k][1]];
						} else if (toIncrease[k] == 3) {
							data[faces[k]][i][j] = retVal[outerRingBase[k][0]][outerRingBase[k][1] - current[0]];
						}
					}
				}
			}
			unfoldMap1[k][axis[k]] -= currentLayer;
			unfoldMap2[k][axis[k]] -= currentLayer;
		}
		
		System.out.println("");
		if(layer == 0) {
			for (int i = 1; i < 5; i++) {
				for (int j = 1; j < 5; j++) {
					data[face][i - 1][j - 1] = retVal[i][j];
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			System.out.println("");
			for (int j = 0; j < 6; j++) {
				System.out.print(retVal[i][j]);
			}
		}
	}
}
