package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import view.View;


public class PlayerListener implements EventHandler<KeyEvent>{


    @Override
    public void handle(KeyEvent event) {
        if (event.getCode().equals(KeyCode.UP)) {
        	int y=View.getInstance().getPlayer().getY();
        	View.getInstance().getPlayer().seDeplacer(View.getInstance().getPlayer().getX(), --y);
        	System.out.println(View.getInstance().getPlayer().getY());
        }
        if (event.getCode().equals(KeyCode.DOWN)) {
        	int y=View.getInstance().getPlayer().getY();
        	View.getInstance().getPlayer().seDeplacer(View.getInstance().getPlayer().getX(), ++y);
        	System.out.println(View.getInstance().getPlayer().getY());
        }
        if ( event.getCode().equals(KeyCode.LEFT)) {
        	int x=View.getInstance().getPlayer().getX();
        	View.getInstance().getPlayer().seDeplacer(--x, View.getInstance().getPlayer().getY());
        	System.out.println(View.getInstance().getPlayer().getX());
        }  
        if (event.getCode().equals(KeyCode.RIGHT)) {
        	int x=View.getInstance().getPlayer().getX();
        	View.getInstance().getPlayer().seDeplacer(++x, View.getInstance().getPlayer().getY());
        	System.out.println(View.getInstance().getPlayer().getX());
        }   
    	//System.out.println("tototototo");
    }
}
