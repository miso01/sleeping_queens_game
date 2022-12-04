package model;

public class AwokenQueenPosition extends Position {

    private final int playerIndex;

    public AwokenQueenPosition(int cardIndex, int playerIndex) {
        super(cardIndex);
        this.playerIndex = playerIndex;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }
}
