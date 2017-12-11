package view;


import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ScoreView {

    private static ScoreView instance = null;
    private static Label score;

    private ScoreView() {	
    	score = new Label();
    }

    public static ScoreView getInstance() {
        if (instance == null)
        	instance = new ScoreView();
        
        return instance;
    }

    public void createScoreView(Pane pane) {
	    updateScore(0);

	    score.relocate(680, 0);
        pane.getChildren().add(score);
    }
    
    public void updateScore(int score) {
    	ScoreView.score.setText(Integer.toString(score));
    }
    
    
}
