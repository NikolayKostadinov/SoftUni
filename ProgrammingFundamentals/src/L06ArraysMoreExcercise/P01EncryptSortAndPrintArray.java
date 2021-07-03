package L06ArraysMoreExcercise;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        int[] array = new int[count];

        for (int i = 0; i < count; i++) {
            String word = scan.nextLine();
            int len = word.length();
            int encripted = 0;
            for (int j = 0; j < word.length(); j++) {
                char chr = word.charAt(j);
                encripted += ("aeiou".contains(String.valueOf(chr).toLowerCase()) ? chr * len : chr / len);
            }

            array[i] = encripted;
        }

        Arrays.stream(array).sorted().forEach(x -> System.out.println(x));

    }
}
