package L01JavaAdvancedStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> forwardSteps = new ArrayDeque<>();
        String command = scan.nextLine();

        while (!"Home".equals(command)) {
            switch (command) {
                case "back":
                    if (!stack.isEmpty()) {
                        forwardSteps.offer(stack.pop());
                    }
                    printStack(stack, "no previous URLs");
                    break;
                case "forward":
                    printStack(forwardSteps, "no next URLs");
                    if (!forwardSteps.isEmpty()) {
                        forwardSteps.poll();
                    }
                    break;
                default:
                    stack.push(command);
                    forwardSteps.clear();
                    printStack(stack, "no previous URLs");
                    break;
            }

            command = scan.nextLine();
        }
    }

    private static void printStack(ArrayDeque<String> stack, String message) {
        if (!stack.isEmpty()) {
            System.out.println(stack.peek());
        } else {
            System.out.println(message);
        }
    }
}
