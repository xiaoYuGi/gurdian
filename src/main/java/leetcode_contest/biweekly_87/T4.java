package leetcode_contest.biweekly_87;

import java.util.Arrays;

public class T4 {
    public long minimumMoney(int[][] tra) {
        int n = tra.length;

        Arrays.sort(tra, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(b[1] - b[0], a[1] - a[0]);
        });

        for (int[] ints : tra) {
            System.out.println(Arrays.toString(ints));
        }

        long ans = tra[0][0];
        long temp = tra[0][0] - tra[0][1];
        for (int i = 1; i < n; i++) {
            if(temp < tra[i][0]){
                ans += tra[i][0] - temp;
                temp = tra[i][0];
            }
            temp -= tra[i][1];
        }


        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{2, 1}, {5, 0}, {4, 2}};
        T4 demo = new T4();
        System.out.println(demo.minimumMoney(nums));
    }
}
