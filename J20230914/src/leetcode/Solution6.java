package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
class Solution6 {
    /**
     * 分割链表: 模拟, 使用两个链表来进行模拟分割过程
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head 给定头节点
     * @param x 比较值
     * @return 返回新链表
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        //申请链表, 使用两个链表来进行分割链表
        ListNode start = new ListNode(-1), startHead = start;
        ListNode last = new ListNode(-1), lastHead = last;
        ListNode cur = head;

        while (cur != null) {
            //值比较, 把小的放在start链表中, 大的放在last链表中
            if (cur.val < x) {
                start.next = cur;
                start = start.next;
            } else {
                last.next = cur;
                last = last.next;
            }
            cur = cur.next;
        }
        //置为空防止形成环
        start.next = null;
        last.next = null;
        //让start的下一个节点指向last的开头
        start.next = lastHead.next;
        //返回拼接后的新链表
        return startHead.next;
    }
}