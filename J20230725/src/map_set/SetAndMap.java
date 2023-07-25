package map_set;

import java.util.*;

/**
 * Map和Set的基本操作
 */
public class SetAndMap {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("hello");
        //set中不能添加null，会出现空指针异常
        //set.add(null);
        set.add("abc");
        //set.add("abc");//会进行覆盖
        System.out.println(set);

        for (String s : set) {
            System.out.println(s);
        }
    }

    public static void main1(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("this", 2);
        //放入相同的key值会进行覆盖，value会更新
        //map.put("this",2);

        map.put("ky", 1);
        map.put("kr", 1);
        map.put("kt", 1);
        //getOrDefault：对应的key不在，则使用默认值default
        int val = map.getOrDefault("ph", 1999);
        System.out.println(val);

        //获取map中所有的key值 --> Set接收
        Set<String> set = map.keySet();
        System.out.println(set);

        //获取map中所有的value值 --> 使用Collection接收
        Collection<Integer> collection = map.values();
        System.out.println(collection);
        System.out.println(map);

        //获取map中的entry键值对 --> 使用Set<Map.Entry<K,V>>接收
        Set<Map.Entry<String, Integer>> set2 = map.entrySet();
        System.out.println(set2);

        //遍历获取entrySet中的key中和value中
        for (Map.Entry<String, Integer> entry : set2) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}