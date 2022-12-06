import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameObservableTest {

    private GameObservable gameObservable;
    private Game game;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private static class DummyObserver implements GameObserver {
        @Override
        public void notify(String message) {
            System.out.println("DummyObserverTest: " + message);
        }
    }

    @BeforeEach
    void setUp() {
        gameObservable = new GameObservable();
        game = MockHelper.gameMock();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testObserver() {
        DummyObserver observer = new DummyObserver();
        gameObservable.add(observer);
        gameObservable.add(new DummyObserver());
        gameObservable.addPlayer(0, new DummyObserver());
        gameObservable.addPlayer(1, new DummyObserver());
        gameObservable.notifyAll(game.getGameState());
        List<String> messages = Arrays.stream(outContent.toString().split("\n")).toList();

        assertEquals(4, messages.size());
        messages.forEach(line -> assertTrue(line.contains("DummyObserverTest")));

        gameObservable.remove(observer);
        gameObservable.removePlayer(1);
        gameObservable.notifyAll(game.getGameState());

        messages = new ArrayList<>(Arrays.stream(outContent.toString().split("\n")).toList());

        assertEquals(6, messages.size());
        messages.forEach(line -> assertTrue(line.contains("DummyObserverTest")));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

}