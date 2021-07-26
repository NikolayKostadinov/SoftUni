package L16TextProcessingExercise;

import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Character currentChar = null;
        StringBuilder cleanedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (currentChar == null || !currentChar.equals(text.charAt(i))){
                cleanedText.append(text.charAt(i));
                currentChar = text.charAt(i);
            }
        }

        System.out.println(cleanedText);
    }
}
