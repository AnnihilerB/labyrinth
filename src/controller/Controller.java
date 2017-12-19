package controller;

import model.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.stage.Stage;
import view.GlobalView;
import view.LabyrinthView;

import java.util.*;

import view.ElementView;
import view.MonsterView;

public class Controller {
    private Stage stage;

	private static Controller instance = null;
	private static GlobalView globalView;
	private static Game game;

	ArrayList<ThreadMovementEnemy> threadMovement;

    private EventHandler<KeyEvent> keyboardListener = event -> {
        switch (event.getCode()) {

            case UP:
                // Déplacement du personnage
                game.getPlayer().moves(game.getPlayer().getX(),game.getPlayer().getY()-1);
                globalView.getPlayerView().updatePosition(game.getPlayer().getX(),game.getPlayer().getY());
                areColliding(game.getCandies());
                areColliding(game.getEnemies());
                break;
            case DOWN:
                game.getPlayer().moves(game.getPlayer().getX(),game.getPlayer().getY()+1);
                globalView.getPlayerView().updatePosition(game.getPlayer().getX(), game.getPlayer().getY());
                areColliding(game.getCandies());
                areColliding(game.getEnemies());
                break;
            case LEFT:
                game.getPlayer().moves(game.getPlayer().getX()-1,game.getPlayer().getY());
                globalView.getPlayerView().updatePosition(game.getPlayer().getX(), game.getPlayer().getY());
                areColliding(game.getCandies());
                areColliding(game.getEnemies());
                break;
            case RIGHT:
                game.getPlayer().moves(game.getPlayer().getX()+1,game.getPlayer().getY());
                globalView.getPlayerView().updatePosition(game.getPlayer().getX(), game.getPlayer().getY());
                areColliding(game.getCandies());
                areColliding(game.getEnemies());
                break;

        }
    };

		private Controller() {
			globalView = GlobalView.getInstance();
			game = Game.getInstance();
		}

		public static Controller makeInstance() {
			if (instance == null)
				instance = new Controller();
			return instance;
		}

		public void start(Stage primaryStage) throws Exception {
            this.stage = primaryStage;

            ArrayList wallCoordinates = generateWalls(game.getLabyrinth().getWalls());
            System.out.println(game.getLabyrinth());

            game.getCandies().forEach((key, candy)-> globalView.addCandyView(key, candy.getX(), candy.getY()));

            game.getEnemies().forEach((key, enemy)-> globalView.addEnemyView(enemy.getX(), enemy.getY()));

            game.getButtons().forEach((key, button)-> globalView.addEnemyView(button.getX(), button.getY()));

            globalView.addDoorView(game.getDoor().getX(), game.getDoor().getY());


            globalView.createGlobalView(primaryStage, wallCoordinates);
            globalView.getLabyrinthView().setOnAction(keyboardListener);
            primaryStage.show();
            moveEnemy();
		}

		private ArrayList generateWalls(Set<List<Vertex>> walls){
			ArrayList<Integer> wallsCoordinates = new ArrayList();
			walls.forEach((wall) -> {
				int xs = wall.get(0).getX();
				int ys = wall.get(0).getY();
				int xt = wall.get(1).getX();
				int yt = wall.get(1).getY();
				wallsCoordinates.add(xs);
				wallsCoordinates.add(ys);
				wallsCoordinates.add(xt);
				wallsCoordinates.add(yt);
			});
			return wallsCoordinates;
		}

    private int areColliding(HashMap<Integer, Element> elementHashMap){
        int coordPlayerX = game.getPlayer().getX();
        int coordPlayerY = game.getPlayer().getY();

        Iterator<Map.Entry<Integer,Element>> iter = elementHashMap.entrySet().iterator();

        while (iter.hasNext()) {

            Map.Entry<Integer,Element> entry = iter.next();

            Element element = entry.getValue();
            if(coordPlayerX == element.getX() && coordPlayerY == element.getY()){
                iter.remove();
                if (element instanceof Candy){
                    globalView.removeCandyFromView(entry.getKey());
                }
                if (element instanceof Enemy) {
                    game.resetGame();
                    globalView.resetView();
                    stopMovements();
                    try {
                        stage.setScene(null);
                        start(this.stage);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }

            }
        }
        return 0;
    }

    public void moveEnemy(){
		    threadMovement = new ArrayList();
		    game.getEnemies().forEach((key, enemy) ->{
		        ThreadMovementEnemy t = new ThreadMovementEnemy((Enemy)enemy, globalView.getMonsterViews().get(key));
		        threadMovement.add(t);
		        Timer timer = new Timer();
		        timer.scheduleAtFixedRate(t, 0, 500);
            });
    }

    public void stopMovements(){
		    threadMovement.forEach(thread ->{
		        System.out.println("Interrupted thread" + thread.toString());
            });
		    threadMovement.clear();
    }


    public class ThreadMovementEnemy extends TimerTask{

		    Enemy enemy;
		    MonsterView monsterView;

		    public ThreadMovementEnemy(Enemy e, MonsterView monsterView){
		        this.enemy = e;
		        this.monsterView = monsterView;
            }

            @Override
            public void run() {
                game.getLabyrinth().launchManhattan(new Vertex(enemy.getX(), enemy.getY()), new Vertex(game.getPlayer().getX(), game.getPlayer().getY()));
                moveManhattan();
                monsterView.updatePosition(enemy.getX(), enemy.getY());
        }

        public void moveManhattan() {
            Enemy e = enemy;
            Vertex vertex = game.getLabyrinth().getVertex(enemy.getX(), enemy.getY());
            for (Labyrinth.Directions dir : Labyrinth.Directions.values()) {
                Vertex next = game.getLabyrinth().getVertexByDir(vertex, dir);
                if (next == null)
                    continue;
                if (game.getLabyrinth().areVerticesConnected(vertex.getX(),vertex.getY(), next.getX(), next.getY()) && (next.getNbr() == vertex.getNbr() - 1)) {
                    if (dir == Labyrinth.Directions.SOUTH)
                        e.moves(e.getX(), e.getY() - 1);
                    if (dir == Labyrinth.Directions.NORTH)
                        e.moves(e.getX(), e.getY() + 1);
                    if (dir == Labyrinth.Directions.WEST)
                        e.moves(e.getX() - 1, e.getY() );
                    if (dir == Labyrinth.Directions.EAST)
                        e.moves(e.getX() + 1, e.getY() );
                }
            }
        }
    }

}
