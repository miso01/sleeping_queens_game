import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerState {

    private final int playerIndex;
    private final Map<HandPosition, Card> cards;
    private final Map<AwokenQueenPosition, Queen> awokenQueens;

    public PlayerState(int playerIndex, List<Card> cards, Map<AwokenQueenPosition, Queen> awokenQueens) {
        this.playerIndex = playerIndex;
        this.awokenQueens = awokenQueens;
        this.cards = new HashMap<>();
        for (int i = 0; i < cards.size(); i++) {
            this.cards.put(new HandPosition(i, playerIndex), cards.get(i));
        }
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public Map<HandPosition, Card> getCards() {
        return cards;
    }

    public Map<AwokenQueenPosition, Queen> getAwokenQueens() {
        return awokenQueens;
    }

}
