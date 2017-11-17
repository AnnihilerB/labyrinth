package view;

import java.awt.event.KeyEvent;

import controller.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class View {
	private static View instance=new View();
	private Button button;
	
	private VBox vbox;
	private HBox hbox1;
	private Scene scene;
	
	private View() {
		
	}
	
	public static View getInstance() {
		return instance;
	}
	
	public void start(Stage primaryStage) throws Exception {
		
        // bouton
        button=new Button("Joueur");
       
       
        // Box
        vbox=new VBox(8);
        hbox1=new HBox(3);
        hbox1.setAlignment(Pos.BASELINE_CENTER);
        
        // ajout des éléments
        vbox.getChildren().add(hbox1);
        hbox1.getChildren().add(button);
        
        // scène
        scene = new Scene(vbox,350,100);
       
        // stage
        primaryStage.setTitle("Jeu vidéo labyrinthe"); 
        primaryStage.setScene(scene); 
        primaryStage.sizeToScene(); 
        primaryStage.show(); 
	}
	


	public Button getButton() {
		return button;
	}

	public void setOnAction() {
		button.setOnKeyPressed(Controller.getInstance().eventHandlerButton);
	}
	
	
}
