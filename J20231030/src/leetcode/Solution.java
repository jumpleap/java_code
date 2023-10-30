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
     * 思路分析: 遍历+头插: 使用cur指针进行边遍历边头插
     * 1) 让cur指针指向head的下一个节点, 遍历cur;
     * 2) 使用curNext指针指向cur的下一个节点, 即记录cur的下一节点的位置
     * 3) 进行头插, 把cur的下一个指向head, 让head又指向cur
     * 4) cur重新指向curNext, 即保存了cur的下一个节点的指针
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head 给定头节点
     * @return 返回新链表
     */
    public ListNode reverseList(ListNode head) {
        //判空
        if (head == null) return head;

        ListNode cur = head.next;
        //防止形成环
        head.next = null;
        while (cur != null) {
            //记录cur的下一个节点
            ListNode curNext = cur.next;
            //头插
            cur.next = head;
            head = cur;
            //获取cur的下一个节点
            cur = curNext;
        }
        return head;
    }
}