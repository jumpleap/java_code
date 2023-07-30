package demo;

import java.math.BigInteger;

/**
 * 二进制和十进制的相互转化
 */
public class BinaryToDecimal {
    /**
     * 十进制转化为二进制
     * @param decimalSource 十进制数
     * @return 返回二进制的字符串
     */
    public static String decimalToBinary(int decimalSource) {
        //转化成BigInteger类型，默认是十进制
        BigInteger bigInteger = new BigInteger(String.valueOf(decimalSource));
        return bigInteger.toString(2);//返回二进制的字符串
    }

    /**
     * 二进制转为十进制
     * @param binarySource 二级制字符串
     * @return 十进制数
     */
    public static int binaryToDecimal(String binarySource) {
        //把binarySource转化为BigInteger类型的二进制
        BigInteger bigInteger = new BigInteger(binarySource,2);
        //bigInteger.toString()默认转为十进制
        return Integer.parseInt(bigInteger.toString());
    }

    public static void main(String[] args) {
        int num = 51;
        String binary = "1001101";

        System.out.println(decimalToBinary(num));
        System.out.println(binaryToDecimal(binary));
    }
}