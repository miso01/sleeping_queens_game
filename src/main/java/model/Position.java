package model;

abstract public class Position {

    private final int cardIndex;

    public Position(int cardIndex) {
        this.cardIndex = cardIndex;
    }

    public int getCardIndex() {
        return cardIndex;
    }
}
