package leetcode.simply.array;

// 旋转数组的最小数字
public class MinNumberInRotateArray {
    /*
        有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，
        变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
        请问，给定这样一个旋转数组，求数组中的最小值。
        数据范围：1≤n≤10000，数组中任意元素的值: 0≤val≤10000
        要求：空间复杂度：O(1) ，时间复杂度：O(logn)
        https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=295&tqId=23269&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     */

    // 遍历思路
    public int minNumberInRotateArray1(int[] array) {
        // 定义数组的第一个值为最小的值
        int minVal = array[0];

        for (int i = 0; i < array.length; i++) {
            // 谁小谁就是minVal
            if (minVal > array[i]) {
                minVal = array[i];
            }
        }

        // 返回最小值
        return minVal;
    }


    // 二分
    public int minNumberInRotateArray(int[] array) {
        // 定义二分的左右边界
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // 获取中值
            int mid = left + (right - left) / 2;

            // 因为原来的数组是非降序数组，所以非分三种情况：
            // 1.中值和边界值比较，若是比边界值大，则说明最小值在右边
            // 2.中值和边界值相等，说明该数组比较匀称，让边界自减在进行判断
            // 3.中值比边界值小，说明最小值在右边也可能当前中值为边界值
            if (array[mid] > array[right]) {
                // 往右边继续查找
                left = mid + 1;
            } else if (array[mid] == array[right]) {
                // 缩小边界，进行查找
                right = right - 1;
            } else {
                // 往左边进行查找，因为可能mid自己为中值
                right = mid;
            }
        }
        // 当left和right相遇后，两者随便返回一个即可
        return array[right];
    }
}