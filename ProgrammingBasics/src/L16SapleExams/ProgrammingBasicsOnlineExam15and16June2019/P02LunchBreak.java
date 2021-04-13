package L16SapleExams.ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class P02LunchBreak {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String seriesName = scan.nextLine();
        int seriesLength = Integer.parseInt(scan.nextLine());
        int breakTime = Integer.parseInt(scan.nextLine());

        double neededTime = breakTime / 8.0 + breakTime / 4.0 + seriesLength;

        int difference = (int)Math.ceil(Math.abs(neededTime - breakTime));
        if (breakTime >= neededTime){
            System.out.printf("You have enough time to watch %s and left with %d minutes free time.", seriesName, difference);
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %d more minutes.", seriesName, difference);
        }

    }
}
