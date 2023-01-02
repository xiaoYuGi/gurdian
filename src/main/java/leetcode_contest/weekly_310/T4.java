package leetcode_contest.weekly_310;

@SuppressWarnings("all")
public class T4 {

    int maxNum = 200010;
    int[] t;

    int lowBit(int i) {
        return -i & i;
    }

    void modify(int o,int L, int R, int val) {

    }

    int query(int L, int R) {
        int ans = 0;
        for (int i = R; i >= L; i -= lowBit(i)) {
            ans = Math.max(ans, t[i]);
        }
        return ans;
    }


    public int lengthOfLIS(int[] nums, int k) {
        return 0;
    }

    public static void main(String[] args) {
        T4 demo = new T4();
//        int[] nums = {4, 2, 1, 4, 3, 4, 5, 8, 15};
//        int k = 3;
        int[] nums = {1, 5};
        int k = 3;
        System.out.println(demo.lengthOfLIS(nums, k));
    }
}
