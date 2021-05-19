package TheExam;

import java.util.Scanner;

public class P04GrandpaStavri {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        double totalQuantity = 0;
        double totalDegrees = 0;
        for (int i = 0; i < days; i++) {
            double rakiaQuantity = Double.parseDouble(scan.nextLine());
            double degrees = Double.parseDouble(scan.nextLine());
            totalQuantity += rakiaQuantity;
            totalDegrees += rakiaQuantity * degrees;
        }

        double averageDegrees = totalDegrees / totalQuantity;

        System.out.printf("Liter: %.2f\n", totalQuantity);
        System.out.printf("Degrees: %.2f\n", averageDegrees);

        if (averageDegrees < 38){
            System.out.println("Not good, you should baking!");
        } else if (38 <= averageDegrees && averageDegrees <= 42){
            System.out.println("Super!");
        } else if (averageDegrees > 42){
            System.out.println("Dilution with distilled water!");
        }
    }
}
