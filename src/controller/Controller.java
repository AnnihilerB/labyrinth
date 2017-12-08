package controller;

import model.Labyrinth;
import model.Model;
import model.Player;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.stage.Stage;
import model.Vertex;
import view.GlobalView;
import view.LabyrinthView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import view.ElementView;
import view.PlayerView;

/**
 * Controller class.
 * This class handles communication between model and view.
 * It contains one single instance of view and model.
 */
public class Controller {

	/**
	 * Instance of controller
	 */
	private static Controller instance = null;

	private static PlayerView playerView;

	private static EventHandler<KeyEvent> keyboardListener = event -> {
        switch (event.getCode()) {

            case UP:
            	// Déplacement du personnage
            	Player.getInstance().seDeplacer(Player.getInstance().getX(),Player.getInstance().getY()-1);
                playerView.updatePosition(Player.getInstance().getX(),Player.getInstance().getY());
                break;
            case DOWN:
            	Player.getInstance().seDeplacer(Player.getInstance().getX(),Player.getInstance().getY()+1);
				playerView.updatePosition(Player.getInstance().getX(), Player.getInstance().getY());
                break;
            case LEFT:
            	Player.getInstance().seDeplacer(Player.getInstance().getX()-1,Player.getInstance().getY());
				playerView.updatePosition(Player.getInstance().getX(), Player.getInstance().getY());
                break;
            case RIGHT:
            	Player.getInstance().seDeplacer(Player.getInstance().getX()+1,Player.getInstance().getY());
				playerView.updatePosition(Player.getInstance().getX(), Player.getInstance().getY());
                break;

        }
    };

		private Controller() {
		    playerView = PlayerView.getInstance();
		}

		public static Controller makeInstance() {
			if (instance == null)
				instance = new Controller();
			return instance;
		}

		public static void start(Stage primaryStage){
			ArrayList wallCoordinates = generateWalls(Labyrinth.getInstance().getWalls());
			GlobalView.getInstance().createGlobalView(primaryStage, wallCoordinates);
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
