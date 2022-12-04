import model.Card;

import java.util.ArrayList;
import java.util.List;

public interface DrawAndShuffleStrategy {
    List<Card> drawAndDiscardUsingStrategy(List<Card> drawPile, List<Card> discardPile, List<Card> discardedCards);

    default List<Card> drawAndDiscardNormally(List<Card> drawPile, List<Card> discardPile, List<Card> discardedCards) {
        discardPile.addAll(discardedCards);
        List<Card> drawnCards = new ArrayList<>(drawPile.subList(drawPile.size() - discardedCards.size(), drawPile.size()));
        drawPile.subList(drawPile.size() - discardedCards.size(), drawPile.size()).clear();
        return drawnCards;
    }
}
