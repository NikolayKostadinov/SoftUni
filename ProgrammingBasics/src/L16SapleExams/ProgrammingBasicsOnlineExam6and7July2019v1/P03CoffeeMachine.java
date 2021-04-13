package L16SapleExams.ProgrammingBasicsOnlineExam6and7July2019v1;

import java.util.Scanner;

public class P03CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String drinkType = scan.nextLine();
        String sugar = scan.nextLine();
        int drinks = Integer.parseInt(scan.nextLine());

        double price = 0;

        switch (drinkType){
            case "Espresso":
                switch (sugar){
                    case "Without":
                        price = 0.9* 0.65;
                        break;
                    case "Normal":
                        price = 1.0;
                        break;
                    case "Extra":
                        price = 1.2;
                        break;
                }

                if (drinks >= 5) price *= 0.75;
                break;
            case "Cappuccino":
                switch (sugar){
                    case "Without":
                        price = 1.0 * 0.65;
                        break;
                    case "Normal":
                        price = 1.20;
                        break;
                    case "Extra":
                        price = 1.6;
                        break;
                }
                break;
            case "Tea":
                switch (sugar){
                    case "Without":
                        price = 0.5 * 0.65;
                        break;
                    case "Normal":
                        price = 0.6;
                        break;
                    case "Extra":
                        price = 0.7;
                        break;
                }
                break;
        }

        double sum = price * drinks;
        if (sum > 15) sum *= 0.8;

        System.out.printf("You bought %d cups of %s for %.2f lv.", drinks, drinkType, sum);
    }
}
