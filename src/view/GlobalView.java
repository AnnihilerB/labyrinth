package view;

import controller.PlayerListener;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Labyrinth;


public class GlobalView {

    private static GlobalView globalView = null;

    static Scene scene;
    static Pane pane = new Pane();

    private GlobalView() {
    		scene.setOnKeyPressed(new PlayerListener());

    }

    public static GlobalView getInstance() {
        if (globalView == null)
            globalView = new GlobalView();
        return globalView;
    }

    public void createGlobalView(Stage stage){
        //LabyrinthView.drawFrame(stage, scene, pane, 16,16);
       // LabyrinthView.drawWall(pane, 1, 1, 1, 2, LabyrinthView.WALL_COLOR);

    }
}



