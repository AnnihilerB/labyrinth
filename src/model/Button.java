package model;
/**
 * The Button is an element which appears in the labyrinth and allows to open or close the linked door.
 * @author Martial Duverneix
 *
 */
public class Button extends InteractiveElement {
	/**
	 * the door linked to the button which will get opened or closed.
	 */
	private Door linkedDoor;
	/**
	 * Allocates a new Button object with a chosen position and with the off mode (door closed).
	 * @param _x the x coordinate we want for the button.
	 * @param _y the y coordinate we want for the button.
	 */
	public Button(int _x, int _y) {
		super(_x,_y);
	}
	/**
	 * Allocates a new Button with a chosen position and state.
	 * @param _x the x coordinate we want for the button.
	 * @param _y the y coordinate we want for the button.
	 * @param _state the state we want for the button.
	 */
	public Button(int _x, int _y, boolean _state) {
		super(_x, _y, _state);

	}
	/**
	 * Gets the linked door.
	 * @return the linked door.
	 */
	public Door getLinkedDoor() {
		return linkedDoor;
	}
	/**
	 * Sets a new linked Door.
	 * @param linkedDoor the new linked door.
	 */
	public void setLinkedDoor(Door linkedDoor) {
		this.linkedDoor = linkedDoor;
	}
}
