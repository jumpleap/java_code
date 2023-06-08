package leetcode;

@SuppressWarnings({"all"})

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，
 * 并返回 新的头节点 。
 */
public class RemoveElements {
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
     * 法一：若是结点的值和val相同，那么直接让当前节点的前一个结点指向
     *
     * @param head
     * @param val
     * @return
     */
    //当前结点的后一个结点
    public ListNode removeElements1(ListNode head, int val) {
        //判断头节点非空
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        //删掉除头节点以外和val相同的值
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        //判断头节点是不是和val一样
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    /**
     * 法二：左右指针思想
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        //判断头节点非空
        if (head == null) {
            return null;
        }

        //左右指针
        ListNode left = head;
        ListNode right = head.next;

        while (right != null) {
            if (right.val == val) {
                //让left的下一个结点为right的下一个结点
                left.next = right.next;
            } else {
                //不相等则使left放到right的位置处
                left = right;
            }
            //right正常遍历
            right = right.next;
        }
        //判断头节点的值为val
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    /**
     * 法三：另开一个链表
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = new ListNode(1);
        ListNode newHead = cur;
        //判断头节点非空
        if (head == null) {
            return null;
        }

        while (head.next != null) {
            if (head.val != val) {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }

        //判断最后一个节点的值
        if (head.val == val) {
            cur.next = null;
        } else {
            cur.next = head;
        }
        return newHead.next;
    }
}