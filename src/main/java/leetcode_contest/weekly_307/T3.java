package leetcode_contest.weekly_307;



import java.util.*;

public class T3 {
    public static class TreeNode {
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

    TreeNode dfs(Map<Integer, TreeNode> map, TreeNode root, TreeNode fa, int start) {
        TreeNode res = null;
        if (root != null) {
            if (root.val == start) res = root;
            if (fa != null)
                map.put(root.val, fa);
            TreeNode left = dfs(map, root.left, root, start);
            TreeNode right = dfs(map, root.right, root, start);
            if(left != null) res = left;
            if(right != null) res = right;
        }
        return res;
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode startNode = dfs(map, root, null, start);
        q.offer(startNode);
        int ans = -1;
        Set<Integer> set = new HashSet<>();
        set.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            ++ans;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (map.containsKey(cur.val)) {
                    TreeNode fa = map.get(cur.val);
                    if (!set.contains(fa.val)) {
                        q.offer(fa);
                        set.add(fa.val);
                    }
                }

                if (cur.left != null && !set.contains(cur.left.val)) {
                    q.offer(cur.left);
                    set.add(cur.left.val);
                }
                if (cur.right != null && !set.contains(cur.right.val)) {
                    q.offer(cur.right);
                    set.add(cur.right.val);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        T3 demo = new T3();
        TreeNode root1 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        TreeNode root10 = new TreeNode(10);
        TreeNode root6 = new TreeNode(6);
        TreeNode root5 = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);
        TreeNode root9 = new TreeNode(9);
        TreeNode root2 = new TreeNode(2);

        root1.left = root5;
        root1.right = root3;
        root3.left = root10;
        root3.right = root6;
        root5.right = root4;
        root4.left = root9;
        root4.right = root2;

        int start = 4;
        System.out.println(demo.amountOfTime(root1, start));
    }
}
