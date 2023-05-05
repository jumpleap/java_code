package demo;

public class RemoveDuplicatesPlusDemo {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 2, 3, 3, 4, 4, 5, 6, 7, 8}));
    }

    /**
     * 删除数组中重复的元素，只保留两个及以下的相同元素
     * 通用解法：保留相同的k个元素
     */
    public static int removeDuplicates(int[] nums) {
        //返回数组长度
        return elementProcess(nums, 2);
    }

    public static int elementProcess(int[] nums, int k) {
        int index = 0;

        for (int num : nums) {
            //保留前面两个元素，然后使用后面的元素和前面的元素进行比较，不相等则加入到数组中去
            if (index < k || nums[index - k] != num) {
                nums[index++] = num;
            }
        }
        //返回新数组的长度
        return index;
    }
}
