package L04FirstStepsInCodingMoreExercises;

import java.util.Scanner;

public class P08CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double radius = Double.parseDouble(scan.nextLine());

        double perimeter = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;

        System.out.printf("%.2f%n%.2f", area, perimeter);

    }
}
