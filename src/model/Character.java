package model;

/**
 * 
 * @author mduverneix
 *
 */
public abstract class Character extends Element {
	/**
	 * Sets the position of the character on the x and y chosen.
	 * @param _x the x coordinate we want for the player.
	 * @param _y the y coordinate we want for the player.
	 */
	public Character(int _x, int _y) {
		super(_x,_y);
	}
	/**
	 * 
	 * @param nx the x where want to test
	 * @param ny
	 * @return
	 */
	public boolean collisionWall(int nx, int ny) {
		if(Labyrinth.getInstance().areVerticesConnected(this.getX(), this.getY(), nx, ny)) {
			return false;
		}
		else
			return true;
	}
	/**
	 * 
	 * @param _x
	 * @param _y
	 */
	public void moves(int _x, int _y) {
		if(!collisionWall(_x, _y)){
			this.setX(_x);
			this.setY(_y);
		}
		else
			System.out.println("collision détecté");
	}

	
	
}
