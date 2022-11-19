import java.util.List;

public class Player {

    private PlayerState playerState;
    private final int playerIndex;
    private Hand hand;
    private AwokenQueens awokenQueens;

    public Player(int playerIndex,List<Card> cards) {
        this.playerIndex = playerIndex;
        this.hand = new Hand(playerIndex,cards);
        this.awokenQueens = new AwokenQueens();
    }


    public PlayerState getPlayerState() {
        return playerState;
    }
}
