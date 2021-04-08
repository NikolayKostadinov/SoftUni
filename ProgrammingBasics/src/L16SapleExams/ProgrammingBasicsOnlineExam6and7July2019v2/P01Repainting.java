package L16SapleExams.ProgrammingBasicsOnlineExam6and7July2019v2;

import java.util.Scanner;

public class P01Repainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nylon = Integer.parseInt(scan.nextLine());
        int paint = Integer.parseInt(scan.nextLine());
        int razreditel = Integer.parseInt(scan.nextLine());
        int hours = Integer.parseInt(scan.nextLine());

        double materialExpenses = (nylon + 2) * 1.5 + paint * 1.1 * 14.5 + razreditel * 5.0 + 0.4;
        double workExpenses = materialExpenses * 0.3 * hours;

        System.out.printf("Total expenses: %.2f lv.", materialExpenses + workExpenses);
    }
}
