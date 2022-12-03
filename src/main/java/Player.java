import java.util.ArrayList;
import java.util.List;

public class Player {

    private final int playerIndex;
    private final Hand hand;
    private final AwokenQueens awokenQueens;

    public Player(int playerIndex, List<Card> cards, DrawAndDiscardPile drawAndDiscardPile) {
        this.playerIndex = playerIndex;
        this.hand = new Hand(playerIndex, cards, drawAndDiscardPile);
        this.awokenQueens = new AwokenQueens(playerIndex);
    }

    public PlayerState getPlayerState() {
        return new PlayerState(playerIndex, hand.getCards(), awokenQueens.getQueens());
    }

    boolean play(List<Integer> position){
        List<Card> cards = new ArrayList<>();
        position.forEach(p -> cards.add(hand.getCards().get(p)));
        if(cards.stream().allMatch(c -> c.getType() == CardType.Number)){
            boolean result = EvaluateNumberedCards.play(cards);
            System.out.println("numbered cards result is ");
            return result;
        }



        return false;
    }

    void printCards(){
        System.out.println("player id " + playerIndex);
        for (Card card: hand.getCards().values()) {
            System.out.println(card);
        }
    }
}
