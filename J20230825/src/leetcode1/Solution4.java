package leetcode1;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
class Solution4 {
    public int[] spiralOrder(int[][] matrix) {
        //判断是不是空数组
        if (matrix.length == 0) {
            return new int[0];
        }

        //设置边界
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        //申请数值空间
        int[] array = new int[(right + 1) * (bottom + 1)];
        int index = 0;//记录新数组的下标

        //进行模拟
        while (true) {
            //从左到右
            for (int i = left; i <= right; i++) {
                array[index++] = matrix[top][i];
            }
            //边界判断
            if (++top > bottom) {
                break;
            }

            //从上到下
            for (int i = top; i <= bottom; i++) {
                array[index++] = matrix[i][right];
            }
            //边界判断
            if (--right < left) {
                break;
            }

            //从右到左
            for (int i = right; i >= left; i--) {
                array[index++] = matrix[bottom][i];
            }
            //边界判断
            if (--bottom < top) {
                break;
            }

            //从下到上
            for (int i = bottom; i >= top; i--) {
                array[index++] = matrix[i][left];
            }
            //边界判断
            if (++left > right) {
                break;
            }
        }
        return array;
    }
}