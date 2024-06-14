package leetcode.simply.linkedlist;

import leetcode.util.ListNode;

// 删除排序链表中的重复元素
public class DeleteDuplicates {
    /*
        给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
        https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
     */

    /**
     * 模拟【前后指针】
     * 思路：
     *      1.定义cur和prev, cur用于遍历链表，prev指向cur的前一个节点
     *      2.cur的值和prev相等，那么prev移动到cur的位置【因为可能有多个重复相等的数】，cur后移一步
     *      3.不相等，把prev的节点放到dummy的后面，dummy后移一位，prev后移一位【因为当前的节点已经连接到dummy后面】
     *        cur后移一位【因为当前的prev和cur已经比较过了】
     *      4.跳出循环或，把prev节点连接到dummy后【因为防止后面有重复的数，此时已经比较过了】
     *      5.返回dummy.next;
     * 时间复杂度：O(N)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 一个节点也没有 或 只有一个节点
        if (head == null || head.next == null) return head;

        // 多个节点的情况
        // 遍历节点，判断和前驱节点值是否相等
        ListNode cur = head.next;
        // 前驱节点，用来判断和cur节点是否相等
        ListNode prev = head;
        // 连接节点
        ListNode dummy = new ListNode();
        // 新的头节点
        ListNode newHead = dummy;

        // cur为空，链表已经遍历完了
        while (cur != null) {
            // cur当前节点和前驱节点prev相等
            if (cur.val == prev.val) {
                // 两个值相等，则让prev指向cur的位置
                prev = cur;
                // cur后移一步
            } else {
                // 不相等，则dummy指向prev，并dummy后移一步
                dummy.next = prev;
                dummy = dummy.next;
                // prev后移一步
                prev = prev.next;
                // cur后移一步
            }
            cur = cur.next;
        }
        // 指向最后的prev节点
        dummy.next = prev;
        return newHead.next;
    }
}
