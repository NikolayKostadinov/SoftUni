package P04FirstStepsInCodingLab;

import java.util.Scanner;

public class P07FruitMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double strawberryPrice = Double.parseDouble(scanner.nextLine());
        double bananasQuantity = Double.parseDouble(scanner.nextLine());
        double orangesQuantity = Double.parseDouble(scanner.nextLine());
        double raspberriesQuantity = Double.parseDouble(scanner.nextLine());
        double strawberriesQuantity = Double.parseDouble(scanner.nextLine());

        double raspberryPrice = strawberryPrice * 0.5;
        double orangePrice = raspberryPrice * 0.6;
        double bananaPrice = raspberryPrice * 0.2;

        System.out.printf("%.2f", strawberriesQuantity * strawberryPrice
                + bananasQuantity * bananaPrice
                + orangesQuantity * orangePrice
                + raspberriesQuantity * raspberryPrice);
    }
}
