package leetcode;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 */
public class DeleteDuplicates {
    /**
     * 思路分析：使用两个结点 —— 左节点、右节点分别指向head的第一个和第二个结点；
     * 判断左节点和右节点的值是否相等，若不相等，若不相等，让cur结点指向left结点的值，并使cur指向下一个结点
     * 不管是否相等，左节点跳到右节点的值，让右节点跳到下一个结点
     */
    public ListNode deleteDuplicates(ListNode head) {
        //判断head非空
        if (head == null) {
            return null;
        }

        ListNode cur = new ListNode();//申请连接结点
        ListNode left = head;//左结点
        ListNode right = head.next;//右节点
        ListNode newHead = cur;//新的头节点

        while (right != null) {
            //不相等则直接让cur指向left的结点
            if (left.val != right.val) {
                cur.next = left;
                cur = cur.next;
            }
            //让left指向right的位置，right指向下一个位置
            left = right;
            right = right.next;
        }
        //cur指向left已经指向最后一个位置
        cur.next = left;
        return newHead.next;
    }
}