package model;

import java.util.Objects;

/**
 * Class representing a vertex in a graph.
 */
public class Vertex implements Comparable<Vertex> {
	/**
	 * the x coordinate for the vertex.
	 */
	private int x;
	/**
	 * the y coordinate for the vertex.
	 */
	private int y;
	/**
	 * Number used to mak vertices through the manhattan algorithm
	 */
	private int nbr;
	
	/**
	 * Allocates a new Vertex with the position 0 for the x coordinate and 0 for the y coordinate.
	 */
	public Vertex() {
		this(0, 0);
	}
	/**
	 * Allocates a new Vertex with the x and y coordinates chosen.
	 * @param x the x coordinate we want for the vertex.
	 * @param y the y coordinate we want for the vertex.
	 */
	public Vertex(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//Sources: 
	//https://docs.oracle.com/javase/8/docs/api/java/util/Objects.html
	//https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html

	/**
	 * Gets the string showing the x and y position like this : (x,y)
	 * Overrides the toString(...) method.
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y +")";
	}
	
	//Methode utilise par SimpleGraph.containsVertex()
	/**
	 * Compares an object if it is a Vertex with this one.
	 * If they both have the same position on x and y coordinate, it returns true.
	 * If they don't have the same position on x and y coordinate, it returns false.
	 * If the object is not a Vertex it returns false too.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vertex)
			if (this.x == ((Vertex) obj).getX() && this.y == ((Vertex) obj).getY())
				return true;
		
		return false;		
	}

	/**
	 * Method returning the reference for an object.
	 * @return the reference of an object.
	 */
	@Override
	public int hashCode() {
		//used by SimpleGraph.containsVertex()
		return Objects.hash(x, y);
	}

	/**
	 * Compares a vertex to another.
	 * @param o the vertex Object to be compared to.
	 * @return the distance between the two vertices.
	 */
	@Override
	public int compareTo(Vertex o) {
		//used by Edge.compareTo()
		return java.lang.Math.abs(this.x-o.getX()) + java.lang.Math.abs(this.y-o.getY());
	}
	/**
	 * Gets the x coordinate.
	 * @return the x coordinate.
	 */
	public int getX() {
		return x;
	}
	/**
	 * Sets the new x coordinate.
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
	 * Sets the new y coordinate.
	 * @param y the new y coordinate.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * return the mark number of a vertex
	 * @return the mark number
	 */
    public int getNbr() {
        return nbr;
    }

	/**
	 * Set the mark number of a vertex trough the manhattan algorithm
	 * @param nbr the mark number to set to.
	 */
	public void setNbr(int nbr) {
        this.nbr = nbr;
    }
}
