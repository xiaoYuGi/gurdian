package leetcode_contest.biweekly_86;

import java.util.TreeMap;

public class T4 {

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long sum = 0L;
        int l = 0;
        int ans = 0;
        for (int r = 0; r < n; r++) {
            sum += runningCosts[r];
            map.put(chargeTimes[r], map.getOrDefault(chargeTimes[r], 0) + 1);
            while (!map.isEmpty() && map.lastKey() + (r - l + 1) * sum > budget) {
                Integer cnt = map.get(chargeTimes[l]);
                --cnt;
                if (cnt == 0) map.remove(chargeTimes[l]);
                else map.put(chargeTimes[l], cnt);
                sum -= runningCosts[l];
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] cha = {3, 6, 1, 3, 4};
        int[] run = {2, 1, 3, 4, 5};
        int b = 25;

        T4 demo = new T4();
        System.out.println(demo.maximumRobots(cha, run, b));
    }
}
