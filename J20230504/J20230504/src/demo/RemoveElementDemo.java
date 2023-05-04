package demo;

@SuppressWarnings({"all"})
/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElementDemo {
    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 2, 3};
        int val = 3;
        int ret = removeElement(array, val);
    }

    /**
     * 思路分析：把不和val相等的值赋值在数组中，并记录下标，最后返回值
     * 移除数组元素
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int index = 0;//计算不含val的元素总数

        for (int element : nums) {
            //判断是否和val相等
            if (element != val) {
                nums[index++] = element;
            }
        }
        return index;
    }
}
