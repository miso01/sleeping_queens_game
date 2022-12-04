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
    private SleepingQueens sleepingQueens;
    private DrawAndDiscardPile drawAndDiscardPile;
    private AwokenQueens defenderAwokenQueens;
    private final int ATTACKER_INDEX = 0;
    private final int DEFENDER_INDEX = 1;

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

        evaluateAttack = new EvaluateAttack(sleepingQueens);
        List<Card> drawingPile = new ArrayList<>() {{
            add(new Card(CardType.Number, 1));
            add(new Card(CardType.Number, 2));
            add(new Card(CardType.Number, 3));
            add(new Card(CardType.Number, 4));
            add(new Card(CardType.Number, 5));
            add(new Card(CardType.Number, 6));
            add(new Card(CardType.Number, 7));
            add(new Card(CardType.Number, 8));
            add(new Card(CardType.Number, 9));
            add(new Card(CardType.Number, 10));
        }};

        drawAndDiscardPile = new DrawAndDiscardPile(drawingPile, new ArrayList<>());

        List<Card> attackerCards = new ArrayList<>() {{
            add(new Card(CardType.Number, 1));
            add(new Card(CardType.Number, 2));
            add(new Card(CardType.King, 0));
            add(new Card(CardType.Knight, 0));
            add(new Card(CardType.SleepingPotion, 0));
        }};
        List<Card> defenderCards = new ArrayList<>() {{
            add(new Card(CardType.Number, 3));
            add(new Card(CardType.Number, 4));
            add(new Card(CardType.Number, 5));
            add(new Card(CardType.MagicWand, 0));
            add(new Card(CardType.Dragon, 0));
        }};

        defenderAwokenQueens = new AwokenQueens(DEFENDER_INDEX, new ArrayList<>(){{
            add(new Queen(5));
            add(new Queen(10));
            add(new Queen(15));
            add(new Queen(20));
        }});

        attacker = new Player(ATTACKER_INDEX, new Hand(ATTACKER_INDEX, attackerCards, drawAndDiscardPile), sleepingQueens, new AwokenQueens(ATTACKER_INDEX));
        defender = new Player(DEFENDER_INDEX, new Hand(DEFENDER_INDEX, defenderCards, drawAndDiscardPile), sleepingQueens, defenderAwokenQueens);
    }

    @Test
    void defenseAgainstKnightAttack() {
        assertTrue(evaluateAttack.play(defender, attacker, new AwokenQueenPosition(0, DEFENDER_INDEX), new HandPosition(3, ATTACKER_INDEX)));
        assertEquals(4, defender.getAwokenQueens().getQueens().size());
        defender.getHand().getCards().values().forEach(card -> assertNotSame(card.getType(), CardType.Dragon));
        attacker.getHand().getCards().values().forEach(card -> assertNotSame(card.getType(), CardType.Knight));
        assertEquals(5, attacker.getHand().getCards().size());
        assertEquals(5, defender.getHand().getCards().size());
    }

    @Test
    void knightAttack(){
        List<Card> defenderCards = new ArrayList<>() {{
            add(new Card(CardType.Number, 4));
            add(new Card(CardType.Number, 5));
            add(new Card(CardType.Number, 6));
            add(new Card(CardType.MagicWand, 0));
            add(new Card(CardType.SleepingPotion, 0));
        }};
        defender = new Player(DEFENDER_INDEX, new Hand(DEFENDER_INDEX, defenderCards, drawAndDiscardPile), sleepingQueens, defenderAwokenQueens);
        assertTrue(evaluateAttack.play(defender, attacker, new AwokenQueenPosition(0, DEFENDER_INDEX), new HandPosition(3, ATTACKER_INDEX)));
        attacker.getHand().getCards().values().forEach(card -> assertNotSame(card.getType(), CardType.Knight));
        assertEquals(3, defender.getAwokenQueens().getQueens().size());
        assertEquals(1, attacker.getAwokenQueens().getQueens().size());
    }


    @Test
    void defenseAgainstSleepingPotionAttack(){
        assertTrue(evaluateAttack.play(defender, attacker, new AwokenQueenPosition(0, DEFENDER_INDEX), new HandPosition(4, ATTACKER_INDEX)));
        assertEquals(4, defender.getAwokenQueens().getQueens().size());
        defender.getHand().getCards().values().forEach(card -> assertNotSame(card.getType(), CardType.MagicWand));
        attacker.getHand().getCards().values().forEach(card -> assertNotSame(card.getType(), CardType.SleepingPotion));
        assertEquals(5, attacker.getHand().getCards().size());
        assertEquals(5, defender.getHand().getCards().size());
    }

    @Test
    void sleepingPotionAttack(){
        List<Card> defenderCards = new ArrayList<>() {{
            add(new Card(CardType.Number, 4));
            add(new Card(CardType.Number, 5));
            add(new Card(CardType.Number, 6));
            add(new Card(CardType.Knight, 0));
            add(new Card(CardType.Dragon, 0));
        }};
        defender = new Player(DEFENDER_INDEX, new Hand(DEFENDER_INDEX, defenderCards, drawAndDiscardPile), sleepingQueens, defenderAwokenQueens);
        assertTrue(evaluateAttack.play(defender, attacker, new AwokenQueenPosition(0, DEFENDER_INDEX), new HandPosition(4, ATTACKER_INDEX)));
        attacker.getHand().getCards().values().forEach(card -> assertNotSame(card.getType(), CardType.SleepingPotion));
        assertEquals(3, defender.getAwokenQueens().getQueens().size());
        assertEquals(0, attacker.getAwokenQueens().getQueens().size());
        assertEquals(9, sleepingQueens.getQueens().size());
    }

    @Test
    void kingAttack(){
        assertTrue(evaluateAttack.play(defender, attacker, new SleepingQueenPosition(0), new HandPosition(2, ATTACKER_INDEX)));
        assertEquals(5, attacker.getHand().getCards().size());
        assertEquals(4, defender.getAwokenQueens().getQueens().size());
        assertEquals(7, sleepingQueens.getQueens().size());
        assertEquals(1, attacker.getAwokenQueens().getQueens().size());
    }

}