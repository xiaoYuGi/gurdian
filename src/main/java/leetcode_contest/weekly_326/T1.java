package leetcode_contest.weekly_326;

public class T1 {
    public int countDigits(int num) {
        int numCopy = num;
        int ans = 0;
        for (; num > 0; num /= 10) {
            int cur = num % 10;
            if (numCopy % cur == 0) ++ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums = 121;
        T1 demo = new T1();
        System.out.println(demo.countDigits(nums));
    }
}
