import model.Card;

import java.util.ArrayList;
import java.util.List;

public class DrawAndDiscardPile implements IPile {

    private final List<Card> drawPile;
    private final List<Card> discardPile;
    private final List<Card> lastDiscarded;
    private IDrawAndShuffleStrategy drawAndShuffleStrategy;

    public DrawAndDiscardPile(List<Card> drawPile, List<Card> discardPile) {
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.lastDiscarded = new ArrayList<>();
        this.drawAndShuffleStrategy = new ShuffleFirst();
    }

    public DrawAndDiscardPile(List<Card> drawPile, List<Card> discardPile, IDrawAndShuffleStrategy drawAndShuffleStrategy) {
        this(drawPile, discardPile);
        this.drawAndShuffleStrategy = drawAndShuffleStrategy;
    }

    @Override
    public List<Card> discardAndDraw(List<Card> discardedCards) {
        lastDiscarded.clear();
        lastDiscarded.addAll(discardedCards);
        return drawAndShuffleStrategy.drawAndDiscardUsingStrategy(drawPile, discardPile, discardedCards);
    }

    @Override
    public List<Card> getCardsDiscardedThisTurn() {
        return lastDiscarded;
    }

}