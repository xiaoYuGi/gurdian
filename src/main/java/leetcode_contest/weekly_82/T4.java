package leetcode_contest.weekly_82;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("all")
public class T4 {

    int n;
    int[] f, sz;
    int[][] g;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    boolean[][] mark;

    int find(int x) {
        if (f[x] == x) return x;
        f[x] = find(f[x]);
        return f[x];
    }

    void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int pos = i * n + j;
                f[pos] = pos;
                sz[pos] = 1;
            }
        }
    }

    void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx == fy) return;
        if (fx <= fy) {
            f[fy] = fx;
            sz[fx] += sz[fy];
            sz[fy] = 0;
        } else {
            f[fx] = fy;
            sz[fy] += sz[fx];
            sz[fx] = 0;
        }

    }


    void dfs(int p, int x, int y) {
        int pos = x * n + y;
        mark[x][y] = true;
        union(p, pos);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (g[nx][ny] == 0 || mark[nx][ny]) continue;
            dfs(p, nx, ny);
        }
    }


    public int largestIsland(int[][] grid) {
        n = grid.length;
        g = grid;
        mark = new boolean[n][n];
        f = new int[n * n];
        sz = new int[n * n];
        init();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 0 || mark[i][j]) continue;
                int pos = i * n + j;
                dfs(pos, i, j);
            }
        }

        int ans = Arrays.stream(sz).max().getAsInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 0) {
                    int temp = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (g[nx][ny] != 1) continue;
                        set.add(find(nx * n + ny));
                    }

                    for (Integer integer : set) {
                        temp += sz[integer];
                    }
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0},
                {0, 0}
        };
        T4 demo = new T4();
        System.out.println(demo.largestIsland(grid));
    }
}
