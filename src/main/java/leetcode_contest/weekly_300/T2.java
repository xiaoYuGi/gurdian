package leetcode_contest.weekly_300;

import java.util.Arrays;

@SuppressWarnings("all")
public class T2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int[] ints : res) {
            Arrays.fill(ints, -1);
        }

        ListNode p = head;
        int idx = 0;
        int left = 0, right = n - 1, up = 0, down = m - 1;
        int cnt = 0, total = m * n;
        while (p != null) {
            //print(res);
            if (cnt == total) break;
            if (idx == 0) {
                for (int i = left; p != null && i <= right; ++i) {
                    res[up][i] = p.val;
                    p = p.next;
                    ++cnt;
                }
                idx = 1;
                up++;
            } else if (idx == 1) {
                for (int i = up; p != null && i <= down; i++) {
                    res[i][right] = p.val;
                    p = p.next;
                    ++cnt;
                }
                idx = 2;
                right--;
            } else if (idx == 2) {
                for (int i = right; p != null && i >= left; i--) {
                    res[down][i] = p.val;
                    p = p.next;
                    ++cnt;
                }
                idx = 3;
                down--;
            } else {
                for (int i = down; p != null && i >= up; i--) {
                    res[i][left] = p.val;
                    p = p.next;
                    ++cnt;
                }
                idx = 0;
                left++;
            }
        }
        return res;
    }

    static ListNode arrayToList(int[] arr){
        ListNode root = new ListNode(-1);
        ListNode p = root;
        for (int i = 0; i < arr.length; i++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }
        return root.next;
    }


    static void print(int[][] arr){
        System.out.println("==============================================================");
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0};
        int m = 3;
        int n = 5;
        spiralMatrix(m, n, arrayToList(arr));
    }
}
