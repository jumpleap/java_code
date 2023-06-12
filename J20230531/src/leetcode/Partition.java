package leetcode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 */
public class Partition {
    /**
     * 思路分析：使用两个链表，一个链表放比x小的值的结点，另一个链表放比x值大的结点，然后s1连接s2，最后返回头节点
     * 注意：连接s2链表之前需要找到s2的头节点和把s2链表的最后一个结点置为null，防止形成环或多了几个结点
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * @param head 需要分割的链表
     * @param x    比较值
     * @return 返回新的链表
     */
    public ListNode partition(ListNode head, int x) {
        //防止head非空
        if (head == null) {
            return null;
        }
        //小于x的链表
        ListNode s1 = new ListNode(-1);
        ListNode curS1 = s1;//指向s1的头节点
        //大于x的链表
        ListNode s2 = new ListNode(-1);
        ListNode curS2 = s2;//指向s2的头节点

        //循环head中val与x的比较
        while (head != null) {
            //val小于x则放在s1链表，否则放在s2链表
            if (head.val < x) {
                s1.next = head;
                s1 = s1.next;
            } else {
                s2.next = head;
                s2 = s2.next;
            }
            head = head.next;
        }
        s2.next = null;//防止形成环或多了结点
        //让s1的值在s2的前面
        s1.next = curS2.next;
        //返回s1的头节点
        return curS1.next;
    }
}