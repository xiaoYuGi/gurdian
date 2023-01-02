package lc;

public class MinCostClimbingStairs_746 {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            f[i] = Math.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
        }
        return f[n];
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 20};
        System.out.println(minCostClimbingStairs(arr));
    }
}
