package test;

import java.util.Scanner;

public class DemoOne {
    public static void main(String[] args) {
        int[] arr = {12,3,45,6,7,9,11};
        System.out.println(threeConsecutiveOdds(arr));
    }

    //判断连续3个奇数
    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] % 2 == 1) {
                count++;
            } else {
                //不连续置为0
                count = 0;
            }
            //判断是否三个奇数连续
            if(count == 3) {
                return true;
            }
        }
        return false;
    }

    public static void main4(String[] args) {
        int[] arr = {1,3,3,3,4,4,5,3,3};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        //投票
        int count = 1;
        int cur = nums[0];
        for(int i=1; i<nums.length; i++) {
            //判断是否相等
            if(cur == nums[i]) {
                count++;
            } else if(count == 0) {
                //更新元素
                cur = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return cur;
    }

    public static void main2(String[] args) {
        int[] arr = {1, 1, 2, 2, 3};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        int ret = 0;
        //异或的性质得到只出现一次的数字
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }

    public static void main1(String[] args) {
        //给定一个整数数组 nums 和一个整数目标值 target，
        //请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
        Scanner scanner = new Scanner(System.in);
        //输入
        System.out.println("请输入数组的长度：");
        int len = scanner.nextInt();
        int[] nums = new int[len];
        System.out.println("请输入数组元素：");
        for (int i = 0; i < nums.length; i++) {
            int data = scanner.nextInt();
            nums[i] = data;
        }
        int target = 0;
        System.out.println("请输入你要查找的值：");
        target = scanner.nextInt();

        int[] index = twoSum(nums, target);
        //输出下标位置
        for (int i = 0; i < index.length; i++) {
            System.out.print(index[i] + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //判断和是否等于target
                if (nums[i] + nums[j] == target) {
                    //记录下标
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }
}