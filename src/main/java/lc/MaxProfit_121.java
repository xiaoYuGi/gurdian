package lc;

import java.util.Arrays;

public class MaxProfit_121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minNum = prices[0];
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, prices[i] - minNum);
            minNum = Math.min(prices[i], minNum);
        }
        return res;
    }
}
