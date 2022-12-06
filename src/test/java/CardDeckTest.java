import model.CardDeck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @Test
    void cardDeckSize() {
        assertEquals(62, CardDeck.getDeckWithoutQueens().size());
    }

    @Test
    void queensCount() {
        assertEquals(12,CardDeck.getAllQueens().size());
    }
}