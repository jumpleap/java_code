package datastrcture;

import java.util.*;

/**
 * Set的基本使用
 */
public class Demo4 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        //add()添加元素
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        //重复元素不会添加成功
        set.add(4);
        set.add(5);
        set.add(6);

        System.out.println(set);

        //contains方法
        System.out.println(set.contains(2));

        //size()
        System.out.println(set.size());

        //toArray方法
        Object[] array = set.toArray();
        System.out.println(Arrays.toString(array));

        //Iterator方法
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            int num = iterator.next();
            System.out.print(num + " ");
        }
        System.out.println();

        //containsAll()方法
        Collection<Integer> collection = new HashSet<>();
        collection.add(1);
        collection.add(2);
        System.out.println(set.containsAll(collection));

        //clear方法
        set.clear();

        //empty方法
        System.out.println(set.isEmpty());
    }
}
