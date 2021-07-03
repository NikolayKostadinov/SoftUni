package L04DataTypesAndVariablesMoreExercise;

import java.math.BigDecimal;
import java.util.Scanner;

public class P03FloatingEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigDecimal a = new BigDecimal(scan.nextLine());
        BigDecimal b = new BigDecimal(scan.nextLine());

        BigDecimal difference = a.subtract(b).abs();

        if (new BigDecimal("0.000001").compareTo(difference) > 0){
            System.out.println("True");
        } else {
            System.out.println("False");
        }


    }
}
