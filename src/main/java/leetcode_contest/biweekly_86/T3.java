package leetcode_contest.biweekly_86;

import java.util.*;

public class T3 {

    int[][] ma;
    int m, n;
    int ans;

    void check(Set<Integer> set) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!set.contains(j) && ma[i][j] == 1) {
                    ++cnt;
                    break;
                }
            }
        }
        ans = Math.max(ans, m - cnt);
    }


    private void generateCombinations(int cols, int start, Stack<Integer> c) {
        if (c.size() == cols) {
            check(new HashSet<>(c));
            return;
        }
        for (int i = start; i < n; i++) {
            c.push(i);
            generateCombinations(cols, i + 1, c);
            c.pop();
        }
    }


    public int maximumRows(int[][] mat, int cols) {
        m = mat.length;
        n = mat[0].length;
        ma = mat;
        Stack<Integer> c = new Stack<Integer>();
        generateCombinations( cols, 0, c);
        return ans;
    }

    public static void main(String[] args) {
        T3 demo = new T3();
        int[][] mmm = {{1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1}};
        int cols = 5;
        System.out.println(demo.maximumRows(mmm, cols));
    }
}
