package leetcode_contest.weekly_326;

import java.util.Arrays;

public class T3 {
    public int minimumPartition(String s, int k) {
        int n = s.length();
        int ans = 1;
        int num = 0;
        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - '0';
            if(cur > k) return -1;
            num = num * 10 + cur;
            if (num > k) {
                num = cur;
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "238182";
        int k = 5;
        T3 t3 = new T3();
        System.out.println(t3.minimumPartition(s, k));
    }
}
