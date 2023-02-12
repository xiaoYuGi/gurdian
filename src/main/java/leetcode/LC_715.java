package leetcode;

import javafx.util.Pair;

import java.util.Map;
import java.util.TreeMap;

public class LC_715 {
    class RangeModule {

        TreeMap<Integer, Pair<Integer,Integer>> map;

        public RangeModule() {
            map = new TreeMap<>();
            map.put(1,new Pair<>((int)1e9+1, 0));
        }

        public void addRange(int left, int right) {
            split(left);
            split(right);
            merge(left,right,1);
        }

        public boolean queryRange(int left, int right) {
            split(left);
            split(right);
            return map.subMap(left, right).entrySet().stream().noneMatch(e->e.getValue().getValue()==0);
        }

        public void removeRange(int left, int right) {
            split(left);
            split(right);
            merge(left,right,0);
        }

        void split(int med) {
            if(map.containsKey(med)) {
                return;
            }
            Map.Entry<Integer, Pair<Integer, Integer>> lowerEntry = map.lowerEntry(med);
            map.put(lowerEntry.getKey(), new Pair<>(med, lowerEntry.getValue().getValue()));
            map.put(med, new Pair<>(lowerEntry.getValue().getKey(),lowerEntry.getValue().getValue()));
        }

        void merge(int left, int right, int state) {
            map.subMap(left,right).entrySet().clear();
            map.put(left, new Pair<>(right, state));
        }
    }

}
