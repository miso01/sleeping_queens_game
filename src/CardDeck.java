import java.util.ArrayList;
import java.util.List;

// class resposible for string all types of cards
public  class CardDeck {

    static List<Card> getNumberCards() {
        List<Card> numberCards = new ArrayList<>();
        for(int val = 1; val <= 10; val++){
            for(int i = 0; i < 4; i++){
                numberCards.add(new Card(CardType.Number, val));
            }
        }
        return numberCards;
    }

    static List<Card> getDragonCards(){
        List<Card> dragonCards = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            dragonCards.add(new Card(CardType.Dragon, 0));
        }
        return dragonCards;
    }

    static List<Card> getWandCards(){
        List<Card> wandCards = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            wandCards.add(new Card(CardType.MagicWand, 0));
        }
        return wandCards;
    }
    static List<Card> getSleepingPotionCards(){
        List<Card> sleepingPotionCards = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            sleepingPotionCards.add(new Card(CardType.SleepingPotion, 0));
        }
        return sleepingPotionCards;
    }

    static List<Card> getKnightsCards(){
        List<Card> knightsCards = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            knightsCards.add(new Card(CardType.Knight, 0));
        }
        return knightsCards;
    }

    static List<Card> getKingCards(){
        List<Card> kingCards = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            kingCards.add(new Card(CardType.King, 0));
        }
        return kingCards;
    }

    static List<Card> getAllCards(){
        List<Card> cards = new ArrayList<>();
        cards.addAll(getNumberCards());
        cards.addAll(getKingCards());
        cards.addAll(getKnightsCards());
        cards.addAll(getSleepingPotionCards());
        cards.addAll(getDragonCards());
        cards.addAll(getWandCards());
        return cards;
    }
}
