import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Hand {

    private final int playerIndex;
    private final List<Card> cards;

    public Hand(int playerIndex, List<Card> cards) {
        this.playerIndex = playerIndex;
        this.cards = cards;
    }

    Optional<List<Card>> pickCards(List<HandPosition> positions){
        return Optional.empty();
    }

    Map<HandPosition,Card> removePickedCardsAndRedraw(){
        return null;
    }


}
