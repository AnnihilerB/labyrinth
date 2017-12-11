package model;
/**
 * The Candy is an element which appears in the labyrinth and can be taken to increase the score.
 * @author mduverneix
 *
 */
public class Candy extends Element {
	/**
	 * the number of points we want to add to the score.
	 */
	private int numPoint; // le nombre de points qu'on va ajouter au score
	
	/**
	 * Allocates a new Candy object with 500 number of points and a chosen position.
	 * @param _x the x coordinate we want for the candy.
	 * @param _y the y coordinate we want for the candy.
	 */
	public Candy(int _x, int _y) { // constructeur par défaut avec un nombre de points à ajouter fixé à 500
		super(_x,_y);
		numPoint=500; // cette variable peut être modifiée pour être en accord avec le nombre de points qu'on veut ajouter
	}
	/**
	 * Allocates a new Candy object with a chosen position and a chosen number of points.
	 * @param _x the x coordinate we want for the candy.
	 * @param _y the y coordinate we want for the candy.
	 * @param _point the number of points we want the candy to give.
	 */
	public Candy(int _x, int _y, int _point) { // constructeur pour définir le nombre de points qu'on veut ajouter
		super(_x, _y);
		numPoint=_point;
	}
	/**
	 * Gets the number of points.
	 * @return the number of points.
	 */
	public int getNumPoint() {
		return numPoint;
	}
	/**
	 * Sets a new number of points.
	 * @param ajoutPoint the new number of points.
	 */
	public void setNumPoint(int numPoint) {
		this.numPoint = numPoint;
	}
	
}

// possibilité d'ajouter les cerises (en enfant) pour avoir la capacité de tuer les ennemis pendant un certain temps