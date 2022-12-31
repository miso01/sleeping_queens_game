import model.*;

import java.util.Optional;

public class MoveQueen {

    private final QueenCollection<SleepingQueenPosition> sleepingQueens;
    private final QueenCollection<AwokenQueenPosition> defenderAwokenQueens;

    public MoveQueen(QueenCollection<SleepingQueenPosition> sleepingQueens, QueenCollection<AwokenQueenPosition> defenderAwokenQueens) {
        this.sleepingQueens = sleepingQueens;
        this.defenderAwokenQueens = defenderAwokenQueens;
    }

    boolean stealQueen(AwokenQueenPosition awokenQueenPosition, QueenCollection<AwokenQueenPosition> attackerAwokenQueens) {
        Optional<Queen> queen = defenderAwokenQueens.removeQueen(awokenQueenPosition);
        if (queen.isPresent()) {
            attackerAwokenQueens.addQueen(queen.get());
            return true;
        }
        return false;
    }

    boolean putQueenToSleep(AwokenQueenPosition awokenQueenPosition) {
        Optional<Queen> queen = defenderAwokenQueens.removeQueen(awokenQueenPosition);
        if (queen.isPresent()) {
            sleepingQueens.addQueen(queen.get());
            return true;
        }
        return false;
    }

    boolean awakeQueen(SleepingQueenPosition sleepingQueenPosition) {
        Optional<Queen> queen = sleepingQueens.removeQueen(sleepingQueenPosition);
        if (queen.isPresent()) {
            defenderAwokenQueens.addQueen(queen.get());
            return true;
        }
        return false;
    }

}
