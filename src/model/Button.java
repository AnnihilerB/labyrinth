package model;

public class Button extends Element {
	private boolean etat; // etat du bouton. On=true, Off=false. Ouvrir/fermer la porte en conséquence
	
	public Button(int _x, int _y) {
		super(_x,_y);
		etat=false;
	}
	
	public Button(int _x, int _y, boolean _etat) {
		super(_x, _y);
		etat=_etat;
	}
}
