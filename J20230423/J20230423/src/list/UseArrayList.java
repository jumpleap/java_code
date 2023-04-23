package list;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class UseArrayList {
    public static void main(String[] args) {
        //无参构造器
        //ArrayList arrayList = new ArrayList();
        ArrayList arrayList = new ArrayList(8);

        //查看ArrayList的底层源码
        for (int i = 0; i < 12; i++) {
            arrayList.add(i);
        }
        /*
        1.无参构造器中的空Object数组
        private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
        2.基本数据类型转为对应的包装类：自动装箱
        public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }
        3.
        //elementData是空数组，s是传进来的size，默认是0开始
        private void add(E e, Object[] elementData, int s) {
            if (s == elementData.length)
                elementData = grow();//进行扩容
            elementData[s] = e;//把这个e赋给elementData数组中的第一个下标处
            size = s + 1;//size的长度增1
        }
        4.扩容
        private Object[] grow() {
            //真正进行扩容
            return grow(size + 1);
        }
        5.进行扩容的地方
        private Object[] grow(int minCapacity) {
                int oldCapacity = elementData.length;//旧容量：0
                //进行判断：旧容量大于0 或 elementData数组不是空数组则进行if
                if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                    int newCapacity = ArraysSupport.newLength(oldCapacity,
                            minCapacity - oldCapacity, oldCapacity >> 1  );
                    return elementData = Arrays.copyOf(elementData, newCapacity);
            } else {
                //空数组的话进入else：DEFAULT_CAPACITY是10，所有空参构造器会扩容到10
                return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
            }
        }

        public static int newLength(int oldLength, int minGrowth, int prefGrowth) {
        // preconditions not checked because of inlining
        // assert oldLength >= 0
        // assert minGrowth > 0

        //扩容到原来的一半
        int prefLength = oldLength + Math.max(minGrowth, prefGrowth); // might overflow
        if (0 < prefLength && prefLength <= SOFT_MAX_ARRAY_LENGTH) {
            return prefLength;
        } else {
            // put code cold in a separate method
            return hugeLength(oldLength, minGrowth);
        }
    }
         */
    }
}
