package set;

import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings({"all"})
/**
 * LinkedHashSet的底层源码分析
 */
public class LinkedHashSetUse {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
//        set.add(456);
//        set.add(123);
//        set.add(456);
//        set.add(234);
        for (int i = 0; i < 15; i++) {
            set.add(i);
        }
        set.add(12);

        /*
        源码刨析：
            1.默认扩容至16的集合大小，加载因子是0.75，dummy是true,走的是LinkedHashMap的构造器
            HashSet(int initialCapacity, float loadFactor, boolean dummy) {
                map = new LinkedHashMap<>(initialCapacity, loadFactor);
            }
            2.查看LinkedHashMap的构造器：走的是父类的构造器
            public LinkedHashMap(int initialCapacity, float loadFactor) {
                super(initialCapacity, loadFactor);
                accessOrder = false;
            }
            3.走的是HashMap底层构造器
            public HashMap(int initialCapacity, float loadFactor) {
                //初始值小于0，则抛出异常
                if (initialCapacity < 0)
                    throw new IllegalArgumentException("Illegal initial capacity: " +
                                                       initialCapacity);
                if (initialCapacity > MAXIMUM_CAPACITY)
                    initialCapacity = MAXIMUM_CAPACITY;
                if (loadFactor <= 0 || Float.isNaN(loadFactor))
                    throw new IllegalArgumentException("Illegal load factor: " +
                                                       loadFactor);
                this.loadFactor = loadFactor;
                //临界因子：16
                this.threshold = tableSizeFor(initialCapacity);
            }
            4.添加元素：先走自动装箱
            public static Integer valueOf(int i) {
                if (i >= IntegerCache.low && i <= IntegerCache.high)
                    return IntegerCache.cache[i + (-IntegerCache.low)];
                return new Integer(i);
            }
            5.进入添加的方法
            public boolean add(E e) {
                return map.put(e, PRESENT)==null;
            }
            6.进行hash的计算
            static final int hash(Object key) {
                int h;
                //得到key的哈希值后，它先无符号右移16位，在使用两者的哈希值进行异或
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            }
            6.即将进入真正添加元素的位置
            public V put(K key, V value) {
                return putVal(hash(key), key, value, false, true);
            }
            7.第一次添加元素
            final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
                //辅助变量
                Node<K,V>[] tab; Node<K,V> p; int n, i;
                //判断当前的table是不是null或当前的table的长度是不是为0
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length;
                //添加到哈希值异或后的table的对应下标处
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
                //修改次数
                ++modCount;
                //判断当前的集合长度是否大于临界因子，大于则需要扩容
                if (++size > threshold)
                    resize();
                afterNodeInsertion(evict);
                return null;
            }

         */
    }
}
