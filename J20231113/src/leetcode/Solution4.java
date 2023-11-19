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
class Solution4 {
    /**
     * 思路分析: 定界 + 反转 + 连接 + 重置.
     * 定界: 找到要反转k个元素的头和尾, 若是不能到达k个元素, 则说明无需反转
     * 反转: 把找到的尾置为空(前提: 让一个节点指向尾结点的下一个节点), 头节点开始反转
     * 连接: 反转后, 此时之前的头节点是最后一个节点, 把头节点的.next指向保存的尾结点的下一个节点, 即连接起来了
     * 重置: 让pre和end重新指向下一组要反转的头节点
     * 时间复杂度: O(n*k)
     * 空间复杂度: O(1)
     * @param head 给定头节点
     * @param k 要反转的k个元素
     * @return 返回反转后的链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 用于定界k个元素的头和尾
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 找到第k个位置
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }

            // 如果距离不够到第k个位置, 就退出循环
            if (end == null) break;

            ListNode start = pre.next; // 用于翻转的节点
            ListNode next = end.next; // 保存第k个节点的下一个节点
            end.next = null; // 和前面翻转的节点断开连接

            pre.next = reverse(start); // 开始进行k个元素的翻转

            start.next = next; // 把断开的链表连接起来
            // pre 和 end 指向翻转后的最后一个节点位置处
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) return head;

        ListNode cur = head.next;

        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }
}