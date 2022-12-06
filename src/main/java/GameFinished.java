import model.GameState;

import java.util.*;

public class GameFinished implements GameFinishedStrategy {

    @Override
    public int isFinished(GameState gameState) {

        int pointsNeeded = -1;
        int queensNeeded = -1;

        if (gameState.getNumberOfPlayers() >= 2 && gameState.getNumberOfPlayers() <= 3) {
            pointsNeeded = 50;
            queensNeeded = 5;
        } else if (gameState.getNumberOfPlayers() >= 4 && gameState.getNumberOfPlayers() <= 5) {
            pointsNeeded = 40;
            queensNeeded = 4;
        }

        Map<Integer, Integer> points = new HashMap<>();
        Map<Integer, Integer> queens = new HashMap<>();
        gameState.getCards().forEach((handPosition, card) -> {
            points.put(handPosition.getPlayerIndex(), points.getOrDefault(handPosition.getPlayerIndex(), 0) + card.getValue());
        });

        gameState.getAwokenQueens().forEach((awokenQueenPosition, queen) ->{
            points.put(awokenQueenPosition.getPlayerIndex(), points.getOrDefault(awokenQueenPosition.getPlayerIndex(), 0) + queen.getPoints());
            queens.put(awokenQueenPosition.getPlayerIndex(), queens.getOrDefault(awokenQueenPosition.getPlayerIndex(), 0) + 1);
        });

        Map.Entry<Integer, Integer> maxPoints = Collections.max(points.entrySet(), Map.Entry.comparingByValue());
        if (maxPoints.getValue() >= pointsNeeded) {
            return maxPoints.getKey();
        }

        Map.Entry<Integer, Integer> maxQueens = Collections.max(points.entrySet(), Map.Entry.comparingByValue());
        if (maxQueens.getValue() >= queensNeeded) {
            return maxQueens.getKey();
        }

        if(gameState.getSleepingQueens().isEmpty()) {
            return maxPoints.getKey();
        }

        return -1;
    }
}















