import java.util.HashMap;
import java.util.Map;

public class AwokenQueens extends QueenCollection {

    @Override
    Map<? extends Position, Queen> getQueens() {
        Map<SleepingQueenPosition, Queen> queensMap = new HashMap<>();
        for (int i = 0; i < queens.size(); i++) {
            queensMap.put(new SleepingQueenPosition(i), queens.get(i));
        }
        return queensMap;
    }

}
