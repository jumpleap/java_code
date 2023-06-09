package leetcode;

public class GetKthFromEnd {
    /**
     * 思路分析：使用快慢指针，让fast先走k步，然后让fast和slow一起走，最后slow即可走到倒数第k个结点的位置
     * @param head 头节点
     * @param k 倒数值
     * @return 返回值
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        //快慢指针
        ListNode fast = head;
        ListNode slow = head;

        //让fast先走k步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        //两个一起走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //倒数第k个结点
        return slow;
    }
}