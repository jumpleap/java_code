package practice;

import java.util.Arrays;

public class Demo5 {
    // 选择题
    /*
        1、在异常处理中，如释放资源，关闭数据库、关闭文件应由（ ）语句来完成（ C ）
        A: try子句 B: catch子句 C: finally子句 D: throw子句
        // 解释: 在finally中完成题干要求

        2、HASH 函数冲突处理方式不包括以下哪一项：（ C ）
        A. 开放定址法
        B. 链地址法
        C. 插入排序法
        D. 公共溢出区法

        3、HashMap的数据结构是怎样的（ C ）
        A. 数组 B. 链表 C. 数组+链表 D. 二叉树
        // JDK8以前是数组＋链表, JDK8是数组＋链表, 链表超过一定节点变成红黑树

        4、以下程序的运行结果是（ C ）
        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer> subSet = new TreeSet<Integer>();
        for(int i=606;i<613;i++){
            if(i%2==0){
                set.add(i); // 606 608 610 612
            }
        }
        subSet = (TreeSet)set.subSet(608,true,611,true);
        set.add(609);
        System.out.println(set+" "+subSet);
        A. 编译失败
        B. 发生运行时异常
        C. [606, 608, 609，610, 612] [608, 609，610]
        D. [606, 608, 609，610, 612] [608, 610]

        5、散列函数有共同的性质，则函数值应当以（ ）概率取其值域的每一个值。（ D ）
        A. 最大 B. 最小 C. 平均 D. 同等
     */

    // 编程题
    /*
        给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
        假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
        你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
        链接: https://leetcode.cn/problems/find-the-duplicate-number/description/
     */

    /**
     * 法一: 排序后遍历比较
     * 时间复杂度: O(NlogN)
     * 空间复杂度: O(1)
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        // 数组排序
        Arrays.sort(nums);
        int len = nums.length;
        // 遍历比较
        for (int i = 0; i < len; i++) {
            // 相等则返回重复值
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        // 没有重复值
        return -1;
    }

    /**
     * 法二: 利用哈希数组
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        // 创建一个哈希数组
        int[] hash = new int[100001];

        // 把nums中的值映射到哈希数组中
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }

        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 查找是否有大于2的映射值, 有则说明有重复的值
            if (hash[nums[i]] > 1) {
                return nums[i];
            }
        }
        // 没有
        return -1;
    }

    /**
     * 法三: 快慢指针＋遍历数组(和链表的入环点一个思路)
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        // 定义快慢指针
        int slow = 0, fast = 0;
        do {
            // slow每次走一步
            slow = nums[slow];
            // fast每次走两步
            fast = nums[nums[fast]];
        } while (slow != fast); //相等退出

        // slow重置
        slow = 0;

        // slow和fast相遇则退出循环
        while (slow != fast) {
            // fast 和 slow每次都走一步
            slow = nums[slow];
            fast = nums[fast];
        }
        // 返回相遇值
        return slow;
    }
}