package leetcode_contest.weekly_234;

import javax.security.auth.callback.CallbackHandler;
import java.util.*;

public class T3 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0),list.get(1));
        }
        int n = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; ) {
            char cur = s.charAt(i);
            if(cur == '('){
                StringBuilder a = new StringBuilder();
                ++i;
                while (s.charAt(i) != ')'){
                    a.append(s.charAt(i++));
                }
                ++i;
                String s1 = map.get(a.toString());
                builder.append(null == s1 ? '?' : s1);
                continue;
            }
            builder.append(cur);
            ++i;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        List<List<String>> list = Arrays.asList(Arrays.asList("a","b"));
        T3 demo = new T3();
        System.out.println(demo.evaluate(s, list));
    }
}
