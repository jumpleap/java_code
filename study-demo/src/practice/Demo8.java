package practice;

import java.util.Arrays;

// 题目练习
public class Demo8 {
    // 选择题
    /*
        1、以下关于 Servlet 生命周期说法错误的是 ( C )
        A: Servlet 容器根据 Servlet 类的位置加载 Servlet 类，成功加载后，由容器创建 Servlet 的实例
        B: 对于每一个 Servlet 实例， init() 方法只被调用一次
        C: 当 Servlet 容器接收到客户端请求时，调用 Servlet 的 service() 方法以及 destory() 方法处理客户端请求
        D: servlet 的实例是由 servlet 容器创建的，所以实例销毁也由容器完成
        // 解析: 客户端的每次请求, 都会根据路径查找对应的Servlet实例对象, 并调用service方法,
        //      init和destroy方法分别是初始化方法及销毁方法, 只执行一次

        2、以下关于转发和重定向的说法错误的是 ( C )
        A: 转发通过 request 的 getRequestDispatcher().forward() 方法即可实现，它的作用是在多个页面交互过程中实现请求
        数据的共享。
        B: 重定向可以理解为是浏览器至少提交了两次请求，它是在客户端发挥作用，通过请求新的地址实现页面转向
        C: 转发和重定向都可以共享 request 范围内的数据
        D: 转发时客户端的 URL 地址不会发生改变，而重定向时客户端浏览器中显示的是新的 URL 地址。
        // 解析: 转发是一次请求返回, 可以共享本次请求的数据
        //      重定向是两次请求, 不能在通过request共享数据, 如果要共享数据, 可以使用session

        3、用HTML标记语言编写一个简单的网页，网页最基本的结构是 ( D )
        A: <html> <head>…</head> <frame>…</frame> </html>
        B: <html> <title>…</title> <body>…</body> </html>
        C: <html> <title>…</title> <frame>…</frame> </html>
        D: <html> <head>…</head> <body>…</body> </html>
        // 解析: html最基础的结构包括: html, head, body标签

        4、以下标记符中，用于设置页面标题的是 ( A )
        A: <title> B: <caption> C: <head> D: <html>

        5、下面哪一项是换行符标记 ( C )
        A: <body> B: <font> C: <br> D: <p>
     */

    // 编程题
    /*
        假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
        给定两个这种链表，请生成代表两个整数相加值的结果链表。
        数据范围：0≤n,m≤1000000，链表任意值: 0≤val≤9
        要求：空间复杂度O(n)，时间复杂度O(n)
        链接: https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=295&tqId=1008772&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     */

    /**
     * 思路分析: 模拟, 反转两个链表, 然后各位就在第一个节点, 最高位在最后一个节点, 然后定义进位变量, 防止进位
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param head1
     * @param head2
     * @return
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // 判空
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // 若都不为空, 反转链表
        head1 = reverse(head1);
        head2 = reverse(head2);

        // 进位变量
        int ret = 0;
        // 连接节点
        ListNode dummy = new ListNode(0);
        // 新的头节点
        ListNode newHead = dummy;
        while (head1 != null & head2 != null) {
            ret += head1.val + head2.val;

            ListNode node = new ListNode(ret % 10);
            // 判断是否有进位
            ret /= 10;

            // 连接节点
            dummy.next = node;
            dummy = dummy.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        // 到这个地方有一个链表为空
        while (head1 != null) {
            ret += head1.val;
            ListNode node = new ListNode(ret % 10);
            // 判断是否有进位
            ret /= 10;

            // 连接节点
            dummy.next = node;
            dummy = dummy.next;
            head1 = head1.next;
        }

        while (head2 != null) {
            ret += head2.val;
            ListNode node = new ListNode(ret % 10);
            // 判断是否有进位
            ret /= 10;

            // 连接节点
            dummy.next = node;
            dummy = dummy.next;
            head2 = head2.next;
        }

        // 进位判断
        if (ret != 0) {
            ListNode node = new ListNode(ret);
            dummy.next = node;
        }
        // 反转后返回新的头节点
        return reverse(newHead.next);
    }


    // 反转链表
    private ListNode reverse(ListNode head) {
        // 只有一个节点的情况下
        if (head.next == null) return head;

        ListNode cur = head.next;
        // 置空,防止形成环
        head.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            // 头插
            cur.next = head;
            head = cur;
            // 指向下一个节点
            cur = curNext;
        }
        return head;
    }


    /*
        给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
        链接: https://leetcode.cn/problems/7WHec2/description/
     */

    /**
     * 思路分析: 模拟, 获取链表长度, 申请和链表长度同长的数组, 把链表中的值赋给数组, 然后对数组排序, 然后把数组中的值转为链表
     * 时间复杂度: O(NlogN)
     * 空间复杂度: O(N)
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        // 判空
        if(head == null) return null;

        // 获取链表长度
        int size = size(head);
        // 申请空间
        int[] array = new int[size];

        // 数组赋值
        ListNode cur = head;
        for(int i = 0; i < size; i++) {
            array[i] = cur.val;
            cur = cur.next;
        }

        // 排序
        Arrays.sort(array);

        // 申请连接节点和新的头节点
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;
        // 把排序后的数组转为链表
        for (int i = 0; i < size; i++) {
            ListNode node = new ListNode(array[i]);
            dummy.next = node;
            dummy = dummy.next;
        }
        // 返回新的排序链表
        return newHead.next;

    }

    // 获取链表长度
    private int size(ListNode node) {
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }


    /*
        假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
        链接: https://leetcode.cn/problems/climbing-stairs/description/
     */

    /**
     * 法一: 递归, 时间复杂度过高, ac不过
     * 时间复杂度: O(2^N)
     * 空间复杂度: O(N)
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        // 小于2的直接返回1
        if (n < 2) {
            return 1;
        }
        // 进行递归, 因为每次可以跳一阶也可也跳两阶
        return climbStairs(n-1) + climbStairs(n - 2);
    }


    /**
     * 法二: 迭代计算
     * 时间复杂度: .O(N)
     * 空间复杂度: O(N)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // 定义迭代变量
        int n1 = 1;
        int n2 = 1;
        // 记录总方法数, 置为1是因为可能n为1
        int sum = 1;

        while (n >= 2) {
            // 当前阶跳的方法总数
            sum = n1 + n2;
            // 迭代
            n1 = n2;
            n2 = sum;
            // 台阶数递减
            n--;
        }
        // 返回跳的总方法数
        return sum;
    }
}