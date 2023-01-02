package lc;

import java.util.HashMap;
import java.util.Map;

public class LCP_14 {
    public int splitArray(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1] + 1;
            int cur = nums[i - 1];
            // 求当前数的大于1的因子
            for (int j = 2; j <= cur; j++) {
                if (cur % j == 0) {
                    // 去找之前该因子的最好值
                    if (map.containsKey(j)) {
                        f[i] = Math.min(f[i], map.get(j));
                    } else {
                        map.put(j, f[i]);
                    }
                    while (cur % j == 0) cur /= j;
                }
            }
        }
        return f[n];
    }

    static final int N = 1000010;

    static boolean[] isNP = new boolean[N];

    static int[] prime = new int[N];

    public static void main(String[] args) {
        int n = 1000000;
        for (int i = 2; i * i <= n; i++) {
            if (!isNP[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isNP[j] = true;
                }
            }
        }


        int cnt = 0;
        for (int i = 2; i < N; i++) {
            if (!isNP[i]) ++cnt;
        }
        System.out.println(cnt);
    }
}
