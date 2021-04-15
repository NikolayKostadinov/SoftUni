package L16SapleExams.ProgrammingBasicsOnlineExam9and10March2019v2;

import java.util.Scanner;

public class P02Skeleton {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int minControl = Integer.parseInt(scan.nextLine());
        int secControl = Integer.parseInt(scan.nextLine());
        double length = Double.parseDouble(scan.nextLine());
        int secFor100 = Integer.parseInt(scan.nextLine());

        double diminishing = (length / 120) * 2.5;

        double sec = (secFor100 * length / 100.0) - diminishing;

        if (sec <= minControl * 60 + secControl){
            System.out.println("Marin Bangiev won an Olympic quota!");
            System.out.printf("His time is %.3f.", sec);
        } else {
            System.out.printf("No, Marin failed! He was %.3f second slower.", sec - (minControl * 60 + secControl));
        }
    }
}
