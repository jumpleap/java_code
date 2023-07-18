package task;

public class Day8 {
    /*
    1、关于java中的数组，下面的一些描述，哪些描述是准确的（ AC）
    A: 数组是一个对象，不同类型的数组具有不同的类
    B: 数组长度是可以动态调整的
    C: 数组是一个连续的存储结构
    D: 一个固定长度的数组可类似这样定义：int array[100]
    //解析：数组的长度是一开始就固定好了的，不可以动态调整，数组是一个连续的存储结构


    2、若声明一个浮点数数组如下： float average[]=new float[30]；假设该数组的内存起始位置为200，
    average[15]的内存地址是（C）
    A: 214 B: 215 C: 260 D: 256
    //解析：一个float的大小是4个字节

    3、下列哪个类的声明是正确的（D）
    A: abstract final class HI{}
    B: abstract private move{}
    C: protected private number{}
    D: public abstract class Car{}
    //解析：abstract不能和private和final进行搭配使用

    4、与算法的时间复杂度有关的是（A）
    A. 问题规模 B. 计算机硬件性能 C. 编译程序质量 D. 程序设计语言

    5、某算法的时间复杂度为 O^2，表明该算法的（C）
    A. 问题规模是n^2 B. 执行时间等于n^2 C. 执行时间与n^2成正比 D. 问题规模与n^2成正比
    //算法的时间复杂度中的n只是问题的规模，不代表具体执行时间，具体的执行时间与CPU的执行时间有关
     */

    /*
    给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
    假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
    注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
    返回词汇表 words 中你掌握的所有单词的 长度之和。
     */

    /**
     * 思路分析：分别统计word单词中和chars单词中的字符数，若是word单词中的某个单词的字符数比chars的大，则说明无法拼出word
     * 若word单词中的字符数均小于等于chars，则说明可以拼出word单词
     * 时间复杂度：O(m * n)[m为字符串数组的长度，n为字符串的长度]
     * 空间复杂度：O(n)
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        //统计chars中的字符数
        int[] charsCount = count(chars);
        int res = 0;
        for (String word : words) {
            //统计word中的字符数
            int[] wordCount = count(word);
            //比较
            if (contains(charsCount, wordCount)) {
                //拼的出的话相加word的字符串长度
                res += word.length();
            }
        }
        return res;
    }

    //判断chars中的字符是否能拼出word单词
    private boolean contains(int[] charsCount, int[] wordCount) {
        for (int i = 0; i < 26; i++) {
            //说明chars中的字符不够拼出word中的字符
            if (charsCount[i] < wordCount[i]) {
                return false;
            }
        }
        return true;//拼的出
    }

    //统计26个字母中字符的个数
    private int[] count(String word) {
        int[] counter = new int[26];
        for (int i = 0; i < word.length(); i++) {
            counter[word.charAt(i) - 'a']++;
        }
        return counter;
    }

    /*
    给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
     */
    public int dayOfYear(String date) {
        //日期设置
        int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //获取年月日
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        //获取月份的天数
        int sumDay = 0;
        for (int i = 1; i < month; i++) {
            sumDay += m[i - 1];
        }
        sumDay += day;
        //判断闰年
        if (month > 2 && isLeapYear(year)) {
            sumDay += 1;
        }
        return sumDay;
    }

    //判断闰年
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}