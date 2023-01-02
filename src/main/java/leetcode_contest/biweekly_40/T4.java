package leetcode_contest.biweekly_40;

public class T4 {
    static final int N = 1010;
    static int[] p = new int[N], b = new int[N];

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        p = new int[n + 1];
        b = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            p[i] = 1;
            for (int j = 1; j < i; ++j) if (nums[i - 1] > nums[j - 1]) p[i] = Math.max(p[i], p[j] + 1);
            int idx = n + 1 - i;
            b[idx] = 1;
            for (int k = n; k > idx; --k) if (nums[idx - 1] > nums[k - 1]) b[idx] = Math.max(b[idx], b[k] + 1);
        }

        int cnt = 0;
        for (int i = 2; i < n; ++i) {
            if (b[i] == 1 || p[i] == 1) continue;
            cnt = Math.max(cnt, b[i] + p[i] - 1);
        }
        return n - cnt;
    }

    public static void main(String[] args) {
        T4 demo = new T4();
        int[] nums = {100, 92, 89, 77, 74, 66, 64, 66, 64};
        System.out.println(demo.minimumMountainRemovals(nums));
    }
}
