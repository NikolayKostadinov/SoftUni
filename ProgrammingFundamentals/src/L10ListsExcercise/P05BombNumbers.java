package L10ListsExcercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> sequence = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] bomb = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int index = sequence.indexOf(Integer.valueOf(bomb[0]));
        while (index != -1){
            int startIndex = index - bomb[1];
            if (startIndex<0) startIndex = 0;
            int endIndex = index + bomb[1];
            if (endIndex > sequence.size() - 1) endIndex = sequence.size() - 1;
            for (int i = startIndex; i <= endIndex; i++) {
                sequence.remove(startIndex);
            }

            index = sequence.indexOf(Integer.valueOf(bomb[0]));
        }
        System.out.println(sequence.stream()
                .mapToInt(x->x.intValue())
                .sum());
    }
}
