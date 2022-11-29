import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawAndDiscardPile {

    private final List<Card> drawPile;
    private final List<Card> discardPile;
    private final List<Card> lastDiscarded;

    public DrawAndDiscardPile(List<Card> drawPile, List<Card> discardPile) {
        this.drawPile = drawPile;
        this.discardPile = discardPile;
        this.lastDiscarded = new ArrayList<>();
    }

    public List<Card> discardAndDraw(List<Card> discardedCards) {
        lastDiscarded.clear();
        lastDiscarded.addAll(discardedCards);
        discardPile.addAll(discardedCards);
        if (drawPile.isEmpty()) reshuffleDiscardPile();
        List<Card> drawnCards = new ArrayList<>(drawPile.subList(drawPile.size() - discardedCards.size(), drawPile.size()));
        drawPile.removeAll(drawnCards);
        return drawnCards;
    }

    public List<Card> getCardsDiscardedThisTurn(){
        return lastDiscarded;
    }

    private void reshuffleDiscardPile() {
        Collections.shuffle(discardPile);
        drawPile.addAll(discardPile);
        discardPile.clear();
    }
}
