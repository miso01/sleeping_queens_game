package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AwokenQueens extends QueenCollection<AwokenQueenPosition> {

    private final int playerIndex;

    public AwokenQueens(int playerIndex) {
        super();
        this.playerIndex = playerIndex;
    }

    public AwokenQueens(int playerIndex, List<Queen> queens) {
        super(queens);
        this.playerIndex = playerIndex;
    }

    @Override
    public Map<AwokenQueenPosition, Queen> getQueens() {
        Map<AwokenQueenPosition, Queen> queensMap = new HashMap<>();
        for (int i = 0; i < queens.size(); i++) {
            queensMap.put(new AwokenQueenPosition(i, playerIndex), queens.get(i));
        }
        return queensMap;
    }
}
