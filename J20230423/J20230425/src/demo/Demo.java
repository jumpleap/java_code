package demo;

import java.util.Arrays;
import java.util.Vector;
@SuppressWarnings({"all"})

public class Demo {
    public static void main(String[] args) {
        //调试Vector的底层代码
        //空参构造器的扩容机制
        Vector vector = new Vector(8);

        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        //查看扩容机制
        vector.add(100);

        /*
        //底层源码的分析：
        1.无参构造器的默认空间大小是10
        public Vector() {
            this(10);
        }
        2.相当于也是走了有参构造器：默认大小是10
        public Vector(int initialCapacity) {
            this(initialCapacity, 0);
        }
        3.elementData是一个空数组
        protected Object[] elementData;
        4.Object[] elementData进行扩容
        public Vector(int initialCapacity, int capacityIncrement) {
            super();
            if (initialCapacity < 0)
                throw new IllegalArgumentException("Illegal Capacity: "+
                                                   initialCapacity);
            this.elementData = new Object[initialCapacity];
            this.capacityIncrement = capacityIncrement;
        }
        5.添加元素的先进性自动装箱
        public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }
        6.进行添加元素
        public synchronized boolean add(E e) {
            modCount++;
            //实现添加元素的真正方法
            add(e, elementData, elementCount);
            return true;
        }
        7.添加元素
        private void add(E e, Object[] elementData, int s) {
            //判断空间是否已满
            if (s == elementData.length)
                elementData = grow();//扩容
            //把当前的下标赋值
            elementData[s] = e;
            //集合有效长度加1
            elementCount = s + 1;
        }
        8.扩容机制：按两倍扩容
            private Object[] grow(int minCapacity) {
            int oldCapacity = elementData.length;
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity,
            capacityIncrement > 0 ? capacityIncrement : oldCapacity
            ;
            return elementData = Arrays.copyOf(elementData, newCapacity);
        }
        //元素倍数的扩容
        int prefLength = oldLength + Math.max(minGrowth, prefGrowth); // might overflow
         */
    }
}
