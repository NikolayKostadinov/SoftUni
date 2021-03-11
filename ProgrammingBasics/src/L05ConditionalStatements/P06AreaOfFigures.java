package L05ConditionalStatements;

import java.util.Scanner;

public class P06AreaOfFigures {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String figureType = scan.nextLine();
        double area = 0.0;

        switch (figureType) {
            case "square":
                //TODO: side * side
                double side = Double.parseDouble(scan.nextLine());
                area = side * side;
                break;

            case "rectangle":
                //TODO: sideA * sideB
                double sideA = Double.parseDouble(scan.nextLine());
                double sideB = Double.parseDouble(scan.nextLine());
                area = sideA * sideB;
                break;

            case "circle":
                //TODO: pi * r^2
                double radius = Double.parseDouble(scan.nextLine());
                area = Math.PI * Math.pow(radius, 2);
                break;

            case "triangle":
                double side1 = Double.parseDouble(scan.nextLine());
                double hide = Double.parseDouble(scan.nextLine());
                area = (side1 * hide) / 2;
                break;
        }

        System.out.printf("%.3f", area);
    }
}
