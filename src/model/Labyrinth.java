package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.jgrapht.EdgeFactory;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

/**
 * Create the graph using SimpleGraph. Also contains all the required
 * methods to check what contains the labyrinth as well as the Manhattan algorithm.
 *  *
 * @author 			Teiki Pepin, Pierre Lorson
 */


public class Labyrinth {

	public enum Directions {
		NORTH,
		EAST,
		SOUTH,
		WEST,
	}

	private final static int NORTH_BORDER = 0;
	private final static int EAST_BORDER = 15;
	private final static int SOUTH_BORDER = 15;
	private final static int WEST_BORDER = 0;

	private static Labyrinth instance = new Labyrinth();

	private SimpleGraph<Vertex, Edge> labyrinth;


	/**
	 * Create a Labyrinth. Warning : as we're using the Singleton design pattern,
	 * this method should not be called directly. Use getInstance instead.
	 */
	//Constructeur privé (singleton design pattern)
	private Labyrinth() {
		labyrinth = new SimpleGraph(Edge.class);

		Vertex startingCell = new Vertex();
		labyrinth.addVertex(startingCell);

		buildLabyrinth(startingCell);
	}


	private void buildLabyrinth(Vertex vertex) {
		int x = vertex.getX();
		int y = vertex.getY();

		int[] ordre = new int[4];

		ordre[0] = ThreadLocalRandom.current().nextInt(0, 4);

		do {
			ordre[1] = ThreadLocalRandom.current().nextInt(0, 4);
		} while (ordre[1] == ordre[0]);

		do {
			ordre[2] = ThreadLocalRandom.current().nextInt(0, 4);
		} while (ordre[2] == ordre[0] || ordre[2] == ordre[1]);

		do {
			ordre[3] = ThreadLocalRandom.current().nextInt(0, 4);
		} while (ordre[3] == ordre[0] || ordre[3] == ordre[1] || ordre[3] == ordre[2]);


		for (int i=0; i<4; i++) {
			Vertex newVertex = null;

			switch (ordre[i]) {
				case 0:
					if (!(labyrinth.containsVertex(new Vertex(x, y-1))) && y > NORTH_BORDER)
						newVertex = new Vertex(x, y-1);
					break;

				case 1:
					if (!(labyrinth.containsVertex(new Vertex(x+1, y))) && x < EAST_BORDER)
						newVertex = new Vertex(x+1, y);
					break;

				case 2:
					if (!(labyrinth.containsVertex(new Vertex(x, y+1))) && y < SOUTH_BORDER)
						newVertex = new Vertex(x, y+1);
					break;

				case 3:
					if (!(labyrinth.containsVertex(new Vertex(x-1, y))) && x > WEST_BORDER)
						newVertex = new Vertex(x-1, y);
					break;

				default:
					System.out.println("Error in model.Labyrinth.buildLabyrinth in switch.");
					break;
			}

			if (newVertex != null) {
				labyrinth.addVertex(newVertex);
				labyrinth.addEdge(vertex, newVertex);
				buildLabyrinth(newVertex);
			}
		}
	}

	/**
	 * Get a vertex from the vertices set
	 * @param x Horizontal axis
	 * @param y Vertical axis
	 * @return The desired vertex.
	 */
    public model.Vertex getVertex(int x, int y) {
        Set<Vertex> setVertex = labyrinth.vertexSet();
        for (Vertex vertex : setVertex) {
            if (vertex.getX() == x && vertex.getY() == y)
                return vertex;
        }
        return null;
    }

	/**
	 * Calculate the Manhattan distance using the Manhattan algorithm
	 * between two vertices.
	 * Should not be called. Use launchManhattan instead.
	 * @param source Starting vertex.
	 * @param target Goal vertex.
	 */
    private void calculateManhattanDistance(Vertex source, Vertex target) {
        Queue<Vertex> fifo = new ArrayDeque<Vertex>();
        target.setNbr(1);
        fifo.add(target);
        while (!fifo.isEmpty()) {
            Vertex actual = fifo.remove();
            for (Directions dir : Directions.values()) {
                if (this.isOpened(actual, dir)) {
                    Vertex next = getVertexByDir(actual, dir);
                    if (next.getNbr() == 0) {
                        next.setNbr(actual.getNbr()+1);
                        if (next != source)
                            fifo.add(next);
                    }
                }
            }
        }
    }

