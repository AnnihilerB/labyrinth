package model;

public abstract class ElementInteractif extends Element { // classe parent des boutons et des portes car variable etat en commun
	private boolean state; // etat de l'élément. On=true,ouverte ; Off=false,fermée
	
	public ElementInteractif(int _x, int _y) { // constructeur par défaut pour avoir la porte fermée ou le bouton éteint par défaut
		super(_x,_y);
		state=false;
	}
	
	public ElementInteractif(int _x, int _y, boolean _state) { // constructeur pour choisir l'état initial
		super(_x, _y);
		state=_state;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
}
