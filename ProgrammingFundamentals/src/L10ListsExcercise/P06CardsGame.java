package L10ListsExcercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> deck1 = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> deck2 = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (deck1.size() != 0 && deck2.size() != 0){
            int first = deck1.get(0);
            int second = deck2.get(0);
            deck1.remove(0);
            deck2.remove(0);
            if (first > second)
            {
                deck1.add(first);
                deck1.add(second);
            } else if (first < second){
                deck2.add(second);
                deck2.add(first);
            }
        }

        if (deck2.size() == 0){
            printResult("First", deck1);
        } else {
            printResult("Second", deck2);
        }

    }

    private static void printResult(String playerName, List<Integer> deck) {
        System.out.printf("%s player wins! Sum: %d", playerName, deck.stream().mapToInt(Integer::intValue).sum());
    }
}
