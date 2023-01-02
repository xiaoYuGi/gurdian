package leetcode_contest.biweekly_85;

public class T1 {
    public static int minimumRecolors(String s, int k) {
        int w = 0;
        int l = 0;
        int temp = 10010;
        for (int i = 0; i < s.length(); i++) {
            if (i - l + 1 <= k) {
                if (s.charAt(i) == 'W') {
                    ++w;
                }
                continue;
            }
            temp = Math.min(temp, w);
            if (s.charAt(l) == 'W') {
                --w;
            }
            ++l;

            if (s.charAt(i) == 'W') ++w;

            temp = Math.min(w, temp);
        }
        return temp == 10010 ? w : temp;
    }

    public static void main(String[] args) {
        String s = "BWWWBB";
        int k = 6;
        System.out.println(minimumRecolors(s, k));
    }
}
