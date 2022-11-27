import java.util.Optional;

public class Position {

    private HandPosition handPosition;
    private SleepingQueenPosition sleepingQueenPosition;
    private AwokenQueenPosition awokenQueenPosition;

    public Position(HandPosition handPosition) {
        this.handPosition = handPosition;
    }

    public Position(SleepingQueenPosition sleepingQueenPosition) {
        this.sleepingQueenPosition = sleepingQueenPosition;
    }

    public Position(AwokenQueenPosition awokenQueenPosition) {
        this.awokenQueenPosition = awokenQueenPosition;
    }

    public Optional<HandPosition> getHandPosition() {
        return Optional.of(handPosition);
    }

    public Optional<AwokenQueenPosition> getAwokenQueenPosition() {
        return Optional.of(awokenQueenPosition);
    }

    public Optional<SleepingQueenPosition> getSleepingQueenPosition() {
        return Optional.of(sleepingQueenPosition);
    }
}
