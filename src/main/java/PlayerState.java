import java.util.Map;

public class PlayerState {

    private final int playerIndex;
    private final Map<HandPosition, Card> cards;
    private final Map<AwokenQueenPosition, Queen> awokenQueens;

    public PlayerState(int playerIndex, Map<HandPosition, Card> cards, Map<AwokenQueenPosition, Queen> awokenQueens) {
        this.playerIndex = playerIndex;
        this.awokenQueens = awokenQueens;
        this.cards = cards;
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
