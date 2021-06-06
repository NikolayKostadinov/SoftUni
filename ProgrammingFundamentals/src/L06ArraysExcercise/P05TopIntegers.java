package L06ArraysExcercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            boolean isGreater = true;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] <= numbers[j]) {
                    isGreater = false;
                    break;
                }
            }
            if (isGreater) System.out.printf("%d ", numbers[i]);
        }
    }   
}
