package L16SapleExams.ProgrammingBasicsOnlineExam28and29March2020v2;

import java.util.Scanner;

public class P03FitnessCard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sum = Double.parseDouble(scan.nextLine());
        String sex = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String sport = scan.nextLine();

        double price = 0;
        // todo: Calculate the price
        switch (sport){
            case "Gym":
                price = "m".equals(sex) ? 42 : 35;
                break;
            case "Boxing":
                price = "m".equals(sex) ? 41 : 37;
                break;
            case "Yoga":
                price = "m".equals(sex) ? 45 : 42;
                break;
            case "Zumba":
                price = "m".equals(sex) ? 34 : 31;
                break;
            case "Dances":
                price = "m".equals(sex) ? 51 : 53;
                break;
            case "Pilates":
                price = "m".equals(sex) ? 39 : 37;
                break;
        }

        if ( age <= 19 ) price *= 0.8;

        if (price > sum){
            System.out.printf("You don't have enough money! You need $%.2f more.", price - sum);
        } else {
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        }
    }
}
