package task;

import java.util.HashMap;
import java.util.Map;

public class Day10 {
    /*
    1、数组常用的两种基本操作是 （C）
    A. 建立与删除 B. 删除与查找 C. 查找与修改 D. 插入与索引
    //解析：数组中最常用的基本操作是查找和修改，这两个操作的时间复杂度都是O(1)

    2、线性表的逻辑顺序与物理顺序总是一致的 （B）
    A. 是 B. 否
    //解析：链表的逻辑机构和物理顺序不一致

    3、定义了一维 int 型数组 a[10] 后，下面错误的引用是（C）
    A. a[0] = 1; B. a[0] = 5*2; C. a[10] = 2; D. a[1] = a[2] * a[0];
    //解析：数组越界

    4、从一个长度为n的数组中删除第i个元素(1≤i≤n)时,需向前移动（）个元素 （A）
    A. n-i B. n-i+1 C. n-i-1 D. i
    //解析：从为n长度的数组中删除为i的元素时，需要前移n-i个元素
    //添加到i下标的元素时，需要后移n-i+1个元素

    5、下列关于链表的描述中正确的是【多选】（ABC）
    A. 链表由头指针唯一确定，单链表可以用头指针的名字来命名
    B. 线性链表的存储空间不一定连续，并且各元素的存储顺序是任意的
    C. 链表的插入删除不需要移动元素，可以只改变指针
    D. 链表可随机访问任一元素
    //解析：链表插入和删除的效率是O(1)，访问的效率是O(n)
     */

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param head 给定的头节点
     * @return 返回改变后的链表
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();

        int sum = 0;
        //进行前缀和的相加，若为同一个结果，则更新为最后一个结果
        for (ListNode tmp = dummy; tmp != null; tmp = tmp.next) {
            sum += tmp.val;
            map.put(sum, tmp);
        }

        sum = 0;
        //第二次的遍历，找和前缀和相同节点，让tmp指向该节点的下一个节点
        for (ListNode tmp = dummy; tmp != null; tmp = tmp.next) {
            sum += tmp.val;
            tmp.next = map.get(sum).next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Day10 test = new Day10();
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(-3);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(1);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        System.out.println("======");
        ListNode cur = test.removeZeroSumSublists(head);
        System.out.println();
        //ListNode p5 = new ListNode(2);

    }

    /*
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */

    /**
     * 思路分析：两两进行相加，若是长度不够的链表补0，最后需要判断相加的数是否大于10，进行进位判断
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param l1 l1
     * @param l2 l2
     * @return 返回相加后的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            //如果l1和l2其中一条链表为空，则后面补0
            int m = l1 == null ? 0 : l1.val;
            int n = l2 == null ? 0 : l2.val;

            //计算l1.val和l2.val的和
            int sum = m + n + carry;

            //判断是否进1
            carry = sum / 10;
            sum %= 10;

            //链表重连
            ListNode tmp = new ListNode(sum);
            cur.next = tmp;
            cur = tmp;

            //判断l1和l2是否为空
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        //最后判断carry是否还进1
        if (carry == 1) {
            ListNode tmp = new ListNode(carry);
            cur.next = tmp;
            cur = tmp;
        }

        return newHead.next;
    }
}