package LME01ProgrammingFundamentalsMidExamRetake;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        double totalPriceNoTaxes = 0.0;

        while (!("special".equals(command) || "regular".equals(command))) {
            double price = Double.parseDouble(command);
            if (price <= 0) {
                System.out.println("Invalid price!");
            } else {
                totalPriceNoTaxes += price;
            }
            command = scan.nextLine();
        }

        if (totalPriceNoTaxes == 0) {
            System.out.println("Invalid order!");
        } else {
            double totalTaxes = totalPriceNoTaxes * 0.2;
            double totalPrice = totalPriceNoTaxes + totalTaxes;

            if ("special".equals(command)) {
                totalPrice = totalPrice * 0.9;
            }

            System.out.printf("Congratulations you've just bought a new computer!\n" +
                    "Price without taxes: %.2f$\n" +
                    "Taxes: %.2f$\n" +
                    "-----------\n" +
                    "Total price: %.2f$\n", totalPriceNoTaxes, totalTaxes, totalPrice);
        }
    }
}
