package model;
/**
 * 
 * @author mduverneix
 *
 */
public class Button extends ElementInteractif {
	/**
	 * 
	 */
	private Door linkedDoor; // porte liée au bouton à ouvrir et fermer en conséquence
	/**
	 * 
	 * @param _x
	 * @param _y
	 */
	public Button(int _x, int _y) {
		super(_x,_y);
	}
	/**
	 * 
	 * @param _x
	 * @param _y
	 * @param _state
	 */
	public Button(int _x, int _y, boolean _state) {
		super(_x, _y, _state);

	}
	/**
	 * 
	 * @return
	 */
	public Door getLinkedDoor() {
		return linkedDoor;
	}
	/**
	 * 
	 * @param linkedDoor
	 */
	public void setLinkedDoor(Door linkedDoor) {
		this.linkedDoor = linkedDoor;
	}
}
