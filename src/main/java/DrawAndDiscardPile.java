import java.util.List;

public class DrawAndDiscardPile {

    List<Card> drawPile;
    List<Card> discardPile;

    public DrawAndDiscardPile(List<Card> drawPile, List<Card> discardPile) {
        this.drawPile = drawPile;
        this.discardPile = discardPile;
    }
}
