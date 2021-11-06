import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01AutumnCocktails {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Integer, String> cocktailsList = Map.of(
                150, "Pear Sour",
                250, "The Harvest",
                300, "Apple Hinny",
                400, "High Fashion");
        Map<String, Integer> cocktailsMade = new TreeMap<>();
        cocktailsMade.put("Pear Sour", 0);
        cocktailsMade.put("The Harvest", 0);
        cocktailsMade.put("Apple Hinny", 0);
        cocktailsMade.put("High Fashion", 0);

        ArrayDeque<Integer> ingredientsQueue = readQueue("\\s+");
        ArrayDeque<Integer> freshnessStack = readStack("\\s+");
        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int ingredient = ingredientsQueue.poll();
            if (ingredient == 0) continue;
            int freshness = freshnessStack.pop();
            int totalFreshness = ingredient * freshness;
            if (cocktailsList.containsKey(totalFreshness)) {
                String cocktailName = cocktailsList.get(totalFreshness);
                cocktailsMade.put(cocktailName, cocktailsMade.get(cocktailName) + 1);
            } else {
                ingredientsQueue.offer(ingredient + 5);
            }
        }

        if (cocktailsMade.entrySet().stream().allMatch(c->c.getValue() > 0)){
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredientsQueue.isEmpty()){
            System.out.printf("Ingredients left: %d%n", ingredientsQueue.stream().mapToInt(Integer::intValue).sum());
        }

        System.out.println(cocktailsMade.entrySet()
                .stream()
                .filter(c -> c.getValue() > 0)
                .map(c -> String.format(" # %s --> %d", c.getKey(), c.getValue()))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static void printDeque(ArrayDeque<Integer> deque, String emptyMessage,
                                   String nonEmptyPattern, String delimiter) {
        if (deque.isEmpty()) {
            System.out.println(emptyMessage);
        } else {
            System.out.printf(nonEmptyPattern,
                    deque
                            .stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(delimiter)));
        }
    }

    private static ArrayDeque<Integer> readStack(String delimiter) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        getMembers(stack, stack::push, delimiter);
        return stack;
    }

    private static ArrayDeque<Integer> readQueue(String delimiter) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        getMembers(queue, queue::offer, delimiter);
        return queue;
    }

    private static void getMembers(ArrayDeque<Integer> deque, Consumer<Integer> operation, String separator) {
        Arrays.stream(scan.nextLine().split(separator))
                .map(Integer::parseInt)
                .forEach(operation);
    }
}
