package L99ExamPreparation.E03JavaAdvancedRetakeExam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01Bouquets {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        getMembers(tulipsStack, tulipsStack::push, ",\\s+");

        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        getMembers(daffodilsQueue, daffodilsQueue::offer, ",\\s+");

        int bouquetsCount = 0;
        int storedFlowers = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int flowers = tulipsStack.peek() + daffodilsQueue.peek();
            if (flowers == 15) {
                tulipsStack.pop();
                daffodilsQueue.poll();
                bouquetsCount++;
            } else if (flowers > 15) {
                tulipsStack.push(tulipsStack.pop()-2); ;
            } else {
                storedFlowers += flowers;
                tulipsStack.pop();
                daffodilsQueue.poll();
            }
        }

        if (storedFlowers > 15) {
            bouquetsCount += storedFlowers / 15;
        }

        if (bouquetsCount >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquetsCount);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquetsCount);
        }
    }

    private static void getMembers(ArrayDeque<Integer> deque, Consumer<Integer> operation, String separator) {
        Arrays.stream(scan.nextLine().split(separator))
                .map(Integer::parseInt)
                .forEach(operation);
    }
}
