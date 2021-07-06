package LME06ProgrammingFundamentalsMidExam;

import java.util.Scanner;

public class P01BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int plunderADay = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());

        double sum =0.0;

        for (int i = 1; i <= days; i++) {
            double daily = plunderADay;
            if (i % 3 == 0){
                daily *= 1.5;
            }
            sum += daily;
            if (i % 5 == 0){
                sum *= 0.7;
            }
        }

        if (sum >= expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.", sum);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", (sum/expectedPlunder) * 100.0);
        }
    }
}