	/**
	 * Calculate the Manhattan distance using the Manhattan algorithm implemented
	 * in the calculateManhattanDistance algorithm.
	 * @param source Starting vertex.
	 * @param target Goal vertex.
	 */
    public void launchManhattan(Vertex source, Vertex target) {
        for (Vertex vertex : labyrinth.vertexSet())
            vertex.setNbr(0);

        calculateManhattanDistance(source, target);
    }

	/**
	 * Check if there is a wall at the specified direction.
	 * @param vertex Checked vertex.
	 * @param dir Checked direction.
	 * @return A boolean.
	 */

	public boolean isWall(Vertex vertex,Directions dir) {
		Vertex dest = getVertexByDir(vertex, dir);
		Edge edge=labyrinth.getEdge(vertex,dest);
		return (edge==null);
	}

	/** Check if the player can go at the specified direction or if
	 * something is blocking the way.
	 * @param vertex Starting vertex.
	 * @param dir Checked direction.
	 * @return A boolean.
	 */
	public boolean isClosed(Vertex vertex,Directions dir){
		Vertex dest = getVertexByDir(vertex, dir);
		Edge edge=labyrinth.getEdge(vertex,dest);
		return (edge==null || (edge.getType()==Edge.Type.CLOSED_DOOR));
	}

	/** Check if the player can go at the specified direction or if
	 * something is blocking the way.
	 * @param vertex Starting vertex.
	 * @param dir Checked direction.
	 * @return A boolean.
	 */
	public boolean isOpened(Vertex vertex,Directions dir){
		Vertex dest = getVertexByDir(vertex,dir);
		Edge edge=labyrinth.getEdge(vertex,dest);
		return ((edge!=null)&&((edge.getType()!=Edge.Type.CLOSED_DOOR)));
	}

	/** Check if there is a closed door at the specified direction.
	 * @param vertex Starting vertex.
	 * @param dir Checked direction.
	 * @return A boolean.
	 */
	public boolean isClosedDoor(Vertex vertex,Directions dir){
		Vertex dest = getVertexByDir(vertex, dir);
		Edge edge=labyrinth.getEdge(vertex,dest);
		return(edge!=null&&edge.getType()==Edge.Type.CLOSED_DOOR);
	}

	/** Check if there is a opened door at the specified direction.
	 * @param vertex Starting vertex.
	 * @param dir Checked direction.
	 * @return A boolean.
	 */
	public boolean isOpenedDoor(Vertex vertex,Directions dir){
		Vertex dest = getVertexByDir (vertex, dir);
		Edge edge=labyrinth.getEdge(vertex,dest);
		return ((edge!=null)&&((edge.getType()==Edge.Type.OPENED_DOOR)));
	}

	/** Get the vertex localized at the specified direction from the actual vertex
	 * and return it.
	 * @param vertex Actual Vertex
	 * @param dir Direction from the actual vertex.
	 * @return The desired vertex.
	 */
	private Vertex getVertexByDir(Vertex vertex, Directions dir){
		Vertex newvertex = null;
		switch (dir){
			case NORTH:
				newvertex = getVertex(vertex.getX(),vertex.getY()-1);
				break;
			case SOUTH:
				newvertex = getVertex(vertex.getX(),vertex.getY()+1);
				break;
			case EAST:
				newvertex = getVertex(vertex.getX()+1,vertex.getY());
				break;
			case WEST:
				newvertex = getVertex(vertex.getX()-1,vertex.getY());
				break;
		}
		return newvertex;
	}


	/** Get an instance of the object Labyrinth.
	 * Needed because we are using the Singleton Design Pattern.
	 * @return An instance of Labyrinth.
	 */
	public static Labyrinth getInstance() {
		return instance;
	}

	@Override
	/** Write a String version of the content of the labyrinth.
	 */
	public String toString() {
		return labyrinth.toString();
	}

