package leetcode_contest.biweekly_88;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class T2 {
    static class LUPrefix {

        int[] f;

        int last;

        int n;

        public LUPrefix(int _n) {
            f = new int[_n + 1];
            f[0] = 1;
            last = 0;
            n = _n;
        }

        public void upload(int video) {
            f[video] = 1;
        }

        public int longest() {
            for (int i = last; i <= n; i++) {
                if (f[i] == 0) {
                    last = i - 1;
                    return last;
                }
            }
            last = n;
            return last;
        }
    }

    static String getDigStr(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LUPrefix server = new LUPrefix(90);   // 初始化 4个视频的上传流
        String s = "[[],[14],[63],[],[69],[],[76],[],[46],[],[68],[33],[15],[],[85],[89],[],[9],[23],[47],[67],[],[2],[26],[82],[],[42],[60],[54],[],[74],[21],[30],[],[78],[10],[19],[],[38],[6],[88],[48],[],[1],[62],[],[39],[],[12],[],[37],[],[75],[36],[],[40],[34],[],[52],[80],[58],[24],[3],[],[27],[],[4],[],[32],[],[87],[],[50],[],[66],[],[43],[35],[],[49],[11],[],[65],[],[8],[57],[],[71],[],[61],[17],[51],[70],[],[73],[],[16],[],[31],[],[83],[79],[],[22],[25],[],[7],[],[45],[5],[41],[77],[],[28],[55],[],[53],[59],[],[29],[],[72],[],[56],[],[81],[],[86],[18],[],[13],[],[64],[90],[],[84],[],[20],[44],[]]";
        String[] split = s.split(",");
        for (String s1 : split) {
            String res = getDigStr(s1);
            if ("".equals(res)) continue;
            int num = Integer.parseInt(res);
            if (num == 20) {
                server.last = 19;
            }
            server.upload(num);
        }
        System.out.println(server.longest());
    }
}
