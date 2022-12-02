import java.util.Objects;

public class HandPosition extends Position {

    private final int playerIndex;

    public HandPosition(int cardIndex, int playerIndex) {
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
        HandPosition that = (HandPosition) o;
        return getCardIndex() == that.getCardIndex() && playerIndex == that.playerIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardIndex(), playerIndex);
    }
}