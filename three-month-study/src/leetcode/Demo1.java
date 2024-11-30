package leetcode;
/**
 * @author 林沐雨
 * @date 2024/12/1
 */

public class Demo1 {
    /**
     * 题目链接：<a href="https://leetcode.cn/problems/move-zeroes/"> 移动0 </a>
     * 思路分析：双指针，右指针指向非0，左指针指向0值，当遇到非0的时候和左指针进行交换，交换后左指针右移一位。
     * 时间复杂度：O(N)
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 数组的长度不超过2
        if (nums.length < 2) return;

        // 定义双指针
        int left = 0;
        int right = 0;

        // 当 right == nums.length 时跳出循环
        while (right < nums.length) {
            // 当 right 不为0时，则需要和前面的0值进行交换，交换后 left 指向的 0 值后移一位
            if (nums[right] != 0) {
                // 交换
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                // left后移一位
                left++;
            }
            // right右移一位
            right++;
        }
    }


    /**
     * 题目链接：<a href="https://leetcode.cn/problems/duplicate-zeros/"> 复写0 </a>
     * 思路分析：双指针，left 遇到0则让 right 走两步，非0走一步，当 right 走完后判断是否到达数组的最后一个元素，
     *          到达的话则跳出循环；此时 left 指向要复写的最后一个元素，需要进行边界判断，判断 right 是否和数组长度相等
     *          相等的话则需要把数组的最后一个元素置为0，right 自减2，left 自减1【因为复写的最后一个数是0】
     *          最后进行代码的向前复写
     * 时间复杂度：O(N)
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        // 定义双指针，用于找到要复写的最后一个数
        int left = 0;
        int right = -1;
        int n = arr.length;

        while (right < n) {
            // 遇到0复写两次，遇到非0复写一次
            if (arr[left] == 0) {
                right += 2;
            } else {
                right++;
            }

            // 判断right是否到达数组的末尾
            if (right >= n - 1) break;

            left++;
        }

        // 此时 left 指向要复写的最后一个数
        // 边界判断：判断 right 的值是否和数组长度相同
        // 相同的话则需要把数组的最后一个数置为0且让 right-2，left-1
        if (right == n) {
            arr[arr.length - 1] = 0;
            right -= 2;
            left--;
        }

        // 对数组进行复写，遇到0复写两次，非0复写一次
        while (left >= 0) {

            // 遇到0复写两遍
            if (arr[left] == 0) {
                arr[right--] = 0;
                arr[right--] = 0;
            } else {
                // 非0复写一遍
                arr[right--] = arr[left];
            }
            left--;
        }
    }


    /**
     * <a href="https://leetcode.cn/problems/happy-number/"> 快乐数 </a>
     * 思路分析：双指针，让右指针走两步，左指针走一步，判断左右指针的值是否相等，相等则跳出循环，在判断其中的一个值是否为1
     * 时间复杂度：O(N)
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        // left走一步，right走两步
        int left = total(n);
        int right = total(total(n));

        // left 和 right 相等跳出循环
        while (left != right) {
            // left 走一步，right 走两步
            left = total(left);
            right = total(total(right));
        }
        // 判断结果是否为1
        return right == 1;
    }

    // 用于计算每个位的平方和
    private int total(int num) {
        int sum = 0;

        while (num != 0) {
            sum += Math.pow(num % 10, 2);
            num /= 10;
        }
        return sum;
    }


    /**
     * 链接：<a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/"> 两数之和 -- 非递减序列</a>
     * 思路分析：双指针 -- 左右指针，左指针指向数组首元素，右指针指向最后一个元素，相加后和 target 进行判断
     *          大于 target，则 right--，小于 target，则 left++；等于 target，则返回对于下标
     *          注意：题目中的下标是从 1 开始的
     * 时间复杂度：O(N)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        // 定义双指针：左右指针
        int left = 0;
        int right = numbers.length - 1;

        // 当左右指针相遇时跳出循环
        while (left < right) {
            // 获取左右指针值之和
            int ret = numbers[left] + numbers[right];

            // 判断，数组是非递减序列
            // 所以当 ret 的值大于 target，则 right--；反之 left++
            if (ret < target) left++;
            if (ret > target) right--;

            // 当相等时返回下标，注：下标是从 1 开始的，所以需要加 1
            if (ret == target) {
                return new int[]{left + 1, right + 1};
            }
        }
        // 没有该组数的情况
        return new int[]{-1, -1};
    }
}
