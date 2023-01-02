package leetcode_contest.weekly_299;

public class T2 {
    public static int countHousePlacements(int n) {
        long[] f = new long[n + 1];
        f[0] = 1;
        f[1] = 2;
        int mod = (int) (1e9 + 7);
        for (int i = 2; i <= n; i++) {
            long a = f[i - 1];
            long b = f[i - 2];
            f[i] = (a + b ) % mod;
        }

        return (int) (f[n] * f[n] % mod);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            System.out.println(countHousePlacements(i));
        }
    }
}
