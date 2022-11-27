import java.util.ArrayList;
import java.util.List;

public class GameObservable {

    private List<GameObserver> subscribers;

    public GameObservable() {
        subscribers = new ArrayList<>();
    }

    void add(GameObserver gameObserver) {
        subscribers.add(gameObserver);
    }

    void remove(GameObserver gameObserver) {
        subscribers.remove(gameObserver);
    }

    void addPlayer(int playerIndex, GameObserver observer){

    }

    void notifyAll(GameState message){

    }

}
