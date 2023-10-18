package leetcode;

public class Card {
    private String suit;//花色
    private int number; //数字

    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        /*return "Card{" +
                "suit='" + suit + '\'' +
                ", number=" + number +
                '}';*/
        return number + "" + suit;
    }
}
