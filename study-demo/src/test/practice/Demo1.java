package test.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 题目练习
public class Demo1 {
    // 选择题
    /*
        1、派生类调用基类的构造器必须用到的关键字（ C ）
        A: this B: final C: super D: static
        解释: 子类若想要调用父类的构造器使用super关键字

        2、以下哪个接口的定义是正确的（ D ）
        A: interface B{ void print() { } ;}
        B: interface B{ static void print() ;}
        C: abstract interface B extends A1, A2{ abstract void print(){ };} //A1、A2为已定义的接口
        D: interface B{ void print();}
        解释: interface声明的方法无需方法体, 只要有方法声明即可, 但是static方法和default方法

        3、关键字super的作用是（ D ）
        A: 用来访问父类被隐藏的非私有成员变量
        B: 用来调用父类中被重写的方法
        C: 用来调用父类的构造函数
        D: 以上都是

        4、将下列（A、B、C、D）哪个代码替换下列程序中的【代码】不会导致编译错误（ A ）
        interface Com{
            int M=200;
            int f();
        }
        class ImpCom implements Com{
            //【代码】
        }
        A: public int f(){ return 100+M;}
        B: float f(){ return 100;}
        C: public double f(){ return 2.6;}
        D: public abstract int f()

        5、默认类型等价表示是哪一项（ C ）
        public interface IService {String NAME="default";}
        A: public String NAME="default";
        B: public static String NAME="default";
        C: public static final String NAME="default";
        D: private String NAME="default";
        解释: 接口中的属性默认是public static final的
     */

    // 编程题
    /*
    给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；
    如果数组中每个元素互不相同，返回 false 。
    链接: https://leetcode.cn/problems/contains-duplicate/
     */
    /**
     * 思路: 哈希表
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        // 创建哈希表
        Set<Integer> ans = new HashSet<>();

        // 遍历数组
        for (int num : nums) {
            // 判断哈希表中是否存在该元素
            if (ans.contains(num)) {
                // 存在
                return true;
            } else {
                // 不存在
                ans.add(num);
            }
        }
        // 没有相同的元素
        return false;
    }

    /**
     * 思路: 排序后比较
     * 时间复杂度: O(NlogN)
     * 空间复杂度: O(1)
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        // 数组排序
        Arrays.sort(nums);

        // 遍历数组
        for (int i = 0; i < nums.length - 1; i++) {
            // 判断当前元素和后一个元素是否相同
            if (nums[i] == nums[i + 1]) {
                // 相同
                return true;
            }
        }
        // 没有相同的元素
        return false;
    }


    /*
    给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
    满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false
    链接: https://leetcode.cn/problems/contains-duplicate-ii/description/
     */

    /**
     * 思路: 暴力枚举
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N)
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        // 获取数组长度
        int len = nums.length;

        // 遍历数组
        for (int i = 0; i < len; i++) {
            // 当nums[i] == nums[j] 且 abs(i-j) <= k则返回true
            for (int j = i + 1; j < len && Math.abs(i - j) <= k; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        // 不存在相同元素
        return false;
    }

    /**
     * 思路: 滑动窗口
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 数组长度
        int len = nums.length;
        // 创建哈希表
        Set<Integer> ans = new HashSet<>();

        // 遍历数组
        for (int i = 0; i < len; i++) {
            // 哈希表若是含有当前元素, 返回true
            if(ans.contains(nums[i])) {
                return true;
            }
            // 把数据入哈希表
            ans.add(nums[i]);
            // 这里保证abs(i-j) <= k
            if (ans.size() > k) {
                // 当哈希表长度超过k后, 把先入的元素弹出
                ans.remove(nums[i-k]);
            }
        }
        // 不存在重复元素
        return false;
    }
}
