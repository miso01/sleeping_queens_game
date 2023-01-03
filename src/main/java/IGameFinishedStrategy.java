import model.GameState;

public interface IGameFinishedStrategy {
    int isFinished(GameState gameState);
}
