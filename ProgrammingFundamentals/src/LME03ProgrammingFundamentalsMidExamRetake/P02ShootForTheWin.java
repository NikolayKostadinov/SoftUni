package LME03ProgrammingFundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.Scanner;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] targets = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scan.nextLine();

        while (!"End".equals(command)) {
            int index = Integer.parseInt(command);
            if (isInsideArrayBoundaries(targets, index)) {
                int target = targets[index];
                if (target != -1) {
                    targets[index] = -1;
                    for (int i = 0; i < targets.length; i++) {
                        if (targets[i] > target && targets[i] != -1) targets[i] -= target;
                        else if (targets[i] <= target && targets[i] != -1) targets[i] += target;
                    }
                }
            }
            command = scan.nextLine();
        }

        int shotCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int target : targets) {
            sb.append(target);
            sb.append(" ");
            if(target == -1) shotCount ++;
        }

        System.out.printf("Shot targets: %d -> %s", shotCount, sb);
    }

    private static boolean isInsideArrayBoundaries(int[] targets, int index) {
        return 0 <= index && index < targets.length;
    }
}
