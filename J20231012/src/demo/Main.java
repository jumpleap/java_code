package demo;

import java.util.Scanner;

/**
 * 扑克牌大小
 */

// 注意类名必须为 Main, 不要有任何 package xxx 信息
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] sp = str.split("-");
        String[] p1 = sp[0].split(" ");
        String[] p2 = sp[1].split(" ");
        String s = "34567891JQKA2";//10使用1表示

        if (sp[0].equals("joker JOKER") || sp[1].equals("joker JOKER")) { // 其中一副手牌是对王
            System.out.println("joker JOKER");
        } else if (p1.length == p2.length) { //两副手牌长度相同,比较牌面大小
            //使用substring, 防止10的情况, 我们把10看成1
            if (s.indexOf(p1[0].substring(0, 1)) > s.indexOf(p2[0].substring(0, 1))) {
                System.out.println(sp[0]);
            } else {
                System.out.println(sp[1]);
            }
        } else if (p1.length == 4) { //其中一副牌是炸弹
            System.out.println(sp[0]);
        } else if (p2.length == 4) { //其中一副牌是炸弹
            System.out.println(sp[1]);
        } else { //两副牌长度不同, 无法比较
            System.out.println("ERROR");
        }
    }
}