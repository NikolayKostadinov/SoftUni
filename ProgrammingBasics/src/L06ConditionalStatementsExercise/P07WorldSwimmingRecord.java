package L06ConditionalStatementsExercise;

import java.util.Scanner;

public class P07WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double recordTime = Double.parseDouble(scan.nextLine());
        double distance = Double.parseDouble(scan.nextLine());
        double timePerMeter = Double.parseDouble(scan.nextLine());

        double time = distance * timePerMeter;
        int delays = (int) Math.floor(distance / 15.0);
        time += (delays * 12.5);

        if (time < recordTime) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", time);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", time - recordTime);
        }
    }
}
