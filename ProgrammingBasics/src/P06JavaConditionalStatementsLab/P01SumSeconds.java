package P06JavaConditionalStatementsLab;

import java.util.Scanner;

public class P01SumSeconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int time1 = Integer.parseInt(scan.nextLine());
        int time2 = Integer.parseInt(scan.nextLine());
        int time3 = Integer.parseInt(scan.nextLine());

        int sumTime = time1 + time2 + time3;
        int minutes = sumTime / 60;
        int seconds = sumTime % 60;
        System.out.printf("%1$d:%2$02d", minutes, seconds);
    }
}
