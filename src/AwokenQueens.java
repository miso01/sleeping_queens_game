import java.util.List;
import java.util.Optional;

public class AwokenQueens {

    int playerIndex;
    private List<Queen> queens;

    public AwokenQueens() {

    }

    private void addQueen(Queen queen) {
        queens.add(queen);
    }

    private Optional<Queen> pickQueen(AwokenQueenPosition position) {
        return Optional.empty();
    }

    public List<Queen> getQueens(){
        return queens;
    }



}
