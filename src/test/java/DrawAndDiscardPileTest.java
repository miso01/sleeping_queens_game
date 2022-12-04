import model.Card;
import model.CardType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrawAndDiscardPileTest {

    private DrawAndDiscardPile piles;
    private List<Card> drawPile;
    private List<Card> discardPile;

    @BeforeEach
    void setUp() {
        drawPile = new ArrayList<>() {{
            add(new Card(CardType.Knight, 0));
            add(new Card(CardType.SleepingPotion, 0));
        }};
        discardPile = new ArrayList<>() {{
            add(new Card(CardType.Number, 4));
            add(new Card(CardType.Number, 5));
            add(new Card(CardType.Number, 6));
            add(new Card(CardType.Number, 7));
            add(new Card(CardType.Number, 8));
            add(new Card(CardType.Number, 9));
            add(new Card(CardType.Number, 10));
        }};
        piles = new DrawAndDiscardPile(drawPile, discardPile, new ShuffleFirst());
    }

    @Test
    void testShuffleFirstStrategy() {
        List<Card> cardsToDiscard = new ArrayList<>() {{
            add(new Card(CardType.Number, 1));
            add(new Card(CardType.Number, 2));
            add(new Card(CardType.Number, 3));
        }};

        List<Card> drawnCards = piles.discardAndDraw(cardsToDiscard);

        drawnCards.forEach(c -> {
            assertNotEquals(new Card(CardType.Number, 1), c);
            assertNotEquals(new Card(CardType.Number, 2), c);
            assertNotEquals(new Card(CardType.Number, 3), c);
        });
    }

    @Test
    void testDrawFirstStrategy() {
        piles = new DrawAndDiscardPile(drawPile, discardPile, new DrawFirst());
        List<Card> cardsToDiscard = new ArrayList<>() {{
            add(new Card(CardType.MagicWand, 1));
            add(new Card(CardType.MagicWand, 2));
            add(new Card(CardType.MagicWand, 3));
        }};

        List<Card> drawnCards = piles.discardAndDraw(cardsToDiscard);
        assertEquals(new Card(CardType.Knight, 0), drawnCards.get(0));
        assertEquals(new Card(CardType.SleepingPotion, 0), drawnCards.get(1));
        assertEquals(CardType.Number, drawnCards.get(2).getType());
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
    void getLastDiscardedCards() {
        setUp();
        List<Card> discardedCards = new ArrayList<>() {{
            add(new Card(CardType.Number, 1));
            add(new Card(CardType.SleepingPotion, 1));
        }};
        piles.discardAndDraw(discardedCards);
        Assertions.assertIterableEquals(piles.getCardsDiscardedThisTurn(), discardedCards);
    }
}