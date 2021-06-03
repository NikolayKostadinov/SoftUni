package L02BasicSyntaxConditionalStatementsAndLoopsExcercise;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command;
        double sum = 0.0;
        // calculate inserted money
        command = scan.nextLine();
        do {
            double money = Double.parseDouble(command);
            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                sum += money;
            }else{
                System.out.printf("Cannot accept %.2f\n", money);
            }
            command = scan.nextLine();
        } while (!"Start".equals(command));

        command = scan.nextLine();
        while (!"End".equals(command)) {
            double price = 0.0;
            switch (command) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            if (price > 0 ){
                if (price <= sum){
                    System.out.printf("Purchased %s\n", command);
                    sum -= price;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            }
            command = scan.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}
