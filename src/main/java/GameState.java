import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class GameState {
    private final int numberOfPlayers;
    private int onTurn;
    private final Set<SleepingQueens> sleepingQueens;
    private Map<HandPosition, Optional<Card>> cards;
    private Map<AwokenQueenPosition, Queen> awokenQueens;
    private List<Card> cardsDiscardedLastTurn;

    public GameState(int numberOfPlayers, int onTurn, Set<SleepingQueens> sleepingQueens, Map<HandPosition, Optional<Card>> cards, Map<AwokenQueenPosition, Queen> awokenQueens, List<Card> cardsDiscardedLastTurn) {
        this.numberOfPlayers = numberOfPlayers;
        this.onTurn = onTurn;
        this.sleepingQueens = sleepingQueens;
        this.cards = cards;
        this.awokenQueens = awokenQueens;
        this.cardsDiscardedLastTurn = cardsDiscardedLastTurn;
    }

    public void setOnTurn(int onTurn) {
        this.onTurn = onTurn;
    }


}
