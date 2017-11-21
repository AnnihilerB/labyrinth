import controller.Controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	static Controller controller;

	public static void main(String args[]) {
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
