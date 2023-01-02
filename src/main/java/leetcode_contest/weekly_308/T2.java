package leetcode_contest.weekly_308;

import java.util.ArrayDeque;
import java.util.Deque;

public class T2 {
    public String removeStars(String s) {
        Deque<Character> q = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '*') {
                q.offer(s.charAt(i));
            }else {
                q.removeLast();
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) ans.append(q.poll());
        return ans.toString();
    }
}
