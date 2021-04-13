package L16SapleExams.ProgrammingBasicsOnlineExam15and16June2019v2;

import java.util.Scanner;

public class P01MovieProfit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String movieName = scan.nextLine();
        int days = Integer.parseInt(scan.nextLine());
        int tickets = Integer.parseInt(scan.nextLine());
        double ticketPrice = Double.parseDouble(scan.nextLine());
        int percent = Integer.parseInt(scan.nextLine());

        double profit = (days * tickets * ticketPrice) * (1 - (percent/100.0));
        System.out.printf("The profit from the movie %s is %.2f lv.", movieName, profit);
    }
}
