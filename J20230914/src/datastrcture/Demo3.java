package datastrcture;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map的基本使用
 */
public class Demo3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //put方法
        map.put("111", 3);
        map.put("222", 2);
        map.put("333", 5);
        map.put("133", 7);
        map.put("4543", 8);

        System.out.println(map);

        /*
        map中的方法使用
         */
        //get(Object key)方法
        System.out.println(map.get("111"));
        System.out.println(map.get("222"));

        //getOrDefault(Object key, V defaultValue)方法
        System.out.println(map.getOrDefault("789", 1000));

        //remove方法
        map.remove("111");
        System.out.println(map);

        //keySet(): 把所有的key值放入到Set中去
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();

        //values(): 把所有的values值放入到Collection中去
        Collection<Integer> collection = map.values();
        for (int num : collection) {
            System.out.print(num + " ");
        }

        //containsKey(): 是否包含key值
        System.out.println(map.containsKey("222"));

        //containsValue(): 是否包含value值
        System.out.println(map.containsValue(5));


        //最重要的: Map.Entry<K, V> entrySet方法
        Set<Map.Entry<String, Integer>> s = map.entrySet();
        for (Map.Entry<String, Integer> num : s) {
            System.out.println(num.getKey() + " = " + num.getValue());
        }
    }
}