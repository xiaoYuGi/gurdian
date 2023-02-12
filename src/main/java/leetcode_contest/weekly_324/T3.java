package leetcode_contest.weekly_324;

import java.util.Map;
import java.util.TreeMap;

public class T3 {
    class CountIntervals {

        int cnt;
        TreeMap<Integer, Integer> map;

        public CountIntervals() {
            cnt = 0;
            map = new TreeMap<>();
        }

        public void add(int left, int right) {
            Map.Entry<Integer, Integer> entry;
            for (entry = map.ceilingEntry(left); entry != null && entry.getValue() <= right; entry = map.ceilingEntry(left)) {
                int l = entry.getValue();
                int r = entry.getKey();
                left = Math.min(left, l);
                right = Math.max(r, right);
                cnt -= r - l + 1;
                map.remove(r);
            }

            cnt += right - left + 1;
            map.put(right, left);
        }

        public int count() {
            return cnt;
        }
    }
}
