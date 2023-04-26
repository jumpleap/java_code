package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings({"all"})
public class SetMethod {
    /**
     * 模拟数组 + 链表结构
     * @param args
     */
    public static void main(String[] args) {
        Node[] table = new Node[16];//表
        Node jack = new Node("jack");
        table[2] = jack;
        Node maria = new Node("maria");
        jack.next = maria;
        Node jerry = new Node("jerry");
        maria.next = jerry;

        Node heny = new Node("heny");
        table[5] = heny;

    }

    /**
     * LinkedList的应用
     * @param args
     */
    public static void main2(String[] args) {
        //1.HashSet底层是HashMap
        HashSet hashSet = new HashSet();
        /*
        //底层是HashMap
        public HashSet() {
            map = new HashMap<>();
        }
        */

        //2.可以存放null值，但是存放的元素不可重复且是无序的
        hashSet.add(null);
        hashSet.add("jack");
        hashSet.add("mary");
        hashSet.add("jack");
        hashSet.add(null);
        System.out.println(hashSet);//[null, mary, jack]

        //思考以下代码输出什么？
        HashSet set = new HashSet();
        System.out.println(set.add("jack"));//true
        System.out.println(set.add("jack"));//false
        System.out.println(set.add("amry"));//true
        System.out.println(set.add("mack"));//true
        System.out.println(set.add(null));//true
        System.out.println(set.add(null));//fasle
        System.out.println(set);


        HashSet hashSet1 = new HashSet();
        System.out.println(hashSet1.add(new People("jack")));//true
        System.out.println(hashSet1.add(new People("jack")));//true
        System.out.println(hashSet1.add(new People("mary")));//true
        System.out.println(hashSet1);

        System.out.println(hashSet1.add(new String("maria")));//ture
        System.out.println(hashSet1.add(new String("maria")));//false
        System.out.println(hashSet1);
    }

    /**
     * set常用的方法
     * @param args
     */
    public static void main1(String[] args) {
        //set的特点：无序，无索引，不能有重复元素
        Set set = new HashSet();
        //add方法
        set.add("jack");
        set.add("marry");
        set.add("jerry");
        set.add("tom");
        set.add(null);
        set.add(null);
        System.out.println(set);//[null, tom, marry, jerry, jack]

        //删除元素
        set.remove(null);
        //判断某个元素是否在集合中
        System.out.println(set.contains("jack"));
        //判断集合是否为空
        System.out.println(set.isEmpty());
        //长度
        System.out.println(set.size());

        //set的两种遍历方式
        //1.Iterator迭代器
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.print(obj + " ");
        }
        System.out.println();

        //2.for each循环
        for (Object o : set) {
            System.out.print(o + " ");
        }

        set.clear();//清空集合
    }
}


class People {
    public String name;

    public People(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Node {
    public Object item;
    public Node next;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item + "";
    }
}