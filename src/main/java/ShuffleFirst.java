import model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*** If there is not enough cards to draw, it shuffles discard pile and puts it at the bottom of
 * draw pile. Then player draws. ***/
public class ShuffleFirst implements DrawAndShuffleStrategy {

    @Override
    public List<Card> drawAndDiscardUsingStrategy(List<Card> drawPile, List<Card> discardPile, List<Card> discardedCards) {
        if (discardedCards.size() > drawPile.size()) {
            Collections.shuffle(discardPile);
            List<Card> tmp = new ArrayList<>(drawPile);
            drawPile.clear();
            drawPile.addAll(discardPile);
            discardPile.addAll(tmp);
            discardPile.clear();
        }
        return drawAndDiscardNormally(drawPile, discardPile, discardedCards);
    }

}
