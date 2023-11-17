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
class Solution {
    /**
     * 思路分析: dummy节点 + 部分反转
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head 给定头节点
     * @param left 左区域
     * @param right 右区域
     * @return 返回部分反转后的头节点
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 申请节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 新的头节点
        ListNode newHead = dummy;
        // 反转节点
        ListNode end = head;

        // 让end走到要反转的链表节点位置,  dummy走到要反转节点的前一个节点
        for (int i = 0; i < left - 1; i++) {
            dummy = dummy.next;
            end = end.next;
        }

        // 保存反转之前的头节点, 防止连不到反转之后的节点
        ListNode tmp = end;

        // 进行反转
        ListNode cur = end.next;
        // 这个地方设置为为end.next是防止left == right的清理
        ListNode curNext = end.next;
        for (int i = 0; i < right - left; i++) {
            // 保存cur下一个节点的位置
            curNext = cur.next;
            // 头插
            cur.next = end;
            end = cur;
            // 指向下一个节点
            cur = curNext;
        }

        // 连接前半部分
        dummy.next = end;
        // 连接后半部分
        tmp.next = curNext;

        // 返回新节点
        return newHead.next;
    }
}