package model;

import model.Card;
import model.CardType;
import model.Queen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    private static List<Card> getNumberCards() {
        List<Card> numberCards = new ArrayList<>();
        for (int val = 1; val <= 10; val++) {
            for (int i = 0; i < 4; i++) {
                numberCards.add(new Card(CardType.Number, val));
            }
        }
        return numberCards;
    }

    private static List<Card> getDragonCards() {
        List<Card> dragonCards = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            dragonCards.add(new Card(CardType.Dragon, 0));
        }
        return dragonCards;
    }

    private static List<Card> getWandCards() {
        List<Card> wandCards = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            wandCards.add(new Card(CardType.MagicWand, 0));
        }
        return wandCards;
    }

    private static List<Card> getSleepingPotionCards() {
        List<Card> sleepingPotionCards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            sleepingPotionCards.add(new Card(CardType.SleepingPotion, 0));
        }
        return sleepingPotionCards;
    }

    private static List<Card> getKnightsCards() {
        List<Card> knightsCards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            knightsCards.add(new Card(CardType.Knight, 0));
        }
        return knightsCards;
    }

    private static List<Card> getKingCards() {
        List<Card> kingCards = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            kingCards.add(new Card(CardType.King, 0));
        }
        return kingCards;
    }

    static public List<Card> getDeckWithoutQueens() {
        List<Card> cards = new ArrayList<>();
        cards.addAll(getNumberCards());
        cards.addAll(getKingCards());
        cards.addAll(getKnightsCards());
        cards.addAll(getSleepingPotionCards());
        cards.addAll(getDragonCards());
        cards.addAll(getWandCards());
        Collections.shuffle(cards);
        return cards;
    }

    static public List<Queen> getAllQueens() {
        List<Queen> queens = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            queens.add(new Queen(5));
        }
        for (int i = 0; i < 4; i++) {
            queens.add(new Queen(10));
        }
        for (int i = 0; i < 4; i++) {
            queens.add(new Queen(15));
        }
        for (int i = 0; i < 4; i++) {
            queens.add(new Queen(20));
        }
        Collections.shuffle(queens);
        return queens;
    }
}
