package model;

import java.util.Objects;

public class SleepingQueenPosition extends Position {

    public SleepingQueenPosition(int cardIndex) {
        super(cardIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SleepingQueenPosition that = (SleepingQueenPosition) o;
        return getCardIndex() == that.getCardIndex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardIndex());
    }

    @Override
    public String toString() {
        return "SleepingQueenPosition{cardIndex=" + getCardIndex() + "}";
    }
}
