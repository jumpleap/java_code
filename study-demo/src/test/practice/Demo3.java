package test.practice;

import util.ListNode;

// 题目练习
public class Demo3 {
    // 选择题
    /*
        1、关于下面程序 ThisTest.java 运行结果 说法正确的是（ B ）
        public class ThisTest {
            public static void main(String args[]) {
                String x="7";
                int y = 2;
                int z = 2;
                System.out.println(x+y+z);
            }
        }
        A: 11 B: 722 C: 22 D: 程序有编译错误
        // 解释: 字符串拼接

        2、已知String a="a"，String b="b"，String c=a+b，String d=new String("ab")
         以下操作结果为true的是【多选】（ AD ）
        A: (a+b).equals(c) B: b==c C: c==d D: c.equals(d)
        // 解释: 考察字符串常量池和equals方法

        3、下列Java代码中的变量a、b、c分别在内存的存储区存放（ C ）
        class A {
            private String a = “aa”;
            public boolean methodB() {
                String b = “bb”;
                final String c = “cc”;
            }
        }
        A: 堆区、堆区、堆区
        B: 堆区、栈区、堆区
        C: 堆区、栈区、栈区
        D: 堆区、堆区、栈区
        // 解释: 成员变量在堆区, 局部变量在栈区

        4、假设有以下代码String s = "hello"；String t = "hello"；char c [ ] = {'h','e','l','l','o'}；
        下列选项中返回false的语句是（ B ）
        A: s.equals (t)； B: t.equals (c)； C: s==t； D: t.equals (new String ("hello"))；
        // 解释: 字符串和数组比较的是地址, 因为字符数组不是字符串

        5、能单独和finally语句一起使用的块是（ A ）
        A: try B: catch C: throw D: throws
        // try - finally; try - catch - finally; throw 搭配new使用; throws把异常抛出, 后跟异常类型
     */

    // 编程题
    /*
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    链接: https://leetcode.cn/problems/merge-two-sorted-lists/description/
     */

    /**
     * 思路分析: 模拟
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 判空
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // 创建链接节点
        ListNode dummy = new ListNode();
        // 创建新的头节点
        ListNode newHead = dummy;

        // 当list1和list都为空, 跳出循环
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                // 当list1为空, 把list2的节点全部放在dummy的后面
                dummy.next = list2;
                break;
            } else if (list2 == null) {
                // 当list2为空, 把list1的节点全部放在dummy的后面
                dummy.next = list1;
                break;
            } else if (list1.val < list2.val) {
                // 当list1的节点值小于list2的节点值, 把list1当前节点放在dummy后面
                dummy.next = list1;
                // list1后移一步
                list1 = list1.next;
            } else {
                // 当list2的节点值小于list1的节点值, 把list2当前节点放在dummy后面
                dummy.next = list2;
                // list2后移一步
                list2 = list2.next;
            }
            // dummy后移一步
            dummy = dummy.next;
        }
        // 返回连接后的节点
        return newHead.next;
    }

    /*
        给你一个链表的头节点 head ，判断链表中是否有环。
        如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
        链接: https://leetcode.cn/problems/linked-list-cycle/description/
     */

    /**
     * 思路分析: 快慢指针, 定义快慢指针, 快指针每次走两步, 慢指针每次走一步, 相遇则说明有环, 快指针遇到空则说明无环
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // 一个节点也没有
        if (head == null) return false;
        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = head;

        // 当fast为空或fast.next为空则说明不存在环
        while (fast != null && fast.next != null) {
            // fast走两步
            fast = fast.next.next;
            // slow走一步
            slow = slow.next;

            // 判断是否相遇, 相遇则说明有环
            if (fast == slow) {
                return true;
            }
        }
        // 不存在环
        return false;
    }

    /*
        给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
        如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
        链接: https://leetcode.cn/problems/linked-list-cycle-ii/description/
     */

    /**
     * 思路分析: 快慢指针+遍历比较: 定义快慢指针, 快指针每次走两步, 慢指针每次走一步, 相遇则有环, 否则无环;
     * 有环重置快指针, 让快慢指针一起走, 相遇点即为入环点
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        // 一个节点也没有
        if (head == null) return null;

        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = head;

        // fast不为空或fast.next不为空
        while (fast != null && fast.next != null) {
            // fast每次走两步
            fast = fast.next.next;
            // slow每次走一步
            slow = slow.next;

            // 相遇跳出循环
            if (fast == slow) {
                break;
            }
        }

        // 当fast为空或fast.next为空则说明无环, 即没有入环点
        if (fast == null || fast.next == null) {
            return null;
        }

        // 重置快指针
        fast = head;
        // 快慢指针相遇点即为入换点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        // 返回入环点
        return fast;
    }

    /*
        给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
        如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
        假设环境不允许存储 64 位整数（有符号或无符号）。
        链接: https://leetcode.cn/problems/reverse-integer/description/
     */

    /**
     * 思路分析: 模拟; 注: 负数模正数是负数, 注意溢出判断
     * 时间复杂度: O(logX)
     * 空间复杂度: O(1)
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        // 定义结果变量
        int ans = 0;
        // x == 0 跳出循环
        while (x != 0) {
            // 溢出判断
            if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {
                return 0;
            }
            // 数值反转
            ans = ans * 10 + x % 10;
            // 降位
            x /= 10;
        }
        // 返回结果
        return ans;
    }
}