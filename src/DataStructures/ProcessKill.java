package DataStructures;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ProcessKill {
    private HashMap<Integer, List<Integer>> processMap;

    ProcessKill(HashMap<Integer, List<Integer>> processMap) {
        this.processMap = processMap;
    }

    public HashMap<Integer, List<Integer>> getProcessMap() {
        return this.processMap;
    }

    public static HashMap<Integer, List<Integer>> processMap(int pid[], int ppid[]) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < pid.length; i++) {
            if(map.containsKey(ppid[i])) {
                map.get(ppid[i]).add(pid[i]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(pid[i]);
                map.put(ppid[i], list);
            }
        }

        return map;
    }

    public static List<Integer> killProcessList(int kill, HashMap<Integer, List<Integer>> processMap) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(kill);
        while(!stack.empty()) {
            Integer process = stack.pop();
            list.add(process);
            if(processMap.containsKey(process)) {
                stack.addAll(processMap.get(process));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int pid[] = {1, 2, 3, 4, 5};
        int ppid[] = {2, 3, 4, 0, 4};
        int kill = 4;

        HashMap<Integer, List<Integer>> map = processMap(pid, ppid);
        ProcessKill processKill = new ProcessKill(map);

        List<Integer> list = killProcessList(kill, processKill.getProcessMap());
        System.out.println(list);
    }
}
