import controller.Controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	static Controller controller;
	
	public static void main(String args[]) {
		controller = Controller.getInstance();
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller.start(primaryStage);
	}
	
}
