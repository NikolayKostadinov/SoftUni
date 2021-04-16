package L16SapleExams.ProgrammingBasicsOnlineExam20and21April2019v2;

import java.util.Scanner;

public class P05EasterBake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cakeCount = Integer.parseInt(scan.nextLine());

        int totalSugar = 0;
        int totalFlower = 0;
        int maxSugar = 0;
        int maxFlower = 0;

        for (int i = 0; i < cakeCount; i++) {
            int sugar = Integer.parseInt(scan.nextLine());
            int flower = Integer.parseInt(scan.nextLine());
            totalSugar += sugar;
            totalFlower += flower;
            if (sugar > maxSugar) maxSugar = sugar;
            if (flower > maxFlower) maxFlower = flower;
        }

        int sugarPackages = (int) Math.ceil(totalSugar / 950.0);
        int flowerPackages = (int) Math.ceil(totalFlower / 750.0);

        System.out.printf("Sugar: %d\n", sugarPackages);
        System.out.printf("Flour: %d\n", flowerPackages);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.\n", maxFlower, maxSugar);

    }
}
