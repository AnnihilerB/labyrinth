package model;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {

	@org.junit.Test
    public void testPlayer() {
        Player player=Player.getInstance();
        assertEquals(0,player.getX());
        assertEquals(0,player.getY());
        player.setX(10);
        player.setY(11);
        assertEquals(10,player.getX());
        assertEquals(11,player.getY());
    }
	
	@org.junit.Test
    public void testCollisionMur() {
        Player player=Player.getInstance();
        Labyrinth labyrinth=Labyrinth.getInstance();
        /*assertEquals(false,labyrinth.areVerticesConnected(player.getX(), player.getY(), player.getX()+1, player.getY()));
        assertEquals(false,labyrinth.areVerticesConnected(player.getX(), player.getY(), player.getX()-1, player.getY()));
        assertEquals(false,labyrinth.areVerticesConnected(player.getX(), player.getY(), player.getX(), player.getY()+1));
        assertEquals(false,labyrinth.areVerticesConnected(player.getX(), player.getY(), player.getX(), player.getY()-1));*/
    } 
	
}
