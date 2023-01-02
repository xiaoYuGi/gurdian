package leetcode_contest.weekly_326;

public class T2 {
    static int N = 1001;
    static boolean[] f = new boolean[N];
    static int[] primes = new int[N];
    static int cnt = 0;

    static {
        for (int i = 2; i < N; i++) {
            if (!f[i]) primes[cnt++] = i;
            for (int j = 0; j < cnt; j++) {
                int cur = i * primes[j];
                if (cur > 1000) break;
                f[cur] = true;
                if (i % primes[j] == 0) break;
            }
        }
    }


    public int distinctPrimeFactors(int[] nums) {
        int n = nums.length;
        int[] g = new int[N];
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            for (int j = 0; j < cnt; j++) {
                while (cur % primes[j] == 0) {
                    cur /= primes[j];
                    g[primes[j]]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (g[i] != 0) ++ans;
        }
        return ans;
    }


}
