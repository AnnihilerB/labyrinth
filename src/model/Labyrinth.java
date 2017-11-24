package model;

import java.util.concurrent.ThreadLocalRandom;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class Labyrinth {
	private final static int NORTH = 0;
	private final static int EAST = 1;
	private final static int SOUTH = 2;
	private final static int WEST = 3;
	
	private final static int NORTH_BORDER = 0;
	private final static int EAST_BORDER = 15;
	private final static int SOUTH_BORDER = 15;
	private final static int WEST_BORDER = 0;
	
	private static Labyrinth instance = new Labyrinth();
	
	private SimpleGraph<Vertex, String> labyrinth;

	//Constructeur privé (singleton design pattern)
	private Labyrinth() {
		labyrinth = new SimpleGraph(DefaultEdge.class);
		
		/*for (int i=0; i<16; i++)
			for (int j=0; j<16; j++)
				labyrinth.addVertex(new Cellule(i, j));*/
		
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
				case NORTH:
					if (!(labyrinth.containsVertex(new Vertex(x, y-1))) && y > NORTH_BORDER)
						newVertex = new Vertex(x, y-1);
					break;
					
				case EAST:
					if (!(labyrinth.containsVertex(new Vertex(x+1, y))) && x < EAST_BORDER)
						newVertex = new Vertex(x+1, y);
					break;
					
				case SOUTH:
					if (!(labyrinth.containsVertex(new Vertex(x, y+1))) && y < SOUTH_BORDER)
						newVertex = new Vertex(x, y+1);
					break;

					
				case WEST:
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
	
	public static Labyrinth getInstance() {
		return instance;
	}
	
	@Override
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
		
}
