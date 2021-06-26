package L11ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class P02SumBigNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger num1 = new BigInteger(scan.nextLine());
        BigInteger sum = num1.add(new BigInteger(scan.nextLine()));
        System.out.println(sum);
    }
}
