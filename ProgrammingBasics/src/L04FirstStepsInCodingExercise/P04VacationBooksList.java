package L04FirstStepsInCodingExercise;

import java.util.Scanner;

public class P04VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short pages = Short.parseShort(scanner.nextLine());
        short pagerPerHour = Short.parseShort(scanner.nextLine());
        short days = Short.parseShort(scanner.nextLine());
        double hoursPerDay = (pages / pagerPerHour) / days;

        System.out.printf("%.0f", hoursPerDay);
    }
}
