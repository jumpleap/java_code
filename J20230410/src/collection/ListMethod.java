package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings({"all"})
public class ListMethod {
    /**
     * List的练习
     * @param args
     */
    public static void main(String[] args) {
        //练习：添加10个以上的元素，在2号位插入一个元素”封果大帅逼“，获取第五个元素，
        //删除第六个元素，修改第七个元素，使用迭代器完成
        List list = new ArrayList();

        for (int i = 0; i < 12; i++) {
            list.add("hello" + i);
        }
        //2号位插入元素
        list.add(1,"kava");
        //获取第五个元素
        System.out.println(list.get(4));
        //删除第六个元素
        list.remove(5);
        //修改第七个元素
        list.set(6,"加油，奥里给");

        //迭代器迭代
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.print(obj + " ");
        }
    }

    /**
     * List的常用方法
     * @param args
     */
    public static void main2(String[] args) {
        //add：在集合的后面添加一个元素
        List list = new ArrayList();
        list.add("林黛玉");
        list.add("林沐雨");
        System.out.println(list);//[林黛玉, 林沐雨]

        //add(int index, Object ele);在index的位置插入一个元素
        list.add(1,"过去");
        System.out.println(list);//[林黛玉, 过去, 林沐雨]

        //addAll()：添加所有元素
        List list1 = new ArrayList();
        list1.addAll(list);
        System.out.println(list1);//[林黛玉, 过去, 林沐雨]

        //addAll(int index, Collection eles):添加从index开始的所有元素
        List list2 = new ArrayList();
        list2.add(1);
        list2.add(2);
        //注：不能在空参的清空下直接添加元素
        list2.addAll(1,list1);
        System.out.println(list2);//[1, 林黛玉, 过去, 林沐雨, 2]

        //get(int index):获取index处的元素
        System.out.println(list.get(1));//过去

        //int indexOf(Object obj): 返回obj在集合中首次出现的位置下标
        list.add("林沐雨");
        System.out.println(list.indexOf("林沐雨"));//2

        //int lastIndexOf(Object obj)：返回obj元素在集合中最后一次出现的下标
        System.out.println(list.lastIndexOf("林黛玉"));//0

        //remove(int index): 移除index位置的元素
        list2.remove("林黛玉");
        System.out.println(list2);//[1, 过去, 林沐雨, 2]

        //Object set(int index, Object ele)：设置指定index位置处的元素，把该元素改为ele
        list2.set(1,"过往");
        System.out.println(list2);//[1, 过往, 林沐雨, 2]

        //List subList(int fromIndex, int toIndex): 返回从fromIndex到toIndex位置的子集合[fromIndex, toIndex);
        System.out.println(list2.subList(1, 3));//[过往, 林沐雨]
    }


    /**
     * List接口的基本介绍
     * @param args
     */
    public static void main1(String[] args) {
        //List集合类中元素是有序的【添加顺序和取出顺序是一致的】且可重复的
        List list = new ArrayList();
        list.add(new Book("三国",100));
        list.add(new Book("三体",200));
        list.add(new Book("流浪地球",1000));
        System.out.println(list);

        //List集合中的每个元素都有对应的顺序索引，即支持索引查找【索引从0开始】
        System.out.println(list.get(2));

    }
}

class Book {
    //成员变量
    private String name;
    private double price;

    //构造器
    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //getter和setter方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    //重写toString方法
    public String toString() {
        return "书名：" + this.name + " 价格：" + this.price;
    }
}