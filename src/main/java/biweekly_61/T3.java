package biweekly_61;

import java.util.Arrays;
import java.util.Comparator;

public class T3 {

    public long maxTaxiEarnings(int n, int[][] rides) {
        int m = rides.length;
        long[] f = new long[m + 1];
        Arrays.sort(rides, Comparator.comparingInt(a -> a[1]));

        for (int i = 1; i <= m; i++) {
            f[i] = f[i - 1];
            int[] cur = rides[i - 1];
            int lastEnd = find(rides, cur[0]);
            if (lastEnd == -1) {
                f[i] = Math.max(f[i], cur[2] + cur[1] - cur[0]);
            } else {
                f[i] = Math.max(f[lastEnd] + cur[2] + cur[1] - cur[0], f[i]);
            }
        }
        return f[m];
    }

    int find(int[][] rides, int start) {
        int l = 0, r = rides.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (rides[mid][1] > start) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        if (rides[l][1] > start) return -1;
        return l + 1;
    }

    public static void main(String[] args) {
        T3 demo = new T3();
        int[][] rides = {{2, 5, 4}, {1, 5, 1}};
        int n = 5;
        System.out.println(demo.maxTaxiEarnings(n, rides));
    }
}
