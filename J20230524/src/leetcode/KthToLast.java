package leetcode;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 */
public class KthToLast {
    /**
     * 思路：定义快慢指针，快指针先走k步，然后快慢指针一起走，慢指针到达的位置即是倒数第k个结点
     * 时间复杂度：O(n)  空间复杂度：O(1)
     *
     * @param head 头节点
     * @param k    k值
     * @return 返回倒数第k个结点的值
     */
    public int kthToLast(ListNode head, int k) {
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        //快指针先走k步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        //快慢指针一起走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //慢指针走到的位置就是倒数第k个结点
        return slow.val;
    }
}
