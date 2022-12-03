import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    private Hand hand;

    @BeforeEach
    void setUp() {
        List<Card> handCards = new ArrayList<>() {{
            add(new Card(CardType.Number, 1));
            add(new Card(CardType.Number, 2));
            add(new Card(CardType.Number, 3));
            add(new Card(CardType.Knight, 0));
            add(new Card(CardType.SleepingPotion, 0));
        }};


        List<Card> drawingCards = new ArrayList<>() {{
            add(new Card(CardType.Number, 4));
            add(new Card(CardType.Number, 5));
            add(new Card(CardType.Number, 6));
            add(new Card(CardType.Number, 7));
            add(new Card(CardType.Number, 8));
            add(new Card(CardType.Number, 9));
            add(new Card(CardType.Knight, 10));
            add(new Card(CardType.MagicWand, 0));
            add(new Card(CardType.SleepingPotion, 0));
            add(new Card(CardType.Knight, 0));
            add(new Card(CardType.SleepingPotion, 0));
            add(new Card(CardType.Dragon, 0));
        }};
        hand = new Hand(0, handCards, new DrawAndDiscardPile(drawingCards, new ArrayList<>()));
    }


    @Test
    void removeCardsAndRedraw() {
        Map<HandPosition, Card> cardsToDiscard = Map.of(
                new HandPosition(0, 0), new Card(CardType.Number, 4),
                new HandPosition(1, 0), new Card(CardType.Number, 5),
                new HandPosition(2, 0), new Card(CardType.Number, 6)
        );

        hand.removeCardsAndRedraw(cardsToDiscard.keySet().stream().toList());
        Map<HandPosition, Card> currentCardsAfter = hand.getCards();
        for (Card discardedCard : cardsToDiscard.values()) {
            assertFalse(currentCardsAfter.containsValue(discardedCard));
        }
        assertEquals(5, currentCardsAfter.size());
    }

    @Test
    void hasCardOfTypeNumber() {
        Map<HandPosition, Card> cards = hand.hasCardOfType(CardType.Number);
        assertEquals(Set.of(
                new HandPosition(0, 0),
                new HandPosition(1, 0),
                new HandPosition(2, 0)
        ), cards.keySet());
    }

    @Test
    void hasCardOfTypeKnight() {
        Map<HandPosition, Card> cards = hand.hasCardOfType(CardType.Knight);
        assertEquals(Set.of(new HandPosition(3, 0)), cards.keySet());
    }

    @Test
    void hasCardOfTypeMagicWand() {
        Map<HandPosition, Card> cards = hand.hasCardOfType(CardType.MagicWand);
        assertEquals(Set.of(), cards.keySet());
    }
}