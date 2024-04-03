package practice;

import util.ListNode;

import java.util.Arrays;
import java.util.PriorityQueue;

// 题目练习
public class Demo4 {
    // 选择题
    /*
        1、执行如下代码后输出结果为（ C ）
        public class Test {
            public static void main(String[] args) {
                System.out.println("return value of getValue(): " + getValue());
            }

            public static int getValue() {
                int i = 1;
                try {
                    i = 4;
                } finally {
                    i++;
                    return i;
                }
            }
        }
        A: return value of getValue(): 1
        B: return value of getValue(): 4
        C: return value of getValue(): 5
        D: 其他几项都不对
        // try  -finally的考察, finally必须执行的代码块

        2、try块后必须有catch块（ B ）
        A: 正确 B: 错误
        // try - finally

        3、以下关于JAVA语言异常处理描述正确的有【多选】（ CD ）
        A: throw 关键字可以在方法上声明该方法要抛出的异常。
        B: throws用于抛出异常对象。// 异常类型
        C: try是用于检测被包住的语句块是否出现异常，如果有异常，则捕获异常，并执行catch语句。
        D: finally语句块是不管有没有出现异常都要执行的内容。

        4、下面代码运行结果是（ C ）
        public class Test{
            public int add(int a,int b){
                try {
                    return a+b;
                } catch (Exception e) {
                    System.out.println("catch语句块");
                } finally {
                    System.out.println("finally语句块");
                }
                return 0;
            }
            public static void main(String argv[]){
                Test test =new Test();
                System.out.println("和是："+test.add(9, 34));
            }
        }
        A: catch语句块 和是：43
        B: 编译异常
        C: finally语句块
        和是：43
        D: 和是：43
        finally语句块
        // 解释: finally语句块必须执行

        5、以下说法哪个是正确的【多选】（ ABCD ）
        A: IOException在编译时会被发现
        B: NullPointerException在编译时不被发现
        C: SQLException在编译时会被发现
        D: FileNotFoundException在编译时会被发现
     */

    // 编程题
    /*
        给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
        请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
        你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
        链接: https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
     */

    /**
     * 法一: 排序
     * 时间复杂度: O(NlogN)
     * 空间复杂度: O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        // 排序
        Arrays.sort(nums);
        // 返回第k大的数
        return nums[nums.length - k];
    }

    /**
     * 法二: 优先级队列, 大根堆
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        // 建立大根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        // 入堆
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }

        // 弹出前k个元素, 找到最大的k个数
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.peek();
    }

    /**
     * 法三: 优先级队列, 建立小根堆
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // 创建小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });

        for (int i = 0; i < nums.length; i++) {
            // 入堆
            pq.offer(nums[i]);

            // 当长度超过k时,弹出最小的元素
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // 返回第k个元素
        return pq.peek();
    }

    /*
        给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
        链接: https://leetcode.cn/problems/SLwz0R/description/
     */

    /**
     * 思路分析: 快慢指针, 让快指针先走n步, 然后快慢指针一起走, 慢指针走到要删除的前一个节点, 然后删除要删除的节点
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 申请哑节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 申请快慢指针
        ListNode fast = head;
        ListNode slow = dummy;

        // 让fast先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // fast和slow一起走, 让slow走到要删除节点的前一个节点, fast走到null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除节点
        slow.next = slow.next.next;
        // 返回删除后的链表
        return dummy.next;
    }
}
