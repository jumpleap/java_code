package map;

import java.util.*;

@SuppressWarnings({"all"})
/**
 * Map的遍历方式
 */
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("王宝强", "马蓉");
        map.put("刘令博", null);
        map.put("邓超", "孙俪");
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");
        map.put("宋喆", "马蓉");

        //1. 取出所有的Key，通过Key取出对应的value
        //i.Iterator遍历器
        Set keyset = map.keySet();
        Iterator iterator = keyset.iterator();

        //通过对应的keyset进行value的遍历
        while (iterator.hasNext()) {
            Object key = iterator.next();
            //通过key取出value
            System.out.println(key + "=" + map.get(key));
        }

        System.out.println("============================");

        //ii.增强for循环
        for (Object key : keyset) {
            System.out.println(key + "=" + map.get(key));
        }

        //2.把所有的values取出:这种方法只能得到所有的values，得不到keyset
        Collection values = map.values();
        //i.迭代器遍历
        Iterator iterator1 = values.iterator();
        while(iterator1.hasNext()) {
            Object obj = iterator1.next();
            System.out.println(obj);
        }
        System.out.println("===========================");

        //ii.增强for循环
        for (Object o :values) {
            System.out.println(o);
        }

        //3.使用EntrySet来获取
        Set entrySet = map.entrySet();
        //i.增强for循环
        for (Object entry :entrySet) {
            Map.Entry m = (Map.Entry)entry;
            System.out.println(m.getKey() + "=" + m.getValue());
        }

        //ii.迭代器
        Iterator iterator2 = entrySet.iterator();
        while(iterator2.hasNext()) {
            Object entry = iterator2.next();
            Map.Entry m = (Map.Entry)entry;
            System.out.println(m.getKey() + "=" + m.getValue());
        }
    }
}