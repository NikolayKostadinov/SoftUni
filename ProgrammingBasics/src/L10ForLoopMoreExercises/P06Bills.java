package L10ForLoopMoreExercises;

import java.util.Scanner;

public class P06Bills {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int months = Integer.parseInt(scan.nextLine());
        double monthlyElectricityBill = 0;
        double electricityBill = 0;
        double waterBill = 0;
        double internetBill = 0;
        double otherBill = 0;

        for (int i = 0; i < months; i++) {
            monthlyElectricityBill = Double.parseDouble(scan.nextLine());
            electricityBill += monthlyElectricityBill;
            waterBill += 20;
            internetBill += 15;
            otherBill += (monthlyElectricityBill + 20 + 15) * 1.2;
        }

        System.out.printf("Electricity: %.2f lv\n", electricityBill );
        System.out.printf("Water: %.2f lv\n", waterBill );
        System.out.printf("Internet: %.2f lv\n", internetBill );
        System.out.printf("Other: %.2f lv\n", otherBill );
        System.out.printf("Average: %.2f lv\n", (electricityBill + waterBill + internetBill + otherBill) / months );
    }
}
