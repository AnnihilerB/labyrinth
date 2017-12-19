package view;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Candy;

public class GlobalView {

    private static GlobalView globalView = null;

    private Stage stage;

    private PlayerView playerView;
    private DoorView doorView;
    private LabyrinthView labyrinthView;


    private HashMap<Integer, MonsterView> monsterViews;
    private HashMap<Integer, CandyView> candyViews;
    private HashMap<Integer, ButtonView> buttonViews;


    static Pane pane = new Pane();

    private GlobalView() {
        labyrinthView = LabyrinthView.getInstance();

        monsterViews = new HashMap<>();
        candyViews = new HashMap<>();
        buttonViews = new HashMap<>();

        playerView = PlayerView.getInstance();

    }

    public static GlobalView getInstance() {
        if (globalView == null)
            globalView = new GlobalView();
        return globalView;
    }

    public PlayerView getPlayerView() {
        return playerView;
    }

    public DoorView getDoorView() {
        return doorView;
    }

    public LabyrinthView getLabyrinthView() {
        return labyrinthView;
    }

    public HashMap<Integer, MonsterView> getMonsterViews() {
        return monsterViews;
    }

    public HashMap<Integer, CandyView> getCandyViews() {
        return candyViews;
    }

    public HashMap<Integer, ButtonView> getButtonViews() {
        return buttonViews;
    }


    public void createGlobalView(Stage stage, ArrayList<Integer> wallCoordinates){
        labyrinthView.drawFrame(stage, pane, 16,16);

        for (int i = 0; i < wallCoordinates.size(); i+=4){
            labyrinthView.drawWall(pane, wallCoordinates.get(i), wallCoordinates.get(i+1),wallCoordinates.get(i+2), wallCoordinates.get(i+3), LabyrinthView.WALL_COLOR);
        }
        playerView.drawSprite(pane, 0, 0);

    }

    public void addCandyView(int ident, int x, int y){
        CandyView candyView = new CandyView();
        candyViews.put(ident, candyView);
        candyView.drawSprite(pane, x, y);
    }

    public void addEnemyView(int x, int y){
        MonsterView monsterView = new MonsterView();
        monsterViews.put(monsterViews.size(), monsterView);
        monsterView.drawSprite(pane, x, y);
    }

    public void addButtonView(int x, int y){
        ButtonView buttonView = new ButtonView();
        buttonViews.put(0, buttonView);
        buttonView.drawSprite(pane, x, y);
    }

    public void addDoorView(int x, int y){
        doorView = new DoorView();
        doorView.drawSprite(pane, x, y);

    }

    public void removeCandyFromView(int ident){
        pane.getChildren().remove(candyViews.get(ident).getSprite());
        candyViews.remove(ident);
    }

    public void resetView(){
        pane.getChildren().clear();
    }
}
