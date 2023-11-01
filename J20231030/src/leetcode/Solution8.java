package leetcode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution8 {
    /**
     * 思路分析: 快慢指针.
     * 让快指针每次走两步, 慢指针每次走一步; 若是存在环, 那么两者必会相遇, 若不存在环, 则跳出循环, 返回false
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        //一个节点也没有
        if (head == null) return false;
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            //快指针走两步, 慢指针走一步
            fast = fast.next.next;
            slow = slow.next;

            //相遇, 即存在环
            if (fast == slow) {
                return true;
            }
        }
        //不存在环
        return false;
    }
}