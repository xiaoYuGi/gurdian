package leetcode_contest.weekly_304;

import java.util.*;

public class T4 {
    int ans;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Set<Integer>> nextS = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cnt.put(edges[i], cnt.getOrDefault(edges[i], 0) + 1);
            nextS.computeIfAbsent(i, a -> new TreeSet<>()).add(edges[i]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = -1; i < n; i++) if (!cnt.containsKey(i)) q.offer(i);
        while (!q.isEmpty()) {
            int src = q.poll();
            if (!nextS.containsKey(src)) continue;
            Set<Integer> set = nextS.get(src);
            for (Integer next : set) {
                Integer count = cnt.get(next);
                --count;
                if (count == 0) {
                    q.offer(next);
                    cnt.remove(next);
                } else {
                    cnt.put(next, count);
                }
            }
            nextS.remove(src);
        }
        Set<Integer> vis = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : nextS.entrySet()) {
            int src = entry.getKey();
            if (!vis.contains(src)) dfs(vis, nextS, src, 0);
        }
        return ans == 0 ? -1 : ans;
    }


    void dfs(Set<Integer> vis, Map<Integer, Set<Integer>> map, int i, int res) {
        if (!vis.contains(i)) {
            vis.add(i);
            for (Integer next : map.get(i)) {
                dfs(vis, map, next, res + 1);
            }
        } else {
            ans = Math.max(res, ans);
        }
    }

    public static void main(String[] args) {
//        int[] arr = {3, 3, 4, 2, 3};
//        int[] arr = {2, -1, 3, 1};
//        int[] arr = {-1, 2, -1, 5, 3, 3};
        int[] arr = {-1, 4, -1, 2, 0, 4};
        T4 demo = new T4();
        System.out.println(demo.longestCycle(arr));
    }
}
