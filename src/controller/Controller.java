package controller;

import javafx.scene.paint.Color;
import model.Labyrinth;
import model.Model;

import javafx.event.*;
import javafx.scene.input.*;
import javafx.stage.Stage;
import view.GlobalView;

public class Controller {
	private static Controller instance = null;
	private static GlobalView view;
	private static Labyrinth labyrinth;
	
	public static EventHandler eventHandlerButton = new EventHandler<KeyEvent>() {
		public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.UP))
					System.out.println("test haut");
				else if(event.getCode()==KeyCode.DOWN)
					System.out.println("test bas");
				else if(event.getCode()==KeyCode.LEFT)
					System.out.println("test gauche");
				else if(event.getCode()==KeyCode.RIGHT)
					System.out.println("test droit");
		}	
	};
	
	
	private Controller() {
	    view = GlobalView.getInstance();
		labyrinth = Labyrinth.getInstance();
	}
	
	public static Controller makeInstance() {
		if (instance == null)
		    instance = new Controller();
		return instance;
	}
	
	public static void start(Stage primaryStage) throws Exception {		
        GlobalView.getInstance().createGlobalView(primaryStage, labyrinth.getWalls());
        primaryStage.show();
	}
		
}