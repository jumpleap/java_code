package set;

import java.util.HashSet;

@SuppressWarnings({"all"})
/**
 * HashSet源码解读
 */
public class HashSetExplain {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("jack");
        //解释源码中对这句话的分析
        /*
            1.HashSet的底层是HashMap
            public HashSet() {
                map = new HashMap<>();
            }
            2.进入add方法
            public boolean add(E e) {
                return map.put(e, PRESENT)==null;
            }
            private static final Object PRESENT = new Object();//被类中所有的成员共享

            3.把传进行的e对象的哈希码值进行无符号右移16位：防止哈希值碰撞
            static final int hash(Object key) {
                int h;
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
                //获取无符号右移16位的哈希值，并把结果返回
            }
            4.添加元素到table中
            final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i;//辅助变量
                //判断table表是不是null或长度是否为0，无参构造器的话：table表是null值，需要扩容
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length;//tab= newTab；即tab指向newTab的空间，n =16
                //判断当前的i的值是否在tab中是null，i = (n - 1) & hash]：得到和ey哈希值按位与的值
                if ((p = tab[i = (n - 1) & hash]) == null)
                    //是null就插入到当前tab[i]的位置，value只是一个占位符，PRESENT
                    tab[i] = newNode(hash, key, value, null);
                else {
                    //不为null则走到这步
                    Node<K,V> e; K k;
                    //判断key的哈希值和table中的哈希值是否相等 且 key不为null且两者的内容相同
                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;//e指向p
                    //判断它是不是一颗红黑树
                    else if (p instanceof TreeNode)
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    else {
                        for (int binCount = 0; ; ++binCount) {
                            if ((e = p.next) == null) {
                                p.next = newNode(hash, key, value, null);
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    treeifyBin(tab, hash);
                                break;
                            }
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;//两者的内容相同
                        //onlyIfAbsent默认为false
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value;//两者的PRESENT相同
                        afterNodeAccess(e);
                        return oldValue;//返回原来的值
                    }
                }
                ++modCount;
                //判断是否到达临界值：到达了临界值需要扩容
                if (++size > threshold)
                    resize();
                afterNodeInsertion(evict);
                return null;//返回空则添加成功
            }

        5.n = (tab = resize()).length;解读
        final Node<K,V>[] resize() {
            Node<K,V>[] oldTab = table;//null
            //无参构造器进来这里是0
            int oldCap = (oldTab == null) ? 0 : oldTab.length;
            int oldThr = threshold;//临界值：0
            int newCap, newThr = 0;
            if (oldCap > 0) {
                if (oldCap >= MAXIMUM_CAPACITY) {
                    threshold = Integer.MAX_VALUE;
                    return oldTab;
                }
                else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                         oldCap >= DEFAULT_INITIAL_CAPACITY)
                    newThr = oldThr << 1; // double threshold
            }
            else if (oldThr > 0) // initial capacity was placed in threshold
                newCap = oldThr;
            //无参构造器走的是这个
            else {               // zero initial threshold signifies using defaults
                newCap = DEFAULT_INITIAL_CAPACITY;//16,默认是16的容量
                newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);//12
            }
            if (newThr == 0) {
                float ft = (float)newCap * loadFactor;
                newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                          (int)ft : Integer.MAX_VALUE);
            }
            threshold = newThr;//更换临界值
            @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];//newTab申请16个Node的空间
            table = newTab;//table指向newTab的空间
            if (oldTab != null) {
                for (int j = 0; j < oldCap; ++j) {
                    Node<K,V> e;
                    if ((e = oldTab[j]) != null) {
                        oldTab[j] = null;
                        if (e.next == null)
                            newTab[e.hash & (newCap - 1)] = e;
                        else if (e instanceof TreeNode)
                            ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                        else { // preserve order
                            Node<K,V> loHead = null, loTail = null;
                            Node<K,V> hiHead = null, hiTail = null;
                            Node<K,V> next;
                            do {
                                next = e.next;
                                if ((e.hash & oldCap) == 0) {
                                    if (loTail == null)
                                        loHead = e;
                                    else
                                        loTail.next = e;
                                    loTail = e;
                                }
                                else {
                                    if (hiTail == null)
                                        hiHead = e;
                                    else
                                        hiTail.next = e;
                                    hiTail = e;
                                }
                            } while ((e = next) != null);
                            if (loTail != null) {
                                loTail.next = null;
                                newTab[j] = loHead;
                            }
                            if (hiTail != null) {
                                hiTail.next = null;
                                newTab[j + oldCap] = hiHead;
                            }
                        }
                    }
                }
            }
            return newTab;
        }

         */

        hashSet.add("maria");
        hashSet.add("jack");
        System.out.println(hashSet);
    }
}
