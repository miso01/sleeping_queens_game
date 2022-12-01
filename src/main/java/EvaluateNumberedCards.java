import java.util.List;

public class EvaluateNumberedCards {

    boolean play(List<Card> cards) {
        if (cards.size() == 1) {
            return true;
        }
        List<Integer> cardValues = cards.stream().map(Card::getValue).toList();
        int cardSum = cardValues.stream().mapToInt(Integer::intValue).sum();
        for (int cardValue : cardValues) {
            if (cardValues.contains(cardSum - cardValue)) {
                return true;
            }
        }
        return false;
    }

}
