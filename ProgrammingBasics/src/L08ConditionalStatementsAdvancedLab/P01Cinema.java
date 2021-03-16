package L08ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P01Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String projectionType = scanner.nextLine();
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        double price = 0;
        switch (projectionType) {
            case "Premiere":
                price = 12.0;
                break;
            case "Normal":
                price = 7.50;
                break;
            case "Discount":
                price = 5.00;
                break;
        }

        System.out.printf("%.2f leva", row * col * price);
    }
}
