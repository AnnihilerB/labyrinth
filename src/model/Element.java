package model;

/**
 * The abstract class Element is a superclass of all classes that appears in the labyrinth.
 * @author mduverneix
 *
 */
public abstract class Element {
	/**
	 * the x coordinate for the element.
	 */
	private int x;
	/**
	 * the y coordinate for the element.
	 */
	private int y;
	/**
	 * 
	 * @param _x the x coordinate we want for the element.
	 * @param _y the y coordinate we want for the element.
	 */
	public Element(int _x, int _y) {
		this.x=_x;
		this.y=_y;
	}
	/**
	 * Gets the x coordinate.
	 * @return the x coordinate.
	 */
	public int getX() {
		return x;
	}
	/**
	 * Sets a new x coordinate.
	 * @param x the new x coordinate.
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Gets the y coordinate.
	 * @return the y coordinate.
	 */
	public int getY() {
		return y;
	}
	/**
	 * Sets a new y coordinate.
	 * @param y the new y coordinate.
	 */
	public void setY(int y) {
		this.y = y;
	}

	
}
