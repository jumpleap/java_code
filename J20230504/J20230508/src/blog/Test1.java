package blog;

public class Test1 {
    public static void main(String[] args) {
        String s = null;
        StringBuffer str = new StringBuffer();
        str.append(s);
        System.out.println(str.length());//4
        System.out.println(str);//null

        StringBuffer str1 = new StringBuffer(s);
        System.out.println(str1);//NullPointerException

        /*
        //1.append()方法的底层分析
        private AbstractStringBuilder appendNull() {
            int c = count;
            ensureCapacityInternal(c + 4);
            final char[] value = this.value;
            value[c++] = 'n';
            value[c++] = 'u';
            value[c++] = 'l';
            value[c++] = 'l';
            count = c;
            return this;
        }

        //2.new StringBuffer(String s)的底层分析
        public StringBuffer(String str) {
            //可以看出，这里的长度为null.length()的时候，引发空指针异常
            super(str.length() + 16);
            append(str);
        }
         */
    }
}


class Demo {
    public static void main(String[] args) {
        //使用StringBuffer的toString()方法
        StringBuffer maria = new StringBuffer("maria");
        String str = maria.toString();
        System.out.println(str);//maria

        //使用String的构造器
        String s = new String(maria);
        System.out.println(s);//maria

        /*
        //1.StringBuffer的toString()源码分析
        public synchronized String toString() {
            //这个缓存数组是不是null
            if (toStringCache == null) {
                //进行数组拷贝
                toStringCache = Arrays.copyOfRange(value, 0, count);
            }
            //返回一个String对象
            return new String(toStringCache, true);
        }

        //2.String的构造器
        public String(StringBuffer buffer) {
            synchronized(buffer) {
                //将buffer的内容拷贝到value数组中去【value是String的属性】
                this.value = Arrays.copyOf(buffer.getValue(), buffer.length());
            }
        }
         */
    }

    public static void main1(String[] args) {
        //使用构造器
        String str = "jack";
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(stringBuffer);//jack

        //使用append方法
        StringBuffer s = new StringBuffer();
        s.append(str);
        System.out.println(s);//jack

        /*
        1.StringBuffer的构造器底层源码：
        public StringBuffer(String str) {
            super(str.length() + 16);
            append(str);
        }

        2.append()方法的底层源码
        public synchronized StringBuffer append(String str) {
            toStringCache = null;
            super.append(str);
            return this;
        }

        public AbstractStringBuilder append(String str) {
            if (str == null)
                return appendNull();
            int len = str.length();
            ensureCapacityInternal(count + len);
            str.getChars(0, len, value, count);
            count += len;
            return this;
        }
         */
    }
}