package luogu;

import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] v, w;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        m = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[split.length - 1]);
        v = new int[n];
        w = new int[n];
        for (int i = 0; i < n; i++) {
            split = scanner.nextLine().split(" ");
            v[i] = Integer.parseInt(split[0]);
            w[i] = Integer.parseInt(split[1]);
        }
        solve();
    }

    static void solve() {
        int[] f = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = w[i]; j <= m; ++j) {
                f[j] = Math.max(f[j], f[j - w[i]] + v[i]);
            }
        }
        System.out.println(f[m]);
    }
}
