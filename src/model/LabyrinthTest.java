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
    public void testisClosed() {
        Labyrinth lab = Labyrinth.getInstance();
        Vertex v1 = new Vertex(0,0);
        assertTrue(lab.isClosed(v1, EAST));
        //lab.addVertex

    }

    @org.junit.Test
    public void testisOpened() {
        Labyrinth lab = Labyrinth.getInstance();
        Vertex v1 = new Vertex(0,0);
        assertTrue(lab.isOpened(v1, EAST));
    }

    @org.junit.Test
    public void testisClosedDoor() {
        Labyrinth lab = Labyrinth.getInstance();
        Vertex v1 = new Vertex(0,0);
        assertTrue(lab.isClosedDoor(v1, EAST));
    }

    @org.junit.Test
    public void testisOpenedDoor() {
        Labyrinth lab = Labyrinth.getInstance();
        Vertex v1 = new Vertex(0,0);
        assertTrue(lab.isOpenedDoor(v1, EAST));
    }
}