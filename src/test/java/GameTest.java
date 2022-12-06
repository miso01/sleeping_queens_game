import model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = MockHelper.gameMock();
    }

    @Test
    void gameInitialization() {
        GameState gameState = game.getGameState();
        assertEquals(2, gameState.getNumberOfPlayers());
        assertEquals(0, gameState.getOnTurn());
        assertEquals(0, gameState.getAwokenQueens().size());
        assertEquals(12, gameState.getSleepingQueens().size());
        assertEquals(10, gameState.getCards().size());
        assertEquals(0, gameState.getCardsDiscardedLastTurn().size());
    }

}