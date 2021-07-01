package L02BasicSyntaxConditionalStatementsAndLoopsMoreExcercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P01SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = Double.parseDouble(scan.nextLine());
        double b = Double.parseDouble(scan.nextLine());
        double c = Double.parseDouble(scan.nextLine());

        DecimalFormat df = new DecimalFormat("0.#");

        if (a > b && a > c) {
            System.out.println(df.format(a));
            if (b > c){
                System.out.println(df.format(b));
                System.out.println(df.format(c));
            } else {
                System.out.println(df.format(c));
                System.out.println(df.format(b));
            }
        } else if (b > a && b > c) {
            System.out.println(df.format(b));
            if (a > c){
                System.out.println(df.format(a));
                System.out.println(df.format(c));
            } else {
                System.out.println(df.format(c));
                System.out.println(df.format(a));
            }
        } else {
            System.out.println(df.format(c));
            if (a > b){
                System.out.println(df.format(a));
                System.out.println(df.format(b));
            } else {
                System.out.println(df.format(b));
                System.out.println(df.format(a));
            }
        }
    }
}
