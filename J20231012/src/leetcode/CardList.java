package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 洗牌算法
 */
public class CardList {
    private static final String[] SUITS = {"♥", "♦", "♣", "♠"};


    public static void main(String[] args) {
        List<Card> cards = buyCard();
        //System.out.println(cards);
        shuffle(cards);
        System.out.println(cards);

        List<List<Card>> hand = new ArrayList<>();

        List<Card> hand1 = new ArrayList<>();
        List<Card> hand2 = new ArrayList<>();
        List<Card> hand3 = new ArrayList<>();

        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = cards.remove(0);
                hand.get(j).add(card);
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(hand.get(i));
        }
    }

    /**
     * 做牌
     * @return
     */
    public static List<Card> buyCard() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(SUITS[i], j);
                cards.add(card);
            }
        }
        return cards;
    }

    /**
     * 进行洗牌
     * @param cards
     */
    public static void shuffle(List<Card> cards) {
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int index = random.nextInt(i);
            swap(cards, i, index);
        }
    }

    private static void swap(List<Card> cards, int i, int j) {
        Card tmp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, tmp);
    }
}