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
            add(MockHelper.getCardsWithDefenseCards());
            add(MockHelper.getCardsWithAttackCards());
        }};

        List<List<Queen>> playersAwokenQueens = new ArrayList<>(){{
            add(MockHelper.get8Queens());
            add(MockHelper.get3Queens());
        }};

        List<Queen> sleepingQueensList = new ArrayList<>(){{
            add(new Queen(20));
        }};

        game = MockHelper.gameMock(playersCards, playersAwokenQueens, new SleepingQueens(sleepingQueensList));
        assertEquals(-1,game.getGameState().getWinnerIdx());
        game.play(0, List.of(new HandPosition(0,0)),List.of(new SleepingQueenPosition(0)));
        assertEquals(0,game.getGameState().getWinnerIdx());
    }

    @Test
    void finishWhenEnoughPointsCollected() {
        List<List<Card>> playersCards = new ArrayList<>(){{
            add(MockHelper.getCardsWithAttackCards());
            add(MockHelper.get50PointsPlayerCards());
        }};

        game = MockHelper.gameMock(playersCards);

        assertEquals(-1,game.getGameState().getWinnerIdx());
        game.play(0, List.of(new HandPosition(0,0)),List.of(new SleepingQueenPosition(0)));
        assertEquals(1,game.getGameState().getWinnerIdx());
    }

    @Test
    void finishWhenEnoughQueensAwoken(){
        List<List<Card>> playersCards = new ArrayList<>(){{
            add(MockHelper.getCardsWithAttackCards());
            add(MockHelper.getCardsWithDefenseCards());
        }};

        List<List<Queen>> playersAwokenQueens = new ArrayList<>(){{
            add(MockHelper.get4Queens());
            add(MockHelper.get3Queens());
        }};

        game = MockHelper.gameMock(playersCards, playersAwokenQueens, new SleepingQueens(MockHelper.get8Queens()));

        assertEquals(-1,game.getGameState().getWinnerIdx());
        game.play(0, List.of(new HandPosition(0,0)),List.of(new SleepingQueenPosition(0)));
        assertEquals(0,game.getGameState().getWinnerIdx());
    }
}