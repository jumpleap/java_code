package task;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Day7 {

    /*
    1、扩展方法能访问被扩展对象的public成员（A）
    A: 能 B: 不能
    //解析：public为公共属性，可以访问

    2、下面关于静态方法说明正确的是（B）
    A: 在静态方法中可用this来调用本类的类方法
    B: 在静态方法中调用本类的静态方法时可直接调用
    C: 在静态方法中只能调用本类中的静态方法
    D: 在静态方法中绝对不能调用实例方法
    //解析：静态方法只能调用静态方法，若想要调用非静态方法，需要在静态方法中实例化对象，以对象的方式去访问即可
    //调用其他类的静态方法时，直接以类名.方法名调用即可，可以直接调用本类的静态方法

    3、如果类的方法的返回值为空，该方法的返回类型应是（A）
    A: void
    B: null
    C: abstract
    D: default

    4、Which of the following statements are valid array declaration? （BC）
    A: int number();
    B: float average[];
    C: double[] marks;
    D: counter int[];

    5、关于下面代码 int[] x=new int[25]; 描述正确的是（C）
    A: x[25]存放了数据“0”
    B: x[24] 存放了数据“0”
    C: 若访问x[25]，程序将抛出异常
    D: x[1]访问此数组的第一个元素
     */

    /*
    给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     */

    /**
     * 思路分析：使用一个哈希数组，把字符统计在里面，然后判断另外一个字符串的字符是否均在其中
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[] arr = new int[26];

        //长度不等的情况
        if (len1 != len2) {
            return false;
        }

        //计数
        for (int i = 0; i < len1; i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len2; i++) {
            //s2中没有该字符
            if (arr[s2.charAt(i) - 'a'] == 0) {
                return false;
            } else {
                //有不止一个字符的情况
                arr[s2.charAt(i) - 'a']--;
            }
        }
        //字符都相同
        return true;
    }

    /*
    有一堆石头，每块石头的重量都是正整数。
    每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
    如果 x == y，那么两块石头都会被完全粉碎
    如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
    最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     */

    /**
     * 思路分析：建立大根堆，然后直接弹出元素进行比较，若不等于，则相减值入队，最后判断是否为空队或只有一个元素
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        //建立大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                new Comparator<Integer>() {
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
        //入队
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        //结束条件：队列中少于2个元素
        while (maxHeap.size() > 1) {
            //获取值
            int m = maxHeap.poll();
            int n = maxHeap.poll();

            //若是m 比 n大，则入队
            if (m > n) {
                maxHeap.offer(m - n);
            }
        }
        //判断队列是只有一个元素还是空队
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}