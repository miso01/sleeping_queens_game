import model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawAndDiscardPile {

    private final List<Card> drawPile;
    private final List<Card> discardPile;
    private final List<Card> lastDiscarded;
    private DrawAndShuffleStrategy drawAndShuffleStrategy;

    public DrawAndDiscardPile(List<Card> drawPile, List<Card> discardPile) {
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.lastDiscarded = new ArrayList<>();
        this.drawAndShuffleStrategy = new ShuffleFirst();
    }

    public DrawAndDiscardPile(List<Card> drawPile, List<Card> discardPile, DrawAndShuffleStrategy drawAndShuffleStrategy){
        this(drawPile,discardPile);
        this.drawAndShuffleStrategy = drawAndShuffleStrategy;
    }

    public List<Card> discardAndDraw(List<Card> discardedCards) {
        lastDiscarded.clear();
        lastDiscarded.addAll(discardedCards);
        return drawAndShuffleStrategy.drawAndDiscardUsingStrategy(drawPile, discardPile,discardedCards);
    }

    public List<Card> getCardsDiscardedThisTurn(){
        return lastDiscarded;
    }
}
