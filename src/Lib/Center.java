package Lib;

public class Center {
	int color;
	int position;
	
	public Center(int position, int color) {
		super();
		this.color = color;
		this.position = position;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
