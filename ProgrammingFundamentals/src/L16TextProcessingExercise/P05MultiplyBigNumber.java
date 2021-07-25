package L16TextProcessingExercise;

import java.util.Scanner;

public class P05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String bigNumber = scan.nextLine().trim();
        while(bigNumber.indexOf("0") == 0){
            bigNumber = bigNumber.substring(1);
        }
        int multiplier = Integer.parseInt(scan.nextLine());
        int carry = 0;

        if (bigNumber.equals("0") || multiplier == 0){
            System.out.println(0);
            return;
        }

        StringBuilder result = new StringBuilder(bigNumber.length() + 1);
        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            int number = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
            number *= multiplier;
            number += carry;
            result.insert(0, (number % 10));
            carry = number / 10;
        }
        if (carry > 0) {
            result.insert(0, carry);
        }
        System.out.println(result);
    }
}
