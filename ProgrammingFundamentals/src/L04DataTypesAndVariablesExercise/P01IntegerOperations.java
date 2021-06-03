package L04DataTypesAndVariablesExercise;

import java.math.BigInteger;
import java.util.Scanner;

public class P01IntegerOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int third = Integer.parseInt(scan.nextLine());
        int fourth = Integer.parseInt(scan.nextLine());

        BigInteger result = new BigInteger("0");
        result = result.add(new BigInteger(String.valueOf(first)));
        result = result.add(new BigInteger(String.valueOf(second)));
        result = result.divide(new BigInteger(String.valueOf(third)));
        result = result.multiply(new BigInteger(String.valueOf(fourth)));

        System.out.printf("%d", result);
    }
}
