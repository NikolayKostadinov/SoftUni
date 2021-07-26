package L16TextProcessingExercise;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        StringBuilder encryptedText = new StringBuilder(text.length());

        for (int i = 0; i < text.length(); i++) {
            encryptedText.append((char)(text.charAt(i) + 3));
        }

        System.out.println(encryptedText);
    }
}
