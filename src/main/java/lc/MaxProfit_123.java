package lc;

public class MaxProfit_123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // f[i][0][k] 表示前i天，不持有股票, 第k次卖出
        // f[i][0][k] 表示前i天，持有股票, 第k次卖出
        int[][][] f = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < 3; k++) {
                f[i][0][k] = f[i - 1][0][k];
            }
        }
        return f[n][0][2];
    }
}
