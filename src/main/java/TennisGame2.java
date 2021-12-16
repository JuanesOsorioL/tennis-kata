
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;
    public String score = "";

    private static final String[] diferenteScore = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String Love (int P1point){
         return isMenor(P1point, 4) ? diferenteScore[P1point]:"";
    }

    public String all (int P1point){
        String valor = isMenor(P1point, 3) ? diferenteScore[P1point]:"";
        return valor.concat("-All");
    }

    public String result1 (int P1point,int P2point){
        if (isIgual(P1point, 2))
            P1res="Thirty";
        if (isIgual(P1point, 3))
            P1res="Forty";
        if (isIgual(P2point, 1))
            P2res="Fifteen";
        if (isIgual(P2point, 2))
            P2res="Thirty";
        return P1res + "-" + P2res;
    }

    public String result2 (int P2point,int P1point){
        if (isIgual(P2point, 2))
            P2res="Thirty";
        if (isIgual(P2point, 3))
            P2res="Forty";
        if (isIgual(P1point, 1))
            P1res="Fifteen";
        if (isIgual(P1point, 2))
            P1res="Thirty";
        return P1res + "-" + P2res;
    }

    public String getScore(){

        if (isIgual(P1point, P2point) && isMenor(P1point, 4))
        {
            score=all(P1point);
        }

        if (isIgual(P1point, P2point) && isMayorIgual(P1point, 3))
            score = "Deuce";


        if (isMayor(P1point, 0) && isIgual(P2point, 0))
        {
            P1res=Love(P1point);
            P2res = "Love";
            score = P1res + "-" + P2res;
        }

        if (isMayor(P2point, 0) && isIgual(P1point, 0))
        {
            P2res=Love(P2point);
            P1res = "Love";
            score = P1res + "-" + P2res;

        }

        playSets( P1point, P2point);

        Advantage( P1point, P2point);

        win( P1point, P2point);

        return score;
    }

    private void playSets(int P1point, int P2point) {
        if (isMayor(P1point, P2point) && isMenor(P1point, 4))
        {
            score=result1(P1point, P2point);
        }

        if (isMayor(P2point, P1point) && isMenor(P2point, 4))
        {
            score =result2(P2point,P1point);
        }
    }

//////

    private void Advantage(int P1point, int P2point) {
        if (isAdvantage(P1point, P2point))
        {
            resultAdvantageOrWin("Advantage ", player1Name);
        }
        if (isAdvantage(P2point, P1point))
        {
            resultAdvantageOrWin("Advantage ", player2Name);
        }
    }

    private String resultAdvantageOrWin(String s, String player1Name) {
        return score = s.concat(player1Name);
    }

    private void win(int P1point, int P2point) {
        if (isWin(P1point, P2point))
        {
            resultAdvantageOrWin("Win for ", player1Name);
        }
        if (isWin(P2point, P1point))
        {
            resultAdvantageOrWin("Win for ", player2Name);
        }
    }

    //////

    private boolean isWin(int p1point, int p2point) {
        return isMayorIgual(p1point, 4) && isMayorIgual(p2point, 0) && isMayorIgual(p1point - p2point, 2);
    }

    private boolean isAdvantage(int p1point, int p2point) {
        return isMayor(p1point, p2point) && isMayorIgual(p2point, 3);
    }

    private boolean isMayorIgual(int p1point, int i) {
        return p1point >= i;
    }

    private boolean isMayor(int p1point, int i) {
        return p1point > i;
    }

    private boolean isMenor(int p1point, int i) {
        return p1point < i;
    }

    private boolean isIgual(int p1point, int p2point) {
        return p1point == p2point;
    }

    public void SetP1Score(int number){
        for (int i = 0; isMenor(i, number); i++)
        {
            P1Score();
        }
    }
    
    public void SetP2Score(int number){
        for (int i = 0; isMenor(i, number); i++)
        {
            P2Score();
        }
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}