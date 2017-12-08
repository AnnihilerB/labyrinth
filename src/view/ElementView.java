package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public abstract class ElementView {
	//TODO Centrer les elements
	private ImageView sprite = null;
	
	protected abstract File getImageFile();
	
	protected ElementView() {
		Image image = new Image(getImageFile().toURI().toString());
		sprite = new ImageView(image);	
	}	

    public void drawSprite(Pane pane, int nbrX, int nbrY) {		
    	pane.getChildren().add(this.sprite);
    	
    	double xt = (LabyrinthView.WALL + nbrX * (LabyrinthView.WALL + LabyrinthView.CELL)) * LabyrinthView.SPAN;
    	double yt = (LabyrinthView.WALL + nbrY * (LabyrinthView.WALL + LabyrinthView.CELL)) * LabyrinthView.SPAN;
    	
    	sprite.setX(xt);
    	sprite.setY(yt);
    }

    public void updatePosition(int x, int y) {
    	double xt = (LabyrinthView.WALL + x * (LabyrinthView.WALL + LabyrinthView.CELL)) * LabyrinthView.SPAN;
    	double yt = (LabyrinthView.WALL + y * (LabyrinthView.WALL + LabyrinthView.CELL)) * LabyrinthView.SPAN;
    	
    	sprite.setX(xt);
    	sprite.setY(yt); 
    }
    
    protected void updateSprite(File newSpritePath) {
    	sprite.setImage(new Image(newSpritePath.toURI().toString()));
    }
}


