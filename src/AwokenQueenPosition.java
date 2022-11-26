public class AwokenQueenPosition {

    private final int cardIndex;
    private final int playerIndex;

    public AwokenQueenPosition(int cardIndex, int playerIndex) {
        this.cardIndex = cardIndex;
        this.playerIndex = playerIndex;
    }

    public int getCardIndex() {
        return cardIndex;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }
}
