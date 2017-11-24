package model;

import java.util.Objects;

public class Vertex {
	private int x;
	private int y;
	private int nbr;
	
	
	public Vertex() {
		this(0, 0);
	}
	
	public Vertex(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//Sources: 
	//https://docs.oracle.com/javase/8/docs/api/java/util/Objects.html
	//https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html
	
	@Override
	public String toString() {
		return "(" + x + "," + y +")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vertex)
			if (this.x == ((Vertex) obj).getX() && this.y == ((Vertex) obj).getY())
				return true;
		
		return false;		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
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

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int y) {
        this.nbr = nbr;
    }
}
