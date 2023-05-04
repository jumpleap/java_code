package demo;

@SuppressWarnings({"all"})
public class RemoveDuplicatesDemo {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 3, 4, 4, 5, 6, 7}));
    }

    /**
     * 删除数组中重复的元素
     * 思路分析：快慢指针：慢指针指向数组的第一个元素，块指针指向慢指针的后一个元素；
     * 把不同的元素前移，返回这些不同的元素
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int p = 0;
        int q = 1;

        while (q < nums.length) {
            //判断p下标对应的元素和q下标对应的元素是否相等
            if (nums[p] != nums[q]) {
                //不同的数移至数组前面
                nums[++p] = nums[q];
            }
            //相等则q++
            q++;
        }
        //返回的数组长度
        return p + 1;
    }
}
