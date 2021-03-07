package P03FirstStepsInCoding;

import java.util.Scanner;

public class P09YardGreening {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double area = Double.parseDouble(sc.nextLine());
        double regularPrice = area * 7.61;
        double discount = regularPrice * (18.0 / 100);
        double finalPrice = regularPrice - discount;

        System.out.println("The final price is: " + finalPrice + " lv.\n" +
                "The discount is: " + discount + " lv.");
    }
}
