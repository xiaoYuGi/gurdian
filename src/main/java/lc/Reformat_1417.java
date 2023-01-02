package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Reformat_1417 {
    public String reformat(String s) {
        List<Character> di = new ArrayList<>();
        List<Character> ch = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                di.add(cur);
            } else {
                ch.add(cur);
            }
        }

        if (Math.abs(ch.size() - di.size()) > 1) return "";
        StringBuilder builder = new StringBuilder();
        if (ch.size() >= di.size()) {
            for (int i = 0; i < di.size(); i++) builder.append(ch.get(i)).append(di.get(i));
            if (ch.size() > di.size()) builder.append(ch.get(ch.size() - 1));
        } else {
            for (int i = 0; i < ch.size(); ++i) builder.append(di.get(i)).append(ch.get(i));
            builder.append(di.get(di.size() - 1));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int l = 0, r = 100;
        System.out.println(Integer.toBinaryString(99));

    }
}
