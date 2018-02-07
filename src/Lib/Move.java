package Lib;

public class Move {
	int value;
	int layer;
	String name;
	
	public Move(String name) {
		this.name = name;
		value = this.getVal()[0];
		layer = this.getVal()[1];
	}
	
	public int getValue() {
		return value;
	}
	
	public static Move invert(Move m) {
			String firstComponent = m.getName().split("w")[0];
			String secondComponent = m.getName().split("w")[1];
			String newName = "";
			if(!firstComponent.contains("2")) {
				if(firstComponent.contains("'")) {
					firstComponent = firstComponent.substring(0, 1) + "w";
					
				} else {
					firstComponent += "'w";
				}
			} else {
				firstComponent += "w";
			}
			newName += firstComponent;
			newName += secondComponent;
			System.out.println(newName + "ghiuedfhgiuehi");
			Move m2 = new Move(newName);
			m = m2;
			return m2;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getVal() {
		int[] retVal = new int[2];
		if(this.name.length() <= 2) {
			name += "w0";
		}
		String[] components = this.name.split("w");
		System.out.println(components.length + " " + this.name);
		retVal[1] = Integer.parseInt(components[1]);
		switch(components[0]) {
			case "R":
				retVal[0] = Cube.RIGHT_FACE_C;
				break;
			case "U":
				retVal[0] = Cube.TOP_FACE_C;
				break;
			case "L":
				retVal[0] = Cube.LEFT_FACE_C;
				break;
			case "B":
				retVal[0] = Cube.BACK_FACE_C;
				break;
			case "D":
				retVal[0] = Cube.BOTTOM_FACE_C;
				break;
			case "F":
				retVal[0] = Cube.FRONT_FACE_C;
				break;
			case "R'":
				retVal[0] = Cube.RIGHT_FACE_CC;
				break;
			case "U'":
				retVal[0] = Cube.TOP_FACE_CC;
				break;
			case "L'":
				retVal[0] = Cube.LEFT_FACE_CC;
				break;
			case "B'":
				retVal[0] = Cube.BACK_FACE_CC;
				break;
			case "D'":
				retVal[0] = Cube.BOTTOM_FACE_CC;
				break;
			case "F'":
				retVal[0] = Cube.FRONT_FACE_CC;
				break;
			case "R2":
				retVal[0] = Cube.RIGHT_FACE_TWICE;
				break;
			case "U2":
				retVal[0] = Cube.TOP_FACE_TWICE;
				break;
			case "L2":
				retVal[0] = Cube.LEFT_FACE_TWICE;
				break;
			case "B2":
				retVal[0] = Cube.BACK_FACE_TWICE;
				break;
			case "D2":
				retVal[0] = Cube.BOTTOM_FACE_TWICE;
				break;
			case "F2":
				retVal[0] = Cube.FRONT_FACE_TWICE;
				break;
		}
		return retVal;
	}
}
