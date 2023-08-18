package leetcode;

/**
 * 给你一个长度固定的整数数组 arr ，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 */
class Solution2 {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        //快慢指针
        int cur = 0;
        int dest = -1;
        int length = arr.length;

        //找到复写的最后一个数字
        while (cur < length) {
            //不是0，dest走1步
            if (arr[cur] != 0) {
                dest++;
            } else {
                //是0，dest走2步
                dest += 2;
            }

            //判断dest是否已经超过数组长度
            if (dest >= length - 1) break;
            cur++;
        }

        //边界情况的处理
        if (dest == length) {
            arr[length - 1] = 0;
            cur--;
            dest -= 2;
        }

        //从后往前进行复写
        while (cur >= 0) {
            //不是0
            if (arr[cur] != 0) {
                arr[dest--] = arr[cur--];
            } else {
                //是0
                arr[dest--] = 0;
                arr[dest--] = 0;
                cur--;
            }
        }
    }
}