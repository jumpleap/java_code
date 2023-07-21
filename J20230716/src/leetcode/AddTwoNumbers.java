package leetcode;

import task.ListNode;

/*
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {
    /**
     * 思路分析：长度不足的链表补0，需要进行进位的判断
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            //判断l1和l2是否为空，空则置为0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;//大于10则留1，小于10则0
            sum %= 10;
            //连接结点
            cur.next = new ListNode(sum);
            cur = cur.next;

            //判断l1和l2是否为空
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //最后的两个数还进位
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
