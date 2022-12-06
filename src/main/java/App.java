import model.AwokenQueens;
import model.Card;
import model.CardDeck;
import model.SleepingQueens;

import java.util.ArrayList;
import java.util.List;

public class App {

    public App(int numberOfPlayers) {
        GameAdaptor gameAdaptor = initGame(numberOfPlayers);
        // ...
    }

    public GameAdaptor initGame(int numberOfPlayers){
        int PLAYER_CARD_COUNT = 5;
        List<Player> players = new ArrayList<>();
        SleepingQueens sleepingQueens = new SleepingQueens();
        List<Card> deckWithoutQueens = CardDeck.getDeckWithoutQueens();
        List<Card> cardsForPlayers = new ArrayList<>(deckWithoutQueens.subList(0, numberOfPlayers * PLAYER_CARD_COUNT));
        List<Card> unusedCards = new ArrayList<>(deckWithoutQueens.subList(numberOfPlayers * PLAYER_CARD_COUNT, deckWithoutQueens.size()));

        DrawAndDiscardPile drawAndDiscardPile = new DrawAndDiscardPile(unusedCards, new ArrayList<>());

        for (int i = 0; i < numberOfPlayers; i++) {
            List<Card> playerCards = new ArrayList<>(cardsForPlayers.subList(i * numberOfPlayers, i * numberOfPlayers + PLAYER_CARD_COUNT));
            players.add(new Player(i, new Hand(i, playerCards, drawAndDiscardPile), sleepingQueens, new AwokenQueens(i)));
        }

        return new GameAdaptor(new Game(
                numberOfPlayers,
                0,
                players,
                sleepingQueens,
                drawAndDiscardPile,
                new GameFinished()
        ), new GameObservable());
    }
}
