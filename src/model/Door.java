package model;

public class Door extends ElementInteractif{
	
	private Button linkedButton; // bouton lié à la porte
	
	public Door(int _x, int _y, Button _button) {
		super(_x,_y);
		linkedButton=_button;
	}
	
	public Door(int _x, int _y, Button _button, boolean _state) {
		super(_x, _y, _state);
		linkedButton=_button;
	}

	public Button getLinkedButton() {
		return linkedButton;
	}

	public void setLinkedButton(Button linkedButton) {
		this.linkedButton = linkedButton;
	}
}
