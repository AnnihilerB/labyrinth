package model;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The Door is an element which appears in the labyrinth and allows to create a new labyrinth to continue to play after you passed it.
 * @author Martial Duverneix
 *
 */
public class Door extends InteractiveElement{

	private static Door door;

	public static Door getInstance(int x, int y){
		if (door == null)
			door = new Door(x, y);
		return door;
	}

	/**
	 * the button linked to the door which will close or open it.
	 */
	private Button linkedButton;
	/**
	 * Allocates a new Door object with a chosen position, no linked button and opened by default.
	 * @param _x the x coordinate we want for the door.
	 * @param _y the y coordinate we want for the door.
	 */
	public Door(int _x, int _y) {
		super(_x,_y);
		linkedButton=null;
		this.setState(true);
	}
	/**
	 * Allocates a new Door object with a chosen position, linked button and state.
	 * @param _x the x coordinate we want for the door.
	 * @param _y the y coordinate we want for the door.
	 * @param _button the button we want for opening/closing the door.
	 * @param _state the state we want for the door : opened(true) or closed (false)
	 */
	public Door(int _x, int _y, Button _button, boolean _state) {
		super(_x, _y, _state);
		linkedButton=_button;
	}
	/**
	 * Gets the linked button.
	 * @return the linked button.
	 */
	public Button getLinkedButton() {
		return linkedButton;
	}
	/**
	 * Sets a new linked Button.
	 * @param linkedButton the new linked Button.
	 */
	public void setLinkedButton(Button linkedButton) {
		this.linkedButton = linkedButton;
	}
}
