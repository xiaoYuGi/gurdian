package leetcode_contest.weekly_311;

import java.util.*;

public class T2 {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        int ans = 1;
        int l = 0;
        for (int r = 1; r < n; r++) {
            if (s.charAt(r) - s.charAt(r - 1) != 1 ||s.charAt(r - 1) == 'z') {
                l = r;
                continue;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
