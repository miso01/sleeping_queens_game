import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @Test
    void cardDeckSize() {
        assertEquals(62,CardDeck.getAllCardsExceptQueens().size());
    }

    @Test
    void queensCount() {
        assertEquals(12,CardDeck.getAllQueens().size());
    }
}