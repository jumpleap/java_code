package task;

import java.util.ArrayList;
import java.util.List;

public class Day14 {
    /*
    1、递归算法一般需要利用哪种数据结构实现（D）
    A. 数组 B. 链表 C. 队列 D. 栈
    //解析：递归算法每次递归需要栈帧来保存这次递归的信息

    2、以下二叉树前序遍历的顺序是（A）
    A. abefd B. abdef C. ebfad D. efbda
    //解析：前序遍历：根左右

    3、已知一棵完全二叉树的第6层（设根为第1层）有8个叶结点，则该完全二叉树的结点个数最多是（A）
    A. 39 B. 52 C. 111 D. 119
    //解析：1 + 2 + 4 + 8 + 16 + 8

    4、具有 12 个结点的完全二叉树有（B）
    A. 5个叶子结点 B. 5个度为2的结点 C. 7个分支结点 D. 2个度为1的结点
    //解析：画图后就明白

    5、深度为 7 的二叉树共有 127 个结点，则下列说法中错误的是（A）
    A. 该二叉树有一个度为1的结点
    B. 该二叉树是满二叉树
    C. 该二叉树是完全二叉树
    D. 该二叉树有64个叶子结点
    //该二叉树是完全二叉树也是满二叉树
     */


    /*
    给你一个数组 target 和一个整数 n。每次迭代，需要从  list = { 1 , 2 , 3 ..., n } 中依次读取一个数字。
    请使用下述操作来构建目标数组 target ：
    "Push"：从 list 中读取一个新元素， 并将其推入数组中。
    "Pop"：删除数组中的最后一个元素。
    如果目标数组构建完成，就停止读取更多元素。
    题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
    请返回构建目标数组所用的操作序列。如果存在多个可行方案，返回任一即可。
     */

    /**
     * 思路分析：建立集合，遍历数组和1-n的值，若是数组值和i相同，数组下标自增，若是不存在，则Pop
     * 时间复杂度：O(n)
     * 空间复杂度：O(n) n : 集合的容量
     * @param target 目标数组
     * @param n      1-n的值
     * @return 返回集合
     */
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();//申请集合

        int index = 0;//操作数组下标
        //若数字超过了n或数组下标越界，那么跳出循环
        for (int i = 1; i <= n && index < target.length; i++) {
            //进行push
            list.add("Push");
            //数组值和i若相等，则让数组下标自增
            if (target[index] == i) {
                index++;
            } else {
                //不相等，则添加“Pop”
                list.add("Pop");
            }
        }
        //返回集合
        return list;
    }

    /*
    nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
    给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
    对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
    并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
    返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
     */

    /**
     * 思路分析：暴力循环
     * 时间复杂度：O(mn)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];//申请结果数组
        int k = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                //若是nums1[i] == nums2[j],就往nums2[j]的右边寻找最大值
                if (nums1[i] == nums2[j]) {
                    int len = j + 1;
                    //往右边寻找下一个最大值
                    while (len < nums2.length) {
                        //找到了
                        if (nums2[len] > nums2[j]) {
                            //赋值给ans,并跳出循环
                            ans[k++] = nums2[len];
                            break;
                        }
                        len++;
                    }
                    //没有找到
                    if (len == nums2.length) {
                        ans[k++] = -1;
                    }
                }
            }
        }
        return ans;
    }
}