package L16SapleExams.ProgrammingBasicsOnlineExam9and10March2019v2;

import java.util.Scanner;

public class P01TennisEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double rocketPrice = Double.parseDouble(scan.nextLine());
        int rocketCount = Integer.parseInt(scan.nextLine());
        int shoesCount = Integer.parseInt(scan.nextLine());

        double rocketSum = rocketPrice * rocketCount;
        double shoesSum = (rocketPrice / 6.0) * shoesCount;
        double additional = (rocketSum + shoesSum) * 0.2;

        double sum = rocketSum + shoesSum + additional;

        System.out.printf("Price to be paid by Djokovic %d\n", (int) Math.floor(sum / 8.0));
        System.out.printf("Price to be paid by sponsors %d", (int) Math.ceil(sum * 7.0 / 8.0));
    }
}
