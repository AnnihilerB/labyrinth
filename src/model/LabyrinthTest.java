package model;

import junit.framework.TestCase;
import static model.Labyrinth.Directions.*;

import org.jgrapht.graph.SimpleGraph;

public class LabyrinthTest extends TestCase {
	
	static SimpleGraph<Vertex, Edge> labyrinth;	
	static Vertex vertex00;
	static Vertex vertex01;
	static Vertex vertex10;
	static Vertex vertex11; 

    @org.junit.BeforeClass
    public static void generateLabyrinth() {
    	labyrinth = new SimpleGraph(Edge.class);
    	
    	vertex00 = new Vertex(0,0);
    	vertex01 = new Vertex(0,1);
    	vertex10 = new Vertex(1,0);
    	vertex11 = new Vertex(1,1);
    	
		labyrinth.addVertex(vertex00);
		labyrinth.addVertex(vertex01);
		labyrinth.addVertex(vertex10);
		labyrinth.addVertex(vertex11);
		
		labyrinth.addEdge(vertex00, vertex01);
		labyrinth.addEdge(vertex01, vertex11);
		labyrinth.addEdge(vertex11, vertex10);
		System.out.println("test");
    }
	

    @org.junit.Test
    public void testIsClosed() {
        Labyrinth lab = Labyrinth.getInstance();
        assertNotNull(vertex00);
        
        //assertTrue(lab.isClosed(vertex00, SOUTH));
        //lab.addVertex

    }

    @org.junit.Test
    public void testIsOpened() {
        Labyrinth lab = Labyrinth.getInstance();
        Vertex v1 = new Vertex(0,0);
        assertTrue(lab.isOpened(v1, EAST));
    }

    @org.junit.Test
    public void testIsClosedDoor() {
        Labyrinth lab = Labyrinth.getInstance();
        Vertex v1 = new Vertex(0,0);
        assertTrue(lab.isClosedDoor(v1, EAST));
    }

    @org.junit.Test
    public void testIsOpenedDoor() {
        Labyrinth lab = Labyrinth.getInstance();
        Vertex v1 = new Vertex(0,0);
        assertTrue(lab.isOpenedDoor(v1, EAST));
    }

    @org.junit.Test
    public void testIsWall() {
        Labyrinth lab = Labyrinth.getInstance();
        Vertex v1 = new Vertex(0,0);
        assertTrue(lab.isWall(v1, SOUTH));
    }

    @org.junit.Test
    public void testAreVerticesConnected() {
        Labyrinth lab = Labyrinth.getInstance();
        assertTrue(lab.areVerticesConnected(1,0,1,1));
    }
    
    @org.junit.Test
    public void testGetInstance() {
        Labyrinth lab = Labyrinth.getInstance();
        assertNotNull(lab);
        assertTrue(lab instanceof Labyrinth);
    }
    
    @org.junit.Test
    public void testGetterSetter() {
        Labyrinth lab = Labyrinth.getInstance();
        lab.setLabyrinthGraph(labyrinth);
        SimpleGraph<?, ?> returnLabyrinth = lab.getLabyrinthGraph();
        
        assertEquals(labyrinth, returnLabyrinth);
    }
}