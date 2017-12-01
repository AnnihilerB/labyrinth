package view;


import java.util.List;
import java.util.Set;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Vertex;


public class GlobalView {

    private static GlobalView globalView = null;


    static Pane pane = new Pane();

    private GlobalView() {
    }

    public static GlobalView getInstance() {
        if (globalView == null)
            globalView = new GlobalView();
        return globalView;
    }

    public void createGlobalView(Stage stage, Set<List<Vertex>> walls) {
        LabyrinthView.drawFrame(stage, pane, 16,16);

        walls.forEach((wall) -> {
        	int xs = wall.get(0).getX();
        	int ys = wall.get(0).getY();
        	int xt = wall.get(1).getX();
        	int yt = wall.get(1).getY();
        	
        	LabyrinthView.drawWall(pane, xs, ys, xt, yt, LabyrinthView.WALL_COLOR);
        });
        
        ElementView.getInstance().drawSprite(pane, 0, 0);
    }
}



