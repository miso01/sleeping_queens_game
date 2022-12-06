import model.Card;
import model.CardType;
import model.HandPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    private Hand hand;

    @BeforeEach
    void setUp() {
        hand = new Hand(0, MockHelper.getCardsWithAttackCards(), new DrawAndDiscardPile(MockHelper.getDefaultDrawingPile(), new ArrayList<>()));
    }

    @Test
    void removeCardsAndRedraw() {
        Map<HandPosition, Card> cardsToDiscard = Map.of(
                new HandPosition(0, 0), new Card(CardType.Knight, 1),
                new HandPosition(1, 0), new Card(CardType.SleepingPotion, 2)
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
                new HandPosition(3, 0),
                new HandPosition(4, 0)
        ), cards.keySet());
    }

    @Test
    void hasCardOfTypeKnight() {
        Map<HandPosition, Card> cards = hand.hasCardOfType(CardType.Knight);
        assertEquals(Set.of(new HandPosition(0, 0)), cards.keySet());
    }

    @Test
    void hasCardOfTypeMagicWand() {
        Map<HandPosition, Card> cards = hand.hasCardOfType(CardType.MagicWand);
        assertEquals(Set.of(), cards.keySet());
    }

}