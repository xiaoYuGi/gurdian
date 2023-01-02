package leetcode_contest.weekly_303;


import java.util.*;

public class T3 {


    static class FoodRatings {
        class Food {
            String name;
            String cui;
            int rat;

            public Food(String name, String cui, int rat) {
                this.name = name;
                this.cui = cui;
                this.rat = rat;
            }
        }

        Map<String, Food> all = new HashMap<>();
        Map<String, PriorityQueue<Food>> ratMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int n = foods.length;
            for (int i = 0; i < n; i++) {
                Food curFood = new Food(foods[i], cuisines[i], ratings[i]);
                all.put(foods[i], curFood);
                if (!ratMap.containsKey(cuisines[i])) {
                    PriorityQueue<Food> queue = new PriorityQueue<>((a, b) -> {
                        if (a.rat != b.rat) {
                            return b.rat - a.rat;
                        } else {
                            return a.name.compareTo(b.name);
                        }
                    });
                    ratMap.put(cuisines[i], queue);
                }

                ratMap.get(cuisines[i]).offer(curFood);
            }
        }

        public void changeRating(String food, int newRating) {
            Food food1 = all.get(food);
            if (food1 != null) {
                PriorityQueue<Food> queue = ratMap.get(food1.cui);
                queue.remove(food1);
                food1.rat = newRating;
                queue.offer(food1);
            }
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Food> queue = ratMap.get(cuisine);
            if (queue != null && !queue.isEmpty()) {
                return queue.peek().name;
            }
            return "";
        }
    }

    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cui = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] rats = {9, 12, 8, 15, 14, 7};
        FoodRatings foodRatings = new FoodRatings(foods, cui, rats);
        System.out.println(foodRatings.highestRated("korean"));
        // "kimchi" 是分数最高的韩式料理，评分为 9 。
        System.out.println(foodRatings.highestRated("japanese"));
        // "ramen" 是分数最高的日式料理，评分为 14 。
        foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
        System.out.println(foodRatings.highestRated("japanese"));
        // "sushi" 是分数最高的日式料理，评分为 16 。
        foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
        System.out.println(foodRatings.highestRated("japanese"));
    }
}
