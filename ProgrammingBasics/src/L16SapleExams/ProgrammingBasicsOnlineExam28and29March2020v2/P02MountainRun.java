package L16SapleExams.ProgrammingBasicsOnlineExam28and29March2020v2;

import java.util.Scanner;

public class P02MountainRun {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double record = Double.parseDouble(scan.nextLine());
        double distance = Double.parseDouble(scan.nextLine());
        double timePerMeter = Double.parseDouble(scan.nextLine());

        double time = (timePerMeter * distance) + Math.floor(distance / 50) * 30;

        double difference = Math.abs(record - time);
        if (record > time) {
            System.out.printf("Yes! The new record is %.2f seconds.", time);
        } else {
            System.out.printf("No! He was %.2f seconds slower.", difference);
        }
    }
}
