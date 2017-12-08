package model;

public class ElementInteractif extends Element { // classe parent des boutons et des portes car variable etat en commun
	private boolean state; // etat de l'élément. On=true, Off=false. Ouvrir/fermer la porte en conséquence
	
	public ElementInteractif(int _x, int _y) {
		super(_x,_y);
		state=false;
	}
	
	public ElementInteractif(int _x, int _y, boolean _state) {
		super(_x, _y);
		state=_state;
	}
}
