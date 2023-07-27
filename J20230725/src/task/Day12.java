package task;

import java.util.Set;

public class Day12 {
    /*
    1、在单链表中，要将s所指结点插入到p所指结点之后，其语句应为（D）
    A. s.next=p+1; p.next=s;
    B. p.next=s; s.next=p.next
    C. s.next=p.next; p.next=s.next;
    D. s.next=p.next; p.next=s;

    2、下述有关栈和队列的区别，说法错误的是 （D）
    A. 栈是限定只能在表的一端进行插入和删除操作。
    B. 队列是限定只能在表的一端进行插入和在另一端进行删除操作。
    C. 栈和队列都属于线性表
    D. 栈的插入操作时间复杂度都是o(1)，队列的插入操作时间复杂度是o(n)
    //解析：栈和队列的插入和删除时间复杂度都是O(1)

    3、输入序列是ABC,输出序列变为BCA时，经过的栈操作为（B）
    A. push,push,push,pop,pop,pop
    B. push,push,pop,push,pop,pop
    C. push,pop,push,push,pop,pop
    D. push,push,pop,pop,push,pop

    4、栈的特点是先入先出，这种说法（B）
    A. 正确 B. 错误
    //解析：栈的特点是：后进先出；队列的特点是：先进先出

    5、一个队列的入队序列为 1234 ，则队列可能的输出序列是（B）
    A. 4321 B. 1234 C. 1432 D. 3241
    //牢记队列的特点：先进先出
     */

    /*
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */

    /**
     * 思路分析：比较两个链表的大小，那个的值小则那个被连接，若其中一条链表为空，则把另一条的所有节点全部连接到后面
     * 时间复杂度：O(n)
     * @param list1 链表1
     * @param list2 链表2
     * @return 返回排序后的新链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode connection = dummy;//连接节点

        //list1和list2都不为空则进行循环
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                //若list1为null，则把list2连接到connection的后面
                connection.next = list2;
                connection = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                //若list2为null，则把list1连接到connection的后面
                connection.next = list1;
                connection = list1;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                //若list1.val<list2.val，则把list1节点连接到connection后面
                connection.next = list1;
                connection = list1;
                list1 = list1.next;
            } else {
                //把list2连接到connection的后面
                connection.next = list2;
                connection = list2;
                list2 = list2.next;
            }
        }
        return dummy.next;
    }

    /*
    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    例如，链表 1->2->3->3->4->4->5  处理后为 1->2->5
     */

    /**
     * 思路分析：把多个相同的节点直接走完：while(cur.next != null && cur.val == cur.next.val) cur = cur.next
     * 不是相同节点直接连接到后面
     * 时间复杂度：O(n)
     *
     * @param pHead 给定头节点
     * @return 返回新链表
     */
    public ListNode deleteDuplication(ListNode pHead) {
        //判空
        if (pHead == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);//新头节点
        ListNode tmp = newHead;//连接节点
        ListNode cur = pHead;//遍历节点

        while (cur != null) {
            //cur.next不为空且当前节点和下一节点的指向相同
            if (cur.next != null && cur.val == cur.next.val) {
                //把所有的相同节点去掉
                while (cur.next != null && cur.val == cur.next.val) {
                    //则当前节点走一步
                    cur = cur.next;
                }
                //最好去掉相同节点【边界情况】
                cur = cur.next;
            } else {
                //不是相同节点
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        //若最好还是有相同节点，所有tmp不为空，则把tmp.next置为空
        tmp.next = null;
        return newHead.next;
    }
}