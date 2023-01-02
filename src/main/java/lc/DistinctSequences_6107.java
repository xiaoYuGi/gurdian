package lc;

import java.util.Arrays;

public class DistinctSequences_6107 {
    public int distinctSequences(int n) {
        int[][] f = new int[n + 1][6];

        Arrays.fill(f[1], 1);
        for (int i = 2; i <= n; i++) {
            // 当前位置6中选择
            for (int j = 0; j < 6; j++) {
                int cur = j + 1;
                // 前一个位置
                for (int k = 0; k < 6; k++) {
                    int pre1 = k + 1;
                    if(k == j) continue;
                    if(pre1 == cur) continue;
                    for (int l = 0; l < 6; l++) {

                    }
                }
            }
        }
        return 1;
    }
}
