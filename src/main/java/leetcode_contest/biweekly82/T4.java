package leetcode_contest.biweekly82;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class T4 {
    static final int N = 100010;

    static int[] f = new int[N];

    static int[] sz = new int[N];

    static int[] avg = new int[N];

    int find(int x) {
        if (f[x] != x) {
            x = find(f[x]);
        }
        return f[x];
    }

    void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx == fy) return;
        int min = Math.min(fx, fy);
        int max = Math.max(fx, fy);
        f[max] = f[min];
        sz[min] += sz[max];
    }

    class Node {
        int idx, val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            f[i] = i;
            sz[i] = 1;
            if (nums[i] > threshold) return 1;
        }

        List<Node> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) list.add(new Node(i, nums[i]));
        list.sort((a, b) -> {
            if (a.val != b.val) return Integer.compare(b.val, a.val);
            else return Integer.compare(a.idx, b.idx);
        });

        for (int i = 0; i < n; i++) {


        }
        return 0;
    }
}
