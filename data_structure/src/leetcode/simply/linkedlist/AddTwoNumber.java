package leetcode.simply.linkedlist;

import leetcode.util.ListNode;

// 两数相加
public class AddTwoNumber {
    /*
        给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
        并且每个节点只能存储 一位 数字。
        请你将两个数相加，并以相同形式返回一个表示和的链表。
        你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        https://leetcode.cn/problems/add-two-numbers/description/
     */

    /**
     * 模拟
     * 思路：
     *      1.定义连接节点，carry进位
     *      2.两个链表的值进行相加，把该值进行进位判断后连接到dummy节点的后面，然后进行判断链表的下一个相加值
     *      3.在判断链表的下一个相加值之前，我们需要进行进位判断，若大于10则需要除10
     *      4.最后在进行carry判断，判断carry是否还有进位，有则把它申请为节点连接到dummy后面
     * 时间复杂度：O(N)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;
        int carry = 0;

        while (l1 != null && l2 != null) {
            carry += l1.val + l2.val;
            // 进行连接
            ListNode tmp = new ListNode(carry % 10);
            dummy.next = tmp;
            dummy = dummy.next;
            // 进位判断
            carry /= 10;

            // 获取下一个节点
            l1 = l1.next;
            l2 = l2.next;
        }

        // l1还有节点
        while (l1 != null) {
            carry += l1.val;
            // 把节点连接到dummy的后面
            ListNode tmp = new ListNode(carry % 10);
            dummy.next = tmp;
            dummy = dummy.next;
            // 进位判断
            carry /= 10;

            l1 = l1.next;
        }

        // l2还有节点
        while (l2 != null) {
            carry += l2.val;
            ListNode tmp = new ListNode(carry % 10);
            // 连接
            dummy.next = tmp;
            dummy = dummy.next;
            // 进位判断
            carry /= 10;

            l2 = l2.next;
        }

        // 判断carry是否还有进位
        if (carry != 0) {
            ListNode tmp = new ListNode(carry);
            dummy.next = tmp;
        }

        // 返回结果
        return newHead.next;
    }
}
