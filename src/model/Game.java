package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class keeping an single instance of game.
 * Creates every element needed for a game such as a player, enemies, candies and the labyrinth.
 *
 */
public class Game {
	/**
	 * Single instance of a game.
	 */
	private static Game game =new Game();

	/**
	 * single instance of a player
	 */
	private Player player;
	/**
	 * Single instance of the labyrinth
	 */
	private Labyrinth labyrinth;

	/**
	 * Hashmap of collectibles in game.
	 */
	private HashMap<Integer, Element> candies;
	private HashMap<Integer, Element> enemies;
	private HashMap<Integer, Element> buttons;


	/**
	 * Signle instance of the scoring element.
	 */
	private Score score;
	/**
	 * Single instance of the door.
	 */
	private Door door;

	/**
	 * Constructor for the single instance of the game.
	 * Constructs the instance of the labyrinth and creates
	 * the various hashMap.
	 */
	private Game() {
		labyrinth = Labyrinth.getInstance();
		player = Player.getInstance();

		candies = new HashMap<>();
		enemies = new HashMap<>();
		buttons = new HashMap<>();

		generateCandies();
		generateEnemies();
		//generateButtons();

		score = Score.getInstance();

		//Put the door randomly.
        int coordX = ThreadLocalRandom.current().nextInt(0, 16);
        int coordY = ThreadLocalRandom.current().nextInt(0, 16);
		this.door = Door.getInstance(coordX, coordY);
	}

	/**
	 * Returns the only existing instance of a game.
	 * @return the current instance if not null, creates and returns it otherwise.
	 */
	public static Game getInstance() {
		if (game == null)
			game = new Game();
		return game;
	}

	/**
	 * returns the single instance of a player
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * returns the single instance of the labyrinth
	 * @return the current labyrinth
	 */
	public Labyrinth getLabyrinth() {
		return labyrinth;
	}

	/**
	 * return the hashmap containing every candy in game.
	 * @return a hashmap of Element
	 */
	public HashMap<Integer, Element> getCandies() {
		return candies;
	}

	/**
	 * return the hashmap containing every enemy in game.
	 * @return a hashmap of Element
	 */
	public HashMap<Integer, Element> getEnemies() {
		return enemies;
	}

	/**
	 * return the hashmap containing every button in game.
	 * @return a hashmap of Element
	 */
	public HashMap<Integer, Element> getButtons() {
		return buttons;
	}

	/**
	 * return the single instance of the score element.
	 * @return the current Score element.
	 */
	public Score getScore() {
		return score;
	}

	/**
	 * return the single instance of the door
	 * @return the current Door element.
	 */
	public Door getDoor() {
		return door;
	}

	/**
	 * Generates candies randomly placed on the board.
	 * Every candy is added to the hashmap with an unique ID.
	 */
	private void generateCandies(){
		for (int i = 0; i < 16; i++){
			int coordX = ThreadLocalRandom.current().nextInt(0, 16);
			int coordY = ThreadLocalRandom.current().nextInt(0, 16);
			Candy candy = new Candy(coordX, coordY, i);
			candies.put(i, candy);
		}
	}

	/**
	 * Generates two enemies placed randomly on the board.
	 * Each enemy is added to the hashmap with an unique ID
	 */
	private void generateEnemies(){
		int coordX = ThreadLocalRandom.current().nextInt(0, 16);
		int coordY = ThreadLocalRandom.current().nextInt(0, 16);
		Enemy enemy = new Enemy(coordX,coordY);
		enemies.put(0, enemy);
		coordX = ThreadLocalRandom.current().nextInt(0, 16);
		coordY = ThreadLocalRandom.current().nextInt(0, 16);
		enemy = new Enemy(coordX,coordY);
		enemies.put(1, enemy);
	}

	/**
	 * Generates buttons placed randomly on the board.
	 * Each button is added to the hashmap with an unique ID
	 */
	private void generateButtons(){
		int coordX = ThreadLocalRandom.current().nextInt(0, 16);
		int coordY = ThreadLocalRandom.current().nextInt(0, 16);
		//Button button = new Button(coordX, coordY);
		//buttons.put(0, button);
	}

	/**
	 * Resets the game instance. A new Labyrinth is generated. The player is placed at its default
	 * position and the door is placed randomly. The various HashMap are also reinitialized and new
	 * enemies, candies and buttons are generated.
	 */
	public void resetGame(){
		labyrinth.reset();
		labyrinth = Labyrinth.getInstance();
		System.out.println(labyrinth);
		player.setX(0);
		player.setY(0);

		candies = new HashMap();
		enemies = new HashMap();
		buttons = new HashMap();

		int coordX = ThreadLocalRandom.current().nextInt(0, 16);
		int coordY = ThreadLocalRandom.current().nextInt(0, 16);
		door.setX(coordX);
		door.setY(coordY);

		generateCandies();
		generateEnemies();

	}
}
