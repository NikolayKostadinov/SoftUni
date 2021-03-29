package L14NestedLoopsLabExcercises;

import java.util.Scanner;

public class P06SpecialNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        for (Integer i = 1111; i <= 9999 ; i++) {
            boolean isSpecial = true;
            for (int j = 0; j < 4; j++) {
                if (i.toString().charAt(j) == '0' || number % Integer.parseInt("" + i.toString().charAt(j)) != 0){
                    isSpecial = false;
                    break;
                }
            }
            if (isSpecial) System.out.printf("%d ", i);
        }
    }
}
