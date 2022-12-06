import model.Queen;
import model.SleepingQueenPosition;
import model.SleepingQueens;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenCollectionTest {

    private SleepingQueens sleepingQueens;

    @BeforeEach
    void setUp() {
        sleepingQueens = new SleepingQueens();
    }

    @Test
    void addQueen() {
        sleepingQueens.addQueen(new Queen(4));
        assertEquals(13, sleepingQueens.getQueens().size());
    }

    @Test
    void removeQueen() {
        sleepingQueens.removeQueen(new SleepingQueenPosition(0));
        assertEquals(11, sleepingQueens.getQueens().size());
    }

    @Test
    void removeNonExistingQueen() {
        Optional<Queen> removedQueen = sleepingQueens.removeQueen(new SleepingQueenPosition(12));
        assertEquals(12, sleepingQueens.getQueens().size());
        assertTrue(removedQueen.isEmpty());
    }

    @Test
    void getNonExistingQueen() {
        Optional<Queen> queen = sleepingQueens.removeQueen(new SleepingQueenPosition(12));
        assertEquals(12, sleepingQueens.getQueens().size());
        assertTrue(queen.isEmpty());
    }

}
