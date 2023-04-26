package list;

import java.util.Iterator;
import java.util.LinkedList;
@SuppressWarnings("all")

public class LinkedListDemo {
    /**
     * LinkedList 底层源码
     * @param args
     */
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        /*
        1.无参构造器
        public LinkedList() {}

        2.若是普通数据类型则进行自动装箱
        public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }

        3.进行添加的方法
        public boolean add(E e) {
            linkLast(e);
            return true;
        }

        4.执行添加的真正方法
        void linkLast(E e) {
            final Node<E> l = last;//把指向最后的值赋给l
            //申请一个新的结点
            final Node<E> newNode = new Node<>(l, e, null);
            //last指向新结点
            last = newNode;
            //如果原来的LinkeList是null的话，这个则置为first结点
            if (l == null)
                first = newNode;
            else
                l.next = newNode;
            size++;
            modCount++;
        }
         */
    }

    /**
     * LinkedList的增删查改
     * @param args
     */
    public static void main2(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("jack");
        linkedList.add("marry");
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList);

        //删除
        linkedList.remove();//默认删除第一个结点
        linkedList.remove(1);//删除下标为1的值
        System.out.println(linkedList);

        //修改
        linkedList.set(1,"9999");
        System.out.println(linkedList);

        //获取某个下标的值
        System.out.println(linkedList.get(1));

        //三种遍历方式
        //1.Iterator
        Iterator iterator = linkedList.iterator();
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.print(obj + " ");
        }
        System.out.println();

        //2.for each
        for (Object o :linkedList) {
            System.out.print(o + " ");
        }
        System.out.println();

        //3.for循环
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
    }

    /**
     * 双向链表模拟
     */
    public static void main1(String[] args) {
        Node jerry = new Node("Jerry");
        Node blue = new Node("blue");
        Node jack = new Node("jack");

        //双向链表连接
        jerry.next = blue;
        blue.next = jack;
        jack.pre = blue;
        blue.pre = jerry;

        //指向头节点和尾结点
        Node head = jerry;
        Node tail = jack;

        //遍历：首尾遍历
        while(head != null) {
            System.out.println(head);
            head = head.next;
        }
        System.out.println();

        //遍历：尾首遍历
        while(tail != null) {
            System.out.println(tail);
            tail = tail.pre;
        }

        //添加元素
        Node tom = new Node("tom");
        tom.next = blue;
        jerry.next = tom;
        blue.pre = tom;
        tom.pre = jerry;

        head = jerry;
        //遍历：首尾遍历
        while(head != null) {
            System.out.println(head);
            head = head.next;
        }
        System.out.println();
    }
}

class Node {
    Object item;//内容
    Node pre;//前驱
    Node next;//后继

    public Node(Object item) {
        this.item = item;
    }

    public String toString() {
        return item + "";
    }
}
