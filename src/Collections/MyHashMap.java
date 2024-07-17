package Collections;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {
    private static Map<Integer, String> map = new HashMap<Integer, String>();

    private MyHashMap() {}

    public static Map<Integer, String> getMyHashMap() {
        return map;
    }

    public static void putMyHashMap(Integer key, String value) {
        map.put(key, value);
        return;
    }

    public static void removeMyHashMap(Integer key) {
        map.remove(key);
        return;
    }

    public static void printMyHashMap() {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        return;
    }
}
