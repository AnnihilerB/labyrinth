package test;


import model.Element;
import model.Game;
import model.Labyrinth;
import model.Player;
import org.junit.Assert;

import java.util.HashMap;

public class GameTest {

    private static Game game;

    @org.junit.BeforeClass
    public static void generateGame(){
        game = Game.getInstance();
    }

    @org.junit.Test
    public void instanceTest(){
        Game gameTwo;
        gameTwo = Game.getInstance();
        Assert.assertEquals(game, gameTwo);
    }

    @org.junit.Test
    public void getPlayerTest(){
        Assert.assertTrue(game.getPlayer() != null);
    }

    @org.junit.Test
    public void getCandiesTest(){
        Assert.assertTrue(game.getCandies() != null);
    }

    @org.junit.Test
    public void getEnemiesTest(){
        Assert.assertTrue(game.getEnemies() != null);
    }

    @org.junit.Test
    public void getLabyrinthTest(){
        Assert.assertTrue(game.getLabyrinth() != null);
    }

    @org.junit.Test
    public void getScore(){
        Assert.assertTrue(game.getScore() != null);
    }

    @org.junit.Test
    public void getDoorTest(){
        Assert.assertTrue(game.getDoor() != null);
    }

    @org.junit.Test
    public void generateCandiesEnemiesTest(){
        boolean resCandies = true;
        boolean resEnemies = true;
        HashMap<Integer, Element> candies = game.getCandies();
        HashMap<Integer, Element> enemies = game.getEnemies();
        for (int i = 0; i< candies.size(); i++) {
            if (candies.get(i) != candies.get(i + 1))
                resCandies &= true;
            else {
                resCandies &= false;
            }
        }
        for (int i = 0; i < enemies.size(); i++){
            if (enemies.get(i) != enemies.get(i+1))
                resEnemies &= true;
            else
                resEnemies &= false;
        }
        boolean res = resCandies & resEnemies;
        Assert.assertTrue(res);
    }

    @org.junit.Test
    public void resetGameTest(){
        Labyrinth oldLabyrinth = game.getLabyrinth();
        HashMap<Integer, Element> oldCandies = game.getCandies();
        HashMap<Integer, Element> oldEnemies = game.getEnemies();

        //Resetiing and getting the new elements.
        game.resetGame();

        Labyrinth newLabyrinth = game.getLabyrinth();
        Player newPlayer = game.getPlayer();
        HashMap<Integer, Element> newCandies = game.getCandies();
        HashMap<Integer, Element> newEnemies = game.getEnemies();

        //Testing references themselves
        if (oldLabyrinth == newLabyrinth)
            Assert.fail("Old and new Labyrinth are the same");
        if (oldCandies == newCandies)
            Assert.fail("Old and new Candy hashmap are the same");
        if (oldEnemies == newEnemies)
            Assert.fail("Old and new Enemy hashmap are the same");

        //Testing coordinates of Player
        if (newPlayer.getX() != 0 && newPlayer.getY() != 0)
            Assert.fail("Player not resetted to 0,0");

        //Testing each element of hashmap
        if (oldCandies.size() == newCandies.size()){
            int length = oldCandies.size();
            for (int i = 0; i < length; i ++){
                Assert.assertNotEquals(oldCandies.get(i), newCandies.get(i));
            }
        }
        else
            Assert.fail("Candy hashMap size not correct.");

        if (oldEnemies.size() == newEnemies.size() ){
            int length = oldEnemies.size();
            for (int i = 0; i< length; i++){
                Assert.assertNotEquals(oldEnemies.get(i), newEnemies.get(i));
            }

        }
        else
            Assert.fail("Enemey hashMap size not correct.");
    }




}
