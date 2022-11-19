import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private GameState gameState;
    private DrawAndDiscardPile piles;
    private SleepingQueens sleepingQueens;
    private List<Player> players;
    private int turn;

    public Game(int numOfPlayers) {
        initializeGame(numOfPlayers);
    }


    private void initializeGame(int numOfPlayers) {
        Random random = new Random();
        sleepingQueens = new SleepingQueens();
        players = new ArrayList<>();
        List<Card> cards = CardDeck.getAllCards();
        for(int i = 0; i < numOfPlayers; i++) {
            List<Card> playerCards = new ArrayList<>();
            for(int j = 0; j < 5; j++) {
                playerCards.add(cards.remove(random.nextInt(cards.size())));
            }
            players.add(new Player(i, playerCards));
        }
        piles = new DrawAndDiscardPile(cards, new ArrayList<>());
        turn = 0;
    }




}
