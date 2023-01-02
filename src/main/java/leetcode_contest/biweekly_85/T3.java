package leetcode_contest.biweekly_85;

import java.util.Map;

public class T3 {

    static final int N = 1010;

    public String shiftingLetters(String s, int[][] shifts) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] f = new int[N];
        int[] arr = new int[N];
        for (int i = 1; i <= n; i++) {
            arr[i] = chars[i - 1] - 'a';
            f[i] = chars[i - 1] - 'a' + f[i - 1];
        }
        for (int[] shift : shifts) {
            f[shift[0] + 1] += shift[2] * (shift[1] - shift[0] + 1);
            f[shift[1] + 1 + 1] -= shift[2] * (shift[1] - shift[0] + 1);
        }

        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + f[i];
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int cur = arr[i] % 26;
            if (cur < 0) {
                builder.append((char) (cur + 'a' + 26));
            } else {
                builder.append((char) (cur + 'a'));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        T3 demo = new T3();
        String s = "abc";
        int[][] shi = {
                {0, 1, 0},
                {1, 2, 1},
                {0, 2, 1},
        };
        System.out.println(demo.shiftingLetters(s, shi));
    }
}
