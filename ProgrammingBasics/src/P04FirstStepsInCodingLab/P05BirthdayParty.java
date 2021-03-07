package P04FirstStepsInCodingLab;

import java.util.Scanner;
public class P05BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rent = Integer.parseInt(scanner.nextLine());
        double cakePrice = rent * 0.2;
        double drinksPrice = cakePrice * 0.55;
        double animatorTrice = rent / 3.0;
        double budget = rent + cakePrice + drinksPrice + animatorTrice;

        System.out.println(budget);
    }
}
