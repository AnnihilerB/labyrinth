package model;
/**
 * The abstract class InteractiveElement is a superclass of Door and Button.
 * It gives them the "state" attribute.
 * @author Martial Duverneix
 * 
 */
public abstract class InteractiveElement extends Element {
	/**
	 * the state of the InteractiveElement.
	 * If the state is true, the door is opened or the button is on.
	 * If the state is false, the door is closed or the button is off.
	 */
	private boolean state;
	/**
	 * Sets the position of the interactive element on the x and y chosen and sets the state at false.
	 * @param _x the x coordinate we want for the interactive element.
	 * @param _y the y coordinate we want for the interactive element.
	 */
	public InteractiveElement(int _x, int _y) {
		super(_x,_y);
		state=false;
	}
	/**
	 * Sets the position of the interactive element on the x and y chosen and sets the state chosen.
	 * @param _x the x coordinate we want for the interactive element.
	 * @param _y the y coordinate we want for the interactive element.
	 * @param _state the state we want for the interactive element.
	 */
	public InteractiveElement(int _x, int _y, boolean _state) {
		super(_x, _y);
		state=_state;
	}
	/**
	 * Gets the state.
	 * @return the state.
	 */
	public boolean getState() {
		return state;
	}
	/**
	 * Sets the state.
	 * @param state the state we want.
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	
}
