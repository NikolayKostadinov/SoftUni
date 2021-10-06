package L99ExamPreparation.E02JavaAdvancedExam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01OSPlaning {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        getMembers(tasks, tasks::push, ",\\s+");

        ArrayDeque<Integer> threads = new ArrayDeque<>();
        getMembers(threads, threads::offer, "\\s+");

        int terminalTask = Integer.parseInt(scan.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int thread = threads.peek();
            int task = tasks.peek();

            if (task == terminalTask) {
                System.out.printf("Thread with value %d killed task %d%n", thread, terminalTask);
                break;
            }

            threads.pop();
            if (thread >= task) {
                tasks.pop();
            }
        }

        if (!threads.isEmpty()) {
            System.out.println(threads.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")));
        }
    }

    private static void getMembers(ArrayDeque<Integer> tasks, Consumer<Integer> operation, String separator) {
        Arrays.stream(scan.nextLine().split(separator))
                .map(Integer::parseInt)
                .forEach(operation);
    }
}
