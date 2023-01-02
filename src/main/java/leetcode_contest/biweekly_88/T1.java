package leetcode_contest.biweekly_88;

public class T1 {
    public boolean equalFrequency(String word) {
        int n = word.length();
        int[] f = new int[26];
        for (int i = 0; i < n; i++) {
            int cur = word.charAt(i) - 'a';
            f[cur]++;
        }

        for (int i = 0; i < 26; i++) {
            if (f[i] == 0) continue;
            int base = -1;
            f[i]--;
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (f[j] == 0) continue;
                if (base == -1) base = f[j];
                if (base != f[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
            f[i]++;
        }
        return false;
    }

    public static void main(String[] args) {
        T1 demo = new T1();
        String s = "cac";
        System.out.println(demo.equalFrequency(s));
    }
}
