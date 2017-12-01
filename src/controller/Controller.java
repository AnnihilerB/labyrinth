package controller;

import javafx.scene.paint.Color;
import model.Labyrinth;
import model.Model;

import javafx.event.*;
import javafx.scene.input.*;
import javafx.stage.Stage;
import view.GlobalView;

public class Controller implements EventHandler<KeyEvent>{
	private static Controller instance = null;
	private static GlobalView view;
	private static Model model;

	
	
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
        primaryStage.show();
	}


	@Override
	public void handle(KeyEvent event) {
		switch(event.getCode()){

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
}