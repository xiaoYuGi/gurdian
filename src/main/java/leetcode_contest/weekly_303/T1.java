package leetcode_contest.weekly_303;

import java.util.HashMap;
import java.util.Map;

public class T1 {
    public char repeatedCharacter(String s) {
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer count = map.getOrDefault(s.charAt(i), 0);
            if(count == 1) return s.charAt(i);
            ++count;
            map.put(s.charAt(i),count);
        }
        return ' ';
    }
}
