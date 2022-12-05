package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SleepingQueens extends QueenCollection<SleepingQueenPosition> {

    public SleepingQueens() {
        super(CardDeck.getAllQueens());
    }

    public SleepingQueens(List<Queen> queens) {
        super(queens);
    }

    @Override
    public Map<SleepingQueenPosition, Queen> getQueens() {
        Map<SleepingQueenPosition, Queen> queensMap = new HashMap<>();
        for (int i = 0; i < queens.size(); i++) {
            queensMap.put(new SleepingQueenPosition(i), queens.get(i));
        }
        return queensMap;
    }
}
