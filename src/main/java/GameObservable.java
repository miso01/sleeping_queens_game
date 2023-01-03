import model.GameState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameObservable {

    private final List<IGameObserver> otherSubscribers;
    private final Map<Integer, IGameObserver> playerSubscribers;

    public GameObservable() {
        otherSubscribers = new ArrayList<>();
        playerSubscribers = new HashMap<>();
    }

    void add(IGameObserver gameObserver) {
        otherSubscribers.add(gameObserver);
    }

    void remove(IGameObserver gameObserver) {
        otherSubscribers.remove(gameObserver);
    }

    void addPlayer(int playerIndex, IGameObserver observer){
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
