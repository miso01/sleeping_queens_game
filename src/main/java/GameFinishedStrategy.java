import model.GameState;

import java.util.Optional;

public interface GameFinishedStrategy {
    Optional<Integer> isFinished(GameState gameState);
}
