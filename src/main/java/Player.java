import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Player {

    private final int playerIndex;
    private final IHand hand;
    private final QueenCollection<AwokenQueenPosition> awokenQueens;
    private final MoveQueen moveQueen;
    private final EvaluateNumberedCards evaluateNumberedCards;
    private final EvaluateAttack evaluateAttack;
    private final QueenCollection<SleepingQueenPosition> sleepingQueens;

    public Player(int playerIndex, IHand hand, QueenCollection<SleepingQueenPosition> sleepingQueens, QueenCollection<AwokenQueenPosition> awokenQueens) {
        this.playerIndex = playerIndex;
        this.awokenQueens = awokenQueens;
        this.hand = hand;
        this.moveQueen = new MoveQueen(sleepingQueens, awokenQueens);
        this.sleepingQueens = sleepingQueens;
        this.evaluateNumberedCards = new EvaluateNumberedCards();
        this.evaluateAttack = new EvaluateAttack(sleepingQueens);
    }

    void play(Player defender, List<HandPosition> handPositions, Position targetQueenPosition) throws IllegalArgumentException {
        List<Card> handCards = new ArrayList<>();
        handPositions.forEach(handPosition -> handCards.add(hand.getCards().get((handPosition))));
        if (handCards.stream().allMatch(c -> c.getType() == CardType.Number)) {
            boolean result = evaluateNumberedCards.play(handCards);
            if (!result) throw new IllegalArgumentException("Your cards are do not form any equation!");
            hand.removeCardsAndRedraw(handPositions);
        } else if (evaluateAttack.play(defender, this, targetQueenPosition, handPositions.get(0))) {
            Card attackCard = hand.getCards().get(handPositions.get(0));
            HandPosition attackCardPosition = handPositions.get(0);
            switch (attackCard.getType()) {
                case Knight -> {
                    Map<HandPosition, Card> defenseCards = defender.getHand().hasCardOfType(CardType.Dragon);
                    if (!defenseCards.isEmpty()) {
                        defender.getHand().removeCardsAndRedraw(List.of(defenseCards.keySet().iterator().next()));
                        this.getHand().removeCardsAndRedraw(List.of(attackCardPosition));
                    } else {
                        boolean result = defender.getMoveQueen().stealQueen((AwokenQueenPosition) targetQueenPosition, this.getAwokenQueens());
                        if (result) {
                            this.getHand().removeCardsAndRedraw(List.of(attackCardPosition));
                        }
                    }
                }
                case SleepingPotion -> {
                    Map<HandPosition, Card> defenseCards = defender.getHand().hasCardOfType(CardType.MagicWand);
                    if (!defenseCards.isEmpty()) {
                        defender.getHand().removeCardsAndRedraw(List.of(defenseCards.keySet().iterator().next()));
                        this.getHand().removeCardsAndRedraw(List.of(attackCardPosition));
                    } else {
                        boolean result = defender.getMoveQueen().putQueenToSleep((AwokenQueenPosition) targetQueenPosition);
                        if (result) {
                            this.getHand().removeCardsAndRedraw(List.of(attackCardPosition));
                        }
                    }
                }
                case King -> {
                    Optional<Queen> sleepingQueen = sleepingQueens.removeQueen(targetQueenPosition);
                    if (sleepingQueen.isPresent()) {
                        sleepingQueens.getQueens().remove((SleepingQueenPosition) targetQueenPosition);
                        this.getAwokenQueens().addQueen(sleepingQueen.get());
                        this.getHand().removeCardsAndRedraw(List.of(attackCardPosition));
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("You have entered invalid cards!");
        }
    }

    public PlayerState getPlayerState() {
        return new PlayerState(playerIndex, hand.getCards(), awokenQueens.getQueens());
    }

    public IHand getHand() {
        return hand;
    }

    public QueenCollection<AwokenQueenPosition> getAwokenQueens() {
        return awokenQueens;
    }

    public MoveQueen getMoveQueen() {
        return moveQueen;
    }
}
