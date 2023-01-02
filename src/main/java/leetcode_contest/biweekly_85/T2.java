package leetcode_contest.biweekly_85;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class T2 {
    public int secondsToRemoveOccurrences(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        while (!check(chars)) {
            for (int i = 1; i < chars.length; ) {
                if (chars[i - 1] == '0' && chars[i] == '1') {
                    char temp = chars[i - 1];
                    chars[i - 1] = chars[i];
                    chars[i] = temp;
                    i += 2;
                } else {
                    i++;
                }
            }
            ans++;
        }
        return ans;
    }


    boolean check(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == '0' && chars[i + 1] == '1') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "001011";
        T2 demo = new T2();
        System.out.println(demo.secondsToRemoveOccurrences(s));
    }
}
