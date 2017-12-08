package view;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Edge;
import model.Labyrinth;
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

    public void createGlobalView(Stage stage, ArrayList<Integer> wallCoordinates){
        LabyrinthView.drawFrame(stage, pane, 16,16);

        for (int i = 0; i < wallCoordinates.size(); i+=4){
            LabyrinthView.drawWall(pane, wallCoordinates.get(i), wallCoordinates.get(i+1),wallCoordinates.get(i+2), wallCoordinates.get(i+3), LabyrinthView.WALL_COLOR);
        }

        ElementView.getInstance().drawSprite(pane, 0, 0);
    }

    }

