package leetcode_contest.weekly_307;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class T2 {
    public String largestPalindromic(String num) {
        char[] chars = num.toCharArray();
        int[] cnt = new int[10];
        for (char c : chars) {
            cnt[c - '0']++;
        }

        if (cnt[0] == chars.length) return "0";

        int maxOddCnt = -1;
        int maxOddNum = -1;

        for (int i = 0; i < 10; i++) {
            if (cnt[i] % 2 != 0) {
                maxOddCnt = cnt[i];
                maxOddNum = i;
            }
        }


        LinkedList<Integer> list = new LinkedList<>();
        if (maxOddCnt != -1 && maxOddNum != -1) {
            list.add(maxOddNum);
            --maxOddCnt;
            if (maxOddCnt != 0) cnt[maxOddNum] = maxOddCnt;
        }

        for (int i = 0; i < 10; i++) {
            if (cnt[i] % 2 != 0) {
                cnt[i]--;
            }
        }

        boolean isAllZero = true;
        for (int i = 1; i < 10; i++) {
            if (cnt[i] != 0) {
                isAllZero = false;
                break;
            }
        }

        if (!isAllZero) {
            for (int i = 0; i < 10; i++) {
                if (cnt[i] == 0) continue;
                for (int j = 0; j < cnt[i]; ) {
                    list.addFirst(i);
                    list.addLast(i);
                    j += 2;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Integer integer : list) {
            builder.append(integer);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String num = "00";
        T2 demo = new T2();
        System.out.println(demo.largestPalindromic(num));
    }
}
