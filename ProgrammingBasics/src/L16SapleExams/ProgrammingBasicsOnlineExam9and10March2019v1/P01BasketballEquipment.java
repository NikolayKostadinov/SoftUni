package L16SapleExams.ProgrammingBasicsOnlineExam9and10March2019v1;

import java.util.Scanner;

public class P01BasketballEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int yearFee = Integer.parseInt(scan.nextLine());

        double shoes = yearFee * 0.6;
        double dress = shoes * 0.8;
        double ball = dress / 4.0;
        double accessories = ball / 5.0;
        double sum = yearFee + shoes + dress + ball + accessories;

        System.out.printf("%.2f", sum);
    }
}
