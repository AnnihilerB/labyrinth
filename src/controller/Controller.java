package controller;

import model.Labyrinth;
import model.Model;

import javafx.event.*;
import javafx.scene.input.*;
import javafx.stage.Stage;
import view.GlobalView;
import view.LabyrinthView;


public class Controller {
	private static Controller instance = null;
	private static GlobalView view;
	private static Model model;

	private static EventHandler<KeyEvent> keyboardListener = new EventHandler<KeyEvent>() {
		@Override
		public void handle(KeyEvent event) {
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
			GlobalView.getInstance().createGlobalView(primaryStage, Labyrinth.getInstance().getWalls());
			LabyrinthView.getInstance().setOnAction(keyboardListener);
			primaryStage.show();
		}


}