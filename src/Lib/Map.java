package Lib;

public class Map {
	
	int[][] unfoldMap1 = new int[4][2];
	int[][] unfoldMap2 = new int[4][2];
	int[] faces = new int[4];
	int[] axis = new int[4];
	int[] layerIncrease = new int[4];
	int layer = 0;
	int face = 0;
	boolean wrongWay = false;
	
	public static final int[][] TOPFACE = {{0,0},{0,0},{0,0},{0,0},{0,3},{0,3},{0,3},{0,3},{1,2,3,4},{1,1,1,1},{FaceFolder.X,FaceFolder.X,FaceFolder.X,FaceFolder.X},{0,0,0}};
	public static final int[][] RIGHTFACE = {{0,3},{0,3},{3,0},{0,3},{3,3},{3,3},{0,0},{3,3},{2,0,4,5},{-1,-1,1,-1},{FaceFolder.Y,FaceFolder.Y,FaceFolder.Y,FaceFolder.Y}, {0,1,0}};
	public static final int[][] FRONTFACE = {{3,3},{3,0},{0,0},{0,3},{3,0},{0,0},{0,3},{3,3},{0,1,5,3},{-1,1,1,-1},{FaceFolder.X,FaceFolder.Y,FaceFolder.X,FaceFolder.Y},{0,2,0}};
	public static final int[][] LEFTFACE = {{3,0},{3,0},{0,3},{3,0},{0,0},{0,0},{3,3},{0,0},{2,0,4,5},{1,1,-1,1},{FaceFolder.Y,FaceFolder.Y,FaceFolder.Y,FaceFolder.Y},{0,3,1}};
	public static final int[][] BACKFACE = {{0,0},{0,0},{3,3},{3,3},{0,3},{3,0},{3,0},{0,3},{0,3,5,1},{1,1,-1,-1},{FaceFolder.X,FaceFolder.Y,FaceFolder.X,FaceFolder.Y},{0,4,0}};
	public static final int[][] BOTTOMFACE = {{3,0},{3,0},{3,0},{3,0},{3,3},{3,3},{3,3},{3,3},{1,2,3,4},{-1,-1,-1,-1},{FaceFolder.X,FaceFolder.X,FaceFolder.X,FaceFolder.X},{0,5,0}};
	
	public void applyMap(Cube c, Boolean clockwise, int[][] map, int layer) {
		this.parseMap(map);
		if(wrongWay) {
			clockwise = !clockwise;
		}
		int direction = 1;
		if(!clockwise) {
			direction = 3;
		}
		for(int i = 0; i < direction; i ++) {
			int[][] flatFace = FaceFolder.fold(c, face, axis, unfoldMap1, unfoldMap2, faces, layerIncrease, layer);
			flatFace = c.rotateCW(flatFace, 1);
			FaceFolder.unfold(c, face, axis, unfoldMap1, unfoldMap2, faces, flatFace, layerIncrease, layer);
		}
	}
	
	public int[][] unfold(int[][] map, Cube c) {
		this.parseMap(map);
		return FaceFolder.fold(c, face, axis, unfoldMap1, unfoldMap2, faces, layerIncrease, layer);
	}
		
	public void parseMap(int[][] map) {
		for(int i = 0; i < 4; i ++) {
			unfoldMap1[i] = map[i];
		}
		for(int i = 0; i < 4; i ++) {
			unfoldMap2[i] = map[i + 4];
		}
		
		faces = map[8];
		axis = map[10];
		layerIncrease = map[9];
		layer = map[11][0];
		face = map[11][1];
		wrongWay = (map[11][2] == 1);
		
	}
}
