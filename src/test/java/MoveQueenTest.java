import model.*;
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
        sleepingQueens = new SleepingQueens(MockHelper.get8Queens());
        defenderAwokenQueens = new AwokenQueens(0, MockHelper.get3Queens());
        moveQueen = new MoveQueen(sleepingQueens, defenderAwokenQueens);
    }

    @Test
    void awakeQueen() {
        assertTrue(moveQueen.awakeQueen(new SleepingQueenPosition(0)));
        assertEquals(4, defenderAwokenQueens.getQueens().size());
        assertEquals(7, sleepingQueens.getQueens().size());

    }

    @Test
    void awakeNonExistentQueen() {
        assertFalse(moveQueen.awakeQueen(new SleepingQueenPosition(10)));
        assertEquals(3, defenderAwokenQueens.getQueens().size());
    }

    @Test
    void putQueenToSleep() {
        assertTrue(moveQueen.putQueenToSleep(new AwokenQueenPosition(0, 0)));
        assertEquals(2, defenderAwokenQueens.getQueens().size());
        assertEquals(9, sleepingQueens.getQueens().size());
    }

    @Test
    void putNonExistentQueenToSleep() {
        assertFalse(moveQueen.putQueenToSleep(new AwokenQueenPosition(10, 0)));
        assertEquals(3, defenderAwokenQueens.getQueens().size());
        assertEquals(8, sleepingQueens.getQueens().size());
    }


    @Test
    void stealQueen() {
        AwokenQueens attackerAwokenQueens = new AwokenQueens(1, MockHelper.get4Queens());
        assertTrue(moveQueen.stealQueen(new AwokenQueenPosition(0, 0), attackerAwokenQueens));
        assertEquals(2, defenderAwokenQueens.getQueens().size());
        assertEquals(5, attackerAwokenQueens.getQueens().size());
    }

    @Test
    void stealNonExistentQueen() {
        AwokenQueens attackerAwokenQueens = new AwokenQueens(1, MockHelper.get4Queens());
        assertFalse(moveQueen.stealQueen(new AwokenQueenPosition(7, 1), attackerAwokenQueens));
        assertEquals(3, defenderAwokenQueens.getQueens().size());
        assertEquals(4, attackerAwokenQueens.getQueens().size());
    }

}