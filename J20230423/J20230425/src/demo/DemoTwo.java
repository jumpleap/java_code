package demo;

import java.util.Iterator;
import java.util.LinkedList;
@SuppressWarnings({"all"})

public class DemoTwo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("linkedList=" + linkedList);

        //一个删除结点的
        linkedList.remove(); // 这里默认删除的是第一个结点
        //linkedList.remove(2);
        System.out.println("linkedList=" + linkedList);

        //修改某个结点对象
        linkedList.set(1, 999);
        System.out.println("linkedList=" + linkedList);

        //得到某个结点对象
        //get(1) 是得到双向链表的第二个对象
        Object o = linkedList.get(1);
        System.out.println(o);//999

        //遍历
        System.out.println("===LinkedList 遍历迭代器====");
        //获取迭代器
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println("next=" + next);
        }

        System.out.println("===LinkedList 遍历增强 for====");
        for (Object o1 : linkedList) {
            System.out.println("o1=" + o1);
        }

        System.out.println("===LinkedList 遍历普通 for====");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        /*
        LinkedList底层源码
        1.添加在最后一个元素
        public boolean add(E e) {
            linkLast(e);
            return true;
        }
        2.完成添加的工作
        void linkLast(E e) {
            final Node<E> l = last;
            final Node<E> newNode = new Node<>(l, e, null);
            last = newNode;
            if (l == null)
                first = newNode;
            else
                l.next = newNode;
            size++;
            modCount++;
        }

        3.final Node<E> newNode = new Node<>(l, e, null);的底层源码
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
         */
    }
}
