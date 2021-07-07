package L08MethodsMoreExercise;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class P02CenterPoint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = Integer.parseInt(scan.nextLine());
        int y1 = Integer.parseInt(scan.nextLine());
        int x2 = Integer.parseInt(scan.nextLine());
        int y2 = Integer.parseInt(scan.nextLine());

        if (calculateDistance(x1, y1).compareTo(calculateDistance(x2, y2)) <= 0 ) {
            System.out.printf("(%d, %d)", x1, y1);
        } else {
            System.out.printf("(%d, %d)", x2, y2);
        }
    }

    private static BigDecimal calculateDistance(int x, int y) {
        BigDecimal bdX = new BigDecimal(String.valueOf(x));
        BigDecimal bdY = new BigDecimal(String.valueOf(y));
        BigDecimal distance = bdX.multiply(bdX).add(bdY.multiply(bdY)).sqrt(new MathContext(128));
        return distance;
    }
}