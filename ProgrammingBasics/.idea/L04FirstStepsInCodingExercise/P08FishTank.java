package L04FirstStepsInCodingExercise;

import java.util.Scanner;

public class P08FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short length = Short.parseShort(scanner.nextLine());
        short width =  Short.parseShort(scanner.nextLine());
        short height = Short.parseShort(scanner.nextLine());
        double percentageOccupied = Double.parseDouble(scanner.nextLine());

        double volume = ((length / 10.0) * (width / 10.0) * (height / 10.0)) * (1 - percentageOccupied/100.0);

        System.out.printf("%.2f", volume);
    }
}
