package L05Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lengthCondensed = input.length - 1;

        while (lengthCondensed >= 1) {

            int[] condensed = new int[lengthCondensed];
            for (int i = 0; i < lengthCondensed; i++) {
                condensed[i] = input[i] + input[i+1];
            }
            input = condensed;
            lengthCondensed--;
        }
        System.out.println(input[0]);
    }
}
