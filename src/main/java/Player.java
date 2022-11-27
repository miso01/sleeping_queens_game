import java.util.List;

public class Player {

    private final int playerIndex;
    private final Hand hand;
    private final AwokenQueens awokenQueens;

    public Player(int playerIndex, List<Card> cards) {
        this.playerIndex = playerIndex;
        this.hand = new Hand(playerIndex, cards);
        this.awokenQueens = new AwokenQueens();
    }


    public PlayerState getPlayerState() {

        return new PlayerState(hand.getCards(), awokenQueens.getQueens());

    }

    void play(List<Integer> position){

    }


    void printCards(){
        System.out.println("player id " + playerIndex);
        for (Card card: hand.getCards()) {
            System.out.println(card);
        }
    }
}
