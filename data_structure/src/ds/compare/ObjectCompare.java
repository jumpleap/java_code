package ds.compare;

import java.util.Comparator;

// 对象的比较
public class ObjectCompare {
    // 字符串的比较
    public static void main3(String[] args) {
        String s1 = "abcd";
        String s2 = "abcd";
        // Java中字符串字面量（例如"abcd"）在字符串常量池中被缓存，
        // 当两个变量都指向同一个字符串字面量时，它们实际上引用的是堆内存中同一个字符串对象。
        System.out.println(s1 == s2); // true

        String s3 = new String("abcd");
        // 比较内存地址，s3是new出来的，不是从字符串常量池中拿的
        System.out.println(s3 == s2); // false

        String s4 = new String("abcd");
        // 地址不同
        System.out.println(s3 == s4); // false

        // equals方法先比较内存地址是否相同，不相同再比较值是否相同
        System.out.println(s3.equals(s4)); //true
    }


    // 包装类和基本类的比较
    public static void main2(String[] args) {
        // 包装类和包装类的比较
        Integer num1 = new Integer(1);
        Integer num2 = new Integer(1);
        // 对象的地址不一样
        System.out.println(num1 == num2); // false

        // 地址不同
        Integer num3 = 1;
        System.out.println(num1 == num3); // false

        // 包装类和基本类的比较
        int num4 = 1;
        // 包装类和对应的基本类型比较的时候： 比较的是值是否相等
        System.out.println(num4 == num1); // true

        // 自动装箱: 基本类型转为对应的对象类型
        Integer num5 = new Integer(num4);
        System.out.println(num5);
        Integer num6 = Integer.valueOf(6);
        System.out.println(num6);

        // 自动拆箱： 基本类型对应的包装类型转为基本类型
        int num7 = num6.intValue();
        int num8 = num1;
        System.out.println(num7);
        System.out.println(num8);
    }

    // 基本类型的比较
    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a > b); // false
        System.out.println(a < b); // true
        System.out.println(a == b); // false

        char c1 = 'A';
        char c2 = 'B';
        System.out.println(c1 > c2); // false
        System.out.println(c1 < c2); // true
        System.out.println(c1 == c2); // false

        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 == b2); // false
        System.out.println(b1 != b2); // true
    }


    // 对象的比较：未重写Object方法与重写的区别
    public static void main4(String[] args) {
        Card card1 = new Card(1,"♠");
        Card card2 = new Card(1,"♠");
        // 地址不同
        System.out.println(card1 == card2); // false

        // 值相同
        System.out.println(card1.equals(card2)); // true

        // 注：equals方法只能比较等于的情况，即true和false的情况， 无法比较大于小于的情况
    }

    // 基于Comparable的比较
    // 实现Comparable接口，重写compareTo方法, 对类的侵入性较强
    public static void main5(String[] args) {
        Card card1 = new Card(1,"♠");
        Card card2 = new Card(1,"♠");
        Card card3 = new Card(3,"♠");

        System.out.println(card1.compareTo(card2)); // 0
        System.out.println(card3.compareTo(card1)); // 2
        System.out.println(card1.compareTo(card3)); // -2
    }

    // 基于Comparator比较
    // 实现Comparator接口，重写compare方法
    public static void main(String[] args) {
        CardComparator cardComparator = new CardComparator();

        Card card1 = new Card(1,"♠");
        Card card2 = new Card(1,"♠");
        Card card3 = new Card(2,"♠");

        // 0 - 相等
        System.out.println(cardComparator.compare(card1, card2)); // 0
        System.out.println(cardComparator.compare(card1, card3)); // -1 : card1比较小
        System.out.println(cardComparator.compare(card3, card2)); // 1
        
    }
}

// 实现Comparable接口需要重写compareTo方法
class Card implements Comparable<Card>{
    public int rank; // 数值
    public String suit; // 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        // 同一对象
        if (obj == this) return true;

        // obj为空 或 不是Card对象
        if (obj == null || !(obj instanceof Card)) return false;

        // 向下转型
        Card card = (Card) obj;

        // 判断数值和花色是否相同
        return this.rank == card.rank && this.suit.equals(card.suit);
    }

    // 重写compareTo方法
    // 这里我们根据数值比较，不关心花色的问题
    @Override
    public int compareTo(Card o) {
        // o为空，最小
        if (o == null) return 1;

        return rank - o.rank;
    }
}

class CardComparator implements Comparator<Card> {

    // 重写compare方法
    @Override
    public int compare(Card o1, Card o2) {
        // 相等
        if (o1 == o2) return 0;

        // 为空
        if (o1 == null) return o2.rank;
        if (o2 == null) return o1.rank;

        return o1.rank - o2.rank;
    }
}