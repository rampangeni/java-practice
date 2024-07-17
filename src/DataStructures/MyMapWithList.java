package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyMapWithList {
    public static void main(String[] args) {
        Integer  pid[] = {1,2,3,4,5,6,7};
        Integer ppid[] = {2,1,2,0,0,0,3};
        Integer toKill = 2;

        Map<Integer, List<Integer>> myMap = new HashMap<>();
        for(int i=0; i<pid.length; i++) {
            Integer childPid = pid[i];
            Integer parentPid = ppid[i];
            List<Integer> childList = myMap.getOrDefault(parentPid, new ArrayList<>());
            childList.add(childPid);
            myMap.put(parentPid, childList);
        }

        myMap.forEach((k,v) -> System.out.println("KEY:" + k + " -> VALUE:" + v));
    }
}