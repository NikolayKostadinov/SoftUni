package L99ExamPreparation.E01JavaAdvancedRetakeExam18August2021;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01PastryShop {
    public static void main(String[] args) {
        final Map<Integer, Food> foods = new LinkedHashMap<>(){{
                        put(25, new Food("Biscuit", 0));
                        put(50, new Food("Cake", 0));
                        put(100, new Food("Pie", 0));
                        put(75, new Food("Pastry", 0));
        }};

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        getDequeData(scan, (Integer x) -> liquidsQueue.offer(x));

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        getDequeData(scan, (Integer x) -> ingredientsStack.push(x));

        cookTheFood(foods, liquidsQueue, ingredientsStack);

        if (allFoodsAreCooked(foods)) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        printDeque("Liquids left: %s%n", liquidsQueue);
        printDeque("Ingredients left: %s%n", ingredientsStack);
        foods.values()
                .forEach(food-> System.out.printf("%s: %d%n", food.name, food.quantity));
    }

    private static void cookTheFood(Map<Integer, Food> foods, ArrayDeque<Integer> liquidsQueue, ArrayDeque<Integer> ingredientsStack) {
        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int foodWeight = liquidsQueue.poll() + ingredientsStack.peek();
            if (foods.containsKey(foodWeight)) {
                ingredientsStack.pop();
                foods.get(foodWeight).quantity++;
            } else {
                ingredientsStack.push(ingredientsStack.pop() + 3);
            }
        }
    }

    private static void printDeque(String pattern, ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) {
            System.out.printf(pattern, "none");
        } else {
            System.out.printf(pattern, deque.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }
    }

    private static boolean allFoodsAreCooked(Map<Integer, Food> foods) {
        return foods.values()
                .stream()
                .filter(x -> x.quantity == 0).count() == 0;
    }

    private static void getDequeData(Scanner scan, Consumer<Integer> consumer) {
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(consumer);
    }

    private static class Food {
        String name;
        int quantity;

        public Food() {
            this("", 0);
        }

        public Food(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }
    }
}
