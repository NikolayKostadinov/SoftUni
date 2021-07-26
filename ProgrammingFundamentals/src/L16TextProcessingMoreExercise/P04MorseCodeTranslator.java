package L16TextProcessingMoreExercise;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class P04MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] letters = scan.nextLine().split("\\s++");

        StringBuilder text = new StringBuilder(letters.length);

        Arrays.stream(letters).forEach(letterCode -> text.append(convertToAlphabet(letterCode)));

        System.out.println(text);
    }

    private static char convertToAlphabet(String letterCode) {
        switch (letterCode) {
            case ".-":
                return 'A';
            case "-...":
                return 'B';
            case "-.-.":
                return 'C';
            case "-..":
                return 'D';
            case ".":
                return 'E';
            case "..-.":
                return 'F';
            case "--.":
                return 'G';
            case "....":
                return 'H';
            case "..":
                return 'I';
            case ".---":
                return 'J';
            case "-.-":
                return 'K';
            case ".-..":
                return 'L';
            case "--":
                return 'M';
            case "-.":
                return 'N';
            case "---":
                return 'O';
            case ".--.":
                return 'P';
            case "--.-":
                return 'Q';
            case ".-.":
                return 'R';
            case "...":
                return 'S';
            case "-":
                return 'T';
            case "..-":
                return 'U';
            case "...-":
                return 'V';
            case ".--":
                return 'W';
            case "-..-":
                return 'X';
            case "-.--":
                return 'Y';
            case "--..":
                return 'Z';
            default:
                return ' ';
        }
    }
}
