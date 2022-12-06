import model.GameState;

public interface GameFinishedStrategy {
    int isFinished(GameState gameState);
}
