package view;

import java.awt.event.KeyEvent;
import java.io.File;

import controller.Controller;
import controller.PlayerListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
import model.Player;

public class View {
	private static View instance=new View();
	private Button button;
	
	private static Pane pane = new Pane();
	private Scene scene;
	private Player player;
	
	private View() {
		
	}
	
	public static View getInstance() {
		return instance;
	}
	
	public void start(Stage primaryStage) throws Exception {
		
        // bouton
        button=new Button("Joueur");
        player=new Player(50,50,new Image(getClass().getResource("assets/player.png").toExternalForm() ));
        
        // ajout des éléments
        pane.getChildren().add(player.getImageView());
        
        // scène
        scene = new Scene(pane,350,300);
       
        // stage
        primaryStage.setTitle("Jeu vidéo labyrinthe"); 
        primaryStage.setScene(scene); 
        primaryStage.sizeToScene(); 
        scene.setOnKeyPressed(new PlayerListener());
        primaryStage.show(); 
	}
	


	public Player getPlayer() {
		return player;
	}

	public Button getButton() {
		return button;
	}

	
	
}
