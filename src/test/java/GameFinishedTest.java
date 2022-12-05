import model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameFinishedTest {

    private Game game;

    @Test
    void finishWhenAllQueensAreAwoken() {
        List<List<Card>> playersCards = new ArrayList<>(){{
            add(TestHelper.getCardsWithDefenseCards());
            add(TestHelper.getCardsWithAttackCards());
        }};

        List<List<Queen>> playersAwokenQueens = new ArrayList<>(){{
            add(TestHelper.get8Queens());
            add(TestHelper.get3Queens());
        }};

        List<Queen> sleepingQueensList = new ArrayList<>(){{
            add(new Queen(20));
        }};

        game = TestHelper.gameMock(playersCards, playersAwokenQueens, new SleepingQueens(sleepingQueensList));
        assertEquals(-1,game.getGameState().getWinnerIdx());
        game.play(0, List.of(new HandPosition(0,0)),List.of(new SleepingQueenPosition(0)));
        assertEquals(0,game.getGameState().getWinnerIdx());
    }

    @Test
    void finishWhenEnoughPointsCollected() {
        List<List<Card>> playersCards = new ArrayList<>(){{
            add(TestHelper.getCardsWithAttackCards());
            add(TestHelper.get50PointsPlayerCards());
        }};

        game = TestHelper.gameMock(playersCards);

        assertEquals(-1,game.getGameState().getWinnerIdx());
        game.play(0, List.of(new HandPosition(0,0)),List.of(new SleepingQueenPosition(0)));
        assertEquals(1,game.getGameState().getWinnerIdx());
    }

    @Test
    void finishWhenEnoughQueensAwoken(){
        List<List<Card>> playersCards = new ArrayList<>(){{
            add(TestHelper.getCardsWithAttackCards());
            add(TestHelper.getCardsWithDefenseCards());
        }};

        List<List<Queen>> playersAwokenQueens = new ArrayList<>(){{
            add(TestHelper.get4Queens());
            add(TestHelper.get3Queens());
        }};

        game = TestHelper.gameMock(playersCards, playersAwokenQueens, new SleepingQueens(TestHelper.get8Queens()));

        assertEquals(-1,game.getGameState().getWinnerIdx());
        game.play(0, List.of(new HandPosition(0,0)),List.of(new SleepingQueenPosition(0)));
        assertEquals(0,game.getGameState().getWinnerIdx());
    }
}