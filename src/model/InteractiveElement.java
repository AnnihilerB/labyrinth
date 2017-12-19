package model;
/**
 * 
 * @author mduverneix
 *
 */
public abstract class InteractiveElement extends Element { // classe parent des boutons et des portes car variable etat en commun
	/**
	 * 
	 */
	private boolean state; // etat de l'élément. On=true,ouverte ; Off=false,fermée
	/**
	 * Sets the position of the interactive element on the x and y chosen and sets the state at false.
	 * @param _x the x coordinate we want for the interactive element.
	 * @param _y the y coordinate we want for the interactive element.
	 */
	public InteractiveElement(int _x, int _y) { // constructeur par défaut pour avoir la porte fermée ou le bouton éteint par défaut
		super(_x,_y);
		state=false;
	}
	/**
	 * 
	 * @param _x the x coordinate we want for the interactive element.
	 * @param _y the y coordinate we want for the interactive element.
	 * @param _state the state we want for the interactive element.
	 */
	public InteractiveElement(int _x, int _y, boolean _state) { // constructeur pour choisir l'état initial
		super(_x, _y);
		state=_state;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isState() {
		return state;
	}
	/**
	 * 
	 * @param state
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	
}
