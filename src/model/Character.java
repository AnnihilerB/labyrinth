package model;

public abstract class Character extends Element {
	

	
	public Character(int _x, int _y) {
		super(_x,_y);
	}
	
	public boolean collisionMur(int nx, int ny) {
		if(Labyrinth.getInstance().areVerticesConnected(this.getX(), this.getY(), nx, ny)) {
			return true;
		}
		else
			return false;
	}
	
	public void seDeplacer(int _x, int _y) {
		if(!collisionMur(_x, _y)) {
			this.setX(_x);
			this.setY(_y);
		}
	}

	
	
}
