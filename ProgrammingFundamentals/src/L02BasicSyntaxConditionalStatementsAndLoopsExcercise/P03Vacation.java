package L02BasicSyntaxConditionalStatementsAndLoopsExcercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scan.nextLine());
        String groupType = scan.nextLine();
        String day = scan.nextLine();

        double price = 0.0;

        switch (groupType) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.8;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16.0;
                        break;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.5;
                        break;
                }
                break;
        }

        double sum = price * peopleCount;
        if ("Students".equals(groupType) && peopleCount >= 30){
            sum = peopleCount * price * 0.85;
        }

        if ("Business".equals(groupType) && peopleCount >= 100){
            sum = (peopleCount - 10) * price;
        }

        if ("Regular".equals(groupType) && peopleCount >= 10 && peopleCount <= 20){
            sum = peopleCount * price * 0.95;
        }

        System.out.printf("Total price: %.2f", sum);
    }
}
