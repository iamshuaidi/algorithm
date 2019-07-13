package interview;

import jdk.internal.org.objectweb.asm.tree.InsnList;

import java.util.*;

public class 几种重要的类 {

    public static void main(String[] args) {
        // 队列
        Queue<Integer> queue = new LinkedList<>();
        System.out.println(queue.offer(null));
        queue.isEmpty();
        //stack
        Stack<Integer> stack = new Stack<>();
        stack.empty();
        // LinkedList
        LinkedList<Integer> list = new LinkedList<>();
        // HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.containsKey(1);
        map.containsValue(1);
        map.get(1);
        map.keySet();
        map.size();
        map.isEmpty();
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        iterator.hasNext();
        iterator.next();

        String s = "jjj";
    }
}
