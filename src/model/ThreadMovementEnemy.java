package model;

import view.MonsterView;


import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadMovementEnemy extends TimerTask {

    Enemy enemy;
    MonsterView monsterView;
    Labyrinth labyrinth;
    Player player;

    boolean alive = true;

    public ThreadMovementEnemy(Labyrinth labyrinth, Element enemy, MonsterView monsterView, Player player) {
        this.enemy = (Enemy)enemy;
        this.monsterView = monsterView;
        this.labyrinth = labyrinth;
        this.player = player;
    }

    public void run() {
        /*int coordX = ThreadLocalRandom.current().nextInt(0, 16);
        int coordY = ThreadLocalRandom.current().nextInt(0, 16);
        ((Enemy) enemy).moves(coordX, coordY);
        monsterView.updatePosition(coordX, coordY);
        System.out.println(coordX + " " + coordY);
        */

        labyrinth.launchManhattan(new Vertex(enemy.getX(), enemy.getY()), new Vertex(player.getX(), player.getY()));
        moveManhattan();
        monsterView.updatePosition(enemy.getX(), enemy.getY());
    }

    public void setIsAlive(boolean state) {
        this.alive = state;
    }


    public void moveManhattan() {
        Enemy e = (Enemy)enemy;
        Vertex vertex = labyrinth.getVertex(enemy.getX(), enemy.getY());
        for (Labyrinth.Directions dir : Labyrinth.Directions.values()) {
            Vertex next = labyrinth.getVertexByDir(vertex, dir);
            if (next == null)
                continue;
            if (labyrinth.areVerticesConnected(vertex.getX(),vertex.getY(), next.getX(), next.getY()) && (next.getNbr() == vertex.getNbr() - 1)) {
                if (dir == Labyrinth.Directions.SOUTH)
                    e.moves(e.getX(), e.getY() - 1);
                if (dir == Labyrinth.Directions.NORTH)
                    e.moves(e.getX(), e.getY() + 1);
                if (dir == Labyrinth.Directions.WEST)
                    e.moves(e.getX() - 1, e.getY() );
                if (dir == Labyrinth.Directions.EAST)
                    e.moves(e.getX() + 1, e.getY() );
            }
        }
    }

}
