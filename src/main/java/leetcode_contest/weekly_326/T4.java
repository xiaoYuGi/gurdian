package leetcode_contest.weekly_326;

import java.util.Arrays;

public class T4 {

    static int INF = 1000001;
    static boolean[] f = new boolean[INF];

    static {
        int count = 0;
        int[] prime = new int[INF];
        for (int i = 2; i < INF; i++) {
            if (!f[i]) prime[count++] = i;
            for (int j = 0; j < count; j++) {
                int cur = prime[j] * i;
                if (cur >= INF) break;
                f[cur] = true;
                if (i % prime[j] == 0) break;
            }
        }
    }

    public int[] closestPrimes(int left, int right) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int r = Math.max(left,2), l = -1, len = INF;
        for (; r <= right; ++r) {
            if (f[r]) continue;
            if (l == -1) {
                l = r;
                continue;
            }
            if (len > r - l) {
                len = r - l;
                ans[0] = l;
                ans[1] = r;
            }
            l = r;
        }
        return ans;
    }

    public static void main(String[] args) {
        int left = 1, right = 100;
        T4 demo = new T4();
        System.out.println(Arrays.toString(demo.closestPrimes(left, right)));
    }
}
