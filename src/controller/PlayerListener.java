package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class PlayerListener implements EventHandler<KeyEvent>{


    @Override
    public void handle(KeyEvent event) {
        if (event.getCode().equals(KeyCode.UP))
            System.out.println("HAUT");
        if (event.getCode().equals(KeyCode.DOWN))
            return;
        if (event.getCode().equals(KeyCode.LEFT))
            return;
        if (event.getCode().equals(KeyCode.RIGHT))
            return;
    }
}
