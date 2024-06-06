package leetcode.simply.double_pointer;

// 复写0
public class DuplicateZeros {
    /*
        给你一个长度固定的整数数组 arr ，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
        注意：请不要在超过该数组长度的位置写入元素。请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
        链接：https://leetcode.cn/problems/duplicate-zeros/description/
     */

    /**
     * 法一： 临时数组【需要判断是否写满】
     * 空间复杂度： O(N)
     * @param arr
     */
    public void duplicateZeros1(int[] arr) {
        // 申请临时数组
        int[] tmpArr = new int[arr.length];

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // 判断是否已经写满了，防止越界访问
            if (index == tmpArr.length) break;

            if (arr[i] != 0) {
                tmpArr[index++] = arr[i];
            } else {
                tmpArr[index++] = 0;
                // 判断是否写满了，防止越界访问
                if (index == tmpArr.length) break;
                tmpArr[index++] = 0;
            }
        }

        // 赋值
        for (int i = 0; i < tmpArr.length; i++) {
            arr[i] = tmpArr[i];
        }
    }


    /**
     * 法二：双指针
     * 思路：
     *      1.先找到最后一个要复写的数【双指针查找】
     *          1）先判断cur的值：是0，dest走两步， 非0，dest走一步
     *          2）判断dest是否已经走过了数组数组长度，超过，break
     *          3）cur后移一步，进行下一轮的判断
     *      2.边界判断【最后一个复写的是0】
     *          让数组的最后一个元素置为0，dest前移两步，cur前移一步
     *      3.从后往前开始复写
     * 时间复杂度：O(N)
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        // 定义双指针
        int dest = -1;
        int cur = 0;

        while (cur < arr.length) {
            // 遇到0值dest走两步
            if (arr[cur] == 0) {
                dest += 2;
            } else {
                // 非0值走一步
                dest++;
            }

            // 判断是否到达最后一个位置
            if (dest >= arr.length - 1) break;

            cur++;
        }

        // 边界处理，防止最后一个0的情况
        if (dest == arr.length) {
            arr[arr.length - 1] = 0;
            dest -= 2;
            cur--;
        }

        // 此时，cur指向要复写的值，dest指向数组后进行复写的地方

        // 从后向前进行复写
        while (cur >= 0) {
            if (arr[cur] == 0) {
                arr[dest--] = 0;
                arr[dest--] = 0;
            } else {
                arr[dest--] = arr[cur];
            }
            cur--;
        }
    }
}
