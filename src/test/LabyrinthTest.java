package test;

import model.Edge;
import model.Labyrinth;
import model.Vertex;
import org.junit.Assert;
import static model.Labyrinth.Directions.*;

import org.jgrapht.graph.SimpleGraph;


/**
 * JUnit test class for the Labyrinth class.
 * We need attributes here because we will have to generate a small Labyrinth
 * so we can verify if the tests return expected answers.
 * 
 * @author Pierre Lorson
 */

public class LabyrinthTest {
    static SimpleGraph<Vertex, Edge> graph;
	static Labyrinth labyrinth;
	static Vertex vertex00;
	static Vertex vertex01;
	static Vertex vertex10;
	static Vertex vertex11;

    /**
     * Generate a small, known Labyrinth before all tests so we can guess
     * what results we should have.
     */

    @org.junit.BeforeClass
    public static void generateLabyrinth() {
        graph = new SimpleGraph(Edge.class);
    	labyrinth = Labyrinth.getInstance();
    	
    	vertex00 = new Vertex(0,0);
    	vertex01 = new Vertex(0,1);
    	vertex10 = new Vertex(1,0);
    	vertex11 = new Vertex(1,1);
    	
		graph.addVertex(vertex00);
        graph.addVertex(vertex01);
        graph.addVertex(vertex10);
        graph.addVertex(vertex11);

        graph.addEdge(vertex00, vertex01);
        graph.addEdge(vertex01, vertex11);
        graph.addEdge(vertex11, vertex10);

        labyrinth.setLabyrinthGraph(graph);
	}

    /**
     * Checks if isClosed is working correctly :
     * the assertion should be true.
     */
    @org.junit.Test
    public void testIsClosed() {
        Assert.assertTrue(labyrinth.isClosed(vertex00, EAST));

    }

    /**
     * Checks if isOpened is working correctly :
     * the assertion should be true.
     */
    @org.junit.Test
    public void testIsOpened() {
        Assert.assertTrue(labyrinth.isOpened(vertex00, NORTH));
    }

    /**
     * Checks if isWall is working correctly :
     * the assertion should be true.
     */
    @org.junit.Test
    public void testIsWall() {
        Assert.assertTrue(labyrinth.isWall(vertex00, EAST));
    }

    /**
     * Checks if areVerticesConnected is working correctly :
     * The assertion should be true
     */
    @org.junit.Test
    public void testAreVerticesConnected() {
        Assert.assertTrue(labyrinth.areVerticesConnected(1,0,1,1));
    }

    /**
     * Checks if the Singleton is working correctly :
     * The two assertions should return true.
     */
    @org.junit.Test
    public void testGetInstance() {

        Labyrinth lab = Labyrinth.getInstance();
        Assert.assertNotNull(lab);
        Assert.assertTrue(lab instanceof Labyrinth);
    }
}