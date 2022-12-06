import model.*;

import java.util.ArrayList;
import java.util.List;

public class MockHelper {

    public static List<Card> getDefaultDrawingPile() {
        return new ArrayList<>() {{
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
    }

    public static List<Card> get50PointsPlayerCards() {
        return new ArrayList<>() {{
            add(new Card(CardType.Number, 10));
            add(new Card(CardType.Number, 10));
            add(new Card(CardType.Number, 10));
            add(new Card(CardType.Number, 10));
            add(new Card(CardType.Number, 10));
        }};
    }

    public static List<Card> getCardsWithAttackCards() {
        return new ArrayList<>() {{
            add(new Card(CardType.Knight, 0));
            add(new Card(CardType.SleepingPotion, 0));
            add(new Card(CardType.King, 0));
            add(new Card(CardType.Number, 1));
            add(new Card(CardType.Number, 2));
        }};
    }

    public static List<Card> getCardsWithDefenseCards() {
        return new ArrayList<>() {{
            add(new Card(CardType.MagicWand, 0));
            add(new Card(CardType.Dragon, 0));
            add(new Card(CardType.Number, 1));
            add(new Card(CardType.Number, 2));
            add(new Card(CardType.Number, 3));
        }};
    }

    public static List<Queen> get8Queens() {
        return new ArrayList<>() {{
            add(new Queen(5));
            add(new Queen(5));
            add(new Queen(5));
            add(new Queen(10));
            add(new Queen(10));
            add(new Queen(10));
            add(new Queen(15));
            add(new Queen(15));
        }};
    }

    public static List<Queen> get4Queens() {
        return new ArrayList<>() {{
            add(new Queen(15));
            add(new Queen(20));
            add(new Queen(20));
            add(new Queen(5));
        }};
    }

    public static List<Queen> get3Queens() {
        return new ArrayList<>() {{
            add(new Queen(15));
            add(new Queen(20));
            add(new Queen(20));
        }};
    }

    public static Game gameMock() {
        int numberOfPlayers = 2;
        int onTurn = 0;

        List<Player> players = new ArrayList<>();
        SleepingQueens sleepingQueens = new SleepingQueens();
        DrawAndDiscardPile drawAndDiscardPile = new DrawAndDiscardPile(getDefaultDrawingPile(), new ArrayList<>(), new ShuffleFirst());

        players.add(new Player(0, new Hand(0, getCardsWithAttackCards(), drawAndDiscardPile), sleepingQueens, new AwokenQueens(0)));
        players.add(new Player(1, new Hand(1, getCardsWithAttackCards(), drawAndDiscardPile), sleepingQueens, new AwokenQueens(1)));

        return new Game(
                numberOfPlayers,
                onTurn,
                players,
                sleepingQueens,
                drawAndDiscardPile,
                new GameFinished()
        );
    }

    public static Game gameMock(List<List<Card>> playersCards) {
        int numberOfPlayers = playersCards.size();
        int onTurn = 0;
        List<Player> players = new ArrayList<>();
        SleepingQueens sleepingQueens = new SleepingQueens();

        DrawAndDiscardPile drawAndDiscardPile = new DrawAndDiscardPile(getDefaultDrawingPile(), new ArrayList<>(), new ShuffleFirst());

        for (int i = 0; i < playersCards.size(); i++) {
            players.add(new Player(i, new Hand(i, playersCards.get(i), drawAndDiscardPile), sleepingQueens, new AwokenQueens(0)));
        }

        return new Game(
                numberOfPlayers,
                onTurn,
                players,
                sleepingQueens,
                drawAndDiscardPile,
                new GameFinished()
        );
    }

    public static Game gameMock(List<List<Card>> playersCards, List<List<Queen>> playersQueens, SleepingQueens sleepingQueens) {
        int numberOfPlayers = playersCards.size();
        int onTurn = 0;
        List<Player> players = new ArrayList<>();

        DrawAndDiscardPile drawAndDiscardPile = new DrawAndDiscardPile(getDefaultDrawingPile(), new ArrayList<>(), new ShuffleFirst());

        for (int i = 0; i < playersCards.size(); i++) {
            players.add(new Player(i, new Hand(i, playersCards.get(i), drawAndDiscardPile), sleepingQueens, new AwokenQueens(i, playersQueens.get(i))));
        }
        return new Game(
                numberOfPlayers,
                onTurn,
                players,
                sleepingQueens,
                drawAndDiscardPile,
                new GameFinished()
        );
    }
}
