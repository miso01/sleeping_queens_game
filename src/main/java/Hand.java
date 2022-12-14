import model.Card;
import model.CardType;
import model.HandPosition;

import java.util.*;

public class Hand implements IHand {

    private final Map<HandPosition, Card> cards;
    private final IPile drawAndDiscardPile;

    public Hand(int playerIndex, List<Card> cards, IPile drawAndDiscardPile) {
        this.drawAndDiscardPile = drawAndDiscardPile;
        this.cards = new HashMap<>();
        for (int i = 0; i < cards.size(); i++) {
            this.cards.put(new HandPosition(i, playerIndex), cards.get(i));
        }
    }

    @Override
    public Map<HandPosition, Card> removeCardsAndRedraw(List<HandPosition> positionsToRemove) {
        List<Card> cardsToRemove = new ArrayList<>();
        for (HandPosition position : positionsToRemove) {
            cardsToRemove.add(cards.remove(position));
        }

        List<Card> drawnCards = drawAndDiscardPile.discardAndDraw(cardsToRemove);
        int i = 0;
        for (HandPosition position : positionsToRemove) {
            cards.put(position, drawnCards.get(i));
            i++;
        }
        return cards;
    }

    @Override
    public Map<HandPosition, Card> hasCardOfType(CardType cardType) {
        Map<HandPosition, Card> cardsOfSearchedType = new HashMap<>();
        cards.forEach((handPosition, card) -> {
            if (card.getType() == cardType) {
                cardsOfSearchedType.put(handPosition, card);
            }
        });
        return cardsOfSearchedType;
    }

    @Override
    public Map<HandPosition, Card> getCards() {
        return cards;
    }
}
