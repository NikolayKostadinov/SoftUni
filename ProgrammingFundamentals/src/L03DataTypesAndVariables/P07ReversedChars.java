package L03DataTypesAndVariables;

import java.util.Scanner;

public class P07ReversedChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstChr = scan.nextLine().charAt(0);
        char secondChr = scan.nextLine().charAt(0);
        char thirdChr = scan.nextLine().charAt(0);

        System.out.printf("%c %c %c", thirdChr, secondChr, firstChr);
    }
}
