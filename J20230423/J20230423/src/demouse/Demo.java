package demouse;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings({"all"})
public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        num = scanner.nextInt();
        System.out.println(reverse(num));
    }

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
     * 分别表示 nums1 和 nums2 中的元素数目。
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    //法一：排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //把nums2的数据添加到nums1的后面
        for(int i=0; i<n; i++) {
            nums1[i+m] = nums2[i];
        }
        //排序
        Arrays.sort(nums1);
    }

    //法二：双指针 + 原地移动
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;//nums1的含有元素的数组长度
        int q = n - 1;//nums2的数组长度
        int len = m + n - 1;//nums1的数组总长度
        int cur = 0;

        while(p >= 0 || q >= 0) {
            if(p == -1) {
                //nums1是空数组/nums1已经添加完
                cur = nums2[q--];
            } else if(q == -1) {
                //nums2是空数组/nums1已经添加完
                cur = nums1[p--];
            } else if(nums1[p] > nums2[q]) {
                //添加nums1元素
                cur = nums1[p--];
            } else {
                //添加nums2元素
                cur = nums2[q--];
            }
            //从后往前添加
            nums1[len--] = cur;
        }
    }


    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
     * @param x
     */
    public static int reverse(int x) {
        int ret = 0;
        while(x != 0) {
            //判断是否溢出了
            if(ret > Integer.MAX_VALUE / 10 || ret < Integer.MIN_VALUE / 10) {
                return 0;
            }
            //倒置求和
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
}
