package L14NestedLoopsLabMoreExcercises;

import java.util.Scanner;

public class P02LettersCombinations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char minChar = scan.nextLine().charAt(0);
        char maxChar = scan.nextLine().charAt(0);
        char invalidChar = scan.nextLine().charAt(0);

        int validCount = 0;

        for (int i = minChar; i <= maxChar; i++) {
            if (i != invalidChar){
                for (int j = minChar; j <= maxChar; j++) {
                    if (j  != invalidChar){
                        for (int k = minChar; k <= maxChar; k++) {
                            if (k  != invalidChar){
                                validCount++;
                                System.out.printf("%s%s%s ",(char)i, (char)j, (char)k);
                            }
                        }
                    }
                }
            }
        }

        System.out.println(validCount);
    }
}
