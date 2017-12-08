package model;

public class Candy extends Element {
	
	private int ajoutPoint; // le nombre de points qu'on va ajouter au score
	
	public Candy(int _x, int _y) { // constructeur par défaut avec un nombre de points à ajouter fixé à 500
		super(_x,_y);
		ajoutPoint=500; // cette variable peut être modifiée pour être en accord avec le nombre de points qu'on veut ajouter
	}
	
	public Candy(int _x, int _y, int _point) { // constructeur pour définir le nombre de points qu'on veut ajouter
		super(_x, _y);
		ajoutPoint=_point;
	}
}

// possibilité d'ajouter les cerises (en enfant) pour avoir la capacité de tuer les ennemis pendant un certain temps