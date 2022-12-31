import model.Card;

import java.util.List;

public interface IPile {
    List<Card> discardAndDraw(List<Card> discardedCards);
    List<Card> getCardsDiscardedThisTurn();
}
