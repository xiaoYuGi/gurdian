package leetcode_contest.weekly_304;

import java.util.*;

public class T3 {

    class Node {
        int val;
        int dis1;
        int dis2;

        public Node(int val, int dis1, int dis2) {
            this.val = val;
            this.dis1 = dis1;
            this.dis2 = dis2;
        }
    }

    static final int INF = 10010;

    public int closestMeetingNode(int[] edges, int v1, int v2) {
        Map<Integer, Node> map = new HashMap<>();
        int n = edges.length;
        for (int i = 0; i < n; i++) map.put(i, new Node(i, INF, INF));

        Node node1 = map.get(v1);
        Queue<Node> q = new LinkedList<>();
        q.offer(node1);
        int dis = -1;
        Set<Integer> vis = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            ++dis;
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                vis.add(cur.val);
                cur.dis1 = dis;
                int next = edges[cur.val];
                if (next != -1 && !vis.contains(next)) {
                    q.offer(map.get(edges[cur.val]));
                }
            }
        }

        q.offer(map.get(v2));
        dis = -1;
        vis.clear();
        List<Node> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            ++dis;
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                vis.add(node.val);
                node.dis2 = dis;
                if (node.dis1 != INF) {
                    list.add(node);
                }
                if (!vis.contains(edges[node.val]) && edges[node.val] != -1) q.offer(map.get(edges[node.val]));
            }
        }
        if (!list.isEmpty()) {
            list.sort((a, b) -> {
                int disA = Math.max(a.dis1, a.dis2);
                int disB = Math.max(b.dis1, b.dis2);
                if (disA != disB) {
                    return Integer.compare(disA, disB);
                } else {
                    return Integer.compare(a.val, b.val);
                }
            });
            return list.get(0).val;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 0, 2, 4, 5};

        int v1 = 3;
        int v2 = 2;
        T3 demo = new T3();
        System.out.println(demo.closestMeetingNode(arr, v1, v2));
    }
}
