package view;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GlobalView {

    private static GlobalView globalView = null;
    private PlayerView playerView = null;

    static Pane pane = new Pane();

    private GlobalView() {	
    }

    public static GlobalView getInstance() {
        if (globalView == null)
            globalView = new GlobalView();
        return globalView;
    }

    public void createGlobalView(Stage stage, ArrayList<Integer> wallCoordinates){
        LabyrinthView.drawFrame(stage, pane, 16,16);

        for (int i = 0; i < wallCoordinates.size(); i+=4){
            LabyrinthView.drawWall(pane, wallCoordinates.get(i), wallCoordinates.get(i+1),wallCoordinates.get(i+2), wallCoordinates.get(i+3), LabyrinthView.WALL_COLOR);
        }

        playerView = PlayerView.getInstance();
        playerView.drawSprite(pane, (int)playerView.sprite.getX(), (int)playerView.sprite.getY());
        
        MonsterView monster = new MonsterView();
        monster.drawSprite(pane, 12, 5);
        
        DoorView door = new DoorView();
        door.drawSprite(pane, 15, 15);
        
        ButtonView button1 = new ButtonView();
        button1.drawSprite(pane, 3, 3);
        button1.openButton();
        ButtonView button2 = new ButtonView();
        button2.drawSprite(pane, 3, 4);
        button2.closeButton();
        
        for(int i=0; i<16;i++) {
	        CandyView candy = new CandyView();
	        candy.drawSprite(pane, i, 8);
        }
    }
    
}
