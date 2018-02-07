package Lib;

import Utils.MatrixUtils;

public class Commutator {
	
	private static String displacer;
	private static String offseter;
	private static String invertedOffseter;
	private static String horizontal;
	
	private static final String[][] commutatorConfigs = {{"0","5","L2","D","D'","false"},{"0","2","L","F","F'","false"},{"0","1","F","R'","R","false"},{"0","3","F'","L","L'","false"},{"0","4","L'","B","B'","false"},{"1","5","F","D","D'","false"},{"1","2","U","F","F'","true"},{"1","0","F'","U","U'","false"},{"1","3","U2","L'","L","true"},{"1","4","U'","B","B'","true"},{"2","0","L'","U","U'","false"},{"2","1","U'","R","R'","true"},{"2","3","U","L'","L","true"},{"2","4","U2","B","B'","true"},{"2","5","L","D","D'","false"},{"3","0","B'","U","U'","false"},{"3","1","U2","R","R'","true"},{"3","2","U'","B","B'","true"},{"3","4","U","B","B'","true"},{"3","5","B","D'","D","false"},{"4","0","R'","U","U'","false"},{"4","1","U","R","R'","true"},{"4","2","U2","F","F'","true"},{"4","3","U'","L'","L","true"},{"4","5","R","D","D'","false"},{"5","0","L2","U","U'","false"},{"5","1","B","R","R'","false"},{"5","2","L'","F","F'","false"},{"5","3","B'","L'","L","false"},{"5","4","L","B","B'","false"}};
	
	public static Algorithm getCommutator(Integer x, Integer y, int src, int dest) {
		Algorithm retVal = new Algorithm();
		
		loadCommutatorConfigs(src, dest);
	
		
		if(horizontal.equals("true")) {
			System.out.println("HORIZONYGREHRT");
			x = new Integer(y.intValue());
			y = new Integer(x.intValue());
		}
		
		MatrixUtils util = new MatrixUtils(4);
		
		StringBuilder moveBuffer = new StringBuilder("");
		Move displace;
		Move displace2;
		
		String i = offseter;
		
		if(!((x >= 2 & y >= 2) || (y <= 1 & x <= 1))) {
			offseter = invertedOffseter;
			invertedOffseter = i;
			System.out.println("HIIihifgohiofiudf");
		}
		
		moveBuffer.append(displacer)
		.append("w")
		.append(x.toString());
		displace = new Move(moveBuffer.toString());
		
		retVal.addMove(new Move(moveBuffer.toString()));
		retVal.addMove(new Move(offseter + "w0"));
		
		util.setNumber(y, x, 1);
		util.print();
		util.setEvalMatrix(MatrixUtils.rotateCW(util.getEvalMatrix()));
		moveBuffer = new StringBuilder("");
		
		x = util.getNumLocation(1)[1];
		
		moveBuffer.append(displacer)
		.append("w")
		.append(x.toString());
		displace2 = new Move(moveBuffer.toString());
		
		System.out.println(x.toString() + "GDFG");
		util.print();
		System.out.println(displace.getName());
		displace = Move.invert(displace);
		retVal.addMove(new Move(moveBuffer.toString()));
		
		retVal.addMove(new Move(invertedOffseter + "w0"));
		retVal.addMove(displace);
		displace = Move.invert(displace);
		displace2 = Move.invert(displace2);
		retVal.addMove(new Move(offseter + "w0"));
		retVal.addMove(displace2);
		retVal.addMove(new Move(invertedOffseter + "w0"));
		return retVal;
	}
	
	public static void loadCommutatorConfigs(int src, int dest) {	
		for(int i = 0; i < commutatorConfigs.length; i ++) {
			if(Integer.parseInt(commutatorConfigs[i][0]) == src & Integer.parseInt(commutatorConfigs[i][1]) == dest) {
				displacer = commutatorConfigs[i][2];
				offseter = commutatorConfigs[i][3];
				invertedOffseter = commutatorConfigs[i][4];
				horizontal = commutatorConfigs[i][5];
				System.out.println(displacer);
			}
		}
	}

}
