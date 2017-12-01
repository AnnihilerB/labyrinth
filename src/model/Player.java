package model;



public class Player extends Character {
	
	private static Player instance = new Player(0,0);


	public static Player getInstance() {
		return instance;
	}

	private Player(int _x, int _y) {
		super(_x,_y);
	}

}
