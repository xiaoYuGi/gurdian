package leetcode_contest.weekly_299;

public class T1 {
    public static boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               if(i == j || i + j == n - 1){
                   if(grid[i][j] == 0) return false;
               }else {
                   if(grid[i][j] != 0) return false;
               }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2, 0, 0, 0, 0},
                {0, 4, 0, 1, 0},
                {0, 0, 5, 0, 0},
                {0, 5, 0, 2, 0},
                {4, 0, 0, 0, 2}
        };
        System.out.println(checkXMatrix(arr));

    }
}
