import model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*** Draws only available amount of cards from drawing pile, reshuffles discard pile and then draws remaining. ***/
public class DrawFirst implements IDrawAndShuffleStrategy {

    @Override
    public List<Card> drawAndDiscardUsingStrategy(List<Card> drawPile, List<Card> discardPile, List<Card> discardedCards) {
        List<Card> drawnCards = new ArrayList<>();
        if (discardedCards.size() > drawPile.size()) {
            int drawPileSize = drawPile.size();
            drawnCards.addAll(drawAndDiscardNormally(drawPile, discardPile, discardedCards.subList(0, drawPileSize)));
            Collections.shuffle(discardPile);
            drawPile.addAll(discardPile);
            discardPile.clear();
            drawnCards.addAll(drawAndDiscardNormally(drawPile, discardPile, discardedCards.subList(drawPileSize, discardedCards.size())));
            return drawnCards;
        }
        return drawAndDiscardNormally(drawPile, discardPile, discardedCards);
    }

}
