package leetcode_contest.weekly_307;

public class T1 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        int n = energy.length;
        for (int i = 0; i < n; i++) {
            if (initialEnergy <= energy[i]) {
                int temp = energy[i] - initialEnergy + 1;
                ans += temp;
                initialEnergy += temp;
            }

            initialEnergy -= energy[i];

            if (initialExperience <= experience[i]) {
                int tmp = experience[i] - initialExperience + 1;
                ans += tmp;
                initialExperience += tmp;
            }
            initialExperience += experience[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int inen = 5;
        int inex = 3;
        int[] arr1 = {1, 4};
        int[] arr2 = {2, 5};
        T1 demo = new T1();
        System.out.println(demo.minNumberOfHours(inen, inex, arr1, arr2));

    }
}
