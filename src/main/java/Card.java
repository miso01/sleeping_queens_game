import java.util.ArrayList;
import java.util.List;

// this game doesnt involve "Jester" card therefore we have 74 cards total;
public class Card {
    CardType type;
    int value;

    public Card(CardType type, int value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{type=" + type +" & value=" + value +"}";
    }
}
