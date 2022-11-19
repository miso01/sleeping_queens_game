public class GameObservable {

    private GameObserver gameObserver;

    void add(GameObserver gameObserver) {
        this.gameObserver = gameObserver;
    }

    void remove(GameObserver gameObserver) {
        this.gameObserver = null;
    }

    void addPlayer(int playerIndex, GameObserver observer){

    }

    void notifyAll(GameState message){

    }

}
