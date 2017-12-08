package model;

public class Button extends ElementInteractif {
	
	private Door linkedDoor; // porte liée au bouton à ouvrir et fermer en conséquence
	
	public Button(int _x, int _y, Door _door) {
		super(_x,_y);
		linkedDoor=_door;
	}
	
	public Button(int _x, int _y, Door _door, boolean _state) {
		super(_x, _y, _state);
		linkedDoor=_door;
	}

	public Door getLinkedDoor() {
		return linkedDoor;
	}

	public void setLinkedDoor(Door linkedDoor) {
		this.linkedDoor = linkedDoor;
	}
}
