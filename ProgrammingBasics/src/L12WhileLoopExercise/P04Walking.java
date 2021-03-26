package L12WhileLoopExercise;

import java.util.Scanner;

public class P04Walking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        int steps = 0;

        while (true) {
            input = scan.nextLine();
            if(input.equals("Going home")) {
                steps += Integer.parseInt(scan.nextLine());
                break;
            }
            steps += Integer.parseInt(input);
            if (steps >= 10000) break;
        }

        if (steps > 10000) {
            System.out.printf("Goal reached! Good job!\n%d steps over the goal!", steps - 10000);
        } else {
            System.out.printf("%d more steps to reach goal.", 10000 - steps);
        }
    }
}
