import java.util.*;

public class Hand {

    private final Map<HandPosition, Card> cards;
    private final DrawAndDiscardPile drawAndDiscardPile;

    public Hand(int playerIndex, List<Card> cards, DrawAndDiscardPile drawAndDiscardPile) {
        this.drawAndDiscardPile = drawAndDiscardPile;
        this.cards = new HashMap<>();
        for (int i = 0; i < cards.size(); i++) {
            this.cards.put(new HandPosition(i, playerIndex), cards.get(i));
        }
    }

    Optional<List<Card>> pickCards(List<HandPosition> positions){

        return Optional.empty();
    }

    Map<HandPosition,Card> removePickedCardsAndRedraw(){

        return null;
    }

    Map<HandPosition, Card> removeCardsAndRedraw(List<HandPosition> positionsToRemove){
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


    public Map<HandPosition, Card> hasCardOfType(CardType cardType){
        Map<HandPosition,Card> cardsOfSearchedType = new HashMap<>();
        cards.forEach((handPosition,card) -> {
            if(card.getType() == cardType){
                cardsOfSearchedType.put(handPosition, card);
            }
        });
        return cardsOfSearchedType;
    }

    public Map<HandPosition,Card> getCards() {
        return cards;
    }
}
