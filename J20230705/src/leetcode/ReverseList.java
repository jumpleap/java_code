package leetcode;

public class ReverseList {
    /**
     * 头插法进行解决；注意：没有结点的情况，和怎么找到下一个结点的情况
     * 时间复杂度：O(n) 空间复杂度：O(1)
     * @param head 头节点
     * @return 返回翻转后的结点
     */
    public ListNode reverseList(ListNode head) {
        //防止第一个结点为空
        if (head == null) {
            return null;
        }
        //指向head的下一个结点
        ListNode cur = head.next;
        head.next = null;//防止形成环
        while (cur != null) {
            //找到下一个结点
            ListNode curNext = cur.next;
            //头插
            cur.next = head;
            head = cur;
            //指向找到cur的下一个结点
            cur = curNext;
        }
        return head;
    }
}
