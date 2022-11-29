import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrawAndDiscardPileTest {

    private DrawAndDiscardPile piles;

    void setUp() {
        List<Card> drawPile = new ArrayList<>() {{
            add(new Card(CardType.Number, 1));
            add(new Card(CardType.SleepingPotion, 1));
            add(new Card(CardType.SleepingPotion, 2));
            add(new Card(CardType.Knight, 1));
            add(new Card(CardType.Number, 10));

        }};
        List<Card> discardPile = new ArrayList<>() {{
            add(new Card(CardType.Number, 2));
            add(new Card(CardType.Number, 3));
        }};
        piles = new DrawAndDiscardPile(drawPile, discardPile);
    }

    @Test
    void discardAndDrawCards() {
        setUp();
        List<Card> discardedCards = new ArrayList<>() {{
            add(new Card(CardType.Number, 1));
            add(new Card(CardType.SleepingPotion, 1));
        }};
        List<Card> drawnCards = piles.discardAndDraw(discardedCards);
        Assertions.assertIterableEquals(drawnCards, List.of(new Card(CardType.Knight, 1), new Card(CardType.Number, 10)));
    }

    @Test
    void drawCardsWhenDrawingPileIsEmpty() {
        piles = new DrawAndDiscardPile(new ArrayList<>(), new ArrayList<>() {{
            add(new Card(CardType.Number, 2));
            add(new Card(CardType.Number, 3));
        }});
        List<Card> discardedCards = new ArrayList<>() {{
            add(new Card(CardType.Number, 1));
            add(new Card(CardType.SleepingPotion, 1));
        }};
        List<Card> drawnCards = piles.discardAndDraw(discardedCards);
        assertEquals(2, drawnCards.size());
    }

    @Test
    void getLastDiscardedCards(){
        setUp();
        List<Card> discardedCards = new ArrayList<>() {{
            add(new Card(CardType.Number, 1));
            add(new Card(CardType.SleepingPotion, 1));
        }};
        piles.discardAndDraw(discardedCards);
        Assertions.assertIterableEquals(piles.getCardsDiscardedThisTurn(), discardedCards);
    }
}