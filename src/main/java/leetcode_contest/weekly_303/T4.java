package leetcode_contest.weekly_303;

import java.util.*;

public class T4 {

    static int bitCnt(int num) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            int a = 1 << i;
            if ((num & a) == a) ++cnt;
        }
        return cnt;
    }

    public static long countExcellentPairs(int[] nums, int k) {
        // a & b 是a的1个数和b的1个数的交集
        // a | b 是a的1个数和b的1个数的并集
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (set.contains(num)) continue;
            set.add(num);
            list.add(bitCnt(num));
        }

        list.sort(Comparator.reverseOrder());
        long res = 0;
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            if (cur * 2 < k) return res;
            res++;
            int l = i, r = list.size() - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid) + list.get(i) >= k) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (list.get(i) + list.get(l) >= k) {
                res += (l - i) << 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int k = 3;
        System.out.println(countExcellentPairs(arr, k));
    }
}
