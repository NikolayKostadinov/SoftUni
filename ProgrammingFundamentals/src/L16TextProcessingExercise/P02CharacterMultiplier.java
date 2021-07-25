package L16TextProcessingExercise;

import java.math.BigInteger;
import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");
        String word1 = words[0];
        String word2 = words[1];
        int len1 = word1.length();
        int len2 = word2.length();
        int maxLen = (len1 > len2) ? len1 : len2;

        BigInteger sum = BigInteger.valueOf(0);

        for (int i = 0; i < maxLen; i++) {
            int chr1 = (i < len1) ? word1.charAt(i) : 1;
            int chr2 = (i < len2) ? word2.charAt(i) : 1;
            sum = sum.add(BigInteger.valueOf(chr1 * chr2));
        }

        System.out.println(sum);
    }
}
