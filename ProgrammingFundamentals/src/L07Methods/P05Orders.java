package L07Methods;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());

        System.out.printf("%.2f", calculateTotalPrice(product, quantity));
    }

    private static double calculateTotalPrice(String product, int quantity) {
        return getPrice(product) * quantity;
    }

    private static double getPrice(String product) {
        switch (product){
            case "coffee":
                return 1.5;
            case "water":
                return 1.0;
            case "coke":
                return 1.4;
            case "snacks":
                return 2.0;
            default: return 0.0;
        }
    }
}
