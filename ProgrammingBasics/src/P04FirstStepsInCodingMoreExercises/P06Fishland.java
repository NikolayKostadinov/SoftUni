package P04FirstStepsInCodingMoreExercises;

import java.util.Scanner;

public class P06Fishland {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double mackerelPrice = Double.parseDouble(scan.nextLine()); //скумрия
        double spratsPrice = Double.parseDouble(scan.nextLine()); //цаца
        double bonitoQuantity = Double.parseDouble(scan.nextLine()); //паламуд
        double scadQuantity = Double.parseDouble(scan.nextLine()); //сафрид
        double musselsQuantity = Double.parseDouble(scan.nextLine()); //миди

        double bonitoPrice = mackerelPrice * 1.6;
        double scadPrice = spratsPrice * 1.8;

        System.out.printf("%.2f", bonitoQuantity * bonitoPrice + scadQuantity * scadPrice + musselsQuantity * 7.5);
    }
}
