package model;

import java.util.Objects;

public class Card {

    private final CardType type;
    private final int value;

    public Card(CardType type, int value) {
        this.type = type;
        this.value = value;
    }

    public CardType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return this.value == card.value && this.type == card.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public String toString() {
        return "Card{type=" + type + " & value=" + value + "}";
    }

}
