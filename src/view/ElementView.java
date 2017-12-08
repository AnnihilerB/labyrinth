package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public class ElementView {
    //private final Image PlayerImage = new Image(getClass().getResource("assets/player.png").toExternalForm());
    private static ElementView elementView = new ElementView();
    private ImageView playerView;

    private ElementView() {
    }

    public static ElementView getInstance() {
        return elementView;
    }

    public void drawSprite(Pane pane, int nbrX, int nbrY) {
        File file = new File("assets/player.png");
        Image image = new Image(file.toURI().toString());
    	playerView = new ImageView(image);

    	
    	pane.getChildren().add(this.playerView);
    	
    	double xt = (LabyrinthView.WALL + nbrX * (LabyrinthView.WALL + LabyrinthView.CELL)) * LabyrinthView.SPAN;
    	double yt = (LabyrinthView.WALL + nbrY * (LabyrinthView.WALL + LabyrinthView.CELL)) * LabyrinthView.SPAN;
    	
    	playerView.setX(xt);
    	playerView.setY(yt);
    }
    
    public void updatePlayer(int x, int y) {
    	playerView.setX(x);
    	playerView.setY(y); 
    }
}


