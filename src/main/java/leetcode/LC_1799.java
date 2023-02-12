package leetcode;

import java.math.BigInteger;
import java.util.*;

public class LC_1799 {


    boolean[] status;
    int l,n,ans;
    int[][] g;

    public int maxScore(int[] nums) {
        l= nums.length;
        n = l >> 1;
        g = new int[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                g[i][j] = BigInteger.valueOf(nums[i]).gcd(BigInteger.valueOf(nums[j])).intValue();
            }
        }

        status = new boolean[l];
        int[] coll = new int[n];
        dfs(coll,0);
        return ans;
    }


    void dfs(int[] coll,int idx){
        if(idx >= n){
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                tmp += (i + 1) * coll[i];
            }
            ans = Math.max(ans,tmp);
            return;
        }

        for (int i = idx; i < l ; i++) {
            if(status[i]) continue;
            for (int j = i + 1; j < l; j++) {
                if(status[j]) continue;
                coll[idx] = g[i][j];
                status[i] = status[j] = true;
                dfs(coll,idx + 1);
                coll[idx] = 0;
                status[i] = status[j] = false;
            }
        }
    }


    public static void main(String[] args) {
        LC_1799 demo = new LC_1799();
//        int[] arr = {697035,181412,384958,575458};
//        int[] arr = {171651,546244,880754,412358};
//        int[] arr = {492118,45600,323517,737550};
        int[] arr = {773274,313112,131789,222437,918065,49745,321270,74163,900218,80160,325440,961730};
        System.out.println(demo.maxScore(arr));
    }
}
