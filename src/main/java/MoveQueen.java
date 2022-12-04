import java.util.Optional;

public class MoveQueen {

    private final SleepingQueens sleepingQueens;
    private final AwokenQueens defenderAwokenQueens;

    public MoveQueen(SleepingQueens sleepingQueens, AwokenQueens defenderAwokenQueens) {
        this.sleepingQueens = sleepingQueens;
        this.defenderAwokenQueens = defenderAwokenQueens;
    }

    boolean stealQueen(AwokenQueenPosition awokenQueenPosition, AwokenQueens attackerAwokenQueens) {
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
