package model;

public class Score {
    private static Score score = null;

    private int totalScore;

    private Score(){

    }

    public static Score getInstance(){
        if (score == null)
            score = new Score();
        return score;

    }

    public void incrementScore(){
        totalScore +=10;
    }

    public int getTotalScore(){
        return totalScore;
    }

}
