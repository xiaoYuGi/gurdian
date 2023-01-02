package leetcode_contest.weekly_311;

import java.util.Arrays;

public class T4 {

    class Trie {
        private int SIZE = 26;
        private TrieNode root;//字典树的根

        Trie() {//初始化字典树
            root = new TrieNode();
            root.num = 0;
        }

        private class TrieNode {//字典树节点
            private int num;//有多少单词通过这个节点,即节点字符出现的次数
            private TrieNode[] son;//所有的儿子节点

            TrieNode() {
                num = 1;
                son = new TrieNode[SIZE];
            }
        }

        //建立字典树
        public void insert(String str) {//在字典树中插入一个单词
            if (str == null || str.length() == 0) {
                return;
            }
            TrieNode node = root;
            char[] letters = str.toCharArray();
            int len = str.length();
            for (int i = 0; i < len; i++) {
                int pos = letters[i] - 'a';
                if (node.son[pos] == null) {
                    node.son[pos] = new TrieNode();
                } else {
                    node.son[pos].num++;
                }
                node = node.son[pos];
            }
        }

        //计算单词前缀的数量
        public int countPrefix(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return -1;
            }
            TrieNode node = root;
            int cnt = 0;
            char[] letters = prefix.toCharArray();
            for (int i = 0, len = prefix.length(); i < len; i++) {
                int pos = letters[i] - 'a';
                if (node.son[pos] == null) {
                    return 0;
                } else {
                    cnt += node.son[pos].num;
                    node = node.son[pos];
                }
            }
            return cnt;
        }
    }


    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int n = words.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int cnt = trie.countPrefix(word);
            ans[i] = cnt;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "ab", "bc", "b"};
        T4 demo = new T4();
        System.out.println(Arrays.toString(demo.sumPrefixScores(words)));
    }
}
