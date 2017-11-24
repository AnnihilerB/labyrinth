import controller.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Labyrinth;

public class Main extends Application {

	static Controller controller;

	public static void main(String args[]) {
		Labyrinth labyrinth = Labyrinth.getInstance();
		labyrinth.printLabyrinth();
		
		launch();		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		controller.makeInstance();
		Controller.start(primaryStage);
	}

	@Override
	public void stop(){
	    System.exit(0);
    }

}
