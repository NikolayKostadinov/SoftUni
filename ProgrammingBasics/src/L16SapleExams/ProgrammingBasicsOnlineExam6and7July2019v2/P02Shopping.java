package L16SapleExams.ProgrammingBasicsOnlineExam6and7July2019v2;

import java.util.Scanner;

public class P02Shopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int videoCards = Integer.parseInt(scan.nextLine());
        int cpus = Integer.parseInt(scan.nextLine());
        int ram = Integer.parseInt(scan.nextLine());

        double videoSum = videoCards * 250;
        double cpuSum = videoSum * 0.35 * cpus;
        double ramSum = videoSum * 0.1 * ram;
        double sum = videoSum + cpuSum + ramSum;
        if (videoCards > cpus) sum *= 0.85;

        double difference = Math.abs(budget - sum);

        if (budget >= sum) {
            System.out.printf("You have %.2f leva left!", difference);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", difference);
        }
    }
}
