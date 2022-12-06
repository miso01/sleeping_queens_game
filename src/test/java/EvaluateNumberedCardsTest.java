import model.Card;
import model.CardType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateNumberedCardsTest {

    private EvaluateNumberedCards evaluateNumberedCards;

    @BeforeEach
    void setUp() {
        evaluateNumberedCards = new EvaluateNumberedCards();
    }

    @Test
    void evaluateSingleCard() {
        boolean result = evaluateNumberedCards.play(List.of(
                new Card(CardType.Number, 2)
        ));
        assertTrue(result);
    }

    @Test
    void evaluateCardEquation1() {
        boolean result = evaluateNumberedCards.play(List.of(
                new Card(CardType.Number, 2),
                new Card(CardType.Number, 3),
                new Card(CardType.Number, 5)
        ));
        assertTrue(result);
    }

    @Test
    void evaluateCardEquation2() {
        boolean result = evaluateNumberedCards.play(List.of(
                new Card(CardType.Number, 2),
                new Card(CardType.Number, 3),
                new Card(CardType.Number, 5),
                new Card(CardType.Number, 1)
        ));
        assertFalse(result);
    }

}