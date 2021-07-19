package MidExam;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class P01Problem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigDecimal food = new BigDecimal(scan.nextLine());
        BigDecimal hay = new BigDecimal(scan.nextLine());
        BigDecimal cover = new BigDecimal(scan.nextLine());
        BigDecimal weight = new BigDecimal(scan.nextLine());

        for (int i = 1; i <= 30; i++) {
            food = food.subtract(new BigDecimal("0.3"));
            if (i % 2 == 0) {
                hay = hay.subtract(food.multiply(new BigDecimal("0.05")));
            }
            if (i % 3 == 0) {
                cover = cover.subtract(weight.divide(new BigDecimal( "3"), MathContext.DECIMAL128));
            }

            if (food.compareTo(new BigDecimal(0)) <= 0
                    || hay.compareTo(new BigDecimal(0)) <= 0
                    || cover.compareTo(new BigDecimal(0)) <= 0 ) {
                System.out.println("Merry must go to the pet store!");
                return;
            }
        }

        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", food, hay, cover);
    }
}
