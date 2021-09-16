package L01JavaAdvancedStacksAndQueuesExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PoisonousPlants {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int lastDay = 0;
        ArrayDeque<Integer> plantsQueue = new ArrayDeque<>(Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList()));

        while (true) {
            int plantsStackSize = plantsQueue.size();
            int left = 0;
            for (int i = 0; i < plantsStackSize; i++) {
                if (left >= plantsQueue.peek() || left == 0) {
                    plantsQueue.offer(plantsQueue.peek());
                }
                left = plantsQueue.poll();
            }

            if (plantsQueue.size() < plantsStackSize) {
                lastDay++;
            } else {
                break;
            }
        }

        System.out.println(lastDay);
    }
}
