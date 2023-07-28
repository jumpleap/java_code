package task;

public class Day13 {
    /*
    1、带头的单链表实现的栈，栈顶指针为Top，入栈一个P节点时，其操作步骤为（B）
    A. Top.next=p;
    B. p.next=Top.next;Top.next=p;
    C. p.next=Top;Top=p.next;
    D. p.next=Top;Top=Top.next;

    2、下列与队列结构有关联的是 （D）
    A. 函数的递归调用
    B. 数组元素的引用
    C. 多重循环的执行
    D. 先到先服务的作业调度
    //队列的特点：先进先出

    3、以下 （B） 不是队列的基本运算
    A. 从队尾插入一个新元素 B. 从队列中删除第i个元素 C. 判断一个队列是否为空 D. 读取队头元素的值

    4、字符 A 、 B 、 C 依次进入一个栈，按出栈的先后顺序组成不同的字符串，至多可以组成 (B) 个不同的字符串（）
    A. 14 B. 5 C. 6 D. 8
    //ABC、BCA、BAC、CBA、ACB

    5、判断一个循环队列Q（最多元素为m）为满队列的条件是（B）
    A. rear+1=front B. (rear+1)%m=front C. rear=front D. (rear+1)%m=null
    //解析：队列为空的条件是 ：rear = front
    //队列为满的条件是： (rear+1) % m = front
     */

    /*
    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */

    /**
     * 思路分析：使用头插法分别把head节点之后的节点插入到head节点前面
     * 时间复杂度：O(n)
     *
     * @param head 给定的头节点
     * @return 返回新链表
     */
    public ListNode reverseList(ListNode head) {
        //判空
        if (head == null) {
            return head;
        }

        //遍历链表使用头插法把链表后面的节点放到前面
        ListNode cur = head.next;
        head.next = null;//防止形成环
        while (cur != null) {
            //记录cur的下一个节点的位置
            ListNode curNext = cur.next;
            //头插法
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }



    /*
    给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
    为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
    如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     */

    /**
     * 思路分析：先让快慢指针一起走到相遇，相遇后让快指针从头开始和慢指针一起走，再次相遇的点即为入环点
     * 时间复杂度：O(n)
     * @param head 给定的头节点
     * @return 返回入环点
     */
    public ListNode detectCycle(ListNode head) {
        //判空
        if (head == null) {
            return head;
        }

        //快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            //快指针走两步，慢指针走一步
            fast = fast.next.next;
            slow = slow.next;
            //相等则跳出循环
            if (fast == slow) {
                break;
            }
        }

        //判断是否无环
        if (fast == null || fast.next == null) {
            return null;
        }

        //让快指针回到原处重新开始走
        fast = head;
        while (fast != null && slow != null) {
            //快慢指针一起走，若是相同时则跳出循环，说明遇到了入环点
            if (fast == slow) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}