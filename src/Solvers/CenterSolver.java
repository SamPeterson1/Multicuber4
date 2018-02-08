package Solvers;

import Lib.Cube;
import Utils.CenterGroup;

public class CenterSolver {
	public void solveCenter(int center, Cube c) {
		CenterGroup g0 = new CenterGroup(0, c);
		CenterGroup g1 = new CenterGroup(1, c);
		CenterGroup g2 = new CenterGroup(2, c);
		CenterGroup g3 = new CenterGroup(3, c);
		CenterGroup g4 = new CenterGroup(4, c);
		CenterGroup g5 = new CenterGroup(5, c);
		
		int[][] test = g0.getGroup();
		System.out.println("TEST");
		for(int i = 0; i < test.length; i ++) {
			for(int j = 0; j < test.length; j ++) {
				System.out.print(test[i][j]);
			}
			System.out.println("");
		}
		System.out.println(g0.getPos(3)[0] + " " + g0.getPos(3)[1]);
	}
}
