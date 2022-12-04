import model.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EvaluateAttack {

    private final SleepingQueens sleepingQueens;

    public EvaluateAttack(SleepingQueens sleepingQueens) {
        this.sleepingQueens = sleepingQueens;
    }

    boolean play(Player defender, Player attacker, Position targetCardPosition, HandPosition attackCardPosition) {
        Card attackCard = attacker.getHand().getCards().get(attackCardPosition);
        switch (attackCard.getType()) {
            case Knight -> {
                Map<HandPosition, Card> defenseCards = defender.getHand().hasCardOfType(CardType.Dragon);
                if (!defenseCards.isEmpty()) {
                    defender.getHand().removeCardsAndRedraw(List.of(defenseCards.keySet().iterator().next()));
                    attacker.getHand().removeCardsAndRedraw(List.of(attackCardPosition));
                    return true;
                } else {
                    boolean result = defender.getMoveQueen().stealQueen((AwokenQueenPosition) targetCardPosition, attacker.getAwokenQueens());
                    if (result) {
                        attacker.getHand().removeCardsAndRedraw(List.of(attackCardPosition));
                    }
                    return result;
                }
            }
            case SleepingPotion -> {
                Map<HandPosition, Card> defenseCards = defender.getHand().hasCardOfType(CardType.MagicWand);
                if (!defenseCards.isEmpty()) {
                    defender.getHand().removeCardsAndRedraw(List.of(defenseCards.keySet().iterator().next()));
                    attacker.getHand().removeCardsAndRedraw(List.of(attackCardPosition));
                    return true;
                } else {
                    boolean result = defender.getMoveQueen().putQueenToSleep((AwokenQueenPosition) targetCardPosition);
                    if (result) {
                        attacker.getHand().removeCardsAndRedraw(List.of(attackCardPosition));
                    }
                    return result;
                }
            }
            case King -> {
                Optional<Queen> sleepingQueen = sleepingQueens.removeQueen(targetCardPosition);
                if (sleepingQueen.isPresent()) {
                    sleepingQueens.getQueens().remove((SleepingQueenPosition) targetCardPosition);
                    attacker.getAwokenQueens().addQueen(sleepingQueen.get());
                    attacker.getHand().removeCardsAndRedraw(List.of(attackCardPosition));
                    return true;
                }
                return false;
            }
            default -> {
                return false;
            }
        }
    }
}
