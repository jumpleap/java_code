package demo;

/**
 * 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class RotateDemo {
    public static void main(String[] args) {
    }

    /**
     * 法一：逆序法
     * 思路：逆序整个数组，逆序0-k-1的元素，逆序k-len的元素
     */
    public void rotate(int[] nums, int k) {
        if (nums.length == 1 || k == 0) {
            return;
        }
        int len = nums.length;
        //防止k大于数组长度
        int pos = k % len;

        //让整个数组逆序
        reverse(nums, 0, len - 1);
        //逆序千般部分
        reverse(nums, 0, pos - 1);
        //逆序后半部分
        reverse(nums, pos, len - 1);
    }

    /**
     * 逆序数组元素
     */
    public void reverse(int[] nums, int start, int end) {
        int tmp = 0;
        //交换
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

            start++;
            end--;
        }
    }

    /**
     * 法二：取尾法
     * 思路：每次取最后一个元素，然后让整个数组后移，最后把最后一个元素放在第一个位置
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            int key = nums[len - 1];//取最后一个元素
            //数组后移
            for (int j = len - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            //把最后一个元素放在第一个位置
            nums[0] = key;
        }
    }

    /**
     * 法三：数组拷贝
     * 数组拷贝：时间复杂度/空间复杂度【O(n)】
     * 思路分析：开辟一个新的数组空间，把要k之前的元素放在新数组后面，把k之后的元素放在新数组前面，最后拷贝
     */
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        int[] newArr = new int[len];

        //把nums的数组元素拷贝到newArr里面
        for (int i = 0; i < len; i++) {
            newArr[(i + k) % len] = nums[i];
        }
        //最后重新拷贝给nums
        System.arraycopy(newArr, 0, nums, 0, len);
    }
}
