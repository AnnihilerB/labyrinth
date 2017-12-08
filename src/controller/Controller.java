package controller;

import model.Labyrinth;
import model.Model;

import javafx.event.*;
import javafx.scene.input.*;
import javafx.stage.Stage;
import model.Vertex;
import view.GlobalView;
import view.LabyrinthView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Controller {
	private static Controller instance = null;
	private static GlobalView view;
	private static Model model;

	private static EventHandler<KeyEvent> keyboardListener = event -> {
        switch (event.getCode()) {

            case UP:
                System.out.println("UP");
                break;
            case DOWN:
                System.out.println("DOWN");
                break;
            case LEFT:
                System.out.println("LEFT");
                break;
            case RIGHT:
                System.out.println("RIGHT");
                break;

        }
    };

		private Controller() {
			view = GlobalView.getInstance();
			model = Model.getInstance();
		}

		public static Controller makeInstance() {
			if (instance == null)
				instance = new Controller();
			return instance;
		}

		public static void start(Stage primaryStage) throws Exception {
			ArrayList wallCoordiantes = generateWalls(Labyrinth.getInstance().getWalls());
			GlobalView.getInstance().createGlobalView(primaryStage, wallCoordiantes);
			LabyrinthView.getInstance().setOnAction(keyboardListener);
			primaryStage.show();
		}

		private static ArrayList generateWalls(Set<List<Vertex>> walls){
			ArrayList<Integer> wallsCoordinates = new ArrayList();
			walls.forEach((wall) -> {
				int xs = wall.get(0).getX();
				int ys = wall.get(0).getY();
				int xt = wall.get(1).getX();
				int yt = wall.get(1).getY();
				wallsCoordinates.add(xs);
				wallsCoordinates.add(ys);
				wallsCoordinates.add(xt);
				wallsCoordinates.add(yt);
			});
			return wallsCoordinates;
		}


}
