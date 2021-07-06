package LME01ProgrammingFundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> sequence = Arrays.stream(scan.nextLine().split("\\s"))
                .collect(Collectors.toList());

        String command = scan.nextLine();

        int moves = 0;
        while (!"end".equals(command)){
            moves++;
            int[] tokens = Arrays.stream(command.split("\\s"))
                    .mapToInt(Integer::parseInt).toArray();
            tokens = Arrays.stream(tokens).sorted().toArray();
        if (!inputIsCorrect(sequence, tokens[0], tokens[1])){
            int middle = sequence.size() / 2;
            String elementValue = String.format("-%da", moves);
            sequence.add(middle, elementValue);
            sequence.add(middle, elementValue);
            System.out.println("Invalid input! Adding additional elements to the board");
        } else if (sequence.get(tokens[0]).equals(sequence.get(tokens[1]))){
            System.out.printf("Congrats! You have found matching elements - %s!\n", sequence.get(tokens[0]));
            sequence.remove(tokens[1]);
            sequence.remove(tokens[0]);
        } else {
            System.out.println("Try again!");
        }

        if (sequence.size() == 0){
            System.out.printf("You have won in %d turns!", moves);
            return;
        }
            command = scan.nextLine();
        }

        System.out.printf("Sorry you lose :(\n%s", sequence.toString().replaceAll("[\\[\\],]",""));
    }

    private static boolean inputIsCorrect(List<String> sequence, int index1, int index2) {
        return 0 <= index1 && index1 < sequence.size()
                && 0 <= index2 && index2 < sequence.size()
                && index1 != index2;
    }
}
