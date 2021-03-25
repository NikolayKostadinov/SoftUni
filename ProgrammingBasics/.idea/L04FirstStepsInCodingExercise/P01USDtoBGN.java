package L04FirstStepsInCodingExercise;

import java.util.Scanner;

public class P01USDtoBGN {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double course = 1.79549;
        double usd = Double.parseDouble(scan.nextLine());
        double result = usd * course;
        System.out.println(result);
    }
}
