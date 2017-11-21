package controller;

import model.Model;
import view.View;

import javafx.event.*;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.stage.Stage;

public class Controller {
	private static Controller instance = null;
	private static View view;
	private static Model model;
	
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
		view = View.getInstance();
		model = Model.getInstance();
	}
	
	public static Controller makeInstance() {
		if (instance == null)
		    instance = new Controller();
		return instance;
	}
	
	public static void start(Stage primaryStage) throws Exception {
		view.start(primaryStage);
		view.setOnAction();
	}
		
}