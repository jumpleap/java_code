package task;

import java.util.Stack;

public class Day9 {
    /*
    1、请指出冒泡排序平均时间复杂度（A）
    A. n^2 B. nlogn C. n D. logn

    2、确定如下关于求n!算法的时间复杂度是（A）
    long fac(int n) {
        return (n > 1 ? n * fac(n - 1) : 1);
    }
    A. O(n) B. O(nlog(n)) C. O(n^2) D. O(n^3)

    3、判断对错。List，Set，HashMap都继承自Collection接口 （B）
    A. 对 B. 错

    4、下面哪些类实现或者继承了Collection接口？【多选】（BC）
    A. HashMap B. ArrayList C. Vector D. Iterator

    5、关于容器下面说法正确的是 （D）
    A. 列表(List)和集合(Set)存放的元素都是可重复的。
    B. 列表(List)和集合(Set)存放的元素都是不可重复的。
    C. 映射(Map)<key,value>中key是可以重复的。
    D. 映射(Map)<key,value>中value是可以重复的
     */

    /*
    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     */

    /**
     * 法一：使用数组解决【利用数组长度开辟内存，逆序存储后返回】
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head 头结点
     * @return 返回数组
     */
    public int[] reversePrint1(ListNode head) {
        int len = getLen(head);//计算head的链表长度
        int[] array = new int[len];//开辟空间
        ListNode cur = head;
        //倒序存储链表中的结点
        while (cur != null) {
            array[--len] = cur.val;
            cur = cur.next;
        }
        return array;
    }

    //计算链表长度
    private int getLen(ListNode node) {
        ListNode cur = node;
        int count = 0;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 栈：利用栈的先进后出的特点，来进行翻转链表中的元素
     * @param head 头结点
     * @return 返回数组
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        //开辟数组空间
        int[] array = new int[stack.size()];
        int index = 0;
        while (!stack.empty()) {
            array[index++] = stack.pop();
        }
        return array;
    }

    /*
    编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     */

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode cur = head;
        while(cur != null) {
            ListNode fast = cur;
            while(fast.next != null) {
                //判断当前元素是否和下一元素是否相同
                if(cur.val == fast.next.val) {
                    //指向另外一个元素
                    fast.next = fast.next.next;
                } else {
                    fast = fast.next;
                }
            }
            //遍历链表
            cur = cur.next;
        }
        return head;
    }
}