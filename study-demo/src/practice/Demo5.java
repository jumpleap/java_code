package practice;

import util.ListNode;

import java.util.Scanner;

// day5 - 笔试题
public class Demo5 {
    /*
        游游现在有a个'y'，b个'o'，c个'u'，他想用这些字母拼成一个字符串。
        三个相邻的字母是"you"可以获得2分，两个相邻的字母是"oo"，可以获得1分。
        问最多可以获得多少分？
        链接: https://www.nowcoder.com/questionTerminal/cd117803b3364b218a8b3dcc498dee25?page=1&onlyReference=false
     */
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            // 获取结果
            int result = getResult(a, b, c);
            System.out.println(result);
        }
    }

    /**
     * 思路分析: 模拟, 找到abc中最小的一个, 匹配完整的abc, 然后在判断b的值减去匹配abc中b数量后是否大于2, 进行匹配
     */
    private static int getResult(int a, int b, int c) {
        int sum = 0;
        // 找到最小的值, 匹配abc
        int min = Math.min(Math.min(a, b), c);

        // 匹配是每个2分
        sum = min * 2;

        // 只有oo的情况下, 匹配加1分
        if (b - min >= 2) {
            sum = sum + b - min - 1;
        }
        // 返回结果
        return sum;
    }


    /*
        给定一个 n×m  的网格，其中每个单元格中可能有三种值中的一个 0 , 1 , 2。
        其中 0 表示这个格子为空、1 表示这个格子有一个完好的苹果，2 表示这个格子有一个腐烂的苹果。
        腐烂的苹果每分钟会向上下左右四个方向的苹果传播一次病菌，并导致相邻的苹果腐烂。请问经过多少分钟，网格中不存在完好的苹果。如果有苹果永远不会腐烂则返回 -1
        数据范围： 1≤n,m≤1000  ，网格中的值满足 0≤val≤2
        链接: https://www.nowcoder.com/practice/54ab9865ce7a45968b126d6968a77f34?tpId=196&tqId=40529&ru=/exam/oj
     */



    /*
        描述
            每年六一儿童节，牛客都会准备一些小礼物和小游戏去看望孤儿院的孩子们。其中，有个游戏是这样的：
            首先，让 n 个小朋友们围成一个大圈，小朋友们的编号是0~n-1。然后，随机指定一个数 m ，
            让编号为0的小朋友开始报数。每次喊到 m-1 的那个小朋友要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，
            并且不再回到圈中，从他的下一个小朋友开始，继续0... m-1报数....这样下去....直到剩下最后一个小朋友，
            可以不用表演，并且拿到牛客礼品，请你试着想下，哪个小朋友会得到这份礼品呢？
        数据范围：1≤n≤5000，1≤m≤10000
        要求：空间复杂度 O(1)，时间复杂度 O(n)
        链接: https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&ru=/exam/oj
     */

    /**
     * 法一
     * 思路分析: 环形链表 + 模拟; 创建环形链表, 然后创建计数遍历, 每次都计数到要删除节点的前一个节点, 然后删除待删除节点, 直到只有最后一个节点
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    public int LastRemaining_Solution(int n, int m) {
        // 创建环形链表并连接链表
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            ListNode node = new ListNode(i);
            head.next = node;
            head = head.next;
        }
        // 首尾相连
        head.next = cur;

        // 只有一个节点后跳出
        while (cur != cur.next) {
            // 计数, 每次都让cur指向要删除的前一个数
            int count = 1;
            // 让cur指向要删除的前一个数
            while (count < m - 1) {
                cur = cur.next;
                count++;
            }
            // 删除cur的下一个节点
            cur.next = cur.next.next;
            // 指向下一个要计数的节点
            cur = cur.next;
        }
        // 返回最后一个节点
        return cur.val;
    }
}