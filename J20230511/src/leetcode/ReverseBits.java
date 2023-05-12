package leetcode;

public class ReverseBits {
    public static void main(String[] args) {

    }

    /**
     * 法一：对称位重置
     * 时间复杂度：O(1)； 空间复杂度：O(1)
     * @param n 需要逆置二进位逆置
     * @return 返回逆序的二进制位
     */
    public int reverseBits1(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            //得到n的最后一个比特位
            int ret = (n >> i) & 1;
            //ret为0则不需要交换
            if (ret == 1) {
                //对称的位置置为1
                ans |= (1 << (31 - i));
            }
        }
        return ans;
    }

    /**
     * 法二:使用ans存储n的位置，使n右移，ans左移【即可颠倒二进制位】
     * 相当于每次都用 nnn 的最低一位更新成 ans 的最低一位。
     * 时间复杂度：O(1)； 空间复杂度：O(1)
     * @param n 需要逆置二进位逆置
     * @return 返回逆序的二进制位
     */
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans <<= 1;//左移一位留下位置
            ans |= (n & 1);//把n的第0位和ans的第0位进行相加
            n >>= 1;//把n相加过的数丢掉
        }
        return ans;
    }
}
