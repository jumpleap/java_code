package leetcode;

class Solution1 {
    /**
     * 思路分析：斐波那契数列的迭代版本解决（先知道前面两阶的方法数，再使用前面的方法数求后面的方法数）
     * 时间复杂度：O(n)
     * @param n 给定楼梯数
     * @return 返回爬楼梯的方法数
     */
    public int climbStairs(int n) {
        //使用i,j变量进行楼梯的数的迭代
        int i = 0;//0阶
        int j = 1;//1阶楼梯
        //n < 2的情况下，sum的值都是1
        int sum = 1;

        //1阶及以上的楼梯数的情况
        while (n >= 1) {
            //计算爬该阶楼梯的方法数
            sum = i + j;
            //进行迭代
            i = j;
            j = sum;
            n--;//n自减
        }
        //返回总的爬楼梯的方法数
        return sum;
    }
}