package model;

import javafx.event.EventHandler;
import javafx.scene.image.*;

public class Player extends Character {
	

	public Player(int _x, int _y, Image image) {
		super(_x,_y, image);
		this.getImageView().setX(this.getX());
		this.getImageView().setY(this.getY());
	}

}
