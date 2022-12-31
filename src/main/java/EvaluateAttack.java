import model.*;


import java.util.Optional;

public class EvaluateAttack {

    private final QueenCollection<SleepingQueenPosition> sleepingQueens;

    public EvaluateAttack(QueenCollection<SleepingQueenPosition> sleepingQueens) {
        this.sleepingQueens = sleepingQueens;
    }

    boolean play(Player defender, Player attacker, Position targetCardPosition, HandPosition attackCardPosition) {
        Card attackCard = attacker.getHand().getCards().get(attackCardPosition);
        Optional<Queen> targetQueen = Optional.empty();
        if (targetCardPosition instanceof SleepingQueenPosition) {
            targetQueen = sleepingQueens.getQueen(targetCardPosition);
        } else if (targetCardPosition instanceof AwokenQueenPosition) {
            targetQueen = defender.getAwokenQueens().getQueen(targetCardPosition);
        }
        return targetQueen.isPresent() && attackCard != null;
    }
}
