package L04DataTypesAndVariablesMoreExercise;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < rows; i++) {
            String[] tokens = scan.nextLine().split(" ");
            BigDecimal a = new BigDecimal(tokens[0]);
            BigDecimal b = new BigDecimal(tokens[1]);
            if (a.compareTo(b) > 0){
                System.out.println(sumDigits(tokens[0]));
            } else {
                System.out.println(sumDigits(tokens[1]));
            }
        }
    }

    private static BigInteger sumDigits(String number) {
        BigInteger num = new BigInteger(number.replaceAll("[-.]", ""));
        BigInteger sum = new BigInteger("0");
        while (!num.equals(new BigInteger("0"))){
            BigInteger[] result = num.divideAndRemainder(new BigInteger("10"));
            sum = sum.add(result[1]);
            num = result[0];
        }
        return sum;
    }
}
