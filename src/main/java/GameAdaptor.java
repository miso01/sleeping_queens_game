import model.AwokenQueenPosition;
import model.HandPosition;
import model.Position;
import model.SleepingQueenPosition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameAdaptor implements IGamePlayerInterface {

    private final Game game;
    private final GameObservable gameObservable;

    public GameAdaptor(Game game, GameObservable gameObservable) {
        this.game = game;
        this.gameObservable = gameObservable;
    }

    @Override
    public String play(String player, String command) {
        int playerIndex = Integer.parseInt(player); // in real-word scenario this would be replaced with something else
        List<HandPosition> attackerCardPositions = new ArrayList<>();
        List<Position> targetPositions = new ArrayList<>();
        Arrays.stream(command.split(" ")).toList().forEach(cmd -> {
            final int cardIndex = Integer.parseInt(Character.toString(cmd.charAt(1)));
            switch (cmd.charAt(0)) {
                case 'h' -> attackerCardPositions.add(new HandPosition(cardIndex, playerIndex));
                case 'a' -> targetPositions.add(new AwokenQueenPosition(cardIndex, playerIndex));
                case 's' -> targetPositions.add(new SleepingQueenPosition(cardIndex));
            }
        });
        try {
            return game.play(playerIndex, attackerCardPositions, targetPositions).toString();
        } catch (IllegalArgumentException e) {
            return "Invalid command: " + e.getMessage();
        }
    }
}
