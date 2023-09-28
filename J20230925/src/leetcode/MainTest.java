package leetcode;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息

/**
 * “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 * 花花非常喜欢这种拥有对称美的回文串，生日的时候她得到两个礼物分别是字符串A和字符串B。
 * 现在她非常好奇有没有办法将字符串B插入字符串A使产生的字符串是一个回文串。
 * 你接受花花的请求，帮助她寻找有多少种插入办法可以使新串是一个回文串。如果字符串B插入的位置不同就考虑为不一样的办法。
 */
public class MainTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String A = in.nextLine();
        String B = in.nextLine();
        int len = A.length();
        int count = 0;

        for (int i = 0; i <= len; i++) {
            StringBuilder s = new StringBuilder(A);

            //插入数据
            s.insert(i, B);
            StringBuilder tmp = new StringBuilder(s);
            //注: 一旦翻转, 原来的字符串也会进行翻转
            tmp.reverse();

            //StringBuilder中没有equals方法
            if (tmp.toString().equals(s.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * StringBuilder底层reverse方法和insert方法分析
     */
    /*
    public AbstractStringBuilder insert(int offset, String str) {
        //插入的下标异常
        if ((offset < 0) || (offset > length()))
            throw new StringIndexOutOfBoundsException(offset);
        //插入的值为null, 直接把str赋为null字符串
        if (str == null)
            str = "null";
        //获取str字符串的长度
        int len = str.length();

        //扩容
        ensureCapacityInternal(count + len);
        //复制字符串到value中
        System.arraycopy(value, offset, value, offset + len, count - offset);
        //转化为字符数组
        str.getChars(value, offset);
        //计数值
        count += len;
        return this;
    }

    private void ensureCapacityInternal(int minimumCapacity) {
        // overflow-conscious code
        //说明str和value的字符串长度 大于 value的字符串长度, 需要扩容
        if (minimumCapacity - value.length > 0) {
            value = Arrays.copyOf(value,
                    newCapacity(minimumCapacity));
        }
    }

    private int newCapacity(int minCapacity) {
        // overflow-conscious code
        //按照左移一位 + 2 的长度来进行扩容
        int newCapacity = (value.length << 1) + 2;
        //若新长度比原来的长度还小, 那么使用原来的长度
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        //判断返回的长度是否合法, 判断后返回
        return (newCapacity <= 0 || MAX_ARRAY_SIZE - newCapacity < 0)
            ? hugeCapacity(minCapacity)
            : newCapacity;
    }

    void getChars(char dst[], int dstBegin) {
        System.arraycopy(value, 0, dst, dstBegin, value.length);
    }
     */

}