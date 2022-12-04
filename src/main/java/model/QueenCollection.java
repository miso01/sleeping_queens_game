package model;

import java.util.*;

public abstract class QueenCollection<T extends Position> {

    protected final List<Queen> queens;

    protected QueenCollection(List<Queen> queens) {
        this.queens = new ArrayList<>(queens);
    }

    protected QueenCollection() {
        this.queens = new ArrayList<>();
    }

    public void addQueen(Queen queen) {
        this.queens.add(queen);
    }

    protected void addQueens(List<Queen> queens) {
        this.queens.addAll(queens);
    }

    public Optional<Queen> removeQueen(Position position) {
        try {
            return Optional.ofNullable(queens.remove(position.getCardIndex()));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public abstract Map<T, Queen> getQueens();
}