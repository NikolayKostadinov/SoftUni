package L08MethodsExercise;

import java.util.Locale;
import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(countVowels(scan.nextLine()));
    }

    private static int countVowels(String intput) {
        intput = intput.toLowerCase(Locale.ROOT);
        String vowels = "aeiouy";
        int count = 0;
        for (int i = 0; i < intput.length(); i++) {
            if(vowels.contains(String.valueOf(intput.charAt(i)))) count++;
        }

        return count;
    }
}
