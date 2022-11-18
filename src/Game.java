import java.util.ArrayList;
import java.util.List;

public class Game {

    private DrawAndDiscardPile piles;
    private SleepingQueens sleepingQueens;
    private List<Player> players;

    public Game(int numOfPlayers) {
        piles = new DrawAndDiscardPile();
        sleepingQueens = new SleepingQueens();
        players = new ArrayList<>();
        for(int i = 0; i < numOfPlayers; i++) {
            players.add(new Player());
        }
    }




}
