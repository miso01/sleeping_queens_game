import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    private Player attacker;
    private Player defender;
    private SleepingQueens sleepingQueens;
    private AwokenQueens defenderAwokenQueens;
    private final int ATTACKER_INDEX = 0;
    private final int DEFENDER_INDEX = 1;

    @BeforeEach
    void setUp() {
        sleepingQueens = new SleepingQueens(MockHelper.get8Queens());
        defenderAwokenQueens = new AwokenQueens(DEFENDER_INDEX, MockHelper.get4Queens());
        attacker = new Player(ATTACKER_INDEX, new MockHand(ATTACKER_INDEX, MockHelper.getCardsWithAttackCards(),MockHelper.getDefaultDrawingPile()), sleepingQueens, new AwokenQueens(ATTACKER_INDEX));
        defender = new Player(DEFENDER_INDEX, new MockHand(DEFENDER_INDEX, MockHelper.getCardsWithAttackCards(), MockHelper.getDefaultDrawingPile()), sleepingQueens, defenderAwokenQueens);
    }

    @Test
    void defenseAgainstKnightAttack() {
        attacker.play(defender, List.of(new HandPosition(0, ATTACKER_INDEX)), new AwokenQueenPosition(0, DEFENDER_INDEX));
        assertEquals(3, defender.getAwokenQueens().getQueens().size());
        defender.getHand().getCards().values().forEach(card -> assertNotSame(card.getType(), CardType.Dragon));
        attacker.getHand().getCards().values().forEach(card -> assertNotSame(card.getType(), CardType.Knight));
        assertEquals(5, attacker.getHand().getCards().size());
        assertEquals(5, defender.getHand().getCards().size());
    }

    @Test
    void knightAttack() {
        defender = new Player(DEFENDER_INDEX, new MockHand(DEFENDER_INDEX, MockHelper.getCardsWithAttackCards(), MockHelper.getDefaultDrawingPile()), sleepingQueens, defenderAwokenQueens);
        attacker.play(defender,List.of(new HandPosition(0, ATTACKER_INDEX)), new AwokenQueenPosition(0, DEFENDER_INDEX));
        attacker.getHand().getCards().values().forEach(card -> assertNotSame(card.getType(), CardType.Knight));
        assertEquals(3, defender.getAwokenQueens().getQueens().size());
        assertEquals(1, attacker.getAwokenQueens().getQueens().size());
    }


    @Test
    void defenseAgainstSleepingPotionAttack() {
        attacker.play(defender, List.of(new HandPosition(1, ATTACKER_INDEX)), new AwokenQueenPosition(0, DEFENDER_INDEX));
        assertEquals(3, defender.getAwokenQueens().getQueens().size());
        defender.getHand().getCards().values().forEach(card -> assertNotSame(card.getType(), CardType.MagicWand));
        attacker.getHand().getCards().values().forEach(card -> assertNotSame(card.getType(), CardType.SleepingPotion));
        assertEquals(5, attacker.getHand().getCards().size());
        assertEquals(5, defender.getHand().getCards().size());
    }

    @Test
    void sleepingPotionAttack() {
        defender = new Player(DEFENDER_INDEX, new MockHand(DEFENDER_INDEX, MockHelper.getCardsWithAttackCards(), MockHelper.getDefaultDrawingPile()), sleepingQueens, defenderAwokenQueens);
        attacker.play(defender,  List.of(new HandPosition(1, ATTACKER_INDEX)), new AwokenQueenPosition(0, DEFENDER_INDEX));
        attacker.getHand().getCards().values().forEach(card -> assertNotSame(card.getType(), CardType.SleepingPotion));
        assertEquals(3, defender.getAwokenQueens().getQueens().size());
        assertEquals(0, attacker.getAwokenQueens().getQueens().size());
        assertEquals(9, sleepingQueens.getQueens().size());
    }

    @Test
    void kingAttack() {
        attacker.play(defender, List.of(new HandPosition(2, ATTACKER_INDEX)), new SleepingQueenPosition(0));
        assertEquals(5, attacker.getHand().getCards().size());
        assertEquals(4, defender.getAwokenQueens().getQueens().size());
        assertEquals(7, sleepingQueens.getQueens().size());
        assertEquals(1, attacker.getAwokenQueens().getQueens().size());
    }
}