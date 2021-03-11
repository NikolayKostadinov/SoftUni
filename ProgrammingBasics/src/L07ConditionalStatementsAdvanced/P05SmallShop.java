package L07ConditionalStatementsAdvanced;

import java.util.Locale;
import java.util.Scanner;

public class P05SmallShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String product = scan.nextLine();
        String town = scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());

        double price = 0;

        switch (town.toLowerCase(Locale.ROOT)) {
            case ("sofia"):
                switch (product.toLowerCase(Locale.ROOT)) {
                    case "coffee":
                        price = 0.50;
                        break;
                    case "water":
                        price = 0.80;
                        break;
                    case "beer":
                        price = 1.20;
                        break;
                    case "sweets":
                        price = 1.45;
                        break;
                    case "peanuts":
                        price = 1.60;
                        break;
                }
                break;
            case ("plovdiv"):
                switch (product.toLowerCase(Locale.ROOT)) {
                    case "coffee":
                        price = 0.40;
                        break;
                    case "water":
                        price = 0.70;
                        break;
                    case "beer":
                        price = 1.15;
                        break;
                    case "sweets":
                        price = 1.30;
                        break;
                    case "peanuts":
                        price = 1.50;
                        break;
                }
                break;
            case ("varna"):
                switch (product.toLowerCase(Locale.ROOT)) {
                    case "coffee":
                        price = 0.45;
                        break;
                    case "water":
                        price = 0.70;
                        break;
                    case "beer":
                        price = 1.10;
                        break;
                    case "sweets":
                        price = 1.35;
                        break;
                    case "peanuts":
                        price = 1.55;
                        break;
                }
                break;
        }

        System.out.println(price * quantity);
    }
}
