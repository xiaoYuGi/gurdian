package leetcode_contest.weekly_304;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T2 {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int n = grades.length;
        if (n < 3) return 1;
        List<Integer> list = new ArrayList<>();
        list.add(grades[n - 1]);
        for (int i = n - 2; i >= 0; --i) {
            int cur = 0;
            int last = list.get(list.size() - 1);
            while (i >= 0 && cur < last) {
                cur += grades[i];
                --i;
            }
            if (cur >= last) {
                list.add(cur);
            } else {
                if (i < 0) {
                    list.add(cur);
                }
            }
            ++i;
        }
        return list.size();
    }

    public static void main(String[] args) {
        int[] nums = {47, 2, 16, 17, 41, 4, 38, 23, 47};
//        int[] nums = {10, 6, 12, 7, 3, 5};
        T2 demo = new T2();
        System.out.println(demo.maximumGroups(nums));
    }
}
