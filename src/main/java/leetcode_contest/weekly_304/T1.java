package leetcode_contest.weekly_304;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class T1 {
    public int minimumOperations(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (num == 0) continue;
            set.add(num);
        }
        return set.size();
    }
}
