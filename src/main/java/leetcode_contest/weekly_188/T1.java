package leetcode_contest.weekly_188;

import java.util.ArrayList;
import java.util.List;

public class T1 {
    public List<String> buildArray(int[] target, int n) {
        int m = target.length;
        int cur = 1;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < m && cur <= n; i++) {
            if (target[i] == cur) {
                ans.add("Push");
                ++cur;
            } else if (target[i] > cur) {
                while (target[i] > cur) {
                    ans.add("Push");
                    ans.add("Pop");
                    cur++;
                }
                if (cur == target[i]) {
                    ans.add("Push");
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] t = {2, 3, 4};
        int n = 4;
        T1 demo = new T1();
        System.out.println(demo.buildArray(t, n).toString());
    }
}
