import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameAdaptorTest {

    private GameAdaptor gameAdaptor;

    @BeforeEach
    void setUp() {
        gameAdaptor = new GameAdaptor(MockHelper.gameMock(), new GameObservable());
    }

    @Test
    void playWithIncorrectInput() {
        assertTrue(gameAdaptor.play("0", "h4 a12 a13").contains("Invalid"));
    }

    @Test
    void playWithCorrectInput() {
        String result = gameAdaptor.play("0", "h2 s0");
        System.out.println("Result: " + result);
        assertTrue(result.contains("GameState"));
    }

}