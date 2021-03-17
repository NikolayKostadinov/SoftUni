package L08ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P08OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hourOfTheTest = Integer.parseInt(scan.nextLine());
        int minuteOfTheTest = Integer.parseInt(scan.nextLine());
        int hourOfTheArrival = Integer.parseInt(scan.nextLine());
        int minuteOfTheArrival = Integer.parseInt(scan.nextLine());

        int testTime = hourOfTheTest * 60 + minuteOfTheTest;
        int arrivalTime = hourOfTheArrival * 60 + minuteOfTheArrival;
        int timeDifference = Math.abs(testTime - arrivalTime);
        int timeDifferenceHours = timeDifference / 60;
        int timeDifferenceMinutes = timeDifference % 60;

        if (testTime >= arrivalTime) {
            if (timeDifference <= 30) {
                // On time
                System.out.printf("On time");
            } else {
                // Early
                System.out.printf("Early");
            }
            if (timeDifference > 0){
                if (timeDifferenceHours > 0){
                    System.out.printf("%n%d:%02d hours before the start", timeDifferenceHours, timeDifferenceMinutes);
                }else{
                    System.out.printf("%n%d minutes before the start", timeDifferenceMinutes);
                }
            }
        } else {
            // late
            System.out.printf("Late");
            if (timeDifference > 0){
                if (timeDifferenceHours > 0){
                    System.out.printf("%n%d:%02d hours after the start", timeDifferenceHours, timeDifferenceMinutes);
                }else{
                    System.out.printf("%n%d minutes after the start", timeDifferenceMinutes);
                }
            }
        }
    }
}
