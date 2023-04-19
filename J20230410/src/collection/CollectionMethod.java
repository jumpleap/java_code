package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings({"all"})
public class CollectionMethod {
    /**
     * 遍历集合的两种方式
     * @param args
     */
    public static void main(String[] args) {
        //遍历方式1：Iterator迭代器 -> 只能用于集合的遍历
        Collection collection = new ArrayList();

        //添加元素
        collection.add("报价");
        collection.add("未来");
        collection.add("战狼");
        collection.add("maybe");

        //获取迭代器
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()) { //判断是否还有数据
            Object obj = iterator.next();//获取当前数据
            System.out.println(obj);//输出
        }

        //当退出while循环后，iterator迭代器指向最后的元素
        //iterator.next();//抛出异常：NoSuchElementException

        //若是想要使用Iterator二次遍历，需要重置迭代器
        iterator = collection.iterator();//重置迭代器

        //第二次进行遍历
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }

        //遍历方式2：for each循环
        for (Object obj: collection) {
            System.out.println(obj);
        }
    }


    /**
     * 了解并熟悉Collection接口中的常用方法
     * @param args
     */
    public static void main1(String[] args) {
        //add：添加单个元素 --> 可以添加任意类型的数据
        List list = new ArrayList();
        list.add("jack");
        list.add(10);//等价于：list.add(new Integer (10))，即进行自动装箱
        list.add(true);
        System.out.println(list);

        //remove()：删除指定元素
        list.remove(1);
        System.out.println(list);

        //contains：查找某个元素是否存在，返回值为boolean
        System.out.println(list.contains(true));

        //size：获取元素个数
        System.out.println(list.size());//2

        //isEmpty()：判断这个集合是否为空,返回值是boolean
        System.out.println(list.isEmpty());//fasle

        //clear：清空整个集合
        list.clear();

        List list2 = new ArrayList();
        list2.add("国家");
        list2.add("未来");
        list2.add("可期");
        list2.add("做好自己");

        //addAll：添加多个元素
        list.addAll(list2);
        System.out.println(list);

        //containsAll：查找多个元素是否都存在,返回值是boolean
        System.out.println(list.containsAll(list2));//true

        //removeAll：移除多个元素
        List list3 = new ArrayList();
        list3.add("国家");
        list3.add("未来");
        list.removeAll(list3);
        System.out.println(list);
    }
}