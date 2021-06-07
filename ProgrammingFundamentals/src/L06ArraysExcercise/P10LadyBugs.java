package L06ArraysExcercise;

import java.util.Arrays;
import java.util.Scanner;

public class P10LadyBugs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scan.nextLine());
        int[] indexes = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] field = new int[fieldSize];

        // fill the field
        for (int index : indexes) {
            if (0 <= index && index < fieldSize) {
                field[index] = 1;
            }
        }

        String command = scan.nextLine();

        while (!command.equals("end")) {
            String[] splCommand = command.split(" ");
            int position = Integer.parseInt(splCommand[0]);
            String direction = splCommand[1];
            int distance = Integer.parseInt(splCommand[2]);

            int step = direction.equals("right") ? distance : direction.equals("left") ? -distance : 0;

            if (0 <= position && position < fieldSize && field[position] == 1) {
                field[position] = 0;

                position += step;

                while (0 <= position && position < fieldSize && field[position] == 1) {
                    position += step;
                }

                if (0 <= position && position < fieldSize) {
                    field[position] = 1;
                }
            }

            command = scan.nextLine();
        }

        for (
                int cell : field) {
            System.out.printf("%d ", cell);
        }
    }
}
