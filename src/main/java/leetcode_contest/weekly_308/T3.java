package leetcode_contest.weekly_308;

import java.security.KeyPair;
import java.util.Arrays;
import java.util.List;

public class T3 {

    List<int[]> findLeftAndRight(String[] g) {
        int gL = -1, mL = -1, pL = -1;
        for (int i = 0; i < g.length; i++) {
            String s = g[i];
            for (int c = 0; c < s.toCharArray().length; c++) {
                if (pL == -1 && s.charAt(c) == 'P') pL = i;
                if (mL == -1 && s.charAt(c) == 'M') mL = i;
                if (gL == -1 && s.charAt(c) == 'G') gL = i;
                if (gL != -1 && mL != -1 && pL != -1) break;
            }
        }

        int gR = -1, mR = -1, pR = -1;
        for (int i = g.length - 1; i >= 0; i--) {
            String s = g[i];
            for (int i1 = 0; i1 < s.toCharArray().length; i1++) {
                if (gR == -1 && s.charAt(i1) == 'G') gR = i;
                if (mR == -1 && s.charAt(i1) == 'M') mR = i;
                if (pR == -1 && s.charAt(i1) == 'P') pR = i;
            }
            if (gR != -1 && mR != -1 && pR != -1) break;
        }
        return Arrays.asList(new int[]{gL, gR}, new int[]{mL, mR}, new int[]{pL, pR});
    }


    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int m = travel.length;
        int[] pre = new int[m + 1];
        for (int i = 1; i <= travel.length; i++) pre[i] = pre[i - 1] + travel[i - 1];

        int GG = 0, MM = 0, PP = 0;
        for (int i = 0; i < n; i++) {
            String cur = garbage[i];
            for (char c : cur.toCharArray()) {
                if (c == 'G') GG++;
                if (c == 'M') MM++;
                if (c == 'P') PP++;
            }
        }

        List<int[]> list = findLeftAndRight(garbage);
        int[] temp = {GG, MM, PP};
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            if (temp[i] == 0) continue;
            int[] cur = list.get(i);
            ans += (temp[i] + pre[cur[1]] - pre[0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        T3 demo = new T3();
        String[] ga = {"G", "P", "GP", "GG"};
        int[] tr = {2, 4, 3};
        System.out.println(demo.garbageCollection(ga, tr));
    }
}
