package model;

public class Button extends ElementInteractif {
	
	private Door linkedDoor; // porte liée au bouton à ouvrir et fermer en conséquence
	
	public Button(int _x, int _y) {
		super(_x,_y);
	}
	
	public Button(int _x, int _y, boolean _state) {
		super(_x, _y, _state);

	}

	public Door getLinkedDoor() {
		return linkedDoor;
	}

	public void setLinkedDoor(Door linkedDoor) {
		this.linkedDoor = linkedDoor;
	}
}
