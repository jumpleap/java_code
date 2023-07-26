package task;

import java.util.Arrays;

public class Day11 {
    /*
    1、线性结构的是【多选】（ABC）
    A. 数组 B. 链式存储栈 C. 顺序存储栈 D. 顺序存储二叉树
    //解析：数组，链表，栈，队列都属于线性结构

    2、有一个单向链表，头指针和尾指针分别为p，q，以下哪项操作的复杂度不受链表长度的影响【多选】(ACD)
    A. 删除头部元素 B. 删除尾部元素 C. 头部元素之前插入一个元素 D. 尾部元素之后插入一个元素

    3、在一个单链表中，p、q分别指向表中两个相邻的结点，且q所指结点是p所指结点的直接后继，现要删除q所指
    结点，可用的语句是 （C）
    A. p=q.next B. p.next=q C. p.next=q.next D. q.next=NULL

    4、在一个具有 n 个结点的有序单链表中插入一个新结点并仍然保持有序的时间复杂度是 （B）
    A. O（1） B. O（n） C. O（n2） D. O（nlog2n）
    //解析：最坏情况下是O(n)  最好情况下O(1)

    5、对链表进行插入和删除操作时不必移动链表中结点。（A）
    A. 正确 B. 错误
     */

    /*
    给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     */

    /**
     * 思路分析：使用数组把链表中的所有节点值保存起来，对数组排序，然后重新连接有序的链表
     * 时间复杂度：O(nlogN)
     * 空间复杂度：O(n)
     * @param head 给定头节点
     * @return 返回排序后的链表
     */
    public ListNode sortList(ListNode head) {
        //判空
        if (head == null) {
            return head;
        }
        //获取链表长度
        int len = getLength(head);
        //申请空间
        int[] array = new int[len];

        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            //给数组进行赋值
            array[index++] = cur.val;
            cur = cur.next;
        }

        //数组进行排序
        Arrays.sort(array);

        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;

        //给新链表进行连接
        for (int i = 0; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            tmp.next = node;
            tmp = node;
        }
        //返回排序后的新链表
        return newHead.next;
    }

    //求链表的长度
    private int getLength(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    /*
    给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
    第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
    请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
    你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
     */

    /**
     * 思路分析：使用奇偶的性质进行跳跃，然后把偶节点的链表连接到奇节点的后面
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head 给定头节点
     * @return 返回奇偶排序后的链表
     */
    public ListNode oddEvenList(ListNode head) {
        //判空
        if (head == null) {
            return head;
        }

        ListNode evenHead = head.next;//偶节点的头
        ListNode odd = head;//奇节点
        ListNode even = evenHead;//偶节点的遍历节点

        //如果偶节点为空或偶节点的下一个节点为空，跳出循环
        while (even != null && even.next != null) {
            //奇节点指向偶节点的后一个节点
            odd.next = even.next;
            //让奇节点指向自己的下一个节点
            odd = odd.next;
            //让偶节点指向奇节点的下一个节点
            even.next = odd.next;
            //让偶节点指向自己的下一个节点
            even = even.next;
        }
        //把偶节点的链表连接到奇节点的后面
        odd.next = evenHead;
        return head;
    }
}