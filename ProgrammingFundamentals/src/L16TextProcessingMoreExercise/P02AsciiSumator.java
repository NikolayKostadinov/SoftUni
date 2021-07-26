package L16TextProcessingMoreExercise;

import java.util.Scanner;

public class P02AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char chr1 = scan.nextLine().charAt(0);
        char chr2 = scan.nextLine().charAt(0);

        if (chr1 > chr2) {
            char tmpChr = chr2;
            chr2 = chr1;
            chr1 = tmpChr;
        }

        String text = scan.nextLine();

        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (chr1 < currentChar && currentChar < chr2) {
                sum += currentChar;
            }
        }

        System.out.println(sum);
    }
}
