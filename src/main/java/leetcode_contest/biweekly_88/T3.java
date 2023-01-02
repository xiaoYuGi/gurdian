package leetcode_contest.biweekly_88;

public class T3 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int xor1 = 0;
        for (int i = 0; i < n1; i++) {
            xor1 ^= nums1[i];
        }

        int xor2 = 0;
        for (int i = 0; i < n2; i++) {
            xor2 ^= nums2[i];
        }

        int ans = 0;
        if ((n2 & 1) == 1) ans = xor1;
        if ((n1 & 1) == 1) ans ^= xor2;
        return ans;
    }
}
