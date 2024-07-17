package Collections;

import java.util.Map;

public class MyCollections {
    public static void myHashMapOperations() {
        /* Hash Map */
        System.out.println("HashMap operations");
        System.out.println("PUT");
        MyHashMap.putMyHashMap(1, "a");
        MyHashMap.putMyHashMap(2, "b");
        System.out.println("PRINT");
        MyHashMap.printMyHashMap();
        System.out.println("REMOVE");
        MyHashMap.removeMyHashMap(1);
        System.out.println("PRINT");
        MyHashMap.printMyHashMap();
        System.out.println("\n");
    }

    public static void main(String[] args) {
        myHashMapOperations();
    }
}
