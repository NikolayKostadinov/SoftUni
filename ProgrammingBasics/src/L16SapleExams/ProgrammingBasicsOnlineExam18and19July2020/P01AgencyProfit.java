package L16SapleExams.ProgrammingBasicsOnlineExam18and19July2020;

import java.util.Scanner;

public class P01AgencyProfit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String companyName = scan.nextLine();
        int adultCount = Integer.parseInt(scan.nextLine());
        int kidsCount = Integer.parseInt(scan.nextLine());
        double adultPrice = Double.parseDouble(scan.nextLine());
        double tax = Double.parseDouble(scan.nextLine());

        double sum = adultCount * (adultPrice + tax) + kidsCount * ((adultPrice * 0.3) + tax);

        double profit = 0.2 * sum;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", companyName, profit);

    }
}
