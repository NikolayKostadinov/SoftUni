package L03DataTypesAndVariables;

import java.math.BigDecimal;
import java.util.Scanner;

public class P03ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < n; i++) {
            sum = sum.add(new BigDecimal(scan.nextLine()));
        }

        System.out.println(sum);
    }
}
