package list;

import java.util.*;


@SuppressWarnings({"all"})
public class ListMethod {
    /**
     * vector的底层源码
     * @param args
     */
    public static void main(String[] args) {
        //vector的底层源码查看
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(1001);
        System.out.println(vector);
        /*
        1.无参构造器默认以10开辟空间
        public Vector() {
            this(10);
        }
        2.无参构造器真正走的地方
        public Vector(int initialCapacity, int capacityIncrement) {
            super();
            if (initialCapacity < 0)
                throw new IllegalArgumentException("Illegal Capacity: "+
                                                   initialCapacity);
            this.elementData = new Object[initialCapacity];//申请10个对象的Object空间
            this.capacityIncrement = capacityIncrement;
        }
        3.添加元素的过程
            1)基本数据类型先进行自动装箱
            public static Integer valueOf(int i) {
                if (i >= IntegerCache.low && i <= IntegerCache.high)
                    return IntegerCache.cache[i + (-IntegerCache.low)];
                return new Integer(i);
            }
            2)执行到add方法
            public synchronized boolean add(E e) {
                modCount++;//修改次数
                add(e, elementData, elementCount);
                return true;
            }
            3)添加元素到集合中
            private void add(E e, Object[] elementData, int s) {
                //判断集合是否已经满了
                if (s == elementData.length)
                    elementData = grow();//扩容
                //直接插入到elementData数组的最后
                elementData[s] = e;
                elementCount = s + 1;//数组长度+1
            }
        4.扩容的过程
            1)先进入扩容的方法grow
            private Object[] grow() {
                return grow(elementCount + 1);
            }
            2)真正扩容的地方
            private Object[] grow(int minCapacity) {
                int oldCapacity = elementData.length;//原数组长度
                //按照2倍扩容，注：capacityIncrement是0
                int newCapacity = ArraysSupport.newLength(oldCapacity,
                        minCapacity - oldCapacity,
                capacityIncrement > 0 ? capacityIncrement : oldCapacity);
                //把原来的值拷贝到扩容后的数组里面去
                return elementData = Arrays.copyOf(elementData, newCapacity);
            }
            3)newLength方法的扩容机制
            public static int newLength(int oldLength, int minGrowth, int prefGrowth) {
                // preconditions not checked because of inlining
                // assert oldLength >= 0
                // assert minGrowth > 0

                int prefLength = oldLength + Math.max(minGrowth, prefGrowth); // might overflow
                //prefLength = oldLength + oldLength:即两倍原数组长度
                if (0 < prefLength && prefLength <= SOFT_MAX_ARRAY_LENGTH) {
                    return prefLength;
                } else {
                    // put code cold in a separate method
                    return hugeLength(oldLength, minGrowth);
                }
            }
         */
    }

    /**
     * List的三种遍历方式
     */
    public static void main2(String[] args) {
        List list = new ArrayList();
        list.add("中国");
        list.add("美国");
        list.add("英国");
        list.add("加拿大");

        //第第一种遍历方式：Iterator迭代器
        //获取迭代器
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.print(obj + " ");
        }
        System.out.println();

        //第二种遍历方式：增强for循环
        for(Object obj: list) {
            System.out.print(obj + " ");
        }
        System.out.println();

        //第三种方法：普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    /**
     * List接口的常用方法
     */
    public static void main1(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("marry");
        list.add("jerry");

        //void add(int index, Object ele);在index处插入一个元素
        list.add(1, "maria");
        System.out.println(list);//[jack, maria, marry, jerry]

        //boolean addAll(int index, Collection eles)；在index处的位置将eles的值全部插入
        List list1 = new ArrayList();
        list1.add("张三");
        list1.add("李四");
        list.addAll(2, list1);
        System.out.println(list);//[jack, maria, 张三, 李四, marry, jerry]

        //Object get(index)：获取某个位置的元素
        System.out.println(list.get(1));//maira

        //int indexOf(Object obj):查找元素中obj第一次出现的位置
        System.out.println(list.indexOf("张三"));//2

        //int lastIndexOf(Object obj):查找obj最后一次出现的位置
        System.out.println(list.lastIndexOf("jerry"));//5

        //Object remove(int index)：移除指定位置的元素
        System.out.println(list.remove(1));//maria

        //Object set(int index, Object ele)：设置index处的值为ele，即把index处的值改为ele
        list.set(1, "奥里给");
        System.out.println(list);//[jack, 奥里给, 李四, marry, jerry]

        //List subList(int fromIndex, toIndex)：返回一个从fromIndex到toIndex的集合
        List returnList = list.subList(1, 4);
        System.out.println(returnList);//[奥里给, 李四, marry]
    }
}
