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
class Solution6 {
    /**
     * 思路分析: 快慢指针 + 头插法 + 前后指针比较
     * 1) 定义快慢指针, 找到中间节点
     * 2) 把中间节点之后的元素都进行头插
     * 3) 使用slow指针和fast指针比较值, 不同则不是回文
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        //找到中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //头插法
        ListNode cur = slow.next;
        while (cur != null) {
            //保存cur的下一个节点的位置
            ListNode curNext = cur.next;
            //头插
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }

        //遍历比较
        fast = head;
        while (fast != slow) {
            //值不同, 不是回文
            if (fast.val != slow.val) {
                return false;
            }
            //偶数个节点情况, 是回文
            if (fast.next == slow) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}