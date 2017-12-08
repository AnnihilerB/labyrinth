package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public abstract class ElementView {
	//TODO Centrer les elements
	protected ImageView sprite;
	
	protected abstract File getImageFile();
	
	protected ElementView() {
		Image image = new Image(getImageFile().toURI().toString());
		sprite = new ImageView(image);	
	}	

    public void drawSprite(Pane pane, int nbrX, int nbrY) {
    	double xt = (LabyrinthView.WALL + nbrX * (LabyrinthView.WALL + LabyrinthView.CELL)) * LabyrinthView.SPAN;
    	double yt = (LabyrinthView.WALL + nbrY * (LabyrinthView.WALL + LabyrinthView.CELL)) * LabyrinthView.SPAN;
    	
    	sprite.setX(xt);
    	sprite.setY(yt);
		pane.getChildren().add(this.sprite);
    }

    public void updatePosition(int x, int y) {
    	double xt = (LabyrinthView.WALL + x * (LabyrinthView.WALL + LabyrinthView.CELL)) * LabyrinthView.SPAN;
    	double yt = (LabyrinthView.WALL + y * (LabyrinthView.WALL + LabyrinthView.CELL)) * LabyrinthView.SPAN;
    	sprite.setX(xt);
    	sprite.setY(yt);
    }
}


