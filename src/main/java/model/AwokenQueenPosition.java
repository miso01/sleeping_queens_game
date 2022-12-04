package model;

import java.util.Objects;

public class AwokenQueenPosition extends Position {

    private final int playerIndex;

    public AwokenQueenPosition(int cardIndex, int playerIndex) {
        super(cardIndex);
        this.playerIndex = playerIndex;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AwokenQueenPosition that = (AwokenQueenPosition) o;
        return playerIndex == that.playerIndex && getCardIndex() == that.getCardIndex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerIndex, getCardIndex());
    }

    @Override
    public String toString() {
        return "AwokenQueenPosition{" +
                "playerIndex=" + playerIndex +
                "cardIndex=" + getCardIndex() +
                '}';
    }
}
