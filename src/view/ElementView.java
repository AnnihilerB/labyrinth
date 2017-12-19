package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public abstract class ElementView {
	private ImageView sprite;
	private double width, height;
	
	protected abstract File getImageFile();
	
	protected ElementView() {
		Image image = new Image(getImageFile().toURI().toString());
		sprite = new ImageView(image);		
		
		width = image.getWidth();
		height = image.getHeight();
	}	

    public void drawSprite(Pane pane, int x, int y) {		
    	pane.getChildren().add(this.sprite);
    	updatePosition(x, y);
    }

    public void updatePosition(int x, int y) {
    	sprite.setX(getDisplayPositionFromXCoord(x));
    	sprite.setY(getDisplayPositionFromYCoord(y));
    }
    
    private double getDisplayPositionFromXCoord(int x) {
    	double displayPosition;
    	
    	// On décale la position au delà du mur à l'extrémité ouest
    	displayPosition = LabyrinthView.WALL;
    	
    	// On décale la position du nombre de cellules par rapport à l'extrémité ouest
    	displayPosition += x * (LabyrinthView.WALL + LabyrinthView.CELL);
    	
    	// On multiplie ce déplacement par le scaling d'affichage
    	displayPosition *= LabyrinthView.SPAN;
    	
    	// On centre l'affichage dans sa cellule courante
    	displayPosition += (LabyrinthView.SPAN * LabyrinthView.CELL - width)/2;
    	
    	return displayPosition;
    }
    
    private double getDisplayPositionFromYCoord(int y) {
    	double displayPosition;
    	
    	// On décale la position au delà du mur à l'extrémité nord
    	displayPosition = LabyrinthView.WALL;
    	
    	// On décale la position du nombre de cellules par rapport à l'extrémité nord
    	displayPosition += y * (LabyrinthView.WALL + LabyrinthView.CELL);
    	
    	// On multiplie ce déplacement par le scaling d'affichage
    	displayPosition *= LabyrinthView.SPAN;
    	
    	// On centre l'affichage dans sa cellule courante
    	displayPosition += (LabyrinthView.SPAN * LabyrinthView.CELL - height)/2;
    	
    	return displayPosition;
    }

	protected ImageView getSprite() {
		return sprite;
	}

	protected void updateSprite(File newSpritePath) {
    	sprite.setImage(new Image(newSpritePath.toURI().toString()));
    }
}


