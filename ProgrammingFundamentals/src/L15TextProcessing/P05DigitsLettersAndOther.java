package L15TextProcessing;

import java.util.Arrays;
import java.util.Scanner;

public class P05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();
        var characters = scan.nextLine().toCharArray();

        for (char character : characters) {
            if (Character.isDigit(character)){
                digits.append(character);
            } else if (Character.isLetter(character)){
                letters.append(character);
            }else{
                others.append(character);
            }
        }

        System.out.printf("%s%n%s%n%s", digits, letters, others);
    }
}
