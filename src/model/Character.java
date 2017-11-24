package model;

public abstract class Character extends Element {
	
	
	public Character(int _x, int _y) {
		super(_x,_y);
	}
	
	public void seDeplacer(int _x, int _y) {
		this.setX(_x);
		this.setY(_y);
	}
}
