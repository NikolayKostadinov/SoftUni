package L03FirstStepsInCoding;

import java.util.Scanner;

public class P04InchesToCentimeters {
    public static void main(String[] args) {
        Scanner intput = new Scanner(System.in);
        double inch = Double.parseDouble(intput.nextLine());
        double result = inch * 2.54;
        System.out.println(result);
    }
}
