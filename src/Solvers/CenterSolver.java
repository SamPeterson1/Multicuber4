package Solvers;

import Lib.Algorithm;
import Lib.Cube;
import Lib.Move;
import Utils.CenterGroup;
import Utils.Commutator;

public class CenterSolver {
	public void solveCenter(int center, Cube c) {
		CenterGroup g = new CenterGroup(center, c);
		
		for(int i = 0; i < 6; i ++) {
			if(i != center) {
				CenterGroup g2 = new CenterGroup(i, c);
				for(int j = 0; j < 4; j ++) {
					for(int k = 0; k < 4; k ++) {
						if(this.testCommutator(1, 1, i, center, c)) {
							Algorithm commutator = Commutator.getCommutator(1, 1, i, center);
							c.excecuteAlg(commutator);
							System.out.println("HIZZO" + j);
						}
						
						Algorithm rotate = new Algorithm(new Move("D"));
						c.excecuteAlg(rotate);
					}
					Algorithm rotate = new Algorithm(new Move("U"));
					c.excecuteAlg(rotate);
				}
			}
		}
	}
	
	public boolean testCommutator(int x, int y, int src, int dest, Cube c2) {
		boolean retVal;
		
		int testFace = dest;
		int testColor = dest+1;
		int initialColorCt = 0;
		int finalColorCt = 0;
		
		Cube c = c2.clone();
		Algorithm commutator;
		CenterGroup group = new CenterGroup(testFace, c);
		group.update();
		group.print();
		initialColorCt = group.getColorCt(testColor);
		
		commutator = Commutator.getCommutator(x, y, src, dest);
		c.excecuteAlg(commutator);
		group.update();
		
		finalColorCt = group.getColorCt(testColor);
		group.print();
		if(finalColorCt > initialColorCt) {
			retVal = true;
		} else {
			retVal = false;
		}
		
		return retVal;
	}
}
