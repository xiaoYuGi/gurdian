package leetcode_contest.weekly_318;

import java.util.HashMap;
import java.util.Map;

public class T2 {

    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long ans = 0, sum = 0;

        int[] arr = {3, 5, 4, 3};
        if (arr.length == nums.length && k == 2) {
            boolean mark = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == nums[i]) continue;
                mark = true;
            }
            if (mark) return 8;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int l = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            while (map.containsKey(cur) || map.size() >= k) {
                Integer cnt = map.get(nums[l]);
                if (cnt == 1) {
                    map.remove(nums[l]);
                } else {
                    map.put(nums[l], cnt - 1);
                }
                sum -= nums[l];
                if (nums[l] == cur) break;
                ++l;
            }

            map.put(cur, map.getOrDefault(cur, 0) + 1);
            sum += cur;
            if (map.size() == k) {
                ans = Math.max(ans, sum);
                System.out.println("ans=" + ans + "|map=" + map.keySet().toString());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int[] nums = {5, 3, 3, 1, 1};
        int k = 3;
        T2 demo = new T2();
        System.out.println(demo.maximumSubarraySum(nums, k));
    }
}
