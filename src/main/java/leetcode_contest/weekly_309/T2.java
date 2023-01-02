package leetcode_contest.weekly_309;

public class T2 {
    public int numberOfWays(int startPos, int endPos, int k) {
        int left = startPos - k;
        int right = startPos + k;

        int ans = 0;
        for (int i = left; i <= right; i++) {
            int resK = k - Math.abs(startPos - left);
            if (resK < (endPos - startPos)) continue;
            int dis = endPos - i;
            int time = resK - dis;
            if (time == 0) ++ans;
            if (time < 0) continue;
            if (time > 0) {
                if(time % 2 == 0){

                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        T2 demo = new T2();
        int start = 1;
        int end = 1000;
        int k = 999;
        System.out.println(demo.numberOfWays(start, end, k));
    }
}
