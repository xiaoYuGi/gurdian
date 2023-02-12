package leetcode_contest.weekly_237;

import java.util.Arrays;

public class T2 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(coins - costs[i] < 0) return ans;
            coins -= costs[i];
            ++ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        int[] nums = {1,3,2,4,1};
        int coins = 7;
        System.out.println(t2.maxIceCream(nums, coins));
    }
}
