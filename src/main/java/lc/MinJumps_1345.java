package lc;

import java.util.*;

public class MinJumps_1345 {

    static final int INF = (int) (5e4 + 10);

    public int minJumps(int[] arr) {
        int n = arr.length;
        int[] dis = new int[n];
        boolean[] mark = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], a -> new ArrayList<>()).add(i);
            dis[i] = INF;
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        dis[0] = 0;
        mark[0] = true;
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == n - 1) {
                    return res;
                }
                if (cur - 1 >= 0) {
                    if (dis[cur - 1] > dis[cur] + 1) {
                        dis[cur - 1] = dis[cur] + 1;
                        if (!mark[cur - 1]) {
                            q.offer(cur - 1);
                            mark[cur - 1] = true;
                        }
                    }
                }

                if (cur + 1 <= n) {
                    if (dis[cur + 1] > dis[cur] + 1) {
                        dis[cur + 1] = dis[cur] + 1;
                        if (!mark[cur + 1]) {
                            q.offer(cur + 1);
                            mark[cur + 1] = true;
                        }
                    }
                }

                if(map.containsKey(arr[cur])){
                    List<Integer> list = map.get(arr[cur]);
                    for (Integer idx : list) {
                        if (idx == cur) {
                            continue;
                        }
                        if (dis[idx] > dis[cur] + 1) {
                            dis[idx] = dis[cur] + 1;
                            if (!mark[idx]) {
                                q.offer(idx);
                                mark[idx] = true;
                            }
                        }
                    }
                }
                map.remove(arr[cur]);
            }
            ++res;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        MinJumps_1345 demo = new MinJumps_1345();
        System.out.println(demo.minJumps(arr));
    }
}
