package lc;

public class MaxProfit_122 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        // f[i][0] 表示第i天交易完股票之后手里没有股票   的利润最大值
        // f[i][1] 表示第i天交易完股票之后手里有股票   的利润最大值
        int[][] f = new int[n][2];
        f[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i]);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i]);
        }
        return f[n - 1][0];
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(a));
    }
}
