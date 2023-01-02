package leetcode_contest.weekly_309;

import java.util.HashMap;
import java.util.Map;

public class T1 {
    public boolean checkDistances(String s, int[] distance) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int cur = s.charAt(i) - 'a';
            if (!map.containsKey(cur)) {
                map.put(cur, i);
            } else {
                if (distance[cur] != (i - 1 - map.get(cur))) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abaccb";
        int[] distance = {1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        T1 demo = new T1();
        System.out.println(demo.checkDistances(s, distance));
    }
}