	//Affichage basique temporaire pour tests
	public void printLabyrinth() {
		for (int i=NORTH_BORDER; i<=SOUTH_BORDER; i++) {

			for (int j=WEST_BORDER; j<=EAST_BORDER; j++) {
				if(labyrinth.containsEdge(new Vertex(i, j), new Vertex(i-1, j)))
					System.out.print("|");

				else
					System.out.print(" ");

				System.out.print("  ");
			}

			System.out.println();



			for (int j=WEST_BORDER; j<=EAST_BORDER; j++) {
				System.out.print("o");

				if(labyrinth.containsEdge(new Vertex(i, j), new Vertex(i, j+1)))
					System.out.print("--");

				else
					System.out.print("  ");
			}

			System.out.println();
		}
	}

	/**
	 * Check if two vertices are connected by verifying if the labyrinth
	 * contains a edge between them.
	 * @param xs Horizontal localisation of the source vertex.
	 * @param ys Vertical localisation of the source vertex
	 * @param xt Horizontal localisation of the target vertex.
	 * @param yt Vertical localisation of the target vertex.
	 * @return A boolean.
	 */
	public boolean areVerticesConnected(int xs, int ys, int xt, int yt) {
		return labyrinth.containsEdge(new Vertex(xs, ys), new Vertex(xt, yt));
	}

	/** Return the set of vertices contained in the labyrinth.
	 * @return a vertex set.
	 */
	public Set<Vertex> getVertices() {
		return labyrinth.vertexSet();
	}

	/** Return the set of edges contained in the labyrinth.
	 * @return a edge set.
	 */
	public Set<Edge> getPaths() {
		return labyrinth.edgeSet();
	}

	/** Return all the walls contained in the labyrinth.
	 * @return a vertex set.
	 */
	public Set<List<Vertex>> getWalls() {
		Set<List<Vertex>> walls = new HashSet<List<Vertex>>();

		for (int y = NORTH_BORDER; y <= SOUTH_BORDER; y++) {
			for (int x = WEST_BORDER; x <= EAST_BORDER; x++) {
				Vertex currentCell = new Vertex(x, y);
				Vertex eastCell = new Vertex(x, y+1);
				Vertex southCell = new Vertex(x+1, y);

				if (labyrinth.containsVertex(southCell) && !labyrinth.containsEdge(currentCell, southCell))
					walls.add(Arrays.asList(currentCell, southCell));

				if (labyrinth.containsVertex(eastCell) && !labyrinth.containsEdge(currentCell, eastCell))
					walls.add(Arrays.asList(currentCell, eastCell));
			}
		}

		return walls;
	}

    public void openDoorRandom(){
        //On essaie 1000 fois, après quoi on renonce
        for (int i=1 ; i<=1000 ; ++i){
            //On choisit un sommet au hasard
            Vertex vertex = randomVertex();
            if (vertex!=null){
                //On choisit une direction au hasard(on devrait prendre seulement
                //celles qui correspondent à des murs...)
                Labyrinth.Directions dir= Directions.values()[ThreadLocalRandom.current().nextInt(Directions.values().length)];
                if (isWall(vertex,dir)){
                    Vertex vertex2 = getVertexByDir(vertex,dir);
                    if(vertex2!=null){
                        Edge edge=labyrinth.getEdge(vertex,vertex2);
                        if(edge==null){
                            //On ajoute un saut entre ces sommets
                            labyrinth.addEdge(vertex,vertex2);
                            return;
                        }
                    }
                }
            }
        }
    }

	/**
	 * Get a random vertex and returns it.
	 * @return a randon vertex.
	 */
	private Vertex randomVertex(){
        int x = ThreadLocalRandom.current().nextInt(WEST_BORDER, EAST_BORDER+1);
        int y = ThreadLocalRandom.current().nextInt(NORTH_BORDER,SOUTH_BORDER+1);
        return new Vertex(x,y);
    }

	/**
	 * A setter used in the JUnit tests. We need it because we're using a Singleton design pattern
	 * for the Labyrinth.
	 * @param graph a SimpleGraph to be injected in the Labyrinth.
	 */
	public void setLabyrinthGraph(SimpleGraph<Vertex, Edge> graph) {
        this.labyrinth = graph;
    }

	/**
	 * Create and replace a all new instance of a Labyrinth object.
	 */
    public void reset(){
        instance = new Labyrinth();
    }

}
