package ohtu;

public class TennisGame {
    
    private int scoreOne = 0;
    private int scoreTwo = 0;
    private String playerOne;
    private String playerTwo;

    public TennisGame(String playerOne, String playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void wonPoint(String playerName) {
        if (playerOne.equals(playerName))
            scoreOne += 1;
        else
            scoreTwo += 1;
    }

    public String pointsToScore(int score) {
        switch (score) {
            case 0:
                return "Love";                
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";               
            case 3:
                return "Forty";
            default:
                return "Deuce";                                
        }        
    }        
    
    public String scoreIfOverFour(int difference) {                
        if (difference == 1) {
            return "Advantage " + playerOne;
        } else if (difference == -1) {
            return "Advantage " + playerTwo;
        } else if (difference >= 2) {
            return "Win for " + playerOne;
        } else {
            return "Win for " + playerTwo;
        }
    }        
    
    public String getScore() {                
        if (scoreOne == scoreTwo) {
            String score = pointsToScore(scoreOne);
            if (!score.equals("Deuce")) {
                score += "-All";
            }
            return score;
        } else if (scoreOne >= 4 || scoreTwo >= 4) {
            return scoreIfOverFour(scoreOne - scoreTwo);
        } else {
            return pointsToScore(scoreOne) + "-" + pointsToScore(scoreTwo);
        }        
    }
}