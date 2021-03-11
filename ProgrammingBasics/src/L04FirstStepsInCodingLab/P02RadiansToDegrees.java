package L04FirstStepsInCodingLab;

import java.util.Scanner;

public class P02RadiansToDegrees {
    public static void main(String[] args) {
        double factor = 180.0/Math.PI;
        Scanner sc = new Scanner(System.in);
        double rad = Double.parseDouble(sc.nextLine());
        double degrees = rad * factor;

        System.out.printf("%.0f", degrees);
    }
}
