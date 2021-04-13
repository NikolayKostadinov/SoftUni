package L16SapleExams.ProgrammingBasicsOnlineExam6and7July2019v1;

import java.util.Scanner;

public class P02FamilyTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int overnights = Integer.parseInt(scan.nextLine());
        double price = Double.parseDouble(scan.nextLine());
        double additionalExpenses = Integer.parseInt(scan.nextLine()) / 100.0;

        if (overnights > 7) price *= 0.95;
        double sum = overnights * price + budget * additionalExpenses;
        double difference = Math.abs(budget - sum);
        if (sum > budget){
            System.out.printf("%.2f leva needed.", difference);
        } else {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", difference);
        }
    }
}
