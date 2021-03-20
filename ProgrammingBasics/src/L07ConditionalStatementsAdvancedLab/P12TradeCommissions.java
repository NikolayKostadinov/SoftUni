package L07ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class P12TradeCommissions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String town = scan.nextLine();
        double sales = Double.parseDouble(scan.nextLine());

        double commision = 0;
        switch (town) {
            case ("Sofia"):
                if (sales >= 0 && 500 >= sales) {
                    commision = 5;
                } else if (sales > 500 && 1000 >= sales) {
                    commision = 7;
                } else if (sales > 1000 && 10000 >= sales) {
                    commision = 8;
                } else if (sales > 10000) {
                    commision = 12;
                }
                break;
            case ("Varna"):
                if (sales >= 0 && 500 >= sales) {
                    commision = 4.5;
                } else if (sales > 500 && 1000 >= sales) {
                    commision = 7.5;
                } else if (sales > 1000 && 10000 >= sales) {
                    commision = 10;
                } else if (sales > 10000) {
                    commision = 13;
                }
                break;
            case ("Plovdiv"):
                if (sales >= 0 && 500 >= sales) {
                    commision = 5.5;
                } else if (sales > 500 && 1000 >= sales) {
                    commision = 8;
                } else if (sales > 1000 && 10000 >= sales) {
                    commision = 12;
                } else if (sales > 10000) {
                    commision = 14.5;
                }
                break;
            default:
                sales = -1;
                break;
        }
        if (sales > 0 ){
            System.out.printf("%.2f", sales * commision / 100);
        } else {
            System.out.println("error");
        }
    }
}
