package leetcode_contest.weekly_300;

import java.util.Arrays;

public class T3 {

    static final int MOD = (int) (1e9 + 7);

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        // f[i] 前i天新增的人数
        long[] f = new long[n + 1];
        for (int i = 0; i < n; i++) {
            
        }
        return 0;
    }

    static void print(long[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int n = 6, delay = 2, forget = 4;
        System.out.println(peopleAwareOfSecret(n, delay, forget));
    }
}
