package model;

public class Queen {
    private final int points;

    public Queen(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Queen{" +
                "points=" + points +
                '}';
    }
}
