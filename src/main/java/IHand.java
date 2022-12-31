import model.Card;
import model.CardType;
import model.HandPosition;

import java.util.List;
import java.util.Map;

public interface IHand {
    Map<HandPosition, Card> removeCardsAndRedraw(List<HandPosition> positionsToRemove);
    Map<HandPosition, Card> hasCardOfType(CardType cardType);
    Map<HandPosition, Card> getCards();
}
