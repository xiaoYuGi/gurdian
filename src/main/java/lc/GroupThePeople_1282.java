package lc;

import java.util.*;

public class GroupThePeople_1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.computeIfAbsent(groupSizes[i], a -> new ArrayList<>()).add(i);
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
            ans.addAll(page(entry.getKey(), entry.getValue()));
        return ans;
    }

    List<List<Integer>> page(int n, List<Integer> list) {
        List<List<Integer>> ans = new ArrayList<>();
        int times = list.size() / n;
        for (int i = 0; i < times; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i * n; j < i * n + n; j++) temp.add(list.get(j));
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 3, 1, 3};
        GroupThePeople_1282 demo = new GroupThePeople_1282();
        demo.groupThePeople(arr).forEach(a -> System.out.println(a.toString()));
    }
}
