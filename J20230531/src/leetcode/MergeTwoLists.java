package leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {
    /**
     * 思路分析：让两个链表中的值进行比较，那个值小即把那个结点放在新节点的后面，一直把两个链表中的结点放完
     * 时间复杂度：O(n)；空间复杂度：O(1)
     * @param list1 链表1
     * @param list2 链表2
     * @return 返回新的排序链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode connect = new ListNode();//连接结点
        ListNode newHead = connect;//新的头节点

        //判断list1和list2均不为空的清空
        while (list1 != null && list2 != null) {
            ListNode tmp = null;//临时结点
            //判断list1和list2中的val值的大下，谁小谁在前
            if (list1.val < list2.val) {
                tmp = list1;
                //让list1走一步
                list1 = list1.next;
            } else {
                tmp = list2;
                //让list2走一步
                list2 = list2.next;
            }
            //让连接结点指向小的那个值
            connect.next = tmp;
            //连接结点走一步
            connect = connect.next;
        }

        //判断list1和list2中是否有非空情况
        if (list1 != null) {
            connect.next = list1;
        }
        if (list2 != null) {
            connect.next = list2;
        }
        //返回新的头节点
        return newHead.next;
    }
}
