import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateAttackTest {

    private EvaluateAttack evaluateAttack;
    private Player attacker;
    private Player defender;
    private final int ATTACKER_INDEX = 0;
    private final int DEFENDER_INDEX = 1;

    @BeforeEach
    void setUp() {
        SleepingQueens sleepingQueens = new SleepingQueens(MockHelper.get8Queens());
        DrawAndDiscardPile drawAndDiscardPile = new DrawAndDiscardPile(MockHelper.getDefaultDrawingPile(), new ArrayList<>());
        AwokenQueens defenderAwokenQueens = new AwokenQueens(DEFENDER_INDEX, new ArrayList<>());
        attacker = new Player(ATTACKER_INDEX, new Hand(ATTACKER_INDEX, MockHelper.getCardsWithAttackCards(), drawAndDiscardPile), sleepingQueens, new AwokenQueens(ATTACKER_INDEX));
        defender = new Player(DEFENDER_INDEX, new Hand(DEFENDER_INDEX, MockHelper.getCardsWithAttackCards(), drawAndDiscardPile), sleepingQueens, defenderAwokenQueens);
        evaluateAttack = new EvaluateAttack(sleepingQueens);
    }

    @Test
    void attackNonExistingQueen() {
        assertFalse(evaluateAttack.play(attacker, defender, new AwokenQueenPosition(0, DEFENDER_INDEX), new HandPosition(0, ATTACKER_INDEX)));
    }

    @Test
    void attackWithNonExistingCard() {
        assertFalse(evaluateAttack.play(attacker, defender, new SleepingQueenPosition(0), new HandPosition(6, ATTACKER_INDEX)));
    }

}