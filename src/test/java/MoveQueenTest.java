import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveQueenTest {

    private MoveQueen moveQueen;
    private SleepingQueens sleepingQueens;
    private AwokenQueens defenderAwokenQueens;

    @BeforeEach
    void setUp() {

        List<Queen> sleepingQueenList = new ArrayList<>() {{
            add(new Queen(5));
            add(new Queen(5));
            add(new Queen(10));
            add(new Queen(10));
            add(new Queen(15));
            add(new Queen(15));
            add(new Queen(20));
            add(new Queen(20));
        }};

        sleepingQueens = new SleepingQueens(sleepingQueenList);

        List<Queen> awokenQueensList = new ArrayList<>() {{
            add(new Queen(5));
            add(new Queen(10));
            add(new Queen(15));
            add(new Queen(20));
        }};

        defenderAwokenQueens = new AwokenQueens(0, awokenQueensList);
        moveQueen = new MoveQueen(sleepingQueens, defenderAwokenQueens);
    }

    @Test
    void awakeQueen() {
        assertTrue(moveQueen.awakeQueen(new SleepingQueenPosition(0)));
        assertEquals(5, defenderAwokenQueens.queens.size());
    }

    @Test
    void awakeNonExistentQueen() {
        assertFalse(moveQueen.awakeQueen(new SleepingQueenPosition(10)));
        assertEquals(4, defenderAwokenQueens.queens.size());
    }

    @Test
    void putQueenToSleep() {
        assertTrue(moveQueen.putQueenToSleep(new AwokenQueenPosition(0, 0)));
        assertEquals(3, defenderAwokenQueens.queens.size());
        assertEquals(9, sleepingQueens.queens.size());
    }

    @Test
    void putNonExistentQueenToSleep() {
        assertFalse(moveQueen.putQueenToSleep(new AwokenQueenPosition(10, 0)));
        assertEquals(4, defenderAwokenQueens.queens.size());
        assertEquals(8, sleepingQueens.queens.size());
    }


    @Test
    void stealQueen() {
        AwokenQueens attackerAwokenQueens = new AwokenQueens(1, new ArrayList<>() {{
            add(new Queen(5));
            add(new Queen(10));
            add(new Queen(15));
            add(new Queen(20));
        }});
        assertTrue(moveQueen.stealQueen(new AwokenQueenPosition(0, 0), attackerAwokenQueens));
        assertEquals(3, defenderAwokenQueens.getQueens().size());
        assertEquals(5, attackerAwokenQueens.getQueens().size());
    }

    @Test
    void stealNonExistentQueen() {
        AwokenQueens attackerAwokenQueens = new AwokenQueens(1, new ArrayList<>() {{
            add(new Queen(5));
            add(new Queen(10));
            add(new Queen(15));
            add(new Queen(20));
        }});
        assertFalse(moveQueen.stealQueen(new AwokenQueenPosition(7, 1), attackerAwokenQueens));
        assertEquals(4, defenderAwokenQueens.getQueens().size());
        assertEquals(4, attackerAwokenQueens.getQueens().size());
    }
}