package L16SapleExams.ProgrammingBasicsOnlineExam6and7July2019v1;

import java.util.Map;
import java.util.Scanner;

public class P01PoolDay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int employee = Integer.parseInt(scan.nextLine());
        double tax = Double.parseDouble(scan.nextLine());
        double sheslongPrice = Double.parseDouble(scan.nextLine());
        double umbrellaPrice = Double.parseDouble(scan.nextLine());

        double sheslongCount = Math.ceil(employee * 0.75);
        double umbrellasCount = Math.ceil(employee / 2.0);

        double sum = employee * tax + sheslongCount * sheslongPrice + umbrellasCount * umbrellaPrice;

        System.out.printf("%.2f lv.", sum);
    }
}
