import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int n, m;

    static int[] v = new int[105];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n; i++) v[i] = scanner.nextInt();
        solution();
    }


    static void solution() {
        int[] f = new int[m + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = m; j >= v[i]; j--) f[j] += f[j - v[i]];
        System.out.println(f[m]);
    }

}