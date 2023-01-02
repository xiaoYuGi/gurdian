package leetcode_contest.weekly_308;

import java.util.*;

public class T4 {

    void find(int[][] cond) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Set<Integer>> next = new HashMap<>();
        for (int[] con : cond) {
            cnt.put(con[1], cnt.getOrDefault(con[1], 0) + 1);
            if (!cnt.containsKey(con[0])) cnt.put(con[0], 0);
            next.computeIfAbsent(con[0], a -> new TreeSet<>()).add(con[1]);
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) if (entry.getValue() == 0) q.offer(entry.getKey());
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            list.add(cur);
            if (!next.containsKey(cur)) continue;
            Set<Integer> set = next.get(cur);
            for (Integer n : set) {
                if (cnt.get(n) == 1) {
                    q.offer(n);
                }
            }
            next.remove(cur);
            cnt.remove(cur);
        }

        System.out.println(list.toString());
    }


    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        find(rowConditions);
        find(colConditions);
        return new int[][]{};
    }

    public static void main(String[] args) {
        int[][] rowC = {{1, 2}, {3, 2}};
        int[][] colC = {{2, 1}, {3, 2}};
        T4 demo = new T4();
        demo.find(rowC);
        demo.find(colC);
    }
}
