package leetcode;

public class SearchInsert {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 2, 3, 46, 4}, 3));
        System.out.println(searchInsert1(new int[]{1, 2, 3, 46, 4}, 3));
    }

    /**
     * 法一：二分查找
     * 时间复杂度：O(logN)；空间复杂度：O(1)
     * @param nums   数组
     * @param target 要查找的目标值
     * @return 返回对应的索引
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            //取数组的中间值
            int mid = left + (right - left) / 2;
            //使用中间值和目标值进行比较
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                //相等的话直接返回目标值的下标
                return mid;
            }
        }
        //最后判断，如果目标值大于左值，则需要在左值的右边一个
        if (nums[left] < target) {
            return left + 1;
        }
        //否则，直接插入到左值的位置
        return left;
    }


    /**
     * 法二：循环遍历
     * 时间复杂度：O(n)；空间复杂度：O(1)
     * @param nums   排序数组
     * @param target 要查找的目标值
     * @return 需要返回的下标
     */
    public static int searchInsert1(int[] nums, int target) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            //遍历判断：只有nums1中有大于等于target的值就直接返回这个下标
            if (nums[i] >= target) {
                index = i;
                break;
            }
        }
        //如果target大于nums中的所有值，那么直接返回数组的长度
        if (index == -1)
            return nums.length;
        return index;
    }
}
