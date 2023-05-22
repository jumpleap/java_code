package leetcode;

/**
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 */
public class IsPalindrome {
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
     * 思路分析：使用快慢指针找到中间元素，然后把中间后面的部分进行头插，最后比较
     * 时间复杂度：O(n); 空间复杂度：O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        //找到中间结点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode cur = slow.next;
        //链表的一半开始翻转链表元素（头插）
        while (cur != null) {
            ListNode curNext = cur.next;
            //头插法
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }

        //条件，两个不能指向同一个元素
        while (head != slow) {
            //元素不相等则false
            if (head.val != slow.val) {
                return false;
            }
            //判断偶数情况：当head的下一个是slow则说明是最后一个
            if (head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}