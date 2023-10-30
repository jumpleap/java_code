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
class Solution4 {
    /**
     * 思路分析: 模拟
     * 那个节点的值小, 则把那个节点放在连接节点的后面, 若其中一个为空后, 则把另外一个链表直接放到connection的后面
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //定义连接节点
        ListNode connection = new ListNode();
        //头节点
        ListNode head = connection;

        //list1和list2都为空,跳出循环
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                //list1为空, 把list2的节点全部放在connnection的后面
                connection.next = list2;
                break;
            } else if (list2 == null) {
                //list2为空, 把list1的节点全部放在connnection的后面
                connection.next = list1;
                break;
            } else if (list1.val < list2.val) {
                //list1的值比list2的值小, 则把list1的放在connection的后面
                connection.next = list1;
                //list1后移
                list1 = list1.next;
            } else {
                //list2的值比list1的值小, 则把list2的放在connection的后面
                connection.next = list2;
                //list2后移
                list2 = list2.next;
            }
            //connection后移
            connection = connection.next;
        }
        //返回头节点
        return head.next;
    }
}