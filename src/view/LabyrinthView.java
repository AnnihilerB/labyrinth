package view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class LabyrinthView {

    private static LabyrinthView labyrinthView = null;

    private LabyrinthView(){

    }

    static final int SPAN = 4;
    static final int WALL = 2;
    static final int CELL = 9;
    public static final Paint WALL_COLOR = Color.BURLYWOOD;

    static Scene scene;
    static Pane pane = new Pane();

    public static LabyrinthView getInstance(){
        if (labyrinthView == null)
            labyrinthView = new LabyrinthView();
        return labyrinthView;
    }


    public static void drawFrame(Stage stage, int nbrX, int nbrY) {
        int width = ((WALL + CELL) * nbrX + WALL) * SPAN;
        int height = ((WALL + CELL) * nbrY + WALL) * SPAN;
        scene = new Scene(pane, width, height);

        Rectangle square;
        stage.setScene(scene);

        square = new Rectangle(0, 0,
                SPAN * (nbrX * (CELL + WALL) + WALL),
                WALL * SPAN);
        square.setFill(WALL_COLOR);
        pane.getChildren().add(square);

        square = new Rectangle(0, SPAN * (nbrY * (CELL + WALL)),
                SPAN * (nbrX * (CELL + WALL) + WALL),
                WALL * SPAN);
        square.setFill(WALL_COLOR);
        pane.getChildren().add(square);

        square = new Rectangle(0, 0,
                WALL * SPAN,
                SPAN * (nbrY * (CELL + WALL) + WALL));
        square.setFill(WALL_COLOR);
        pane.getChildren().add(square);

        square = new Rectangle(SPAN * (nbrX * (CELL + WALL)), 0,
                WALL * SPAN,
                SPAN * (nbrY * (CELL + WALL) + WALL));
        square.setFill(WALL_COLOR);
        pane.getChildren().add(square);

        for (int x = 0; x < nbrX - 1; ++x) {
            int offsetX = ((WALL + CELL) + (WALL + CELL) * x) * SPAN;
            for (int y = 0; y < nbrY - 1; ++y) {
                int offsetY = ((WALL + CELL) + (WALL + CELL) * y) * SPAN;
                square = new Rectangle(offsetX, offsetY, WALL * SPAN, WALL * SPAN);
                square.setFill(WALL_COLOR);
                pane.getChildren().add(square);

            }
        }

    }

    public static void drawWall(int xs, int ys, int xt, int yt, Paint color) {
        int x = 0, y = 0, xspan = 0, yspan = 0;
        if (ys == yt) {
            x = ((WALL + CELL) + (WALL + CELL)*((int) (xs + xt) / 2))*SPAN;
            y = (WALL + ys*(WALL + CELL))*SPAN;
            xspan = WALL*SPAN;
            yspan = CELL*SPAN;
            Rectangle square = new Rectangle(x, y, xspan, yspan);
            square.setFill(color);
            pane.getChildren().add(square);
        } else if (xs == xt) {
            x = (WALL + xs*(WALL + CELL))*SPAN;
            y = ((WALL + CELL) + (WALL + CELL)*((int) (ys + yt) / 2))*SPAN;
            ;
            xspan = CELL*SPAN;
            yspan = WALL*SPAN;
            Rectangle square = new Rectangle(x, y, xspan, yspan);
            square.setFill(color);
            pane.getChildren().add(square);
        }
    }
}
