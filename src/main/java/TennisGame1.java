

public class TennisGame1 implements TennisGame {

    private int score1 = 0;
    private int score2 = 0;
    private  final String  player1Name;
    private  final String player2Name;

    private static final String[] diferenteScore = {"Love", "Fifteen", "Thirty", "Forty"};
    private static final String[] scores = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
    private static final String[] result = {"Advantage player1", "Win for player1", "Advantage player2", "Win for player2"};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            score1 += 1;
        else
            score2 += 1;
    }

    public String getScore() {
        String score;

        if (score1 == score2)
        {
            score=igualScore(score1);
        }
        else if (score1 >=4 || score2 >=4)
        {
           score =minimoDeSets(score1,score2);
        }
        else
        {
         score = diferenteScore[score1].concat("-").concat(diferenteScore[score2]);
        }
        return score;
    }

    public String igualScore(int score) {
        return score >= 3 ? scores[3] : scores[score];
    }

    public String posibleGanador(int minusResult) {
        return minusResult==1?result[0]:result[2];
    }

    public String ganador(int minusResult) {
        return minusResult>=2?result[1]:result[3];
    }

    public String minimoDeSets(int score1,int score2) {
        int minusResult = score1 - score2;
        switch (minusResult){
            case -1:
                case 1: return posibleGanador(minusResult);
            default:
                return ganador(minusResult);
        }
    }
}
