package model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameState {

    private final int numberOfPlayers;
    private final int onTurn;
    private final Set<SleepingQueenPosition> sleepingQueens;
    private final Map<HandPosition, Card> cards;
    private final Map<AwokenQueenPosition, Queen> awokenQueens;
    private final List<Card> cardsDiscardedLastTurn;

    public GameState(int numberOfPlayers, int onTurn, Set<SleepingQueenPosition> sleepingQueens, Map<HandPosition, Card> cards, Map<AwokenQueenPosition, Queen> awokenQueens, List<Card> cardsDiscardedLastTurn) {
        this.numberOfPlayers = numberOfPlayers;
        this.onTurn = onTurn;
        this.sleepingQueens = sleepingQueens;
        this.cards = cards;
        this.awokenQueens = awokenQueens;
        this.cardsDiscardedLastTurn = cardsDiscardedLastTurn;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getOnTurn() {
        return onTurn;
    }

    public Set<SleepingQueenPosition> getSleepingQueens() {
        return sleepingQueens;
    }

    public Map<HandPosition, Card> getCards() {
        return cards;
    }

    public Map<AwokenQueenPosition, Queen> getAwokenQueens() {
        return awokenQueens;
    }

    public List<Card> getCardsDiscardedLastTurn() {
        return cardsDiscardedLastTurn;
    }
}
