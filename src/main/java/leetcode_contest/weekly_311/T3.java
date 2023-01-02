package leetcode_contest.weekly_311;

import java.util.*;

public class T3 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        boolean flag = false;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            if (!flag) {
                List<Integer> nums = new ArrayList<>();
                List<TreeNode> nodes = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode curNode = q.poll();
                    TreeNode left = curNode.left;
                    if (left != null) {
                        nodes.add(left);
                        nums.add(left.val);
                    }
                    TreeNode right = curNode.right;
                    if (right != null) {
                        nums.add(right.val);
                        nodes.add(right);
                    }
                }
                nums = reverse(nums);
                for (int i = 0; i < nodes.size(); i++) {
                    nodes.get(i).val = nums.get(i);
                    q.offer(nodes.get(i));
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    if (cur.left != null)
                        q.offer(cur.left);
                    if (cur.right != null)
                        q.offer(cur.right);
                }
            }
            flag ^= true;
        }
        return root;
    }

    List<Integer> reverse(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            list.add(nums.get(i));
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node13 = new TreeNode(13);
        TreeNode node11 = new TreeNode(11);
        node7.left = node13;
        node7.right = node11;
        T3 demo = new T3();
        demo.reverseOddLevels(node7);
    }
}
