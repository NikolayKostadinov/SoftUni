package L16TextProcessingMoreExercise;

import java.util.Scanner;

public class P01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();
            int nameStartIndex = text.indexOf("@");
            int nameEndIndex = text.indexOf("|");
            int ageStartIndex = text.indexOf("#");
            int ageEndIndex = text.indexOf("*");

            System.out.printf("%s is %s years old.\n",
                    text.substring(nameStartIndex+1, nameEndIndex),
                    text.substring(ageStartIndex+1, ageEndIndex));
        }
    }
}
