import model.Vertex;

import java.util.ArrayDeque;
import java.util.Queue;packagemodel;

public class Labyrinth {


    private void calculateManhattanDistance(Vertex source, Vertex target) {
        Queue<Vertex> fifo = new ArrayDeque<Vertex>();
        target.setNbr(1);
        fifo.add(target);
        while (!fifo.isEmpty()) {
            Vertex actual = fifo.remove();
            for (Directions dir : Directions.values()) {
                if (this.isOpened(actual, dir)) {
                    Vertex next = graph.getVertexByDir(actual, dir);
                    if (next.getNbr() == 0) {
                        next.setNbr(actual.getNbr() + 1);
                        if (next != source)
                            fifo.add(next);
                    }
                }
            }
        }
    }

    public void launchManhattan(Vertex source, Vertex target) {
        for (Vertexvertex:
             graph.vertexSet())
            vertex.setNbr(0);
        calculateManhattanDistance(source, target);
    }
}