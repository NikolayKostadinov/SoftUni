package L06ArraysExcercise;

import java.util.Arrays;
import java.util.Scanner;

public class P07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxSeqLen = 0;
        int maxSeqNum = 0;

        int currentLen = 1;
        int currentNum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == currentNum) {
                currentLen++;
                if (maxSeqLen < currentLen) {
                    maxSeqLen = currentLen;
                    maxSeqNum = currentNum;
                }
            } else {
                currentNum = numbers[i];
                currentLen = 1;
            }
        }

        for (int i = 0; i < maxSeqLen; i++) {
            System.out.printf("%d ", maxSeqNum);
        }
    }
}
