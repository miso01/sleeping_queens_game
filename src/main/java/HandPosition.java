import java.util.Objects;

public class HandPosition {

    private final int cardIndex;
    private final int playerIndex;

    public HandPosition(int cardIndex, int playerIndex) {
        this.cardIndex = cardIndex;
        this.playerIndex = playerIndex;
    }

    public int getCardIndex() {
        return cardIndex;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandPosition that = (HandPosition) o;
        return cardIndex == that.cardIndex && playerIndex == that.playerIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardIndex, playerIndex);
    }
}