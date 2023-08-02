package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    /**
     * 思路分析：定义快慢指针，让快指针先走k步，然后快慢指针一起走，最后慢指针的位置是倒是第k个节点
     * 时间复杂度：O(n)
     * @param head 给定头节点
     * @param k 给定的k值
     * @return 返回倒数第k个节点的位置
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        //判空
        if (head == null) {
            return null;
        }

        //定义快慢指针
        ListNode slow = head;
        ListNode fast = head;

        //让fast先走k步
        for (int i = 0; i < k; i++) {
            //在走k步的过程中遇到了null,则直接返回null
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        //让slow和fast一起走
        //fast走到最后时，slow走到倒数第k个节点的位置
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}