import model.*;

import java.util.*;

public class Game {

    private final IGameFinishedStrategy gameFinishedStrategy;
    private final List<Player> players;
    private int onTurn;
    private GameState gameState;
    private final int numberOfPlayers;
    private final SleepingQueens sleepingQueens;
    private final IPile drawAndDiscardPile;
    private int winnerId;

    public Game(int numberOfPlayers, int onTurn, List<Player> players, SleepingQueens sleepingQueens, IPile drawAndDiscardPile, IGameFinishedStrategy gameFinishedStrategy) {
        this.numberOfPlayers = numberOfPlayers;
        this.onTurn = onTurn;
        this.players = players;
        this.sleepingQueens = sleepingQueens;
        this.drawAndDiscardPile = drawAndDiscardPile;
        this.winnerId = -1;
        this.gameFinishedStrategy = gameFinishedStrategy;
        composeGameState();
    }

    GameState play(int playerIndex, List<HandPosition> handPositions, List<Position> targetPositions) throws IllegalArgumentException {
        verifyInput(playerIndex, handPositions, targetPositions);
        Position targetPosition = targetPositions.get(0);
        Player defender = null;
        if (targetPosition instanceof AwokenQueenPosition)
            defender = players.get(((AwokenQueenPosition) targetPosition).getPlayerIndex());
        players.get(onTurn).play(defender, handPositions, targetPositions.get(0));
        updateOnTurn();
        winnerId = gameFinishedStrategy.isFinished(gameState);
        return composeGameState();
    }

    void verifyInput(int playerIndex, List<HandPosition> handPositions, List<Position> targetPositions) throws IllegalArgumentException {
        if (playerIndex != onTurn) {
            throw new IllegalArgumentException("It is not your turn!");
        }

        if (targetPositions.size() > 1) {
            throw new IllegalArgumentException("You can only attack one card!");
        }

        if (handPositions.size() == 0) {
            throw new IllegalArgumentException("You must play at least one card!");
        }

        List<Card> handCards = new ArrayList<>();
        handPositions.forEach(handPosition -> {
            Card card = players.get(playerIndex).getHand().getCards().get((handPosition));
            if (card != null)
                handCards.add(card);
        });

        if (handCards.size() != handPositions.size()) {
            throw new IllegalArgumentException("Player does not have all the specified cards>");
        }

        if (handCards.size() > 1 && !handCards.stream().allMatch(c -> c.getType() == CardType.Number)) {
            throw new IllegalArgumentException("You can only play with multiple numbered cards!");
        }

        if (handCards.stream().allMatch(c -> c.getType() == CardType.Number)) {
            throw new IllegalArgumentException("You can't attack with numbered cards!");
        }

        if (handCards.size() != 1) {
            throw new IllegalArgumentException("You can only attack with single card!");
        }

        if (handCards.get(0).getType() == CardType.Number) {
            throw new IllegalArgumentException("You can't attack with numbered card!");
        }

        if (handCards.get(0).getType() == CardType.MagicWand || handCards.get(0).getType() == CardType.Dragon) {
            throw new IllegalArgumentException("Defense cards are played automatically in this version of game!");
        }

    }

    private GameState composeGameState() {
        Map<HandPosition, Card> allCardsOfPlayers = new HashMap<>();
        Map<AwokenQueenPosition, Queen> allAwokenQueensOfPlayer = new HashMap<>();
        players.forEach(player -> {
            allCardsOfPlayers.putAll(player.getHand().getCards());
            allAwokenQueensOfPlayer.putAll(player.getAwokenQueens().getQueens());
        });
        this.gameState = new GameState(numberOfPlayers, onTurn, sleepingQueens.getQueens().keySet(), allCardsOfPlayers, allAwokenQueensOfPlayer, drawAndDiscardPile.getCardsDiscardedThisTurn(), winnerId);
        return gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    private void updateOnTurn() {
        onTurn = (onTurn + 1) % numberOfPlayers;
    }

}
