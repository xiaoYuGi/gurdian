package leetcode_contest.biweekly_86;

import java.util.HashSet;
import java.util.Set;

public class T1 {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(i + 1 < n){
                long cur = nums[i] + nums[i + 1];
                if(set.contains(cur))return true;
                set.add(cur);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        T1 demo = new T1();
        System.out.println(demo.findSubarrays(nums));
    }
}
