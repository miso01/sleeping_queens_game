import java.util.*;

public abstract class QueenCollection {

    private final Map<Position, Queen> queens = new HashMap<>();

    protected void addQueen(Queen queen) {
        // TODO impl we dont know how to get a position
    }

    Optional<Queen> removeQueen(Position position){
        return Optional.ofNullable(queens.remove(position));
    }

    public Map<Position, Queen> getQueens(){
        return queens;
    }

}
