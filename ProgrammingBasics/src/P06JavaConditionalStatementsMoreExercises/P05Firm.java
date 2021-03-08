package P06JavaConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P05Firm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hoursNeeded = Integer.parseInt(scan.nextLine());
        int availableDays = Integer.parseInt(scan.nextLine());
        int employeesForOvertimeCount = Integer.parseInt(scan.nextLine());

        double normalHours = availableDays * 0.9 * 8;
        double overTime = employeesForOvertimeCount * 2 * availableDays;

        double timeDifference = Math.abs(hoursNeeded - Math.floor(normalHours + overTime));

        if (hoursNeeded <= (normalHours + overTime)){
            System.out.printf("Yes!%.0f hours left.", timeDifference);
        } else {
            System.out.printf("Not enough time!%.0f hours needed.", timeDifference);
        }
    }
}
