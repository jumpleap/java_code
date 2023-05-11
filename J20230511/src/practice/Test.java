package practice;

import java.util.Arrays;

@SuppressWarnings({"all"})

public class Test {
    public static void main(String[] args) {
        //比较String、StringBuffer和StringBuilder的效率
        //System.currentTimeMillis()：返回当前的系统时间，以毫秒为单词
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 10000; ++i) {
            s += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);


        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("");
        for (int i = 0; i < 10000; ++i) {
            sbf.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < 10000; ++i) {
            sbd.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main11(String[] args) {
        String s = "hello";
        s += "world";
        System.out.println(s);

        /*
        底层源码分析：
            1.默认走的是StringBuilder的构造器，默认大小是16
            public StringBuilder() {
                super(16);
            }
            2.使用了StringBuilder的append方法
            public StringBuilder append(String str) {
                //调用了父类的append方法
                super.append(str);
                //返回已经添加后的字符串
                return this;//this指的是s
            }

            append的底层源码分析：
            public AbstractStringBuilder append(String str) {
                if (str == null)
                    //添加null
                    return appendNull();
                //字符串长度
                int len = str.length();
                //扩容value的长度到count+len个空间
                ensureCapacityInternal(count + len);
                //进行value的拷贝，底层调用的是System.arraycopy方法
                str.getChars(0, len, value, count);
                count += len;
                return this;
            }
            3.最后调用toString方法返回字符串
            public String toString() {
                // Create a copy, don't share the array
                return new String(value, 0, count);
            }
         */
    }

    public static void main10(String[] args) {
        String s = "abcdef";
        //substring方法：获取字符中的[int fromIndex, int endIndex)的位置
        //返回新对象；如果从0开始，返回的和原来的对象一样
        System.out.println(s.substring(0));//从0开始，一直到最后
        System.out.println(s.substring(0, 4));//[0,4) --> abcd

        String s2 = " abcd efg  ";
        //trim()：去掉字符串前后的空格
        System.out.println(s2.trim());//返回新对象

        /*
        1.substring(int beginIndex)底层源码分析：
        public String substring(int beginIndex) {
            //如果开始的下标小于0，则抛出异常
            if (beginIndex < 0) {
                throw new StringIndexOutOfBoundsException(beginIndex);
            }
            //字符串长度与开始下标之差
            int subLen = value.length - beginIndex;
            //这个地方说明开始长度比字符串长度大
            if (subLen < 0) {
                throw new StringIndexOutOfBoundsException(subLen);
            }
            //如果字符串长度和beginIndex长度相同，直接把当前字符串返回回去；否则，返回一个新的字符串
            return (beginIndex == 0) ? this : new String(value, beginIndex, subLen);
        }

        2.trim()底层源码分析：
        public String trim() {
            //得到当前字符串的长度
            int len = value.length;
            int st = 0;
            //指向当前字符串中字符数组所指向的地址
            char[] val = value;

            //判断字符串前面是不是有空格
            while ((st < len) && (val[st] <= ' ')) {
                st++;
            }
            //判断字符串尾部是不是有空格
            while ((st < len) && (val[len - 1] <= ' ')) {
                len--;
            }
            //返回截取的字符串或返回当前字符串
            return ((st > 0) || (len < value.length)) ? substring(st, len) : this;
        }
         */
    }

    public static void main9(String[] args) {
        String str = "name=zhangsan&age=10";
        //多组分割：使用|连接符
        String[] split = str.split("&|=");
        System.out.println(Arrays.toString(split));

        //自己实现一个多组分割
        String s = "name=zhangsan&age=10";
        //第一次按照&分割
        String[] split1 = s.split("&");
        for (int i = 0; i < split1.length; i++) {
            //把按照&分割后的字符串再按照=分割
            String[] split2 = split1[i].split("=");
            for (int j = 0; j < split2.length; j++) {
                System.out.println(split2[j]);
            }
        }
    }

    public static void main8(String[] args) {
        String str = "name=zhangsan&age=10";
        //split:分割字符串
        String[] split = str.split("&");
        System.out.println(Arrays.toString(split));
        System.out.println("========");

        String str2 = "hello world hello bit";
        String[] s = str2.split(" ");
        System.out.println(Arrays.toString(s));
        //以空格分割为两组字符串
        String[] s1 = str2.split(" ", 2);
        System.out.println(Arrays.toString(s1));

        //特殊情况：.需要转义，\需要转义
        String s2 = "192.168.223.1";
        String[] split1 = s2.split("\\.");
        for (int i = 0; i < split1.length; i++) {
            System.out.println(split1[i]);
        }

        String s3 = "187\\167\\134\\1";
        String[] split2 = s3.split("\\\\");
        System.out.println(Arrays.toString(split2));
    }

    public static void main7(String[] args) {
        String str = "ababcabcdabcde";
        //replace：把字符串中的字符或字符串进行内容替换[返回值是new新对象]
        //把所有的ab转化为oooo字符
        System.out.println(str.replace("ab", "oooo"));//[返回值是new新对象]
        //把所有的'b'字符转化为'z'字符
        System.out.println(str.replace('b', 'z'));
        //把第一个regex值转化为replacement值
        System.out.println(str.replaceFirst("ab", "kk"));
        //把所有的regex值转化为replacement值
        System.out.println(str.replaceAll("ab", "ll"));
    }

    public static void main6(String[] args) {
        String s = "abcdefg";
        //toUpperCase:把小写转化为大写[返回值是new新对象]
        System.out.println(s.toUpperCase());//ABCDEFG

        String str = "HellO";
        //toLowerCase():把大写转化为小写[返回值是new新对象]
        System.out.println(str.toLowerCase());//hello

        //toCharArray():把字符串转化为字符数组【实例方法，需要对象名访问】
        char[] chars = str.toCharArray();
        System.out.println(Arrays.toString(chars));

        //format:字符串的格式化
        String s1 = String.format("%s-%d-%d", "2019年", 12, 12);
        System.out.println(s1);

        /*
        toCharArray的底层源码分析：
        public char[] toCharArray() {
            // Cannot use Arrays.copyOf because of class initialization order issues
            //以value的数组长度申请了一个数组
            char result[] = new char[value.length];
            //进行数组拷贝
            System.arraycopy(value, 0, result, 0, value.length);
            //返回result的地址【引用】
            return result;
        }
         */
    }

    public static void main5(String[] args) {
        String s1 = String.valueOf(1234);//[返回值是new新对象]
        String s2 = String.valueOf(12.34);
        String s3 = String.valueOf(true);
        String s4 = String.valueOf(new Student());

        System.out.println(s1);//1234
        System.out.println(s2);//12.34
        System.out.println(s3);//true

        //parseXxx()方法：底层会把对应的字符串转化为对应的数字或布尔值
        int data = Integer.parseInt("1234");
        double num = Double.parseDouble("12.34");
        System.out.println(data);//1234
        System.out.println(num);//12.34

        /*
        1.valueOf()的底层源码分析：
            public static String valueOf(int i) {
                //走的是Integer 的toString方法
                return Integer.toString(i);
            }

            public static String valueOf(double d) {
                return Double.toString(d);
            }

            public static String valueOf(boolean b) {
                //直接判断是true还是false，返回对应的字符串
                return b ? "true" : "false";
            }

            public static String valueOf(Object obj) {
                //走的是Object的toString方法，最后会动态绑定
                return (obj == null) ? "null" : obj.toString();
            }
         */
    }

    public static void main4(String[] args) {
        String s1 = "AbCd";
        String s2 = "abcd";
        //忽略大小写进行比较
        System.out.println(s1.compareToIgnoreCase(s2));//true

        //charAt(int index):获取指定位置的字符
        String s = "abcdefg";
        System.out.println(s.charAt(1));//b

        //indexOf(int index)：查找某个字符第一次出现的位置
        System.out.println(s.indexOf('b'));//1
        //indexOf(String s)
        System.out.println(s.indexOf("cd"));//2
        System.out.println(s.indexOf('c', 2));//从2下标开始查找字符c

        /*
        1.charAt(int index)底层源码分析：
        public char charAt(int index) {
            //判断index的值是不是小于0或大于等于底层字符数组的场电影，直接抛出异常
            if ((index < 0) || (index >= value.length)) {
                throw new StringIndexOutOfBoundsException(index);
            }
            //直接返回value数组中index下标对应的值
            return value[index];
        }

        //2.indexOf()底层源码分析：
        public int indexOf(int ch, int fromIndex) {、
            //得到数组长度
            final int max = value.length;
            //搜索位置从0开始
            if (fromIndex < 0) {
                fromIndex = 0;
            //如果搜索位置大于数组长度，直接返回-1
            } else if (fromIndex >= max) {
                // Note: fromIndex might be near -1>>>1.
                return -1;
            }
            //字符的Unicode码小于Unicode码的最大值65536
            if (ch < Character.MIN_SUPPLEMENTARY_CODE_POINT) {
                // handle most cases here (ch is a BMP code point or a
                // negative value (invalid code point))
                final char[] value = this.value;
                for (int i = fromIndex; i < max; i++) {
                    //如果有字符相等的话直接返回对应下标
                    if (value[i] == ch) {
                        return i;
                    }
                }
                //返回-1
                return -1;
            } else {
                return indexOfSupplementary(ch, fromIndex);
            }
        }
         */
    }

    public static void main3(String[] args) {
        String s1 = "abcde";
        String s2 = "abcdefg";
        String s3 = "dgdshgd";

        System.out.println(s1.compareTo(s2));//-2
        System.out.println(s1.compareTo(s3));//3
        /*
            1.String中实现了Comparable<String>接口，重写了Comparable接口中的compareTo方法
            2.String中的compareTo方法的底层源码分析：
            public int compareTo(String anotherString) {
                //得到当前字符串的长度
                int len1 = value.length;
                //得到待比较字符串的长度
                int len2 = anotherString.value.length;
                //取两者的最小值
                int lim = Math.min(len1, len2);
                //使用数组v1指向value引用所指向的对象
                char v1[] = value;
                //使用数组v2指向带比较字符串value引用所指向的对象
                char v2[] = anotherString.value;

                int k = 0;
                //开始比较，k和lim【两个字符串中最小长度进行比较】
                while (k < lim) {
                    //分别获取两个字符数组中的字符
                    char c1 = v1[k];
                    char c2 = v2[k];
                    //进行判断，不相等则直接返回两者之差
                    if (c1 != c2) {
                        return c1 - c2;
                    }
                    k++;
                }
                //若比较完最小长度后，但两者相等的话，直接返回两者的长度之差
                return len1 - len2;
            }
         */
    }

    public static void main2(String[] args) {
        String str1 = new String("abcde");
        String str2 = new String("abcde");
        System.out.println(str1 == str2);//false: new出来的字符串在堆中开辟内存空间，两个的内存空间不一样
        //即 == 比较的是两个对象的地址

        System.out.println(str1.equals(str2));//true

        /*
        equals的底层源码分析：
        public boolean equals(Object anObject) {
            //判断两个对象是不是同一个对象【即判断地址是否相等】
            if (this == anObject) {
                return true;
            }
            //判断anObject的运行类型是不是String类型
            if (anObject instanceof String) {
                //向下转型
                String anotherString = (String)anObject;
                //得到this.value的长度【即字符串的长度】
                int n = value.length;
                //判断两个字符串的长度是否相等
                if (n == anotherString.value.length) {
                    //v1的引用指向value引用所指向的对象
                    char v1[] = value;
                    //v2的引用指向anotherString.value所指向的对象
                    char v2[] = anotherString.value;
                    int i = 0;
                    //进行遍历比较
                    while (n-- != 0) {
                        //一旦当前字符串的某个字符不等于另一位一个字符串的字符
                        if (v1[i] != v2[i])
                            return false;
                        i++;
                    }
                    //比较后，没有不相等的字符
                    return true;
                }
            }
            //不是直接false
            return false;
        }
         */

        String s1 = "abcde";
        String s2 = "abcde";
        System.out.println(s1 == s2);//true
        //解释：直接赋值的字符串存储于字符串常量池中，字符串常量池在jdk8及以后从永久代中移至堆中，
        //如果字符串常量池中已经有了"abcde",那么下一个相同的字符串直接从堆中取来用，即两个的地址是一样的
    }

    public static void main1(String[] args) {
        final int[] arr = {1, 2, 3, 4, 5};
        arr[0] = 2;
        //final修饰引用类型，那引用类型的指向不能改变
        //arr = new int[10];
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);//数组的长度

        String str = new String("abcd");
        System.out.println(str);//abcd
        System.out.println(str.length());//4

        char[] ch = {'a', 'b', 'c', 'd'};
        //字符串中以字符数组的构造器
        String s = new String(ch);
        System.out.println(s);//abcd

        //isEmpty()：判断字符串是不是空串"",长度为0
        System.out.println(str.isEmpty());//false
        /*
        底层源码分析：
            public boolean isEmpty() {
                //如果字符串的长度为0，那么这个字符就是空串
                return value.length == 0;
            }
         */

        //比较
        String string = null;
        String string1 = "";
        System.out.println(string1.length());//0
        System.out.println(string.length());//空指针异常
        /*
        解释：
            1）null代表不指向任何一个对象
            2）""代表长度为0的空串
         */
    }
}

class Student {

}