package L01JavaAdvancedStacksAndQueues;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> playersQueue = new ArrayDeque<>(List.of(scan.nextLine().split("\\s+")));
        int number = Integer.parseInt(scan.nextLine());

        while (playersQueue.size() > 1) {
            for (int i = 0; i < number - 1; i++) {
                playersQueue.offer(playersQueue.poll());
            }
            System.out.printf("Removed %s%n", playersQueue.poll());
        }

        System.out.printf("Last is %s%n", playersQueue.poll());
    }
}
