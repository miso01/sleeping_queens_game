import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PlayerState {

    //private final Map<Integer, Optional<Card>> cards;
    private final Map<Integer, Optional<AwokenQueenPosition>> awokenQueens;

    public PlayerState(List<Card> cards, Map<Integer, Optional<AwokenQueenPosition>> awokenQueens) {
        Map<Integer, Optional<Card>> cardMap;
        //this.cards = cards;
        this.awokenQueens = awokenQueens;
    }

}
