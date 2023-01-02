package lc;

import java.util.*;

public class FindMinHeightTrees_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] e) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            int[] cur = e[i];
            cnt.put(cur[0], cnt.getOrDefault(cur[0],0) + 1);
            cnt.put(cur[1], cnt.getOrDefault(cur[1],0) + 1);
        }

        Queue<Integer> q = new LinkedList<>();
        Integer cur = q.poll();
        return new ArrayList<>();
    }
}
