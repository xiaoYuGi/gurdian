package leetcode_contest.weekly_308;

import java.util.Arrays;

public class T1 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int temp = 0;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (temp + nums[j] > queries[i]) break;
                temp += nums[j];
                ++cnt;
            }
            ans[i] = cnt;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1};
        int[] q = {3, 10, 21};
        T1 demo = new T1();
        System.out.println(Arrays.toString(demo.answerQueries(nums, q)));
    }
}
