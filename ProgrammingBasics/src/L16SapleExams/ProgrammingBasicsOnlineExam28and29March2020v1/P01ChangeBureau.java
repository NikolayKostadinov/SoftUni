package L16SapleExams.ProgrammingBasicsOnlineExam28and29March2020v1;

import java.util.Scanner;

public class P01ChangeBureau {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bitcoins = Integer.parseInt(scan.nextLine());
        double joan = Double.parseDouble(scan.nextLine());
        double percent = Double.parseDouble(scan.nextLine());

        double sum = (bitcoins * 1168.0 + joan * 0.15 * 1.76) / 1.95;
        double commission = percent / 100.0 * sum;
        System.out.printf("%.2f", sum - commission);
    }
}
