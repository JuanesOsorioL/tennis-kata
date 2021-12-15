
public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        if (menorACuatro(p1 , p2)) {
            return marcador(p1 , p2);
        } else {
            if (sonIguales(p1 , p2))
                return "Deuce";
            return resultado(p1 , p2);
        }
    }

    public String resultado(int p1,int p2) {
        String s = jugador(p1 , p2);
        return (resta(p1 , p2)*resta(p1 , p2) == 1) ? "Advantage " + s : "Win for " + s;
    }

    public int resta(int p1,int p2) {
        return p1-p2;
    }

    public String jugador(int p1,int p2) {
        return p1 > p2 ? p1N : p2N;
    }

    public String marcador(int p1,int p2) {
        return sonIguales(p1 , p2) ? p[p1] + "-All" : p[p1] + "-" + p[p2];
    }

    public Boolean menorACuatro(int p1,int p2) {
        return p1 < 4 && p2 < 4 && !maxJuegos(p1,p2);
    }

    public Boolean maxJuegos(int p1,int p2) {
        return (p1 + p2 == 6);
    }

    public Boolean sonIguales(int p1,int p2) {
        return p1 == p2;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
    }

}
