package leetcode;

public class HamMingWeight {
    public static void main(String[] args) {

    }

    //法一：使用num = num & (num - 1):每次都去掉最低位的1
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            //每次将最低位的1置为0
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    //法二：让n右移32位，每次和1比较，如果是1，则计数器自增
    public int hammingWeight2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            //将n的每个比特位进行比较，如果是1
            if (((n >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
