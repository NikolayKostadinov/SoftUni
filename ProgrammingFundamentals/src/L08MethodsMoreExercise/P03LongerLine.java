package L08MethodsMoreExercise;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class P03LongerLine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x1 = Integer.parseInt(scan.nextLine());
        int y1 = Integer.parseInt(scan.nextLine());
        int x2 = Integer.parseInt(scan.nextLine());
        int y2 = Integer.parseInt(scan.nextLine());
        int x3 = Integer.parseInt(scan.nextLine());
        int y3 = Integer.parseInt(scan.nextLine());
        int x4 = Integer.parseInt(scan.nextLine());
        int y4 = Integer.parseInt(scan.nextLine());

        if (lenOfLine(x1, y1, x2, y2).compareTo(lenOfLine(x3, y3, x4, y4)) >= 0){
            printOrdered(x1, y1, x2, y2);
        } else {
            printOrdered(x3, y3, x4, y4);
        }

    }

    private static BigDecimal lenOfLine(int x1, int y1, int x2, int y2) {
        int x = (x1 > 0 && x2 > 0) ? Math.abs(x1-x2) : Math.abs(x1) + Math.abs(x2);
        int y = (y1 > 0 && y2 > 0) ? Math.abs(y1-y2) : Math.abs(y1) + Math.abs(y2);

        return calculateDistance(x, y);
    }


    private static void printOrdered(int x1, int y1, int x2, int y2) {
        if (calculateDistance(x1, y1).compareTo(calculateDistance(x2, y2)) <= 0 ) {
            System.out.printf("(%d, %d)", x1, y1);
            System.out.printf("(%d, %d)", x2, y2);
        } else {
            System.out.printf("(%d, %d)", x2, y2);
            System.out.printf("(%d, %d)", x1, y1);
        }
    }

    private static BigDecimal calculateDistance(int x, int y) {
        BigDecimal bdX = new BigDecimal(String.valueOf(x));
        BigDecimal bdY = new BigDecimal(String.valueOf(y));
        BigDecimal distance = bdX.multiply(bdX).add(bdY.multiply(bdY)).sqrt(new MathContext(128));
        return distance;
    }
}
