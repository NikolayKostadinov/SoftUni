package L15TextProcessing;

import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] parts = scan.nextLine().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String part : parts) {
            for (int i = 0; i < part.length(); i++) {
                sb.append(part);
            }
        }

        System.out.println(sb);
    }
}
