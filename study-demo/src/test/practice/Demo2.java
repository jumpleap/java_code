package test.practice;

import util.ListNode;

// 题目练习
public class Demo2 {

    // 选择题
    /*
    1、以下哪些表达式返回为真【多选】（A D）
    String a="My field1";
    String b="My field1";
    String c=new String("My field1");
    String d=new String("My field1");
    A: a==b B: a==c C: c=d D: a.equals(b)
    // 解释:字符串常量中，相同的字符串常量只会被存储一次。当使用字符串变量进行比较时，
    // 实际上是比较两个字符串所指向对象的地址【当某个字符串常量被赋值给字符串变量时，
    // 该字符串常量先会去字符串常量池中查找是否相同的字符串常量；
    // 如果有，直接返回已经有的字符串常量的地址；如果没有，把该字符串常量加入到常量池中，然后返回该对象地址】

    2、此代码片段输出正确的值是（ A ）
    public class CharToString {
        public static void main(String[] args) {
            char myChar = 'g';
            String myStr = Character.toString(myChar);
            System.out.println("String is: "+myStr);
        }
    }
    A: String is: g
    B: String is: 103

    3、执行如下代码段后，变量s1引用的字符串值是（ A ）
    String s1 = "ABCD";
    String s2 = "1234";
    System.out.println(s1 + s2);
    A: ABCD B: 1234 C: ABCD1234 D: 1234ABCD

    4、有以下代码片段( A )
    String str1="hello";
    String str2="he"+ new String("llo");
    System.out.println(str1.equals(str2));
    请问输出的结果是：
    A: true B: 都不对 C: null D: false
    // 解释: 把拼接后的字符串赋给str2, 使用equals方法判断相等

    5、关于String、StringBuffer、StringBuilder以下说法错误的是（ C ）
    A: StringBuilder运行速度最快
    B: StringBuffer是线程安全的
    C: String的值是可变的
    D: StringBuffer运行速度比String快
    // 解释: 1）String的内容不可修改，StringBuffer和StringBuilder的内容可修改【底层的字符数组不同】
    // 2）StringBuffer和StringBuilder的功能大多相似，区别只有StringBuffer是使用synchronized修饰的
    // 3）在进行增删的效率上，不建议使用String【效率低下】，建议使用StringBuffer和StringBuilder

     */


    // 编程题
    /*
    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    链接: https://leetcode.cn/problems/reverse-linked-list/description/
     */

    /**
     * 思路: 头插法逆序插入
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 判空
        if (head == null) return null;

        ListNode cur = head.next;
        // 把head的下一个节点置为空, 防止形成环
        head.next = null;
        while (cur != null) {
            // 记录cur的下一个节点
            ListNode curNext = cur.next;
            // 头插
            cur.next = head;
            head = cur;
            // 让cur指向下一个节点
            cur = curNext;
        }
        return head;
    }

    /*
    给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
    请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
    链接: https://leetcode.cn/problems/reverse-linked-list-ii/description/
     */

    /**
     * 思路分析: 遍历 + 头擦
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 只有一个节点 和 left==right的情况
        if (left == right || head == null) return head;

        // 定义连接节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 定义新的头节点
        ListNode newHead = dummy;
        // 遍历节点
        ListNode end = head;

        // 让end走到left的位置处, 让dummy走到left的前一个节点
        for (int i = 0; i < left - 1; i++) {
            dummy = dummy.next;
            end = end.next;
        }

        // 保存当前的end节点, 为了连接后面的节点
        ListNode tmp = end;

        // 保存end的下一个节点
        ListNode cur = end.next;
        ListNode curNext = null;
        for (int i = left; i < right; i++) {
            // 保存cur的下一个节点
            curNext = cur.next;
            // 头插
            cur.next = end;
            end = cur;
            // 指向curNext处
            cur = curNext;
        }
        // 连接前半部分
        dummy.next = end;
        // 连接后半部分
        tmp.next = curNext;
        // 返回反转后的链表
        return newHead.next;
    }
}
