import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class GameState {
    private int numberOfPlayers;
    private int onTurn;
    private Set<SleepingQueens> sleepingQueens;
    private Map<HandPosition, Optional<Card>> cards;
    private Map<AwokenQueenPosition, Queen>  awokenQueens;
    private List<Card> cardsDiscardedLastTurn;
}
