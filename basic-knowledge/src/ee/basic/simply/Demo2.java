package ee.basic.simply;

import java.util.HashMap;

public class Demo2 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put(null, "1");
        System.out.println(map);
    }
}
