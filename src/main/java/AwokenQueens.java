import java.util.HashMap;
import java.util.Map;

public class AwokenQueens extends QueenCollection<AwokenQueenPosition> {

    private final int playerIndex;

    public AwokenQueens(int playerIndex) {
        super();
        this.playerIndex = playerIndex;
    }

    @Override
    Map<AwokenQueenPosition, Queen> getQueens() {
        Map<AwokenQueenPosition, Queen> queensMap = new HashMap<>();
        for (int i = 0; i < queens.size(); i++) {
            queensMap.put(new AwokenQueenPosition(i, playerIndex), queens.get(i));
        }
        return queensMap;
    }
}
