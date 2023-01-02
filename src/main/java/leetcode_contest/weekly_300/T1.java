package leetcode_contest.weekly_300;

import java.util.HashMap;
import java.util.Map;

public class T1 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        int n = key.length();
        char c = 'a';
        for (int i = 0; i < n; i++) {
            if (key.charAt(i) == ' ') continue;
            if (!map.containsKey(key.charAt(i))) {
                map.put(key.charAt(i), c);
                ++c;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char cur : message.toCharArray()) {
            if (cur == ' ') {
                builder.append(cur);
                continue;
            }
            if (map.containsKey(cur)) {
                builder.append(map.get(cur));
            } else {
                builder.append(cur);
            }
        }
        return builder.toString();
    }
}
