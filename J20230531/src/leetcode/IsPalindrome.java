package leetcode;

/**
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 */
public class IsPalindrome {
    /**
     * 思路分析：使用快慢指针找到链表的中间位置，然后把中间位置之后的元素进行头插，最后使用头节点和头插后的头节点进行比较
     * 若有值不相等，则返回false；若是head.next和slow相等，则返回true；即说明是回文链表
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * @param head 头节点
     * @return 返回布尔值
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //让fast走到最后的位置，让slow走到中间位置
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //在中间位置进行头插
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }

        //判断两个结点是否相等
        while (head != slow) {
            //结点的值不等
            if (head.val != slow.val) {
                return false;
            }

            //判断是否到达了最后的结点且head的下一个结点是slow
            if (head.next == slow) {
                return true;
            }
            //slow和head结点走一步
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}