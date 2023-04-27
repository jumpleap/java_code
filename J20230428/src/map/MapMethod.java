package map;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"all"})
/**
 * Map接口的常用方法
 */
public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap();
        //添加元素:put:一个键值对 k - v
        map.put("jack","mary");
        map.put(1,new Object());
        map.put("zhangsan","李四");
        map.put("jerry","hony");
        map.put("玉女心经","黄帝内经");
        map.put("心法","内经");
        map.put("玉经","黄经");
        map.put("jack","maria");//替换
        System.out.println(map);

        //删除元素：remove：可根据key来删除，也可以根据key-value删除
        map.remove("jack");
        System.out.println(map.remove("jerry", "hony"));//true

        //isEmpty():判断map集合是否为null
        System.out.println(map.isEmpty());//fasle

        //get(key)：根据键获取值
        System.out.println(map.get("zhangsan"));//李四
        System.out.println(map.get("玉女心经"));//黄帝内经

        //size()：获取元素个数
        System.out.println(map.size());//5

        //containsKey():查找键是否存在
        System.out.println(map.containsKey("mary"));//false
        System.out.println(map.containsKey("心法"));//true

        //clear：清空集合中的所有内容
        map.clear();
    }
}
