package model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.jgrapht.EdgeFactory;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import static model.Labyrinth.Directions.*;
import static org.junit.Assert.*;

public class LabyrinthTest extends TestCase {

    @org.junit.Test
    public void testIsClosed() {
        Labyrinth lab = Labyrinth.getInstance();
        Vertex v1 = new Vertex(0,0);
        assertTrue(lab.isClosed(v1, EAST));
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

    public void testIsWall() {
        Labyrinth lab = Labyrinth.getInstance();
        Vertex v1 = new Vertex(0,0);
        assertTrue(lab.isWall(v1, EAST));
    }

    public void testAreVerticesConnected() {
        Labyrinth lab = Labyrinth.getInstance();
        lab.areVerticesConnected(1,0,1,1);
    }
}