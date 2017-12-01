package model;

public abstract class Element {
	private int x;
	private int y;
	
	public Element(int _x, int _y) {
		this.x=_x;
		this.y=_y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
