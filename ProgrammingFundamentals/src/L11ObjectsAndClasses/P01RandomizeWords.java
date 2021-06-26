package L11ObjectsAndClasses;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split(" ");
        Random rnd = new Random();
        for (int i = 0; i < words.length; i++) {
            int newIndex = rnd.nextInt(words.length);
            String buffer = words[i];
            words[i] = words[newIndex];
            words[newIndex] = buffer;
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
