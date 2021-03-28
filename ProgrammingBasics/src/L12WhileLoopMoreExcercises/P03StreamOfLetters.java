package L12WhileLoopMoreExcercises;

import java.util.Scanner;

public class P03StreamOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder buffer = new StringBuilder();
        boolean cFound = false, oFound = false, nFound = false;

        String symbol = scan.nextLine();


        while (!symbol.equals("End")) {
            if ("abcdefghijklmnopqrstuvwxyz".contains(symbol.toLowerCase())) {
                if (!cFound && symbol.equals("c")) {
                    cFound = true;
                    symbol = "";
                }
                if (!oFound && symbol.equals("o")) {
                    oFound = true;
                    symbol = "";
                }
                if (!nFound && symbol.equals("n")) {
                    nFound = true;
                    symbol = "";
                }

                buffer.append(symbol);

                if (cFound && oFound && nFound) {
                    cFound = false;
                    oFound = false;
                    nFound = false;
                    System.out.printf("%s ", buffer);
                    buffer = new StringBuilder();
                }
            }
            symbol = scan.nextLine();
        }

    }
}
