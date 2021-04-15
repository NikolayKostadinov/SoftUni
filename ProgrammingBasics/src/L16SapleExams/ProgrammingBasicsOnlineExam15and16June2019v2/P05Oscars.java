package L16SapleExams.ProgrammingBasicsOnlineExam15and16June2019v2;

import java.util.Scanner;

public class P05Oscars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String actorName = scan.nextLine();
        double points = Double.parseDouble(scan.nextLine());
        int count = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < count; i++) {
            String jouryName = scan.nextLine();
            points += (jouryName.length() * Double.parseDouble(scan.nextLine())) / 2;
            if (points > 1250.5)
            {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, points);
                return;
            }
        }

        System.out.printf("Sorry, %s you need %.1f more!", actorName, 1250.5 - points);
    }
}
