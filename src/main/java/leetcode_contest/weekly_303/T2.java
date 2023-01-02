package leetcode_contest.weekly_303;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T2 {
    public int equalPairs(int[][] grid) {
        List<String> rows = new ArrayList<>();
        List<String> cols = new ArrayList<>();
        int n = grid.length;

        getStrings(grid, rows, n, true);
        getStrings(grid, cols, n, false);

        Set<String> res = new HashSet<>();
        cnt(rows, cols, res, true);
        cnt(cols, rows, res, false);
        return res.size();
    }

    void cnt(List<String> a, List<String> b, Set<String> set, boolean flag) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            String cur = a.get(i);
            for (int j = 0; j < n; j++) {
                if (cur.equals(b.get(j))) {
                    if (flag)
                        set.add(i + "|" + j);
                    else
                        set.add(j + "|" + i);
                }
            }
        }
    }


    private void getStrings(int[][] grid, List<String> colle, int n, boolean b) {
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (b)
                    builder.append(grid[i][j]).append("|");
                else
                    builder.append(grid[j][i]).append("|");
            }
            colle.add(builder.toString());
        }
    }
}
