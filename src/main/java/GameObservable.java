import model.GameState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameObservable {

    private final List<GameObserver> otherSubscribers;
    private final Map<Integer,GameObserver> playerSubscribers;

    public GameObservable() {
        otherSubscribers = new ArrayList<>();
        playerSubscribers = new HashMap<>();
    }

    void add(GameObserver gameObserver) {
        otherSubscribers.add(gameObserver);
    }

    void remove(GameObserver gameObserver) {
        otherSubscribers.remove(gameObserver);
    }

    void addPlayer(int playerIndex, GameObserver observer){
        playerSubscribers.put(playerIndex,observer);
    }

    void removePlayer(int playerIndex){
        playerSubscribers.remove(playerIndex);
    }

    void notifyAll(GameState gameState){
        otherSubscribers.forEach(subscriber -> subscriber.notify(gameState.toString()));
        playerSubscribers.values().forEach(subscriber -> subscriber.notify(gameState.toString()));
    }

}
